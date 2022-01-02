package work.DataInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static work.DataInfo.PathPrefix.path_prefix;

public class DataInfo {
    private static Map<String, String> user_pwd;

    public DataInfo() {
    }

    public DataInfo(int op) throws IOException {
        init();
//        test();
    }

    /**
     * 读取用户信息
     */
    private void init() throws IOException {
        user_pwd = new HashMap<>();
        File file = new File(path_prefix + "user/userPwd/userPwd.txt");
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
    }

    public Set<String> getUserSet() {
        return user_pwd.keySet();
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

    /**
     * 测试用
     */
    private void test() {
        for (String s : user_pwd.keySet()) {
            System.out.println(s + " : " + user_pwd.get(s));
        }
    }

    /**
     * 添加新用户
     *
     * @param user     用户名
     * @param password 用户密码
     */
    public void add(String user, String password) throws IOException {
        user_pwd.put(user, password);
        File file = new File(path_prefix + "user/userPwd/userPwd.txt");
        new PathPrefix(file);
        PrintWriter pr = new PrintWriter(new FileWriter(file, true));
        pr.println(user + " " + password);
        pr.close();
        creatUser(user);
    }

    /**
     * 初始化新用户文件
     *
     * @param user 用户名
     */
    private void creatUser(String user) throws IOException {
        File file = new File(path_prefix + "user/userInfo/" + user + ".txt");
        new PathPrefix(file);
        PrintWriter pr = new PrintWriter(new FileWriter(file, true));
        pr.println("0 0 0 0 0");
        pr.close();
    }

    /**
     * 判断用户名存不存在
     *
     * @param user 输入用户名
     * @return 存在返回真
     */
    public boolean checkInKeys(String user) {
        return user_pwd.containsKey(user);
    }
}
