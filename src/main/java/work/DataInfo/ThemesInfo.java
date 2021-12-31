package work.DataInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThemesInfo {
    private static String themes = "light";
    private static int bound_color = 36;
    private static int title_color = 34;
    private static int sepLine_color = 33;
    private static int content_color = 32;
    private static int selections_color = 36;
    private static int notice_color = 32;
    private static int input_color = 32;
    private static Map<String, Integer> color_id = new HashMap<String,Integer>() {{
        put("black", 30);
        put("red", 31);
        put("green", 32);
        put("yellow", 33);
        put("blue", 34);
        put("purple", 35);
        put("darkgreen", 36);
        put("white", 37);
    }};

    public ThemesInfo() {
    }

    public static String getThemes() {
        return themes;
    }

    public static void setThemes(String themes) throws IOException {
        ThemesInfo.themes = themes;
        InputStream is = ThemesInfo.class.getResourceAsStream("/work/DataInfo/data/themes/" + ThemesInfo.themes + ".txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String line = "";
        ArrayList<Integer> tmp = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            if (line.equals("")) continue;
            tmp.add(ThemesInfo.color(line));
        }
        in.close();
        ThemesInfo.bound_color = tmp.get(0);
        ThemesInfo.title_color = tmp.get(1);
        ThemesInfo.sepLine_color = tmp.get(2);
        ThemesInfo.content_color = tmp.get(3);
        ThemesInfo.selections_color = tmp.get(4);
        ThemesInfo.notice_color = tmp.get(5);
        ThemesInfo.input_color = tmp.get(6);
    }

    public static int getBound_color() {
        return bound_color;
    }

    public static int getTitle_color() {
        return title_color;
    }

    public static int getSepLine_color() {
        return sepLine_color;
    }

    public static int getContent_color() {
        return content_color;
    }

    public static int getSelections_color() {
        return selections_color;
    }

    public static int getNotice_color() {
        return notice_color;
    }

    public static int getInput_color() {
        return input_color;
    }

    public static int color(String c) {
        return color_id.get(c);
    }

    public static int highlight_color(int id) {
        return id + 60;
    }

    public static int background_color(int id) {
        return id + 10;
    }
}
