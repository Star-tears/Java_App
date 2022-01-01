package work.Scene;

import java.io.IOException;

import static work.DataInfo.ThemesInfo.color;
import static work.DataInfo.ThemesInfo.highlight_color;

public class RegScene extends MyScene {
    public RegScene() {
        super();
    }

    public RegScene(int wid, int hei) {
        super(wid, hei);
    }

    @Override
    public void init() {
        for (int i = 0; i < this.height; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < this.width; j++) {
                if (i == 0 || j == 0 || i == this.height - 1 || j == this.width - 1) tmp.append("+");
                else tmp.append(" ");
            }
            this.myWindows.add(convert2DoubleByte(tmp.toString()));
        }
        this.replaceLine(1, "欢 迎 来 到 汉 字 世 界 ！", "center");
        this.sepLine(2, '=');
        int x = this.height / 4;
        this.replaceLine(x, "注      册", "center");
        this.replaceLine(x + 2, "注册用户名：_________", "center");
        this.replaceLine(x + 4, " 密码：____________", "center");
        this.replaceLine(x + 6, " 重复密码：__________", "center");
        this.replaceLine(this.height - 2, "welcome", "right");
    }


    @Override
    public void printInput() {
        System.out.print(colorStart(highlight_color(input_color)));
    }
}
