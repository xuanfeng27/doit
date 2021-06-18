# day10 final、接口、多态

## 今日内容

- final
- 接口
- 多态

# 第一章 final关键字

## 1.1 概述

学习了继承后，我们知道，子类可以在父类的基础上改写父类内容，比如，方法重写。那么我们能不能随意的继承API中提供的类，改写其内容呢？显然这是不合适的。为了避免这种随意改写的情况，Java提供了`final` 关键字，用于修饰**不可改变**内容。

- **final**：  不可改变。可以用于修饰类、方法和变量.
  - 类：被修饰的类，不能被继承。
  - 方法：被修饰的方法，不能被重写。
  - 变量：被修饰的变量，不能被重新赋值。

## 1.2 final详细解释

**1.被修饰的类，不能被继承**

格式如下：

```java
final class 类名 {
  
}
```

查询API发现像 `public final class String` 、`public final class Math` 、`public final class Scanner` 等，很多我们学习过的类，都是被final修饰的，目的就是供我们使用，而不让我们所以改变其内容。

**2.被修饰的方法，不能被重写**

格式如下：

```java
修饰符 final 返回值类型 方法名(参数列表){
    //方法体
}
```

重写被 `final`修饰的方法，编译时就会报错。

**被修饰的变量，不能被重新赋值**

- **局部变量——基本类型**

基本类型的局部变量，被final修饰后，只能赋值一次，不能再更改。代码如下：

```java
public class FinalDemo1 {
    public static void main(String[] args) {
        // 声明变量，使用final修饰
        final int a;
        // 第一次赋值 
        a = 10;
        // 第二次赋值
        a = 20; // 报错,不可重新赋值


        // 声明变量，直接赋值，使用final修饰
        final int b = 10;
        // 第二次赋值
        b = 20; // 报错,不可重新赋值
    }
}
```

思考，如下两种写法，哪种可以通过编译？

写法1：

```java
final int c = 0;
for (int i = 0; i < 10; i++) {
    c = i;
    System.out.println(c);
}
```

写法2：

```java
for (int i = 0; i < 10; i++) {
    final int c = i;
    System.out.println(c);
}
```

根据 `final` 的定义，写法1报错！写法2，为什么通过编译呢？因为每次循环，都是一次新的变量c。这也是大家需要注意的地方。

- **局部变量——引用类型**

**引用类型的局部变量，被final修饰后，只能指向一个对象，地址不能再更改。但是不影响对象内部的成员变量值的修改**，代码如下：

```java
public class FinalDemo2 {
    public static void main(String[] args) {
        // 创建 User 对象
        final   User u = new User();
        // 创建 另一个 User对象
        u = new User(); // 报错，指向了新的对象，地址值改变。

        // 调用setName方法
        u.setName("张三"); // 可以修改
    }
}

```

- **成员变量**

final修饰成员变量必须在创建对象之前赋值,两种方式,二选一：

1.显示初始化；

```java
public class User {
    final String USERNAME = "张三";
    private int age;
}
```

2.构造方法初始化。

```java
public class User {
    final String USERNAME ;
    private int age;
    public User(String username, int age) {
        this.USERNAME = username;
        this.age = age;
    }
}
```

被final修饰的常量名称，一般都有书写规范，所有字母都**大写**。

# 第二章 接口

## 2.1 概述

接口，是Java语言中一种引用类型，是方法的集合，如果说类的内部封装了成员变量、构造方法和成员方法，那么接口的内部主要就是**封装了方法**，接口中所有方法都是抽象方法（JDK 7及以前)(在JDK8中新出了默认方法和静态方法我们在讲解JDK新特性时进行讲解)。

接口只描述所应该具备的方法，并没有具体实现，具体的实现由接口的实现类(相当于接口的子类)来完成。这样将功能的定义与实现分离，优化了程序设计。 耦合性

## 2.2 接口的定义

接口的定义，它与定义类方式相似，但是使用 `interface` 关键字。它也会被编译成.class文件，但一定要明确它并不是类，而是另外一种引用数据类型。

public class 类名.java-->.class

public interface 接口名.java-->.class

> 引用数据类型：数组，类，接口。

 定义格式

```java
public interface 接口名称 {
    // 抽象方法
    // 抽象方法
 
}
```

