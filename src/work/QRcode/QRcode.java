package work.QRcode;

import work.Scene.QRcodeScene;

import java.io.IOException;
import java.util.Scanner;

public class QRcode {
    public QRcode(String s) throws IOException, InterruptedException {
        run(s);
    }
    public void run(String s) throws IOException, InterruptedException {
        Scanner in=new Scanner(System.in);
        String op;
        boolean flag=false;
        while (!flag){
            QRcodeScene qRcodeScene=new QRcodeScene(s);
            qRcodeScene.printScene();
            op=in.nextLine();
            switch (op){
                case "exit":
                    System.exit(0);
                case "0":
                    flag=true;
                    break;
            }
        }
    }

}
