package work.Scene;

import work.DataInfo.QuizInfo;
import work.DataInfo.UserInfo;

public class QuizScene extends MyScene {
    private QuizInfo quizInfo;
    private UserInfo userInfo;

    public QuizScene(QuizInfo quizinfo) {
        super();
        userInfo = new UserInfo();
        quizInfo = quizinfo;
        addQuizInfo();
    }

    private void addQuizInfo() {
        this.replaceLine(1, "知 识 问 答", "center");
        this.sepLine(2,'=');
        this.insertLine(3, quizInfo.getQuiz());
        this.sepLine(this.height / 2, '-');
        this.replaceLine(this.height / 2 + 1, quizInfo.getSelction(), "left");
        String printScore = "积分：" + userInfo.getScore();
        this.replaceLine(this.height - 2, printScore, "right");
        this.selectOption.add("退出答题[0] 结束应用[exit]");
    }

    @Override
    public void printMainScene() {
        for (int i = 0; i < this.height; i++) {
            if (i == 2 || i == this.height / 2) {
                printOneLine(i, sepLine_color);
            } else if (i == 1) {
                printOneLine(i, title_color);
            } else if (i == 0 || i == this.height - 1) {
                System.out.println(colorString(bound_color, 1, this.myWindows.get(i)));
            } else {
                printOneLine(i, content_color);
            }
        }
    }
}
