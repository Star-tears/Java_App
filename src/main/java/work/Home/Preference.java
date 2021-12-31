package work.Home;

import work.DataInfo.ThemesInfo;
import work.Scene.PreferenceScene;

import java.io.IOException;
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
            }
        }
    }

    private void chooseThemes() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        op = in.nextLine();
        if (!op.equals("0")) {
            ThemesInfo.setThemes(op);
        }
    }
}
