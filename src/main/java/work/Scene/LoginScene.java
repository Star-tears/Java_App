package work.Scene;

import work.DataInfo.ThemesInfo;

public class LoginScene extends MyScene {
    public LoginScene() {
        super();
    }

    public LoginScene(int wid, int hei) {
        super(wid, hei);
    }

    @Override
    public void init() {
        super.init();
        this.replaceLine(1, "欢 迎 来 到 汉 字 世 界 ！", "center");
        this.sepLine(2, '=');
        int x = this.height / 3;
        this.replaceLine(x, "登      录", "center");
        this.replaceLine(x + 3, "用户名：____________", "center");
        this.replaceLine(x + 5, " 密码：____________", "center");
        this.replaceLine(this.height - 2, "QAQ", "right");
        this.selectOption.add("登录[1] 注册[2] 退出应用[exit]");
        this.selectOption.add(colorString(ThemesInfo.highlight_color(ThemesInfo.color("blue")), 7, "操作帮助：形如\"操作名[操作命令]\",即输入方括号内操作命令执行该操作。"));
    }
}
