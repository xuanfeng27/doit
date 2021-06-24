package com.doit.poker;

import java.util.*;

/**
 * @ClassName: Poker
 * @Author: zll
 * @CreateTime: 2021/6/24 17:18
 * @Desc: java 程序
 * @Version: 1.0
 */
public class Poker {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        List<Integer> list = new ArrayList<Integer>();
        String[] number = "♥-♠-♦-♣".split("-");
        String[] color = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");
        int num = 2;
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < number.length; j++) {
                map.put(num,color[i]+number[j]);
                list.add(num);
                num++;
            }
        }
        map.put(0, "大王");
        map.put(1,"小王");
        list.add(0);
        list.add(1);

        System.out.println(map);
        System.out.println(list);
        System.out.println("--------------------------");
        Collections.shuffle(list);
        System.out.println(list);

        Set<Integer> player1 = new TreeSet<Integer>();
        Set<Integer> player2 = new TreeSet<Integer>();
        Set<Integer> player3 = new TreeSet<Integer>();
        Set<Integer> diPai = new TreeSet<Integer>();

        for (int i = 0; i <list.size(); i++){
             if (i >=51) {
                diPai.add(list.get(i));
            }else if(i%3==0){
                player1.add(list.get(i));
            }else if (i % 3 == 1){
                player2.add(list.get(i));
            }else if (i % 3 == 2) {
                player3.add(list.get(i));
            }
        }
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(diPai);
        System.out.println("========================================");
        showPocker(player1,map);
        showPocker(player2, map);
        showPocker(player3, map);
        showPocker(diPai, map);
    }

    public static void showPocker(Set<Integer> set, Map<Integer,String> map) {
        for (Integer i : set) {
            System.out.print(map.get(i)+" ");
        }
        System.out.println();
    }
}
