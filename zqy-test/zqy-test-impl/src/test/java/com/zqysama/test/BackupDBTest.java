package com.zqysama.test;

import java.io.File;
import java.io.IOException;

public class BackupDBTest {

    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/resources/db-backup";

        String file = backup("127.0.0.1", "tbrain", "tbrain", basePath, "20210114tbrain_wf-backup", "tbrain_wf");


    }

    public static String backup(String hostIP,  String userName, String password, String savePath, String fileName,
                                 String databaseName) {
        fileName +=".sql";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        //拼接命令行的命令
        StringBuilder cmd = new StringBuilder();
        cmd.append("mysqldump").append(" --opt").append(" -h").append(hostIP);
        cmd.append(" --user=").append(userName).append(" --password=").append(password)
                .append(" --lock-all-tables=true");
        cmd.append(" --result-file=").append(savePath).append(fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);
        try {
            //调用外部执行exe文件的javaAPI
            Process process = Runtime.getRuntime().exec(cmd.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                return savePath + saveFile;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
