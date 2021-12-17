package work;

import work.DataInfo.DataInfo;
import work.Home.Home;
import work.LogReg.Login;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainWindows {
    MainWindows() throws IOException, InterruptedException, URISyntaxException {
        this.run();
    }

    public void run() throws IOException, InterruptedException, URISyntaxException {
        new DataInfo(0);
        new Login();
        new Home();
    }
}
