package work.DataInfo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizInfo {
    private String quiz;
    private String selction;
    private String ans;
    private static final int allQuizNum = 20;

    public QuizInfo(int id) throws IOException {
        id = id % allQuizNum;
        InputStream is = this.getClass().getResourceAsStream("/data/question/" + id + ".txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lines.add(in.readLine());
        }
        this.quiz = lines.get(0);
        this.selction = lines.get(1);
        this.ans = lines.get(2);
        in.close();
    }

    /**
     * @return 返回问题
     */
    public String getQuiz() {
        return quiz;
    }

    /**
     * @return 返回选项
     */
    public String getSelction() {
        return selction;
    }

    /**
     * @return 返回正确答案
     */
    public String getAns() {
        return ans;
    }

    public static int getAllQuizNum() {
        return allQuizNum;
    }
}