使用interface代替了原来的class，其他步骤与定义类相同：

- 接口中的方法均为公共访问的抽象方法
- 接口中无法定义普通的成员变量



## 2.3 类实现接口

### 实现的概述

类与接口的关系为实现关系，即**类实现接口**，该类可以称为接口的实现类，也可以称为接口的子类。实现的动作类似继承，格式相仿，只是关键字不同，实现使用 ` implements`关键字。

实现格式：

```java
public class 类名 implements 接口名 {
    // 重写接口中抽象方法【必须】
} 
```

**在类实现接口后，该类就会将接口中的抽象方法继承过来，此时该类需要重写该抽象方法，完成具体的逻辑。**

- 接口中定义功能，当需要具有该功能时，可以让类实现该接口，只声明了应该具备该方法，是功能的声明。
- 在具体实现类中重写方法，实现功能，是方法的具体实现。

代码如下：

定义接口：

```java
public interface LiveAble {
    // 定义抽象方法
    public abstract void eat();
    public abstract void sleep();
}
```

定义实现类：

```java
public class Animal implements LiveAble {
    @Override
    public void eat() {
        System.out.println("吃东西");
    }

    @Override
    public void sleep() {
        System.out.println("晚上睡");
    }
}
```

定义测试类：

```java
public class InterfaceDemo {
    public static void main(String[] args) {
        // 创建子类对象  
        Animal a = new Animal();
        // 调用实现后的方法
        a.eat();
        a.sleep();
    }
}
输出结果：
吃东西
晚上睡
```

## 2.4 接口中成员的特点

**接口中，无法定义成员变量，但是可以定义常量，其值不可以改变，默认使用public static final修饰。**

接口中定义常量：

```java
public interface LiveAble {
   int NUM0 ; // 错误,必须赋值  
   int NUM1 =10; // 正确 , 省去了默认修饰符 public static final
   public static final int NUM2= 100; // 正确 , 完整写法
}
```

**接口中可以定义方法，方法也有固定的修饰符，public abstract**

```java
public interface LiveAble {
  
   void method(); //正确 没写public abstract java自动补齐
  public abstract void method2();//正确 完成写法
  public void method3(); //正确 没写abstract  java自动补齐
  private void method4();// 错误 
  public void method5(){} //错误 接口中都是抽象方法
}
```

**接口没有构造方法,不能直接创建对象**

```java
public interface LiveAble{
  	public LiveAble(){} //错误 接口没有构造方法
}
```



## 2.5 接口的特点(注意事项)

**1.类与类是继承关系,类与接口是实现关系,一个类可以在继承一个类的同时实现多个接口**

实现格式：

```java
public interface Fu1
{
	void show1();
    void  show();
}
public interface Fu2
{
	void show2();
     void show();
}
public class Fu{
    public abstract void showFu();
    public abstract void show();
}

//有多个抽象方法时，实现类必须重写所有抽象方法。如果抽象方法有重名的，只需要重写一次
public class Zi extends Fu implements Fu1,Fu2// 多实现。同时实现多个接口。
{
	public void show1(){}
	public void show2(){}
  	 public void showFu(){}
     public void show(){}
} 
```

> 小贴士 :  
>
> 1. 一个类继承一个父类的同时实现一个或者多个接口,要重写所有的抽象方法
> 2. 如果两个接口中有重名的抽象方法,那么我们就重写一个

**2.接口与接口的关系继承关系,可以单继承,也可以多继承**

一个接口能继承另一个或者多个接口，这和类之间的继承比较相似。接口的继承使用 `extends` 关键字，子接口继承父接口的方法。

代码如下

```java
public interface A {
    void show1();
}
public interface B {
   void show2();
}
public interface C extends A,B{
   void show3();
}
public class D implements A,B,C{
   void show1(){}
   void show2(){}
   void show3(){}
}
```

## 2.6 接口的好处

- **接口解决了java单继承的局限性,提高了程序的扩展性.**

我们都知道java中类是单继承的,不可以多继承,为什么呢?因为多继承可能造成安全隐患,多继承时，当多个父类中有相同功能时，子类调用会产生不确定性。其实核心原因就是在于多继承父类中功能有主体，而导致调用运行时，不确定运行哪个主体内容。如:

