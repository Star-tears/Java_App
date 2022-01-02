package work.Home;

import work.DataInfo.ThemesInfo;
import work.Scene.SettingOfPreScene;

import java.util.Scanner;

public class SettingOfPre {
    String[] opearation;
    private SettingOfPreScene settingOfPreScene;
    private String op;

    public SettingOfPre() {
        run();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            settingOfPreScene = new SettingOfPreScene();
            settingOfPreScene.printScene();
            op = in.nextLine();
            switch (op) {
                case "exit":
                    System.exit(0);
                case "0":
                    flag = true;
                    break;
            }
            opearation = op.split(" ");
            if (opearation.length == 2) {
                System.out.println("1");
                if (ThemesInfo.hasColor(opearation[1])) {
                    switch (opearation[0]) {
                        case "bound":
                            ThemesInfo.setBound_color(ThemesInfo.color(opearation[1]));
                            break;
                        case "title":
                            ThemesInfo.setTitle_color(ThemesInfo.color(opearation[1]));
                            break;
                        case "sepline":
                            ThemesInfo.setSepLine_color(ThemesInfo.color(opearation[1]));
                            break;
                        case "content":
                            ThemesInfo.setContent_color(ThemesInfo.color(opearation[1]));
                            break;
                        case "selections":
                            ThemesInfo.setSelections_color(ThemesInfo.color(opearation[1]));
                            break;
                        case "notice":
                            ThemesInfo.setNotice_color(ThemesInfo.color(opearation[1]));
                            break;
                        case "input":
                            ThemesInfo.setInput_color(ThemesInfo.color(opearation[1]));
                            break;
                        default:
                            System.out.println("位置错误,按Enter键以继续...");
                            in.nextLine();
                    }
                } else {
                    System.out.println("位置或颜色错误,按Enter键以继续...");
                    in.nextLine();
                }

            }

        }
    }

}
