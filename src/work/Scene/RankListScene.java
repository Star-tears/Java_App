package work.Scene;

import work.DataInfo.UserInfo;
import work.DataInfo.UserScore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import static work.DataInfo.ThemesInfo.highlight_color;

public class RankListScene extends MyScene {
    private TreeSet<UserScore> userScoresRankList;
    private int page_pos;
    private int allpage_num;
    private int onepage_alluser_num;
    private ArrayList<String> Init_myWindows;

    public RankListScene() {
        super();
    }

    @Override
    public void init() {
        super.init();
        page_pos = 1;
        onepage_alluser_num = this.height - 5;
        userScoresRankList = new UserInfo().getAllUserScoreSet();
        allpage_num = (userScoresRankList.size() - 1) / (onepage_alluser_num) + 1;
        this.replaceLine(1, "天 梯 排 行", "center");
        this.replaceLine(2, "排名", "left");
        this.insertLine(2, 5, "用户名");
        this.replaceLine(2, "积分", "right");
        this.Init_myWindows = new ArrayList<>(this.myWindows);
        page_change(page_pos);
        this.selectOption.add("返回主页[0] 上一页[" + colorString(36, 1, "[") + "] 下一页[" + colorString(36, 1, "]") + "] 退出应用[exit]");
    }

    public int getPage_pos() {
        return page_pos;
    }

    public void page_change(int next_pos) {
        this.myWindows = new ArrayList<>(Init_myWindows);
        if (1 <= next_pos && next_pos <= allpage_num) {
            page_pos = next_pos;
        }
        this.replaceLine(this.height - 2, page_pos + "/" + allpage_num + "页", "center");
        TreeSet<UserScore> tmp_userScoresRankList = new TreeSet<>(userScoresRankList);
        for (int i = 1; i < page_pos; i++) {
            for (int j = 0; j < onepage_alluser_num; j++) {
                tmp_userScoresRankList.pollFirst();
            }
        }
        int rank_pos = (page_pos - 1) * (onepage_alluser_num);
        for (int i = 0; i < onepage_alluser_num && tmp_userScoresRankList.size() != 0; i++) {
            rank_pos++;
            UserScore tmp_userScore = tmp_userScoresRankList.pollFirst();
            this.insertLine(3 + i, rank_pos + "");
            this.insertLine(3 + i, 5, tmp_userScore.getName());
            this.replaceLine(3 + i, "" + tmp_userScore.getScore(), "right");
        }
    }


    @Override
    public void printMainScene() {
        for (int i = 0; i < this.height; i++) {
            if (i == 0 || i == this.height - 1) {
                System.out.println(colorString(bound_color, 1, this.myWindows.get(i)));
            } else {
                System.out.println(colorString(bound_color, 1, this.myWindows.get(i).substring(0, 1)) + colorString(33, 1, this.myWindows.get(i).substring(1, this.width - 1)) + colorString(bound_color, 1, this.myWindows.get(i).substring(this.width - 1, this.width)));
            }
        }
    }
}