```java
public class A{
  public void show(){
      System.out.println("A");
  }  
}
public class B{
  public void show(){
    System.out.println("B");
  }
}
//假设可以多继承的话
public class C extends A,B{}
//当创建C的对象调用show方法时根本不能确定调用的A的show还是B的show方法
```

但是接口就可以多实现,因为接口中的方法都没有方法体,方法体的具体内容是由子类来实现的.所以为了避免出现这种不安全的隐患java是单继承的.但是单继承是有局限性的,比如一个类已经有父类,还想为这个类添加一些功能时,是没有办法再继承一个的类的,但是这时可以通过实现接口的方式来添加.

- **接口的出现降低了耦合性，即设备与设备之间实现了解耦。**

   耦合代表着事物与事物之间的的紧密程度,解耦合就是降低事物之间的联系.打个比方你买了一台电脑,假如鼠标是焊死在电脑上的我们就说耦合性比较高,耦合度太高就会有一些问题,比如鼠标坏了是没办法更换的.但是我们现在买的笔记本上面都有USB接口,这个USB接口就帮我们降低了电脑和鼠标之间的耦合性,如果鼠标坏了,拔下来换一个,并且也提高了程序的扩展性,这个USB接口不止可以插鼠标还可以插键盘,插任何符合USB接口规则的东西.

​     java中类与类继承的耦合性就是挺高的,如果父类中定义了很多方法并且都给出了实现,子类继承后,可以直接使用这些功能,但是如果子类不继承这个父类了,子类中什么功能都没有了.但是接口就不会,实现类必须实现接口的功能,接口给出方法声明,实现类类进行具体实现,即使实现类不实现接口了,也不会造成太的的影响.

```java
public class Fu{
    public void show1(){}
  	public void show2(){}
}
//子类继承父类 可以直接使用父类中的方法 ,如果子类不继承父类了 子类中什么方法都没有了
public class Zi extends Fu{}

public interface A{
   void show1();
   void show2();
}
//B实现A 必须实现所有方法 如果B不实现A了 也没有太大的影响 还可以正常使用
public class B implements A{
   void show1(){}
  void show2(){}
}	
```

## 2.7 抽象类和接口的区别

通过实例进行分析和代码演示抽象类和接口的用法。

1、举例：

​	犬科：

​		行为：

​			吼叫；

​			吃饭；

​	缉毒犬：

​		行为：

​			吼叫；

​			吃饭；		

​                 	缉毒；

2、思考：

​	由于犬分为很多种类，他们吼叫和吃饭的方式不一样，在描述的时候不能具体化，也就是吼叫和吃饭的行为不能明确。当描述行为时，行为的具体动作不能明确，这时，可以将这个行为写为抽象行为，那么这个类也就是抽象类。

​	可是当缉毒犬有其他额外功能时，而这个功能并不在这个事物的体系中。这时可以让缉毒犬具备犬科自身特点的同时也有其他额外功能，可以将这个额外功能定义接口中。 

```java
interface 缉毒{
	public abstract void 缉毒();
}
//定义犬科的这个提醒的共性功能
abstract class 犬科{
public abstract void 吃饭();
public abstract void 吼叫();
}
// 缉毒犬属于犬科一种，让其继承犬科，获取的犬科的特性，
//由于缉毒犬具有缉毒功能，那么它只要实现缉毒接口即可，这样即保证缉毒犬具备犬科的特性，也拥有了缉毒的功能
class 缉毒犬 extends 犬科 implements 缉毒{

	public void 缉毒() {
	}
	void 吃饭() {
	}
	void 吼叫() {
	}
}
class 缉毒猪 implements 缉毒{
	public void 缉毒() {
	}
}
```
3、通过上面的例子总结接口和抽象类的区别：

**相同点:**

​	 都位于继承的顶端,用于被其他类实现或继承;

​	 都不能直接实例化对象;

​	 都包含抽象方法,其子类都必须覆写这些抽象方法;

**区别:**

 	抽象类为部分方法提供实现,避免子类重复实现这些方法,提高代码重用性;接口只能包含抽象方法;
 	
 	一个类只能继承一个直接父类(可能是抽象类),却可以实现多个接口;(接口弥补了Java的单继承)
 	
 	抽象类为继承体系中的共性内容,接口为继承体系中的扩展功能

