package com.doit.IOtest;

import java.io.*;
import java.util.*;

/**
 * @ClassName: IOtest
 * @Author: zll
 * @CreateTime: 2021/7/1 17:09
 * @Desc: java 程序
 * @Version: 1.0
 */
//1.将一个文件中的内容读取,然后倒叙写回
//2.将1.txt中的内容和2.txt中的内容合并写到3.txt中
//3.从类似的文件中的读取信息,然后按照年龄进行排序后将排序后的内容按照格式写回文件中
// liuyan,38-tangyang,18-jinlian,138-dalang,8
//4.编写一个程序将一个文件夹下的所有.java文件复制到另一个文件夹下,并将后缀改为.jad(单级目录);
public class IOtest {
    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        //test3();
        test4();
    }

    public static void test1() throws IOException {
        File file = new File("d:\\zll\\apps\\test.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file,true);
        int len = 0;
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((len = fis.read(bytes))!= -1) {
            sb.append(new String(bytes,0,len));
        }
        String s = sb.reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);
            fos.write(b);
        }

        fos.close();
        fis.close();
    }

    public static void test2() throws IOException {
        File file = new File("d:\\zll\\apps\\1.txt");
        File file2 = new File("d:\\zll\\apps\\2.txt");
        File fileOut = new File("d:\\zll\\apps\\3.txt");
        FileInputStream fis = new FileInputStream(file);
        FileInputStream fis2 = new FileInputStream(file2);
        FileOutputStream fos = new FileOutputStream(fileOut);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!= -1) {
            fos.write(bytes, 0, len);
        }
        while ((len = fis2.read(bytes))!= -1) {
            fos.write(bytes, 0, len);
        }

        fos.close();
        fis2.close();
        fis.close();
    }

    public static void test3() throws IOException {
        File file = new File("day21\\src\\com\\doit\\IOtest\\test.properties");
        FileReader fr = new FileReader(file);
        char[] chs = new char[1024];
        int len = 0;
        String str = "";
        while ((len = fr.read(chs)) != -1){
            str += new String(chs, 0, len);
        }
        System.out.println(str);
        String[] split = str.split("-");
        Arrays.sort(split,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int a = Integer.parseInt(o1.split(",")[1]);
                int b = Integer.parseInt(o2.split(",")[1]);
                return a-b;
            }
        });
        System.out.println(Arrays.toString(split));
        String result = "";
        for (int i = 0; i < split.length; i++) {
            result += split[i];
            if(i!=split.length - 1){
                result += "-";
            }
        }
        System.out.println(result);
        FileWriter fw = new FileWriter(file);
        fw.write(result);
        fw.close();
        fr.close();
    }

    public static void test4() throws IOException {
        File file = new File("d:\\zll\\apps\\test");
        File[] files = file.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".java");
            }
        });
        System.out.println(Arrays.toString(files));
        File fileOut = new File("d:\\zll\\test");
        if (!fileOut.exists()){
            fileOut.mkdirs();
        }
        for (File f : files) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut + "\\" + f.getName().replace(".java", ".jad"))));
            char[] chs = new char[1024];
            int len = 0;
            while ((len = br.read(chs)) != -1) {
                bw.write(chs, 0, len);
                bw.flush();
            }
            bw.close();
            br.close();
        }

    }
}
