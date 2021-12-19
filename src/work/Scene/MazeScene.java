package work.Scene;

import work.DataInfo.UserInfo;

import java.io.IOException;
import java.util.ArrayList;

public class MazeScene extends MyScene {
    private int nowx;
    private int nowy;

    public MazeScene(int width, int height) {
        super(width, height);
        nowx = 1;
        nowy = 1;
    }



    @Override
    public void init() {

        for (int i = 0; i < this.height; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < this.width; j++) {
                if (i == 0 || j == 0 || i == this.height - 1 || j == this.width - 1) tmp.append("墙");
                else tmp.append(" ");
            }
            this.myWindows.add(convert2DoubleByte(tmp.toString()));
        }
        this.selectOption.add("移动(上下左右)[WSAD](大小写都可) 返回主页[0] 结束应用[exit]");
    }

    @Override
    public void printScene() throws IOException, InterruptedException {
        clean();
        for (int i = 0; i < this.myWindows.size(); i++) {
            if(i==this.height-2&&i==nowx){
                System.out.print(this.myWindows.get(i).substring(0,nowy));
                printSingleColor("", 31, 1,this.myWindows.get(i).substring(nowy,nowy+1));
                if(nowy<this.width-2){
                    System.out.print(this.myWindows.get(i).substring(nowy+1,this.width-2));
                    printSingleColor("", 36, this.myWindows.get(i).substring(this.width-2,this.width-1));
                }
                System.out.println(this.myWindows.get(i).substring(this.width-1,this.width));
            }
            else if (i == nowx){
                System.out.print(this.myWindows.get(i).substring(0,nowy));
                printSingleColor("", 31, 1,this.myWindows.get(i).substring(nowy,nowy+1));
                System.out.println(this.myWindows.get(i).substring(nowy+1,this.width));
            }else if(i==this.height-2){
                System.out.print(this.myWindows.get(i).substring(0,this.width-2));
                printSingleColor("", 36, this.myWindows.get(i).substring(this.width-2,this.width-1));
                System.out.println(this.myWindows.get(i).substring(this.width-1,this.width));
            }else
                System.out.println(this.myWindows.get(i));
        }
        for (String selectOption : this.selectOption) {
            System.out.println(selectOption);
        }
        System.out.println("当前道具数：");
        System.out.println(new UserInfo().getNumOfItems_string());
        System.out.print(pleaseEnter);
    }

    public void move(char directiion) throws IOException {
        int nex = nowx, ney = nowy;
        if (directiion == 'W') nex -= 1;
        else if (directiion == 'S') nex += 1;
        else if (directiion == 'A') ney -= 1;
        else if (directiion == 'D') ney += 1;
        if (nex >= 1 && nex <= this.height - 2 && ney >= 1 && ney <= this.width - 2 && this.myWindows.get(nex).charAt(ney) != '墙') {
            new UserInfo().addItem(this.myWindows.get(nex).charAt(ney), 1);
            this.insertLine(nex, ney, "我");
            this.insertLine(nowx, nowy, " ");
            nowx = nex;
            nowy = ney;
        }
    }

}
