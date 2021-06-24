package com.doit.DemoMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: DemoCharHash
 * @Author: zll
 * @CreateTime: 2021/6/24 15:17
 * @Desc: java 程序
 * @Version: 1.0
 */
//统计字符串中每个字符出现的次数
public class DemoCharHash {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = sc.nextLine();
       /* for (int i = 0; i < str.length(); i++) {
            str.charAt(i);
        }*/
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        System.out.println(map);
    }
}
