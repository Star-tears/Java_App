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
        int x = this.height / 4;
        this.replaceLine(x, "注      册", "center");
        this.replaceLine(x + 2, "注册用户名：_________", "center");
        this.replaceLine(x + 4, " 密码：____________", "center");
        this.replaceLine(x + 6, " 重复密码：__________", "center");
        this.replaceLine(this.height - 2, "welcome", "right");
    }


    @Override
    public void printMainScene() {
        for (int i = 0; i < this.height; i++) {
            if (i == 0 || i == this.height - 1) {
                System.out.println(colorString(bound_color, 1, this.myWindows.get(i)));
            } else {
                System.out.println(colorString(bound_color, 1, this.myWindows.get(i).substring(0, 1)) + colorString(highlight_color(content_color), 1, this.myWindows.get(i).substring(1, this.width - 1)) + colorString(bound_color, 1, this.myWindows.get(i).substring(this.width - 1, this.width)));
            }
        }
    }

    @Override
    public void printInput() {
        System.out.print(colorStart(highlight_color(input_color)));
    }
}
