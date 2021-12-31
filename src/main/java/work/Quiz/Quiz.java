package work.Quiz;

import work.DataInfo.QuizInfo;
import work.DataInfo.UserInfo;
import work.Scene.QuizScene;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    private QuizInfo quizInfo;
    private String op;

    public Quiz() throws IOException, InterruptedException {
        run();
    }

    public void run() throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            setQuizInfo();
            op = in.nextLine();
            if (op.equals("exit")) {
                System.exit(0);
            } else if (op.equals("0")) {
                break;
            }
            op=op.toUpperCase();
            judge();
            System.out.print("输入Enter键以继续...");
            in.nextLine();
        }
    }

    private void setQuizInfo() throws IOException, InterruptedException {
        Random rand = new Random();
        int id = rand.nextInt(1000);
        quizInfo = new QuizInfo(id);
        QuizScene quizScene=new QuizScene(quizInfo);
        quizScene.printScene();
    }

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
