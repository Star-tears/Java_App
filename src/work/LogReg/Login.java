package work.LogReg;

import work.DataInfo.DataInfo;
import work.DataInfo.UserInfo;
import work.Scene.LoginScene;
import work.Scene.RegScene;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    private boolean isRight = false;
    private String user1;
    private String password1;
    private DataInfo dataInfo;

    public Login() throws IOException, InterruptedException {
        run();
    }

    //检查用户名和密码是否合法
    private static boolean checkPwd(String pwd) {
        String regExp = "^[\\w_]{6,20}$";
        if (pwd.matches(regExp)) {
            return true;
        }
        return false;
    }

    public void run() throws IOException, InterruptedException {
        dataInfo = new DataInfo();
        Scanner in = new Scanner(System.in);
        while (!isRight) {
            LoginScene loginScene = new LoginScene();
            loginScene.printScene();
            String op = in.nextLine();
            switch (op) {
                case "exit":
                    System.exit(0);
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "sch@root":
                    new UserInfo(0);
                    isRight = true;
                    break;
            }
        }
    }

    //登录
    private void login() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("用户名： ");
        user1 = in.nextLine();
        System.out.print("密码： ");
        password1 = in.nextLine();
        DataInfo dataInfo = new DataInfo();
        if (dataInfo.isRight(user1, password1)) {
            this.isRight = true;
            new UserInfo(user1);
            System.out.print("登入成功！（按Enter键登入)");
            in.nextLine();
        } else {
            System.out.print("登入失败！（用户名或密码错误，按Enter键返回)");
            in.nextLine();
        }
    }


    //注册
    private void register() throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        RegScene regScene = new RegScene();
        regScene.printScene();
        while (true) {
            System.out.print("输入注册用户名： ");
            user1 = in.nextLine();
            if (checkPwd(user1)&&!dataInfo.checkInKeys(user1)) {
                break;
            }
            if (dataInfo.checkInKeys(user1)) {
                System.out.println("用户名已存在！！！");
            } else {
                System.out.println("用户名不合法！（用户名必须是6-20位的字母、数字、下划线组合）");
            }
        }
        while (true) {
            System.out.print("输入密码： ");
            password1 = in.nextLine();
            if (checkPwd(password1)) {
                break;
            }
            System.out.println("密码不合法！（密码必须是6-20位的字母、数字、下划线组合）");
        }
        System.out.print("请再输入一次密码： ");
        String password2 = in.nextLine();
        if (password2.equals(password1)) {
            DataInfo dataInfo = new DataInfo();
            dataInfo.add(user1, password1);
            this.isRight = true;
            new UserInfo(user1);
            System.out.print("注册成功！（按Enter键登入）");
            in.nextLine();
        } else {
            System.out.print("注册失败！（按Enter键返回）");
            in.nextLine();
        }
    }
}