- 成员区别

  - 抽象类
    - 变量,常量；有构造方法；有抽象方法,也有非抽象方法
  - 接口
    - 常量；抽象方法

- 关系区别

  - 类与类
    - 继承，单继承
  - 类与接口
    - 实现，可以单实现，也可以多实现
  - 接口与接口
    - 继承，单继承，多继承

- 设计理念区别

  - 抽象类

    - 对类抽象，包括属性、行为

  - 接口

    - 对行为抽象，主要是行为


# 第三章 多态

## 3.1 概述

多态是继封装、继承之后，面向对象的第三大特性。

现实事物经常会体现出多种形态，如学生，学生是人的一种，则一个具体的同学张三既是学生也是人，即出现两种形态。	

Java作为面向对象的语言，同样可以描述一个事物的多种形态。如Student类继承了Person类，一个Student的对象便既是Student，又是Person。

Java中多态的代码体现在一个子类对象(实现类对象)既可以给这个子类(实现类对象)引用变量赋值，又可以给这个子类(实现类对象)的父类(接口)变量赋值。

如Student类可以为Person类的子类。那么一个Student对象既可以赋值给一个Student类型的引用，也可以赋值给一个Person类型的引用。

```java
class Student extens Person{}
Student s = new Student(); //创建一个学生对象，把学生对象赋值给学生类型s
Person p = new Student(); //创建一个学生对象，把学生对象赋值给人类型p 
```

**最终多态体现为父类引用变量可以指向子类对象。**

**前提条件【重点】**

1. 继承或者实现【二选一】
2. 方法的重写【意义体现：不重写，无意义】
3. 父类引用指向子类对象【格式体现】

## 3.2  多态的定义与使用格式

**多态的定义格式：就是父类的引用变量指向子类对象**

```java
父类类型 变量名 = new 子类对象；
变量名.方法名();
```

> 父类类型：指子类对象继承的父类类型，或者实现的父接口类型。

- **普通类多态定义的格式**

```java
//父类 变量名 = new 子类();
    class Fu {}
	class Zi extends Fu {}
	//类的多态使用
	Fu f = new Zi();
```

- **抽象类多态定义的格式**

```java
//抽象类 变量名 = new 抽象类子类();
    abstract class Fu {
         public abstract void method();
	 }
	class Zi extends Fu {
		public void method(){
		      System.out.println(“重写父类抽象方法”);
		}
	}
	//类的多态使用
	Fu fu= new Zi();
```

- **接口多态定义的格式**

```java
//接口 变量名 = new 接口实现类();
interface Fu {
  	public abstract void method();
}
class Zi implements Fu {
    public void method(){
     	System.out.println(“重写接口抽象方法”);
	}
}
//接口的多态使用
Fu fu = new Zi();
```

 **注意事项**

​	同一个父类的方法会被不同的子类重写。在调用方法时，调用的为各个子类重写后的方法。如:

```java
   Person p1 = new Student();
   Person p2 = new Teacher();
   p1.work(); //p1会调用Student类中重写的work方法
   p2.work(); //p2会调用Teacher类中重写的work方法
```

当变量名指向不同的子类对象时，由于每个子类重写父类方法的内容不同，所以会调用不同的方法。

## 3.3 多态-成员的特点

多态调用变量时：

> **编译时期：到父类中找有没有这个变量,如果有编译成功,如果没有编译失败.**
>
> **运行时期：访问的是父类成员变量的值**
>
> 简单记：编译看=号左边,运行看=左边

```java
public class Fu {
	int num = 4;
}
public class Zi extends Fu {
	int num = 5;
    int a = 10;
}
public class Demo {
	public static void main(String[] args) 	{
		Fu fz = new Zi();
      	System.out.println(fz.num);//4
        //System.out.println(fz.a);// 父类中没有这个变量 编译失败
	}
}
```

多态调用方法时:

> 编译时期：到父类中去找这个方法,如果有编译成功,如果没有编译失败
>
> 运行时期：运行的是子类重写后的方法.
>
> 简而言之：编译看左边，运行看右边。

