package com.fei.feilibs_1_0_0.utils;

import java.io.File;
import java.io.IOException;

/**
 * @author fei
 * 有关于File的一些操作
 */
public class FileUtil {

    /**
     * 将文件存储在外部存储中
     * 路径不存在先生成路径，文件不存在生成文件
     *
     * @param path
     * @param name
     * @return
     * @throws IOException
     */
    public static File getFile(String path, String name) throws IOException {
        File parent = new File(path + "/");
        if (!parent.exists()) {
            parent.mkdirs();
        }
        File file = new File(path + "/" + name);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}
