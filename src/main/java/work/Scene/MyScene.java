package work.Scene;

import work.DataInfo.ThemesInfo;

import java.util.ArrayList;

import static work.DataInfo.ThemesInfo.color;
import static work.DataInfo.ThemesInfo.highlight_color;

public class MyScene {
    public static String pleaseEnter = "请输入>>> ";
    public int width;
    public int height;
    public ArrayList<String> myWindows;
    public ArrayList<String> selectOption;
    public int bound_color;
    public int title_color;
    public int sepLine_color;
    public int content_color;
    public int selections_color;
    public int notice_color;
    public int input_color;

    MyScene() {
        this.width = 38;
        this.height = 16;
        this.myWindows = new ArrayList<>();
        this.selectOption = new ArrayList<>();
        init();
    }

    MyScene(int wid, int hei) {
        this.width = wid;
        this.height = hei;
        this.myWindows = new ArrayList<>();
        this.selectOption = new ArrayList<>();
        init();
    }

    /**
     * 清屏
     */
    public static void clean() {
        //System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n------------------------------------------------------------------------------------------------");
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033c");
            }
        } catch (Exception exception) {
            //  Handle exception.
        }
        System.out.println();
    }

    /**
     * 半角转全角
     *
     * @param input 输入字符串参数
     * @return 全角字符串.
     */
    public static String convert2DoubleByte(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') c[i] = '\u3000';
            else if (c[i] < '\177') c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }


    /**
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param content 要打印的内容
     */
    public static String colorString(int code, String content) {
        return String.format("\033[%dm%s\033[0m", code, content);
    }


    /**
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param n       数字+m：1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static String colorString(int code, int n, String content) {
        return String.format("\033[%d;%dm%s\033[0m", code, n, content);
    }

    /**
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param n       数字+m：1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static String colorString(int code, int n, int n2, String content) {
        return String.format("\033[%d;%d;%dm%s\033[0m", code, n, n2, content);
    }

    /**
     * 从当前位置开始字符颜色定义
     *
     * @param code 颜色id
     * @return 返回
     */
    public static String colorStart(int code) {
        return String.format("\033[%dm", code);
    }

    /**
     * 初始化
     */
    public void init() {

        for (int i = 0; i < this.height; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < this.width; j++) {
                if (i == 0 && j == 0) tmp.append("┌");
                else if (i == 0 && j == this.width - 1) tmp.append("┐");
                else if (i == this.height - 1 && j == 0) tmp.append("└");
                else if (i == this.height - 1 && j == this.width - 1) tmp.append("┘");
                else if (i == 0 || i == this.height - 1) tmp.append("=");
                else if (j == 0 || j == this.width - 1) tmp.append("│");
                else tmp.append(" ");
            }
            this.myWindows.add(convert2DoubleByte(tmp.toString()));
        }
    }

    /**
     * 替换index行的信息，where表示以何种方式对齐
     *
     * @param index 第index行
     * @param s     插入字符串
     * @param where 对齐方式
     */
    public void replaceLine(int index, String s, String where) {
        int len = s.length();
        StringBuilder tmp = new StringBuilder(this.myWindows.get(index));
        switch (where) {
            case "center":
                tmp.replace(this.width / 2 - len / 2, this.width / 2 - len / 2 + len, convert2DoubleByte(s));
                break;
            case "left":
                tmp.replace(1, 1 + len, convert2DoubleByte(s));
                break;
            case "right":
                tmp.replace(this.width - 1 - len, this.width - 1, convert2DoubleByte(s));
                break;
        }
        this.myWindows.set(index, tmp.toString());
    }

    /**
     * 从第index行插入字符串s
     *
     * @param index 第index行
     * @param s     插入字符串
     */
    public void insertLine(int index, String s) {
        ArrayList<String> tmp = new ArrayList<>();
        int st = 0;
        while (st < s.length()) {
            tmp.add(s.substring(st, Math.min(s.length(), st + this.width - 2)));
            st += this.width - 2;
        }
        for (int i = 0; i < tmp.size(); i++) {
            replaceLine(i + index, tmp.get(i), "left");
        }
    }

    /**
     * 从第index行第pos个位置插入字符串s
     *
     * @param index 第index行
     * @param pos   第pos个字符
     * @param s     插入字符串
     */
    public void insertLine(int index, int pos, String s) {
        ArrayList<String> tmp = new ArrayList<>();
        int st = 0;
        tmp.add(this.myWindows.get(index).substring(1, pos) + s.substring(st, st + Math.min(s.length(), this.width - pos - 1)));
        st += this.width - pos - 1;
        while (st < s.length()) {
            tmp.add(s.substring(st, Math.min(s.length(), st + this.width - 2)));
            st += this.width - 2;
        }
        for (int i = 0; i < tmp.size(); i++) {
            replaceLine(i + index, tmp.get(i), "left");
        }
    }

    /**
     * 分割线
     *
     * @param index 第index行
     * @param ch    分割字符样式
     */
    public void sepLine(int index, char ch) {
//        this.insertLine(index, String.valueOf(ch).repeat(Math.max(0, this.width - 2)));
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < this.width - 2; i++) {
            tmp.append(ch);
        }
        this.insertLine(index, tmp.toString());
    }

    /**
     * 读取所有颜色
     */
    public void getAllColor() {
        this.bound_color = ThemesInfo.getBound_color();
        this.title_color = ThemesInfo.getTitle_color();
        this.sepLine_color = ThemesInfo.getSepLine_color();
        this.content_color = ThemesInfo.getContent_color();
        this.selections_color = ThemesInfo.getSelections_color();
        this.notice_color = ThemesInfo.getNotice_color();
        this.input_color = ThemesInfo.getInput_color();
    }

    /**
     * 输出屏幕当前所有信息
     */
    public void printScene() {
        clean();
        getAllColor();
        printMainScene();
        printSelections();
        printInput();
    }

    /**
     * 打印主要界面部分
     */
    public void printMainScene() {
        for (int i = 0; i < this.height; i++) {
            if (i == 1) {
                printOneLine(i, title_color);
            }else if(i==2){
                printOneLine(i, sepLine_color);
            }else if (i == 0 || i == this.height - 1) {
                printOneLine(i, bound_color);
            } else {
                printOneLine(i, content_color);
            }
        }
    }

    /**
     * 打印选项部分
     */
    public void printSelections() {
        for (String selectOption : this.selectOption) {
            System.out.println(colorString(highlight_color(selections_color), 1, selectOption));
        }
    }

    /**
     * 打印输入部分
     */
    public void printInput() {
        System.out.print(colorString(highlight_color(notice_color), 1, pleaseEnter) + colorStart(highlight_color(input_color)));
    }

    /**
     * 打印第index行
     *
     * @param index 行号
     * @param color 色号
     */
    public void printOneLine(int index, int color) {
        System.out.println(colorString(bound_color, 1, this.myWindows.get(index).substring(0, 1)) +
                colorString(highlight_color(color), 1, this.myWindows.get(index).substring(1, this.width - 1)) +
                colorString(bound_color, 1, this.myWindows.get(index).substring(this.width - 1, this.width)));
    }

    /**
     * 打印第index行
     *
     * @param index 行号
     * @param color 色号
     * @param num1  参数
     */
    public void printOneLine(int index, int color, int num1) {
        System.out.println(colorString(bound_color, 1, this.myWindows.get(index).substring(0, 1)) +
                colorString(highlight_color(color), 1, num1, this.myWindows.get(index).substring(1, this.width - 1)) +
                colorString(bound_color, 1, this.myWindows.get(index).substring(this.width - 1, this.width)));
    }

}