```java
public class Fu{
  public void show1(){
    System.out.println("fu");
  }  
}
public class Zi{
  //子类重写父类方法
  public void show1(){
    System.out.println("Zi");
  }
  //子类特有方法
  public void show2(){
    System.out.println("子类特有方法");
  }
}
public class Demo {
	public static void main(String[] args) 	{
		 Fu fz = new Zi();
      	 fz.show1();//打印 Zi  
         //fz.show2();//父类中没有这个方法编译失败
	}
}
```

## 3.4 多态的好处

实际开发的过程中，父类类型作为方法形式参数，传递子类对象给方法，进行方法的调用，更能体现出多态的扩展性与便利。代码如下：

定义父类：

```java
public abstract class Animal {  
    public abstract void eat();  
}  
```

定义子类：

```java
class Cat extends Animal {  
    public void eat() {  
        System.out.println("吃鱼");  
    }  
}  

class Dog extends Animal {  
    public void eat() {  
        System.out.println("吃骨头");  
    }  
}
```

定义测试类：

```java
public class Test {
    public static void main(String[] args) {
        // 多态形式，创建对象
        Cat c = new Cat();  
        Dog d = new Dog(); 

        // 调用showCatEat 
        showCatEat(c);
        // 调用showDogEat 
        showDogEat(d); 

        /*
        以上两个方法, 均可以被showAnimalEat(Animal a)方法所替代
        而执行效果一致
        */
        showAnimalEat(c);
        showAnimalEat(d); 
    }

    public static void showCatEat (Cat c){
        c.eat(); 
    }

    public static void showDogEat (Dog d){
        d.eat();
    }

    public static void showAnimalEat (Animal a){
        a.eat();
    }
}
```

由于多态特性的支持，showAnimalEat方法的Animal类型，是Cat和Dog的父类类型，父类类型接收子类对象，当然可以把Cat对象和Dog对象，传递给方法。

当eat方法执行时，多态规定，执行的是子类重写的方法，那么效果自然与showCatEat、showDogEat方法一致，所以showAnimalEat完全可以替代以上两方法。

不仅仅是替代，在扩展性方面，无论之后再多的子类出现，我们都不需要编写showXxxEat方法了，直接使用showAnimalEat都可以完成。

所以，多态的好处，体现在，可以使程序编写的更简单，并有良好的扩展。

## 3.5 多态的转型

多态的转型分为向上转型与向下转型两种：

- **向上转型**：多态本身是子类类型向父类类型向上转换的过程，这个过程是默认的。

当父类引用指向一个子类对象时，便是向上转型。

使用格式：

```java
父类类型  变量名 = new 子类类型();
如：Animal a = new Cat();
```

- **向下转型**：父类类型向子类类型向下转换的过程，这个过程是强制的。

一个已经向上转型的子类对象，将父类引用转为子类引用，可以使用强制类型转换的格式，便是向下转型。

使用格式：

```java
子类类型 变量名 = (子类类型) 父类变量名;
如:Cat c =(Cat) a;  
```

**为什么要转型?**

当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误。也就是说，**不能调用**子类拥有，而父类没有的方法。编译都错误，更别说运行了。这也是多态给我们带来的一点"小麻烦"。所以，想要调用子类特有的方法，必须做向下转型。

转型演示，代码如下：

定义类：

```java
abstract class Animal {  
    abstract void eat();  
}  

class Cat extends Animal {  
    public void eat() {  
        System.out.println("吃鱼");  
    }  
    public void catchMouse() {  
        System.out.println("抓老鼠");  
    }  
}  

class Dog extends Animal {  
    public void eat() {  
        System.out.println("吃骨头");  
    }  
    public void watchHouse() {  
        System.out.println("看家");  
    }  
}
```

定义测试类：

```java
public class Test {
    public static void main(String[] args) {
        // 向上转型  
        Animal a = new Cat();  
        a.eat(); 				// 调用的是 Cat 的 eat

        // 向下转型  
        Cat c = (Cat)a;       
        c.catchMouse(); 		// 调用的是 Cat 的 catchMouse
    }  
}
```

**转型的异常**

转型的过程中，一不小心就会遇到这样的问题，请看如下代码：

```java
public class Test {
    public static void main(String[] args) {
        // 向上转型  
        Animal a = new Cat();  
        a.eat();               // 调用的是 Cat 的 eat

        // 向下转型  
        Dog d = (Dog)a;       
        d.watchHouse();        // 调用的是 Dog 的 watchHouse 【运行报错】
    }  
}
```

