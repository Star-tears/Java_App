package work.Quiz;

import work.DataInfo.QuizInfo;
import work.DataInfo.UserInfo;
import work.Scene.QuizScene;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static work.DataInfo.QuizInfo.getAllQuizNum;

public class Quiz {
    private QuizInfo quizInfo;
    private String op;
    private int allQuizNum = QuizInfo.getAllQuizNum();
    private int[] vis = new int[100];

    public Quiz() throws IOException {
        run();
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            setQuizInfo();
            op = in.nextLine();
            if (op.equals("exit")) {
                System.exit(0);
            } else if (op.equals("0")) {
                break;
            }
            op = op.toUpperCase();
            judge();
            System.out.print("输入Enter键以继续...");
            in.nextLine();
        }
    }

    /**
     * 生成知识问答题面
     */
    private void setQuizInfo() throws IOException {
        Random rand = new Random();
        int id = rand.nextInt(1000);
        id = id % allQuizNum;
        while (vis[id] == 1) {
            id = rand.nextInt(1000);
            id = id % allQuizNum;
        }
        vis[id] = 1;
        quizInfo = new QuizInfo(id);
        QuizScene quizScene = new QuizScene(quizInfo);
        quizScene.printScene();
    }

    /**
     * 判断答案是否正确并反馈
     */
    private void judge() throws IOException {
        if (op.equals(quizInfo.getAns())) {
            System.out.println("恭喜你！答案正确，获得五积分！");
            UserInfo userInfo = new UserInfo();
            userInfo.addScore(5);
        } else {
            System.out.println("太遗憾了！答案错误，正确答案是：" + quizInfo.getAns());
        }
    }
}
