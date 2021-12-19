package work.Scene;

import java.util.ArrayList;
import java.io.IOException;

public class MyScene {
    public static String pleaseEnter = new String(colorString("", 33, 1, "请输入>>> "));
    public int width;
    public int height;
    public ArrayList<String> myWindows;
    public ArrayList<String> selectOption;

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

    //清屏
    public static void clean() throws IOException, InterruptedException {
        //System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n------------------------------------------------------------------------------------------------");
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("");
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
     * @param pattern 前面的图案 such as "=============="
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param content 要打印的内容
     */
    public static void printSingleColor(String pattern, int code, String content) {
        System.out.format("%s\033[%dm%s\033[0m", pattern, code, content);
    }

    /**
     * @param pattern 前面的图案 such as "=============="
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param n       数字+m：1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static void printSingleColor(String pattern, int code, int n, String content) {
        System.out.format("%s\033[%d;%dm%s\033[0m", pattern, code, n, content);
    }

    /**
     * @param pattern 前面的图案 such as "=============="
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param content 要打印的内容
     */
    public static String colorString(String pattern, int code, String content) {
        String tmp = String.format("%s\033[%dm%s\033[0m", pattern, code, content);
        return tmp;
    }


    /**
     * @param pattern 前面的图案 such as "=============="
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param n       数字+m：1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static String colorString(String pattern, int code, int n, String content) {
        String tmp = String.format("%s\033[%d;%dm%s\033[0m", pattern, code, n, content);
        return tmp;
    }

    /**
     * @param pattern 前面的图案 such as "=============="
     * @param code    颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param n       数字+m：1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static String colorString(String pattern, int code, int n, int n2, String content) {
        String tmp = String.format("%s\033[%d;%d;%dm%s\033[0m", pattern, code, n, n2, content);
        return tmp;
    }

    //初始化
    public void init() {

        for (int i = 0; i < this.height; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < this.width; j++) {
                if (i == 0 && j == 0) tmp.append("┌");
                else if (i == 0 && j == this.width - 1) tmp.append("┐");
                else if (i == this.height - 1 && j == 0) tmp.append("└");
                else if (i == this.height - 1 && j == this.width - 1) tmp.append("┘");
                else if (i == 0 || i == this.height - 1) tmp.append("-");
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

    //输出屏幕当前信息
    public void printScene() throws IOException, InterruptedException {
        clean();
        int bound_color = 36;
        for (int i = 0; i < this.height; i++) {
            if (i == 0 || i == this.height - 1) {
                System.out.println(colorString("", bound_color, 1, this.myWindows.get(i)));
            } else {
                System.out.println(colorString("", bound_color, 1, this.myWindows.get(i).substring(0, 1)) + this.myWindows.get(i).substring(1, this.width - 1) + colorString("", bound_color, 1, this.myWindows.get(i).substring(this.width - 1, this.width)));
            }
        }
//        for (String myString : this.myWindows) {
//            System.out.println(myString);
//        }
        for (String selectOption : this.selectOption) {
            System.out.println(selectOption);
        }
        System.out.print(pleaseEnter);
    }
}
