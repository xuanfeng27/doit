import java.util.Random;
import java.util.Scanner;

public class Day03{
	public static void main(String[] args){
		Random r = new Random();
		int a  = r.nextInt(100);//[0,99]
		System.out.println(a);
		int b  = r.nextInt(100)+1;//[1,100]
		System.out.println(b);
		double c = r.nextDouble();//[0,1)
		System.out.println(c);
		/*int c;
		boolean b = true;
		if(b){
			c = 4;
		}
		System.out.println(c);//����: ������δ��ʼ������c  java����ʱ��������b��ֵ*/
		
		Day03 dy = new Day03();
		//dy.conditionJudgment();
		//dy.printNum();
		//dy.multiTables();
		dy.guessNum();
		
		System.out.println(Math.PI);
		//3��Math���ص�
		//����Math����java.lang���£����Բ���Ҫ������
		//��Ϊ���ĳ�Աȫ���Ǿ�̬��,����˽���˹��췽��
	}
	
	public void conditionJudgment(){
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������");
		if (sc.hasNextInt()) {
			 a = sc.nextInt();
		}
		
		if(a>90){
			System.out.println("good");
		}else if(a>80 && a<=90){
			System.out.println("well");
		}else if(a>=60 && a<=80){
			System.out.println("pass");
		}else{
			System.out.println("fail");
		}
		
		//��switch����У����case�ĺ��治дbreak�������ִ�͸����ֱ��������У�ֱ������break����������switch������
		switch(a){
			case 12:
			case 1:
			case 2:
				System.out.println("��");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("��");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("��");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("��");
				break;
			default:
				System.out.println("fail");
			break;
		}
		sc.close();
	}
	
	public void printNum(){
		int sum = 0;
		int i = 0;
		for(;i<=100;i++){
			if(i%2==0){
				System.out.println(i);
			}
			sum+=i;
		}
		System.out.println(sum);
		System.out.format("�����ͱ�����ֵΪ " +  "%f, ���ͱ�����ֵΪ " +  " %d, �ַ���������ֵΪ " +  "is %s", 3.2, 5, "doit");
	
	
		do{
			System.out.println(i);
			i++;
		}while(i<20);
		
		for(int k = 0;k<10;k++){
			if(k==4)
				break;
			System.out.println(k);
		}
	}

	public void multiTables(){
		for(int i =1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
	}

/*	
��̨Ԥ������һ��1-100֮�����������û�����¼�������
����¶��ˣ���ӡ����ϲ��������ˡ�
����´���
�´��ˣ���ӡ��sorry�����´���!��
��С�ˣ���ӡ��sorry������С��!��
ֱ�����ֲµ�Ϊֹ
*/
	public void guessNum(){
		System.out.println("-----------------------------------------------------------------------------------");
		Random r = new Random();
		int a  = r.nextInt(100)+1;
		System.out.println(a);
		int b = 0;
		int num =0;
		Scanner sc = new Scanner(System.in);
		while(num<5){
				System.out.println("������һ������");
			if (sc.hasNextInt()) {
				 b = sc.nextInt();
				 if(b==a){
					 System.out.println("��ϲ���������");
					 break;
				 }else{
					 if(b>a){
						 System.out.println("sorry�����´���!");
					 }else{
						  System.out.println("sorry������С��!");
					 }
				 }
			}
			num++;
		};
		if(num==5){
			System.out.println("sorry,��������");
		}
			
		
	}
}