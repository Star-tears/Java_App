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
        this.insertLine(3,quizInfo.getQuiz());
        StringBuilder cut_line = new StringBuilder();
        for (int i = 0; i < this.width - 2; i++) cut_line.append("-");
        this.replaceLine(this.height / 2, cut_line.toString(), "left");
        this.replaceLine(this.height / 2 + 1, quizInfo.getSelction(), "left");
        String printScore = "积分：" + userInfo.getScore();
        this.replaceLine(this.height - 2, printScore, "right");
        this.selectOption.add("退出答题[0] 结束应用[exit]");
    }
}
