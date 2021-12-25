package work.DataInfo;

import java.io.*;
import java.util.*;

import static work.DataInfo.PathPrefix.path_prefix;

public class UserInfo {
    private static String name;
    private static int score;
    private static ArrayList<Integer> numOfItems;
    private static Map<Character, Integer> itemId = new HashMap<>();
    private static TreeSet<UserScore> userScoreSet = new TreeSet<>();

    public UserInfo() {
    }

    public UserInfo(int admin) throws IOException {
        itemId.put('一', 0);
        itemId.put('键', 1);
        itemId.put('三', 2);
        itemId.put('连', 3);
        name = "admin";
        score = 20011006;
        numOfItems = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            numOfItems.add(0);
        }
        createUserRankList();
    }

    public UserInfo(String user) throws IOException {
        init(user);
        createUserRankList();
    }

    private void createUserRankList() throws IOException {
        Set<String> userSet = new DataInfo().getUserSet();
        for (String user_name_tmp : userSet) {
            if (user_name_tmp.equals(name)) continue;
            File file = new File(path_prefix + "user/userInfo/" + user_name_tmp + ".txt");
            new PathPrefix(file);
            Scanner in = new Scanner(file);
            int user_score_tmp = in.nextInt();
            userScoreSet.add(new UserScore(user_name_tmp, user_score_tmp));
            in.close();
        }
    }

    public int getUserRank(String user) {
        TreeSet<UserScore> allUserScore = new TreeSet<>(userScoreSet);
        allUserScore.add(new UserScore(name, score));
        int user_rank = 0;
        for (UserScore userScore : allUserScore) {
            ++user_rank;
            if (userScore.getName().equals(user)) return user_rank;
        }
        return user_rank;
    }

    public TreeSet<UserScore> getAllUserScoreSet() {
        TreeSet<UserScore> allUserScore = new TreeSet<>(userScoreSet);
        allUserScore.add(new UserScore(name, score));
        return allUserScore;
    }

    private void init(String user) throws IOException {
        itemId.put('一', 0);
        itemId.put('键', 1);
        itemId.put('三', 2);
        itemId.put('连', 3);
        name = user;
        numOfItems = new ArrayList<>();
        File file = new File(path_prefix + "user/userInfo/" + user + ".txt");
        new PathPrefix(file);
        Scanner in = new Scanner(file);
        score = in.nextInt();
        for (int i = 0; i < 4; i++) {
            numOfItems.add(in.nextInt());
        }
        in.close();
    }

    public void update() throws IOException {
        File file = new File(path_prefix + "user/userInfo/" + name + ".txt");
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
        return getUserRank(name);
    }

    public ArrayList<Integer> getNumOfItems() {
        return numOfItems;
    }

    public String getNumOfItems_string() {
        return "一:" + numOfItems.get(itemId.get('一')) + " 键:" + numOfItems.get(itemId.get('键')) + " 三:" + numOfItems.get(itemId.get('三')) + " 连:" + numOfItems.get(itemId.get('连'));
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
