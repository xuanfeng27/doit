# day06【自定义类型,ArrayList类】

## 今日内容

*  自定义类型
*  ArrayList类
*  随机点名案例


# 第一章 自定义类型

## 1.1 引用数据类型分类

提到引用数据类型（类），其实我们对它并不陌生，如使用过的Scanner类、Random类.

我们可以把类的类型为两种：

​	第一种，Java为我们提供好的类，如Scanner类，Random类等，这些已存在的类中包含了很多的方法与属性，可供我们使用。

​	第二种，我们自己创建的类，按照类的定义标准，可以在类中包含多个方法与属性，来供我们使用。

​	这里我们主要介绍第二种情况的简单使用。

## 1.2 自定义数据类型概述

​	我们在Java中，将现实生活中的事物抽象成了代码。这时，我们可以使用自定义的数据类型（类）来描述（映射）现实生活中的事物。

​	类，它是引用数据类型，与之前学习的所有引用数据类型相同，自定义类也是一种数据类型。只是自定义类型并非Java为我们预先提供好的类型，而是我们自己定义的一种引用数据类型用来描述一个事物。

## 1.3 类的定义与使用

​	java代码映射成现实事物的过程就是定义类的过程。

​	我们就拿一部手机进行分析，它能用来做什么呢？它可以打电话，上网，聊微信等，这些就是手机所提供的功能，也就是方法；手机也有它的特征，如颜色、尺寸大小、品牌型号等，这些就是手机的特征，也就是属性。

目前，我们只关注类中的属性，类中的方法在面向对象部分再进行学习。

### 1.3.1类的定义格式

**类的定义格式**

```java
创建java文件，与类名相同
public class 类名{
	数据类型  属性名称1；
	数据类型  属性名称2；
	…
}
```

通过类的定义格式，来进行手机类的描述，如下所示 

```java
public class Phone {
	/*
	 * 属性
	 */
	String brand;// 品牌型号
	String color;// 颜色
	double size; // 尺寸大小
}
```

上述代码，就是创建一个类的的过程，类的名称我们给起名为Phone，类中包含了三个属性（brand品牌型号、color颜色、size尺寸大小）。注意，类中定义的属性没有个数要求。

### 1.3.2 类的使用格式 

Phone类定义好后，我们就可以使用这个类了，使用方式和使用引用数据类型Scanner类相似。格式如下：

```java
导包：我们将所有的类放到同一个文件夹下，可以避免导包。
创建对象：数据类型  变量名 = new 数据类型();
调用方法：目前我们定义的自定义类不涉及方法，只有属性（自定义类中的方法部分在面向对象部分讲解）
访问属性：变量名.属性 (这是当前的方式，后期会采取调用方法的方式替代掉直接访问的方式来完成对属性的访问。)
```

当有了Phone数据类型的变量后，我们就可以使用Phone类中的属性了。对属性的访问我们来演示一下，如下所示：

```java
public class Test {
	public static void main(String[] args) {
		//定义了一个Phone类型的变量p
		Phone p = new Phone();
		/*
		 * 通过p,使用Phone中的属性
		 */
		//访问p中的brand品牌属性
		p.brand = "苹果6s";
		//访问p中的color颜色属性
		p.color = "白色";
		//访问p中的size尺寸大小属性
		p.size = 5.5;

		System.out.println("手机品牌为" + p.brand);
		System.out.println("手机颜色为" + p.color);
		System.out.println("手机尺寸大小为" + p.size);
	}
}
```



### 1.3.3 自定义类型注意事项与内存图

上述代码中，通过类Phone创建出来的变量p，它相当于我们生活中的盒子，里面包含了它能够使用的属性。

通过 p.属性名 就可以对属性进行操作

与引用类型数组类似，引用类型的自定义类型的变量，直接变量时，结果为对象地址值，这里可以通过内存图简单解释。

![对象](img\对象.png)



## 1.4 自定义类型练习

学习了引用数据类型（类）以后，我们就能够使用类描述任何东西了。看几个具体的描述，如下：

电饭锅，包含属性（品牌、容量大小、颜色等）

汽车，包含属性（品牌、颜色、价格等）

学生，包含属性（姓名，年龄，性别等）

#  第二章 ArrayList类

## 2.1 引入

​        前面我们学习了数组，数组可以保存多个元素，但在某些情况下无法确定到底要保存多少个元素，此时数组将不再适用，因为数组的长度不可变。例如，要保存一个学校的学生，由于不停有新生来报道，同时也有学生毕业离开学校，这时学生的数目很难确定。为了保存这些数目不确定的元素，JDK中提供了一系列特殊的类，这些类可以存储引用类型的元素，并且长度可变，统称为集合。在这里，我们先介绍ArrayList集合，其他集合在后续课程中学习。

​      ArrayList集合是程序中最常见的一种集合，它属于引用数据类型（类）。在ArrayList内部封装了一个长度可变的数组，当存入的元素超过数组长度时，ArrayList会在内存中分配一个更大的数组来存储这些元素，因此可以将ArrayList集合看作一个长度可变的数组。

## 2.2 集合的创建

