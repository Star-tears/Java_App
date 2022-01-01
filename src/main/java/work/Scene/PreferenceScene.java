package work.Scene;

import work.DataInfo.ThemesInfo;
import work.DataInfo.UserInfo;

import static work.DataInfo.ThemesInfo.highlight_color;

public class PreferenceScene extends MyScene {
    public PreferenceScene() {
        super();
    }

    @Override
    public void init() {
        super.init();
        UserInfo userInfo = new UserInfo();
        this.replaceLine(1, "个 人 信 息 及 偏 好 设 置", "center");
        this.sepLine(2, '=');
        this.replaceLine(3, "用 户 信 息:", "left");
        this.replaceLine(4, "用户名:" + userInfo.getName() + "  积分：" + userInfo.getScore() + "  排名：" + userInfo.getRank(), "left");
        this.replaceLine(6, "用 户 道 具 数:", "left");
        this.replaceLine(7, userInfo.getNumOfItems_string(), "left");
        this.sepLine(this.height / 2, '-');
        this.replaceLine(this.height / 2 + 1, "个 性 化 设 置", "center");
        this.insertLine(this.height / 2 + 2, "当前主题:" + ThemesInfo.getThemes());
        this.sepLine(this.height / 2 + 3, '+');
        this.insertLine(this.height / 2 + 4, "可供选择的主题:");
        this.insertLine(this.height / 2 + 5, "light dark");
        this.insertLine(this.height / 2 + 6, "beauty windy");
        this.selectOption.add("返回主页[0] 选择主题[themes] 个性化配色[preference] 结束应用[exit]");
    }

    @Override
    public void printMainScene() {
        for (int i = 0; i < this.height; i++) {
            if (i == 2 || i == this.height / 2 || i == this.height / 2 + 3) {
                printOneLine(i, sepLine_color);
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
