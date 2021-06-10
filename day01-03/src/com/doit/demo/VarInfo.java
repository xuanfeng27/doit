package com.doit.demo;

/*�������岢��ֵ
�������� ������ = ����ֵ��
1.���������ȸ�ֵ����ʹ��
2.������������{}
3.��ͬ�������£�������������ͬ
java���﷨����������ֻ�������ͳ�ʼ�������ͳ�Ա���������ǲ���ֱ�Ӽ������������˵int a������������
int a=2������������ͬʱ���г�ʼ������ a=2����һ��������������һ���ǲ�����ģ�������ڹ��췽��������������Ĳ���
*/
/*
������
byte  1  -128����127
short 2
int   4 Ĭ��
long  8  L

С����
float   4  f
double  8 Ĭ��

�ַ���
char    2
������
boolean 1

*/
public class VarInfo{
	int cc;//��Ա����

	//Ĭ�ϵĹ��췽��
	public VarInfo(){
		System.out.println(cc);//0
	}
	
	//main()���
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
		
		VarInfo varcy = new VarInfo();//ִ�й��췽��
		varcy.VarType();
		varcy.VarTypeConverse();
		varcy.VarOperation();
		varcy.AssignmentOperation();
	}

	//��������
	public void VarType(){
		byte b = 4;//Ĭ��int,��ʽǿ������ת��
		long l = 100000000000L;//����int����
		System.out.println(l);
		
		//С��Ĭ��double����
		float f = 3.14434f;
		System.out.println(f);
		
		char c = 'a';
		System.out.println(c+0);
		
		double dd = 79;
		System.out.println(dd);//79.0
		
	}
	
	//ǿ������ת��
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
	
	//��ֵ����� = += -= *= /= %= 
	//�Զ�ǿ������ת��Ϊ��ߵı������� ���磺 a += 1 ����a = (byte)(a + 1)
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
		
		//�Ƚ������ == >= != 
		boolean bl = 4>2;
		System.out.println(bl);
		
		//�߼������ �����
		boolean bol = true;
		boolean boll = false;
		System.out.println(bol && boll);//false
		System.out.println(boll && (bol=false));//false �ұߵĲ�����
		System.out.println(bol);//true
		System.out.println(boll & (bol=false));//false
		System.out.println(bol);//false
		System.out.println(!bol);//true
		
		//λ�����
		System.out.println(12<<2);//48
		
		//��Ԫ����� 
		//�������� ������ = �������ʽ�����ʽ1�����ʽ2
		int ab =6;
		int bc = 3;
		int cd = ab>bc?ab:bc;
		System.out.println(cd);
		String ss = ab>bc?"ab����bc":"bc����ab";
		System.out.println(ss);
	}

}