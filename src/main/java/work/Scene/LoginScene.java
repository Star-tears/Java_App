package work.Scene;

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
        int x = this.height / 3;
        this.replaceLine(x, "登      录", "center");
        this.replaceLine(x + 3, "用户名：____________", "center");
        this.replaceLine(x + 5, " 密码：____________", "center");
        this.replaceLine(this.height - 2, "QAQ", "right");
        this.selectOption.add("登录[1] 注册[2] 退出应用[exit]");
    }
}
