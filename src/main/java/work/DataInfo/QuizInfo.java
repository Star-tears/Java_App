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

    public QuizInfo(int id) throws IOException {
        id = id % 11;
        InputStream is = this.getClass().getResourceAsStream("/work/DataInfo/data/question/" + id + ".txt");
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

    public String getQuiz() {
        return quiz;
    }

    public String getSelction() {
        return selction;
    }

    public String getAns() {
        return ans;
    }
}
