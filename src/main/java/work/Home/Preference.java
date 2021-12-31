package work.Home;

import work.DataInfo.ThemesInfo;
import work.Scene.PreferenceScene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Preference {
    private String op;
    private PreferenceScene preferenceScene;

    public Preference() throws IOException, InterruptedException {
        run();
    }

    public void run() throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            preferenceScene = new PreferenceScene();
            preferenceScene.printScene();
            op = in.nextLine();
            switch (op) {
                case "exit":
                    System.exit(0);
                case "0":
                    flag = true;
                    break;
                case "themes":
                    chooseThemes();
                    break;
                case "preference":
                    new SettingOfPre();
                    break;
            }
        }
    }

    private void chooseThemes() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入您想选择的主题:");
        op = in.nextLine();
        if (ThemesInfo.getAllThemes().contains(op)) {
            ThemesInfo.setThemes(op);
        } else {
            System.out.print("该主题不存在,按Enter键返回...");
            in.nextLine();
        }
    }
}
