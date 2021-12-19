package work.DataInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static work.DataInfo.PathPrefix.path_prefix;

public class UserInfo {
    private static String name;
    private static int score;
    private static ArrayList<Integer> numOfItems;
    private static int rank;
    private static Map<Character, Integer> itemId = new HashMap<>();

    public UserInfo() {
    }

    public UserInfo(int admin) {
        itemId.put('一', 0);
        itemId.put('键', 1);
        itemId.put('三', 2);
        itemId.put('连', 3);
        name = "admin";
        score = 20011006;
        rank = 0;
        numOfItems = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numOfItems.add(0);
        }
    }

    public UserInfo(String user) throws IOException {
        itemId.put('一', 0);
        itemId.put('键', 1);
        itemId.put('三', 2);
        itemId.put('连', 3);
        numOfItems = new ArrayList<>();
        name = user;
        File file = new File(path_prefix + "user\\userInfo\\" + user + ".txt");
        new PathPrefix(file);
        Scanner in = new Scanner(file);
        score = in.nextInt();
        for (int i = 0; i < 4; i++) {
            numOfItems.add(in.nextInt());
        }
        in.close();
    }

    public void update() throws IOException {
        File file = new File(path_prefix + "user\\userInfo\\" + name + ".txt");
        new PathPrefix(file);
        PrintWriter pr = new PrintWriter(new FileWriter(file, false));
        pr.print(score + "");
        for (Integer num : numOfItems) {
            pr.print(" " + num);
        }
        pr.close();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public ArrayList<Integer> getNumOfItems() {
        return numOfItems;
    }

    public String getNumOfItems_string(){
        return "一:"+numOfItems.get(0)+" 键:"+numOfItems.get(1)+" 三:"+numOfItems.get(2)+" 连:"+numOfItems.get(3);
    }
    //增加分数并更新
    public void addScore(int num) throws IOException {
        score += num;
        update();
    }

    //增加某个道具数量并更新
    public void addItem(char key, int num) throws IOException {
        if (itemId.containsKey(key)) {
            numOfItems.set(itemId.get(key), numOfItems.get(itemId.get(key)) + num);
            update();
        }

    }
}
