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
		System.out.println(c);//错误: 可能尚未初始化变量c  java编译时不检查变量b的值*/
		
		Day03 dy = new Day03();
		//dy.conditionJudgment();
		//dy.printNum();
		//dy.multiTables();
		dy.guessNum();
		
		System.out.println(Math.PI);
		//3，Math类特点
		//由于Math类在java.lang包下，所以不需要导包。
		//因为它的成员全部是静态的,所以私有了构造方法
	}
	
	public void conditionJudgment(){
		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字");
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
		
		//在switch语句中，如果case的后面不写break，将出现穿透现象，直接向后运行，直到遇到break，或者整体switch结束。
		switch(a){
			case 12:
			case 1:
			case 2:
				System.out.println("冬");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("春");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋");
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
		System.out.format("浮点型变量的值为 " +  "%f, 整型变量的值为 " +  " %d, 字符串变量的值为 " +  "is %s", 3.2, 5, "doit");
	
	
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
后台预先生成一个1-100之间的随机数，用户键盘录入猜数字
如果猜对了，打印“恭喜您，答对了”
如果猜错了
猜大了：打印“sorry，您猜大了!”
猜小了：打印“sorry，您猜小了!”
直到数字猜到为止
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
				System.out.println("请输入一个数字");
			if (sc.hasNextInt()) {
				 b = sc.nextInt();
				 if(b==a){
					 System.out.println("恭喜您，答对了");
					 break;
				 }else{
					 if(b>a){
						 System.out.println("sorry，您猜大了!");
					 }else{
						  System.out.println("sorry，您猜小了!");
					 }
				 }
			}
			num++;
		};
		if(num==5){
			System.out.println("sorry,次数超了");
		}
			
		
	}
}