package com.doit.demo;

//打印水果报价单
public class PriceList{
	public static void main(String[] args){
		System.out.println("水果编号\t水果名称\t水果单价\t计价单位\t品质");
		System.out.println("1 \t 榴莲 \t 32.0 \t 公斤 \t A");
		System.out.println("2 \t 苹果 \t 6.5 \t 公斤 \t B");
		System.out.println("3 \t 猕猴桃 \t 6.0 \t 公斤 \t A");
		
		System.out.println("水果编号"+"\t"+"水果名称"+"\t"+"水果单价"+"\t"+"计价单位"+"\t"+"品质");
		System.out.println(""+ 1 + "\t" + "榴莲" + "\t"+ 32.0+ "\t" + "公斤"+ "\t" + 'A'+"");
		System.out.println(""+ 2 + "\t" + "苹果" + "\t"+ 6.5+ "\t" + "公斤"+ "\t" + 'B'+"");
		System.out.println(""+ 3 + "\t" + "猕猴桃" + "\t"+ 6.0+ "\t" + "公斤"+ "\t" + 'A'+"");
	}
}