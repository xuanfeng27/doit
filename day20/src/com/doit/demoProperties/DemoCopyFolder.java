package com.doit.demoProperties;

import java.io.*;

/**
 * @ClassName: DemoCopyFolder
 * @Author: zll
 * @CreateTime: 2021/6/30 18:02
 * @Desc: java 程序
 * @Version: 1.0
 */
//复制文件夹
public class DemoCopyFolder {
    public static void main(String[] args) {
        File file = new File("D:\\zll\\apps\\test");
        File[] files = file.listFiles();
        for (File f : files){
            fileCopy(f);
        }
    }

    public static void fileCopy(File file) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream("D:\\zll\\Pictures\\testCopy\\"+file.getName());
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes))!= -1){
                out.write(bytes, 0, len);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (in != null) {
                        in.close();//先开的后关
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
