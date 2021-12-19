package work.Scene;

import work.DataInfo.UserInfo;

import java.util.ArrayList;

public class HomeScene extends MyScene {
    public HomeScene() {
        super();
    }

    public HomeScene(int wid, int hei) {
        super(wid, hei);
    }

    @Override
    public void init() {
        super.init();
        UserInfo user=new UserInfo();
        this.replaceLine(1, "学汉语用汉字，弘扬汉语言文化", "center");
        this.replaceLine(3, "用户名：" +user.getName() +" 积分："+user.getScore()+" 排行："+user.getRank(), "right");
        this.insertLine(5, "中华文化长河源远流长、浩浩汤汤，汉字是河中的浪、水中的波，是长河上悠扬的船夫曲、高扬的云中帆。汉字是国家的根、民族的魂，字字相连、句句相扣，筑起中华文化的共同体。人民是语言文字的主人，汉字如阵，华语如鼓，中华文化前行的方队一路尘土飞扬，正书写新的史记。");
        this.replaceLine(this.height - 6, "1.知识问答", "right");
        this.replaceLine(this.height - 5, "2.文字迷宫", "right");
        this.replaceLine(this.height - 4, "3.个人信息", "right");
        this.replaceLine(this.height - 3, "4.一键三连", "right");
        this.replaceLine(this.height - 2, "5.天梯排行", "right");
        this.replaceLine(this.height-3,"道具数:","left");
        this.replaceLine(this.height-2, user.getNumOfItems_string(), "left");
        this.selectOption.add("知识问答[1] 文字迷宫[2] 个人信息[3] 一键三连[4] 天梯排行[5] 退出应用[exit]");
    }
}
