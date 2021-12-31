package work.Scene;

import static work.DataInfo.ThemesInfo.highlight_color;

public class SettingOfPreScene extends MyScene {
    public SettingOfPreScene() {
        super();
    }

    @Override
    public void init() {
        super.init();
        this.replaceLine(1, "颜 色 定 制", "center");
        this.sepLine(2, '=');
        this.replaceLine(3, "当 前 颜 色", "center");
        this.insertLine(4, this.width / 5 * 2, "bound");
        this.insertLine(5, this.width / 5 * 2, "title");
        this.insertLine(6, this.width / 5 * 2, "sepline");
        this.insertLine(7, this.width / 5 * 2, "content");
        this.insertLine(8, this.width / 5 * 2, "selections");
        this.insertLine(9, this.width / 5 * 2, "notice");
        this.insertLine(10, this.width / 5 * 2, "input");
        this.insertLine(12, "可供选择的颜色：");
        this.insertLine(13, "black red green yellow");
        this.insertLine(14, "blue purple darkgreen white");
        this.selectOption.add("返回[0] 个性化定制[<position> <color>] 退出应用[exit]");
    }

    @Override
    public void printMainScene() {
        for (int i = 0; i < this.height; i++) {
            if (i == 2) {
                printOneLine(i, sepLine_color);
            } else if (i == 4) {
                printOneLine(i, bound_color, 7);
            } else if (i == 5) {
                printOneLine(i, title_color, 7);
            } else if (i == 6) {
                printOneLine(i, sepLine_color, 7);
            } else if (i == 7) {
                printOneLine(i, content_color, 7);
            } else if (i == 8) {
                printOneLine(i, selections_color, 7);
            } else if (i == 9) {
                printOneLine(i, notice_color, 7);
            } else if (i == 10) {
                printOneLine(i, input_color, 7);
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
