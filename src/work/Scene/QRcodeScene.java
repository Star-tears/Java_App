package work.Scene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QRcodeScene extends MyScene{
    private ArrayList<String> qrcode;

    //二维码加载
    public QRcodeScene(String s) throws IOException {
        super(31,31);
        InputStream is = this.getClass().getResourceAsStream("/work/DataInfo/data/QRcode/"+s+".txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        this.qrcode = new ArrayList<>();
        String line = "";
        while ((line=in.readLine())!=null) {
            if (line.equals("")) continue;
            this.qrcode.add(line);
        }
        in.close();
        for(int i=0;i<qrcode.size();i++){
            StringBuilder tmp=new StringBuilder();
            for(int j=0;j<qrcode.get(i).length();j++){
                if(qrcode.get(i).charAt(j)=='1')tmp.append("燚");
                else tmp.append(" ");
            }
            this.replaceLine(i+1,convert2DoubleByte(tmp.toString()),"left");
        }
        this.selectOption.add("恭喜你发现了这里，欢迎一键三连！夹带私货（bushi");
        this.selectOption.add("返回主页[0] 结束程序[exit]");
    }

    @Override
    public void init(){
        for (int i = 0; i < this.height; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < this.width; j++) {
                if (i == 0 || j == 0 || i == this.height - 1 || j == this.width - 1) tmp.append("+");
                else tmp.append(" ");
            }
            this.myWindows.add(convert2DoubleByte(tmp.toString()));
        }
    }
}
