package com.doit.demo;


import java.io.File;
import java.io.FileFilter;

/**
 * @ClassName: Test
 * @Author: zll
 * @CreateTime: 2021/6/29 19:43
 * @Desc: java 程序
 * @Version: 1.0
 */
//过滤器接口FileFilter
public class DemoFilter {
    public static void main(String[] args)  {
        File file = new File("d:\\zll\\apps\\day02");

        FilterFile(file);

        deleteFile(file);
    }

    public static void FilterFile(File file){
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    return true;
                }
                boolean b = pathname.getName().toLowerCase().endsWith(".java");
                return b;
            }
        });

        if (files!=null) {
            for (File f:files){
                if (f.isDirectory()){
                    FilterFile(f);
                }else {
                    System.out.println(f.getName());
                }
            }
        }
    }

    public static void deleteFile(File file){
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if(f.isFile()){
                    f.delete();
                }else {
                    deleteFile(f);
                }
            }
            file.delete();
        }
    }
}


