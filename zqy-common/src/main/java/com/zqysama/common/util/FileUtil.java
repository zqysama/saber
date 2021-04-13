package com.zqysama.common.util;

import java.io.File;

public class FileUtil {

    public static boolean checkFileExist(String path) {
        File file = new File(path);
        return file.exists();
    }
}
