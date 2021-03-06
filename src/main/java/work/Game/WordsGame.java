package work.Game;

import work.Scene.MazeScene;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class WordsGame {
    private String op;
    private int difficulty;
    private MazeScene mazeScene;

    public WordsGame() throws IOException, InterruptedException {
        run();
    }

    public void run() throws IOException, InterruptedException {
        init();
        Scanner in = new Scanner(System.in);
        while (true) {
            mazeScene.printScene();
            op = in.nextLine();
            if (op.equals("exit")) {
                System.exit(0);
            } else if (op.equals("0")) {
                break;
            }
            action();
        }
    }

    /**
     * 初始化迷宫信息
     */
    private void init() {
        selectonDifficulty();
        mazeScene = new MazeScene(difficulty + 2, difficulty + 2);
        Maze mazetmp = new Maze(difficulty, difficulty);
        ArrayList<String> maze = mazetmp.getMazeScene();
        for (int i = 0; i < maze.size(); i++) {
            mazeScene.insertLine(i + 1, maze.get(i));
        }
    }

    /**
     * 选择迷宫难度
     */
    private void selectonDifficulty() {
        Scanner in = new Scanner(System.in);
        System.out.println("简单(11*11) 中等(31*31) 困难(51*51)");
        System.out.println("简单[1] 中等[2] 困难[3]");
        System.out.print("请选择迷宫难度：");
        int num = in.nextInt();
        while (num < 1 || num > 3) {
            System.out.print("非法输入，请重新输入：");
            num = in.nextInt();
        }
        difficulty = (2 * num - 1) * 10 + 1;
    }

    /**
     * 移动角色
     */
    private void action() throws IOException {
        op = op.toUpperCase();
        for (int i = 0; i < op.length(); i++) {
            if (op.charAt(i) == 'W' || op.charAt(i) == 'A' || op.charAt(i) == 'S' || op.charAt(i) == 'D')
                mazeScene.move(op.charAt(i));
        }
    }
}
