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
    static String s = "D:\\zll\\Pictures\\testCopy";
    static String s2 = "D:\\zll\\apps\\test";
    public static void main(String[] args) {
        File fileOut = new File(s);
        boolean b = fileOut.mkdirs();//创建目标文件夹testCopy
        System.out.println(b);
        File file = new File(s2);

        cursorFile(file,fileOut);
    }

    public static void cursorFile(File file,File fileOut){
        File[] files = file.listFiles();
        for (File f : files){
            fileOut = new File(s + f.toString().replace(s2, ""));
            if (f.isDirectory()){
                fileOut.mkdirs();//创建目标文件夹
                cursorFile(f,fileOut);
            }else {
                System.out.println(fileOut);
                fileCopy(f,fileOut);
            }
        }
    }


    public static void fileCopy(File file,File fileOut) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(fileOut);
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
