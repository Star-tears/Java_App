package work.Home;

import work.Game.WordsGame;
import work.QRcode.QRcode;
import work.Quiz.Quiz;
import work.Rank.RankList;
import work.Scene.HomeScene;

import java.io.IOException;
import java.util.Scanner;

public class Home {
    public Home() throws IOException, InterruptedException {
        this.run();
    }

    public void run() throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        while (true) {
            HomeScene homeScene = new HomeScene();
            homeScene.printScene();
            String op = in.nextLine();
            switch (op) {
                case "exit":
                    System.exit(0);
                case "0":
                    break;
                case "1":
                    new Quiz();
                    break;
                case "2":
                    new WordsGame();
                    break;
                case "3":
                    new Preference();
                    break;
                case "4":
                    new QRcode("Bilibili");
                    break;
                case "5":
                    new RankList();
                    break;
            }
        }
    }
}
