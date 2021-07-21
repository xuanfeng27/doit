package com.doit.hdemo;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws Exception {
        File file = new File("day01-03\\src\\data");
        File[] files = file.listFiles();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (File f : files) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line=br.readLine())!=null){
                String[] str = line.split("\\s");
                for (String s : str) {
                    if (!s.equals("")){
                        map.put(s, map.getOrDefault(s,0)+1);
                    }
                }
            }
            br.close();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("day01-03/src/data/rlt.txt"));
        map.forEach((k,v)->{
            try {
                bw.write(k+" "+v);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
    }
}