**创建集合的常用格式在此说明一下**

```java
导包：import java.util.ArrayList;
创建对象：与其他普通的引用数据类型创建方式完全相同，但是要指定容器中存储的数据类型：
ArrayList<要存储元素的数据类型> 变量名 = new ArrayList<要存储元素的数据类型>();
```

**注意:**

1. 集合中存储的元素，只能为<>括号中指定的数据类型元素；
2. <要存储元素的数据类型>”中的数据类型必须是引用数据类型，不能是基本数据类型；

ArrayList对象不能存储基本类型，只能存储引用类型的数据。类似**`<int>`不能写**，但是存储基本数据类型对应的包装类型是可以的。所以，想要存储基本类型数据，`<>`中的数据类型，必须转换后才能编写，转换写法如下：

| 基本类型    | 基本类型包装类   |
| ------- | --------- |
| byte    | Byte      |
| short   | Short     |
| int     | Integer   |
| long    | Long      |
| float   | Float     |
| double  | Double    |
| char    | Character |
| boolean | Boolean   |

我们通过举几个例子，来明确集合的创建方式：

```java
//存储字符串类型数据的ArrayList集合
ArrayList<String> list = new ArrayList<String>();
//存储整数类型数据的ArrayList集合
ArrayList<Integer> list = new ArrayList<Integer>(); 
//存储自定义Phone类型数据的ArrayList集合
ArrayList<Phone> list = new ArrayList<Phone>();
```

## 2.3 集合中常用方法

- `public boolean add(E e)`：将指定的元素添加到此集合的尾部。 

- ` public E get(int index)` ：返回此集合中指定位置上的元素。返回获取的元素。

- `public int size()` ：返回此集合中的元素个数。

  **注意:E 代表集合中存储元素的数据类型,如果集合中存的元素是字符串,E就代表字符串类型.**

通过代码演示上述方法的使用

```java
import java.util.ArrayList;
public class ArrayListDemo01 {
	public static void main(String[] args) {
		// 创建ArrayList集合
		ArrayList<String> list = new ArrayList<String>();
		// 向集合中添加元素
		list.add("stu1");
		list.add("stu2");
		list.add("stu3");
		list.add("stu4");
		// 获取集合中元素的个数
		System.out.println("集合的长度：" + list.size());
			// 取出并打印指定位置的元素
		System.out.println("第1个元素是：" + list.get(0));
		System.out.println("第2个元素是：" + list.get(1));
		System.out.println("第3个元素是：" + list.get(2));
		System.out.println("第4个元素是：" + list.get(3));
	}
}
```

运行结果如下:

![运行结果](img\运行结果.png)

​	强调一点，ArrayList集合相当于是一个长度可变的数组，所以访问集合中的元素也是采用索引方式访问，第一个元素存储在索引0的位置，第二个元素存储在索引1的位置，依次类推。

## 2.4 集合的遍历

通过集合遍历，得到集合中每个元素，这是集合中最常见的操作。集合的遍历与数组的遍历很像，都是通过索引的方式，集合遍历方式如下：ArrayListDemo02.java

```java
 import java.util.ArrayList;
 public class ArrayListDemo02 {
 	public static void main(String[] args) {
 		//创建ArrayList集合
 		ArrayList<Integer> list = new ArrayList<Integer>();
 		//添加元素到集合
 		list.add(13);
 		list.add(15);
 		list.add(22);
 		list.add(29);
 		//遍历集合
 		for (int i = 0; i < list.size(); i++) {
 			//通过索引，获取到集合中每个元素
 			int n = list.get(i);
 			System.out.println(n);
 		}
 	}
 }
```

程序运行结果如下图

![运行结果](img\运行结果.png)

## 2.5 集合中的常用方法补充

- `public void  add(int index,E   element)`：在此集合中的指定位置插入指定的元素。
- `public boolean  remove(Object o)`：删除指定的元素，返回删除是否成功
- `public E remove(int index)` ：移除此集合中指定位置上的元素。返回被删除的元素。
- `public void clear()` ：清空集合中所有元素
- `public E   set(int index,E   element)`：修改指定索引处的元素，返回被修改的元素。

演示代码如下

```java
public class ArrayListDemo02 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> array = new ArrayList<String>();

        //添加元素
        array.add("hello");
        array.add("world");
        array.add("java");

        //public boolean remove(Object o)：删除指定的元素，返回删除是否成功
		//System.out.println(array.remove("world"));
		//System.out.println(array.remove("javaee"));

        //public E remove(int index)：删除指定索引处的元素，返回被删除的元素
		//System.out.println(array.remove(1));

        //IndexOutOfBoundsException
    	//System.out.println(array.remove(3));

        //public E set(int index,E element)：修改指定索引处的元素，返回被修改的元素
		//System.out.println(array.set(1,"javaee"));

        //IndexOutOfBoundsException
		//System.out.println(array.set(3,"javaee"));

  

        //输出集合
        System.out.println("array:" + array);
    }
}
```

## 2.6 ArrayList练习

### 集合添加字符串并遍历

