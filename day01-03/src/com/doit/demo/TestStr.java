package com.doit.demo;


/*
Java��String��StringBuffer �� StringBuilder ������:

String���ַ����������ַ������Ȳ��ɱ䡣Java��String ��immutable�����ɱ䣩�ġ����ڴ���ַ������鱻����Ϊfinal�ģ�
���ֻ�ܸ�ֵһ�Σ������ٸ��ġ�

StringBuffer���ַ���������Synchronized�����̰߳�ȫ�������ҪƵ�����ַ������ݽ����޸ģ�����Ч�ʿ������ʹ�� StringBuffer��
�����ת�� String ���ͣ����Ե��� StringBuffer �� toString() ������Java.lang.StringBuffer �̰߳�ȫ�Ŀɱ��ַ����С�
������ʱ�������������ĳ���ض����ַ����У���ͨ��ĳЩ�������ÿ��Ըı�����еĳ��Ⱥ����ݡ��ɽ��ַ�����������ȫ�����ڶ���̡߳�

StringBuilder���ַ������������̰߳�ȫ�������ڲ� StringBuilder ���󱻵�����һ�������ַ����еı䳤���顣

����ԭ��
���Ҫ���������������� String ��
���̲߳�������������StringBuilder ��
���̲߳����������ݣ���StringBuffer��
*/
/*
String ���� concat() ������ + �ŵ�����:
���ȹ��� new �����Ķ���� String s = "�ַ���" �� == ִ�н��Ϊ false �Ͳ���׸���ˣ���Ϊ == �Ƚϵ�����������ĵ�ֵַ��
equals() �Ƚϵ�������ֵ����ô concat ������ + �ŵ������������������ˣ����ǲ鿴concat������Դ����Կ�����
����ͨ������������ͨ�� char �������ƴ������һ���µĶ������Ե�ֵַ���б䶯
*/


import java.util.Objects;

public class TestStr{
	public static void main(String[] args){
		String a = "saff";
		String b = "saff";
		String c = new String("saff");
		System.out.println(a.equals(b));  // true
		System.out.println(a.equals(c));  // true
		System.out.println(a ==b);  //true
		System.out.println(a ==c);  //false
		
		String s1="a"+"b"+"c";
		String s2="abc";
		System.out.println(s1==s2);//true
		System.out.println(s1.equals(s2));//true
		
		String st1="ab";
		String st2="abc";
		String st3=st1+"c";
		System.out.println(st3==st2);         // false
		System.out.println(st3.equals(st2));  // true
		
		String str1 = "a".concat("b").concat("c");
        String str2 = "a"+"b"+"c";
        String str3 = "abc";
        String str4 = new String("abc");
        System.out.println(str1 == str2); //���н��Ϊfalse
		System.out.println(str1 == str3); //���н��Ϊfalse
        System.out.println(str2 == str3); //���н��Ϊture
        System.out.println(str2 == str4); //���н��Ϊfalse
        System.out.println(str1.equals(str4)); //���н��Ϊtrue
		
	}
}

/*
 ע�� == �� equals������
== ���Ƚϵ��Ƕ���ĵ�ַ
equals �Ƚϵ��Ƕ��������

Java ��� -128 ~ 127 ���������л��棬���Ե���������������ʼ��ֵλ�� -128 ~ 127 ֮��ʱ����������ʹ����ͬһ��ַ��

Integer a=123;
Integer b=123;
System.out.println(a==b);        // ��� true
System.out.println(a.equals(b));  // ��� true

������ Integer ��������ֵ���� -128 ~ 127 ��Χʱ, ����ʹ���˲�ͬ��ַ��

a=1230;
b=1230;
System.out.println(a==b);        // ��� false
System.out.println(a.equals(b));  // ��� true

*/

//Integer ����(�����Ƿ��� new ���ɵ�)�� int �����Ƚϣ�ֻҪ����������ֵ����ȵģ������Ϊ true��

/**
 * �Ƚ�Integer������int����
 */
class TestInt {
    public static void main(String[] args) {
        Integer i1 = 200;
        Integer i2 = new Integer(200);
        int j = 200;
        System.out.println(i1 == j);//�����true
        System.out.println(i2 == j);//�����true
    }
}
//��װ�� Integer ������������������� int �����Ƚ�ʱ��Integer ���Զ����װΪ int��Ȼ����бȽϣ�
//ʵ���Ͼ������� int �������бȽϣ�ֵ��ȣ�����Ϊ true��

class TestString {
    public static void main(String[] args) {
        // ������ֵ�����ַ���
        String s1 = "hello,world!";
        String s2 = "hello,world!";
        System.out.println(s1 == s2);
        System.out.println(Objects.equals(s1, s2));
        // �� new �ؼ��ִ����ַ���
        String s3 = new String("hello,world!");
        String s4 = new String("hello,world!");
        System.out.println(s3 == s4);
        System.out.println(Objects.equals(s3, s4));

        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());

        String s5 = "hello,";
        String s6 = "world!";
        System.out.println(s1 == s5 + s6);
        System.out.println(s1 == "hello," + "world!");
        System.out.println(s3 == s5 + s6);
        System.out.println(s1 == (s5 + s6).intern());
    }
}

// output: true true false true false true false true false true