这段代码可以通过编译，但是运行时，却报出了 `ClassCastException` ，类型转换异常！这是因为，明明创建了Cat类型对象，运行时，当然不能转换成Dog对象的。这两个类型并没有任何继承关系，不符合类型转换的定义。

为了避免ClassCastException的发生，Java提供了 `instanceof` 关键字，给引用变量做类型的校验，格式如下：

```java
变量名 instanceof 数据类型 
如果变量属于该数据类型，返回true。
如果变量不属于该数据类型，返回false。
```

所以，转换前，我们最好先做一个判断，代码如下：

```java
public class Test {
    public static void main(String[] args) {
        // 向上转型  
        Animal a = new Cat();  
        a.eat();               // 调用的是 Cat 的 eat

        // 向下转型  
        if (a instanceof Cat){
            Cat c = (Cat)a;       
            c.catchMouse();        // 调用的是 Cat 的 catchMouse
        } else if (a instanceof Dog){
            Dog d = (Dog)a;       
            d.watchHouse();       // 调用的是 Dog 的 watchHouse
        }
    }  
}
```

学习到这里，面向对象的三大特征学习完了。

总结下封装、继承、多态的作用：

- 封装：把对象的属性与方法的实现细节隐藏，仅对外提供一些公共的访问方式
- 继承：子类会自动拥有父类所有可继承的属性和方法。
- 多态：配合继承与方法重写提高了代码的复用性与扩展性；如果没有方法重写，则多态同样没有意义。

# 第四章 综合案例

## 4.1 案例需求

​	定义笔记本类，具备开机，关机和使用USB设备的功能。具体是什么USB设备，笔记本并不关心，只要符合USB规格的设备都可以。鼠标和键盘要想能在电脑上使用，那么鼠标和键盘也必须遵守USB规范，不然鼠标和键盘的生产出来无法使用;

​	进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘

- USB接口，包含开启功能、关闭功能

- 笔记本类，包含运行功能、关机功能、使用USB设备功能

- 鼠标类，要符合USB接口

- 键盘类，要符合USB接口


## 4.2 需求分析

​	阶段一：

​		使用笔记本，笔记本有运行功能，需要笔记本对象来运行这个功能

​	阶段二：

​		想使用一个鼠标，又有一个功能使用鼠标，并多了一个鼠标对象。

​	阶段三：

​		还想使用一个键盘 ，又要多一个功能和一个对象

​	问题：每多一个功能就需要在笔记本对象中定义一个方法，不爽，程序扩展性极差。

​	降低鼠标、键盘等外围设备和笔记本电脑的耦合性。

## 4.3 代码实现

```java
 //定义鼠标、键盘，笔记本三者之间应该遵守的规则
 public interface USB {
	void open();// 开启功能

	void close();// 关闭功能
}
//鼠标实现USB规则
public class Mouse implements USB {
	public void open() {
		System.out.println("鼠标开启");
	}

	public void close() {
		System.out.println("鼠标关闭");
	}
}
//键盘实现USB规则
public class KeyBoard implements USB {
	public void open() {
		System.out.println("键盘开启");
	}

	public void close() {
		System.out.println("键盘关闭");
	}
}
//定义笔记本
public class NoteBook {
	// 笔记本开启运行功能
	public void run() {
		System.out.println("笔记本运行");
	}

	// 笔记本使用usb设备，这时当笔记本对象调用这个功能时，必须给其传递一个符合USB规则的USB设备
	public void useUSB(USB usb) {
		// 判断是否有USB设备
		if (usb != null) {
			usb.open();
			usb.close();
		}
	}
	public void shutDown() {
		System.out.println("笔记本关闭");
	}
}
//测试
public class Test {
	public static void main(String[] args) {
		// 创建笔记本实体对象
		NoteBook nb = new NoteBook();
		// 笔记本开启
		nb.run();

		// 创建鼠标实体对象
		Mouse m = new Mouse();
		// 笔记本使用鼠标
		nb.useUSB(m);

		// 创建键盘实体对象
		KeyBoard kb = new KeyBoard();
		// 笔记本使用键盘
		nb.useUSB(kb);

		// 笔记本关闭
		nb.shutDown();
	}
}

```