创建一个存储字符串的集合，存储3个字符串元素，使用程序实现在控制台遍历该集合

```java
public class ArrayListTest01 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> array = new ArrayList<String>();

        //往集合中添加字符串对象
        array.add("刘正风");
        array.add("左冷禅");
        array.add("风清扬");

        //遍历集合，其次要能够获取到集合的长度，这个通过size()方法实现
//        System.out.println(array.size());

        //遍历集合的通用格式
        for(int i=0; i<array.size(); i++) {
            String s = array.get(i);
            System.out.println(s);
        }
    }
}
```

### 对象添加到集合

创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合

```java
public class ArrayListTest03 {
  public static void main(String[] args) {
    //创建集合对象
    ArrayList<Student> list = new ArrayList<Student>();

    //创建学生对象
    Student s1 = new Student();
    s1.name = "柳岩";
    s1.age = 38;
    Student s2 = new Student();
    s2.name = "唐嫣";
    s2.age = 19;
    Student s3 = new Student();
    s3.name = "景甜";
    s3.age = 20;
    
    //把学生对象作为元素添加到集合中
    list.add(s1);
    list.add(s2);
    list.add(s3);    

    //遍历集合
    for(int x = 0; x < list.size(); x++) {
      Student s = list.get(x);
      System.out.println(s.getName()+"---"+s.getAge());
    }
  }
}
```

# 第三章 随机点名器案例

## 3.1 案例介绍

随机点名器，即在全班同学中随机的找出一名同学，打印这名同学的个人信息。

我们来完成随机点名器，它具备以下3个内容：

1. 存储所有同学姓名
2. 总览全班同学姓名
3. 随机点名其中一人，打印到控制台

## 3.2 案例需求分析

全班同学中随机的找出一名同学，打印这名同学的个人信息。

我们对本案例进行分析，得出如下分析结果：

1.存储全班同学信息（姓名、年龄）

2.打印全班同学每一个人的信息（姓名、年龄）

3.在班级总人数范围内，随机产生一个随机数，查找该随机数所对应的同学信息（姓名、年龄）

随机点名器明确地分为了三个功能。如果将多个独立功能的代码写到一起，则代码相对冗长，我们可以针对不同的功能可以将其封装到一个方法中，将完整独立的功能分离出来。

而在存储同学姓名时，如果对每一个同学都定义一个变量进行姓名存储，则会出现过多孤立的变量，很难一次性将全部数据持有。此时，我们采用ArrayList集合来解决多个学生信息的存储问题。

## 3.3 代码实现

每名学生都拥有多项个人信息，为了方便管理每个人的信息，我们对学生信息进行封装，编写Student.java文件

```java
/**
 * 学生信息类
 */
public class Student {
	String name; //姓名
	int age; //年龄
}
```

上述代码中，对学生信息（姓名、年龄）进行了封装。这样做的好处在于，以后只要找到这名学生，就能够知道他的每项个人信息了。

接下来我们编写CallName.java文件，完成程序的编写。**main方法中调用三个独立方法** 

```java
public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>(); //创建一个可以存储多个同学名字的容器
		/*
		 * 1.存储全班同学信息
		 */
		addStudent(list);
		/*
		 * 2.打印全班同学每一个人的信息（姓名、年龄）
		 */
		printStudent(list);
		/*
		 * 3.随机对学生点名，打印学生信息
		 */
		randomStudent(list);
	}
```

**存储所有学生的个人信息**

```java
	/**
	 * 1.存储全班同学名字
	 */
	public static void addStudent(ArrayList<Student> list) {
		//键盘输入多个同学名字存储到容器中
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			//创建学生
			Student s = new Student();
			System.out.println("存储第"+i+"个学生姓名：");
			s.name = sc.next();
			System.out.println("存储第"+i+"个学生年龄：");
			s.age = sc.nextInt();
			//添加学生到集合
			list.add(s);
		}
	}
```

上述方法中，方法参数list中用来表示已存储所有学生。通过Scanner，完成新学生信息（姓名，年龄）的录入，并将学生添加到集合中。

**打印全班同学每一个人的信息**

```java
	/**
	 * 2.打印全班同学每一个人的信息（姓名、年龄）
	 */
	public static void printStudent (ArrayList<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println("姓名："+s.name +",年龄："+s.age);
		}
	}
```

上述方法中，方法参数list中用来表示已存储所有学生。通过遍历集合中的每个元素，得到每个同学信息，并输出打印。

**随机对学生点名，打印学生信息**

```java
	/**
	 * 3.随机对学生点名，打印学生信息
	 */
	public static void randomStudent (ArrayList<Student> list) {
		//在班级总人数范围内，随机产生一个随机数
		int index = new Random().nextInt(list.size());
		//在容器（ArrayList集合）中，查找该随机数所对应的同学信息（姓名、年龄）
		Student s = list.get(index);
		System.out.println("被随机点名的同学："+s.name + "，年龄:" + s.age);
	}
```

上述方法中，通过随机数类Random产生一个从0到集合长度的随机索引。使用该索引获取ArrayList集合中对应的值，便得到了全班同学的随机学生信息并打印。









- [x] ​



