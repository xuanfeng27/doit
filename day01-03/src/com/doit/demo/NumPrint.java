package com.doit.demo;

//Java的数据类型分为两大类：
//基本数据类型：包括 `整数`、`浮点数`、`字符`、`布尔`。 
//引用数据类型：包括 `类`、`数组`、`接口`。 
public class NumPrint{
	public static void main(String[] args){
		//整数
		System.out.println(10);
		System.out.println(0b1010);
		System.out.println(012);
		System.out.println(0xA);
		
		//浮点数
		System.out.println(1.0);
		System.out.println(0.003+0.01);//小数计算不精确
		
		//字符
		System.out.println('q');
		System.out.println(' ');//单引号引起来,只能写一个字符,必须有内容
		
		//布尔
		System.out.println(true);
		System.out.println(false);
		//字符串
		System.out.println("1");
		System.out.println("你好");
		System.out.println("\"\"");//转义字符\
		System.out.println("\\");
		System.out.println("aa\tb");//制表符
		
		
	}
}
	       