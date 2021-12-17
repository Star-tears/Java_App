package work.DataInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static work.DataInfo.PathPrefix.path_prefix;

public class UserInfo {
    private static String name;
    private static int score;
    private static ArrayList<Integer> numOfItems;
    private static int rank;

    public UserInfo() {
    }

    public UserInfo(int admin) {
        name = "admin";
        score = 20011006;
        rank = 0;
        numOfItems = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numOfItems.add(0);
        }
    }

    public UserInfo(String user) throws IOException {
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

    public void addScore(int num) throws IOException {
        score += num;
        update();
    }
}
