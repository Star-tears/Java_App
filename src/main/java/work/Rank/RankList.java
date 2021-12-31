package work.Rank;

import work.DataInfo.UserInfo;
import work.DataInfo.UserScore;
import work.Scene.RankListScene;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class RankList {
    private String op;
    private RankListScene rankListScene;
    public RankList() throws IOException, InterruptedException {
        run();
    }

    public void run() throws IOException, InterruptedException {
        Scanner in=new Scanner(System.in);
        rankListScene=new RankListScene();
        boolean flag=false;
        while (!flag){
            rankListScene.printScene();
            op=in.nextLine();
            switch (op){
                case "exit":
                    System.exit(0);
                case "0":
                    flag=true;
                    break;
                case "[":
                    rankListScene.page_change(rankListScene.getPage_pos()-1);
                    break;
                case "]":
                    rankListScene.page_change(rankListScene.getPage_pos()+1);
                    break;
            }
        }
    }
}
