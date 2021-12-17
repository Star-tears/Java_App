package work.DataInfo;

import java.io.File;
import java.io.IOException;

public class PathPrefix {
    public static final String path_prefix="D:\\sch_JavaData\\data\\";
    PathPrefix(File file) throws IOException {
        if(!file.exists()){
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
    }
}
