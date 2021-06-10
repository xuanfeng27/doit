package com.doit.demo;

/*变量定义并赋值
数据类型 变量名 = 变量值；
1.变量必须先赋值，再使用
2.变量有作用域，{}
3.相同作用域下，变量名不能相同
java的语法，在类里面只能声明和初始化方法和成员变量，但是不能直接加入操作，比如说int a是声明变量，
int a=2是声明变量的同时进行初始化，而 a=2则是一个操作，在类这一层是不允许的，你可以在构造方法里面进行这样的操作
*/
/*
整数：
byte  1  -128——127
short 2
int   4 默认
long  8  L

小数：
float   4  f
double  8 默认

字符：
char    2
布尔：
boolean 1

*/
public class VarInfo{
	int cc;//成员变量

	//默认的构造方法
	public VarInfo(){
		System.out.println(cc);//0
	}
	
	//main()入口
	public static void main(String[] args){
		//int a = 10;
		int b;
		b = 30;
		System.out.println(b);
		double c = 1.4;
		char d = 'a';
		boolean bl = true;
		System.out.println(c);
		
		{
			int a = 33;
			System.out.println(a);//33
		}
		
		int a = 10;
		System.out.println(a);//10
		
		VarInfo varcy = new VarInfo();//执行构造方法
		varcy.VarType();
		varcy.VarTypeConverse();
		varcy.VarOperation();
		varcy.AssignmentOperation();
	}

	//数据类型
	public void VarType(){
		byte b = 4;//默认int,隐式强制类型转换
		long l = 100000000000L;//超出int长度
		System.out.println(l);
		
		//小数默认double类型
		float f = 3.14434f;
		System.out.println(f);
		
		char c = 'a';
		System.out.println(c+0);
		
		double dd = 79;
		System.out.println(dd);//79.0
		
	}
	
	//强制类型转换
	public void VarTypeConverse(){
		int a = (int)10.8;
		byte b = (byte)250;
		int c = 'b';
		short s = 3;
		s =(short)(s + c);
		System.out.println(a);//10
		System.out.println(b);//-6
		System.out.println(c);//98
		System.out.println(s);//101
	}

	//+ - * / % ++ --
	public void VarOperation(){
		System.out.println("----------------------------------");
		int a = 3;
		a = a+2;
		a = a-1;
		a = a*3;
		System.out.println(a);
		System.out.println(a+a+"3");
		int b = 5;
		b = b/2;
		System.out.println(b);
		double c = 5.0;
		c = c/2;
		System.out.println(c);
		int d = -5%2;
		System.out.println(d);
		//++ --
		int e = 9;
		e++;
		System.out.println(e++);
		System.out.println(e);
		System.out.println(++e);
		System.out.println(e);
	}
	
	//赋值运算符 = += -= *= /= %= 
	//自动强制类型转换为左边的变量类型 例如： a += 1 就是a = (byte)(a + 1)
	public void AssignmentOperation(){
		byte a = 3;
		a = (byte)(a+5);
		System.out.println(a);//8
		a+=8;
		System.out.println(a);//16
		System.out.println(a-=4);
		a*=10;
		System.out.println(a);
		System.out.println(a/=2);
		
		//比较运算符 == >= != 
		boolean bl = 4>2;
		System.out.println(bl);
		
		//逻辑运算符 或与非
		boolean bol = true;
		boolean boll = false;
		System.out.println(bol && boll);//false
		System.out.println(boll && (bol=false));//false 右边的不运算
		System.out.println(bol);//true
		System.out.println(boll & (bol=false));//false
		System.out.println(bol);//false
		System.out.println(!bol);//true
		
		//位运算符
		System.out.println(12<<2);//48
		
		//三元运算符 
		//数据类型 变量名 = 条件表达式？表达式1：表达式2
		int ab =6;
		int bc = 3;
		int cd = ab>bc?ab:bc;
		System.out.println(cd);
		String ss = ab>bc?"ab大于bc":"bc大于ab";
		System.out.println(ss);
	}

}