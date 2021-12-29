package work.Scene;

import work.DataInfo.UserInfo;

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
    }
}
