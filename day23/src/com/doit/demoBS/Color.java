package com.doit.demoBS;

/**
 * @ClassName: Color
 * @Author: zll
 * @CreateTime: 2021/7/5 21:02
 * @Desc: java 程序
 * @Version: 1.0
 */

/*
     public class Color{
         public static final Color RED = new Color();
         public static final Color GREEN = new Color();
         public static final Color BLUE = new Color();


        private Color(){}
     }
 */
public enum Color {
    RED,GREEN("绿色"),BLUE;


    private String name;
    private Color(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Color(String name){
        this.name = name;
    }

}

class DemoEnum{
    public static void main(String[] args) {
        Color red = Color.RED;
        System.out.println(Color.GREEN.getName());
        Color[] colors = new Color[] {red, Color.GREEN, Color.BLUE};
    }
}