package work.DataInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static work.DataInfo.PathPrefix.path_prefix;

public class DataInfo {
    private static Map<String, String> user_pwd;

    public DataInfo() {
    }

    public DataInfo(int op) throws IOException {
        user_pwd = new HashMap<>();
        File file = new File(path_prefix + "user\\userPwd\\userPwd.txt");
        new PathPrefix(file);
        Scanner in = new Scanner(file);
        String[] arrs = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("")) continue;
            arrs = line.split(" ");
            user_pwd.put(arrs[0], arrs[1]);
        }
        in.close();
        //test();
    }

    /**
     * 判断用户名和密码是否正确
     *
     * @param user     输入用户名
     * @param password 输入密码
     * @return 返回用户名和密码是否正确
     */
    public boolean isRight(String user, String password) {
        if (user_pwd.containsKey(user))
            return user_pwd.get(user).equals(password);
        return false;
    }

    private void test() {
        for (String s : user_pwd.keySet()) {
            System.out.println(s + " : " + user_pwd.get(s));
        }
    }

    public void add(String user, String password) throws IOException {
        user_pwd.put(user, password);
        File file=new File(path_prefix + "user\\userPwd\\userPwd.txt");
        new PathPrefix(file);
        PrintWriter pr = new PrintWriter(new FileWriter(file), false);
        pr.println(user + " " + password);
        pr.close();
        creatUser(user);
    }

    private void creatUser(String user) throws IOException {
        File file=new File(path_prefix + "user\\userInfo\\" + user + ".txt");
        new PathPrefix(file);
        PrintWriter pr = new PrintWriter(new FileWriter(file), false);
        pr.println("0 0 0 0 0");
        pr.close();
    }
}
