package work.DataInfo;

import java.io.File;
import java.io.IOException;

public class PathPrefix {
    public static final String path_prefix = "./sch_JavaData/data/";

    /**
     * 创建文件夹
     *
     * @param file 文件名
     */
    PathPrefix(File file) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
    }
}
