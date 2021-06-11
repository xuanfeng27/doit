# day22 JDK8新特性

## 主要内容

*   Lambda表达式
*   函数式接口
*   Stream流

# 第一章 Open JDK 和 Oracle JDK

## 1.1 Open JDK

Java 由 Sun 公司发明，Open JDK是Sun在2006年末把Java开源而形成的项目。也就是说Open JDK是Java SE平台版 的开源和免费实现，它由 SUN 和 Java 社区提供支持，2009年 Oracle 收购了 Sun 公司，自此 Java 的维护方之一的 SUN 也变成了 Oracle。

## 2.1 Open JDK 和 Oracle JDK的关系

大多数 JDK 都是在 Open JDK 的基础上进一步编写实现的，比如 IBM J9, Oracle JDK 和 Azul Zulu, Azul Zing。 Oracle JDK完全由 Oracle 公司开发，Oracle JDK是基于Open JDK源代码的商业版本。此外，它包含闭源组件。 Oracle JDK根据二进制代码许可协议获得许可，在没有商业许可的情况下，在2019年1月之后发布的Oracle Java SE 8 的公开更新将无法用于商业或生产用途。但是 Open JDK是完全开源的，可以自由使用。

![JDK](img\JDK.png)

**Open JDK 官网介绍**

- Open JDK 官网： http://openjdk.java.net/ 。
- JDK Enhancement Proposals(JDK增强建议)。通俗的讲JEP就是JDK的新特性

# 第一章  Lambda表达式

## 1.1 函数式编程思想概述

![](img/03-Overview.png)

在数学中，**函数**就是有输入量、输出量的一套计算方案，也就是“拿什么东西做什么事情”。相对而言，面向对象过分强调“必须通过对象的形式来做事情”，而函数式思想则尽量忽略面向对象的复杂语法——**强调做什么，而不是以什么形式做**。

**做什么，而不是怎么做**

我们真的希望创建一个匿名内部类对象吗？不。我们只是为了做这件事情而**不得不**创建一个对象。我们真正希望做的事情是：将`run`方法体内的代码传递给`Thread`类知晓。

**传递一段代码**——这才是我们真正的目的。而创建对象只是受限于面向对象语法而不得不采取的一种手段方式。那，有没有更加简单的办法？如果我们将关注点从“怎么做”回归到“做什么”的本质上，就会发现只要能够更好地达到目的，过程与形式其实并不重要。

## 1.2 Lambda的优化

当需要启动一个线程去完成任务时，通常会通过`java.lang.Runnable`接口来定义任务内容，并使用`java.lang.Thread`类来启动该线程。

**传统写法,代码如下：**

```java
public class Demo03Thread {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("多线程任务执行！");
			}
		}).start();
	}
}
```

本着“一切皆对象”的思想，这种做法是无可厚非的：首先创建一个`Runnable`接口的匿名内部类对象来指定任务内容，再将其交给一个线程来启动。

**代码分析:**

对于`Runnable`的匿名内部类用法，可以分析出几点内容：

- `Thread`类需要`Runnable`接口作为参数，其中的抽象`run`方法是用来指定线程任务内容的核心；
- 为了指定`run`的方法体，**不得不**需要`Runnable`接口的实现类；
- 为了省去定义一个`RunnableImpl`实现类的麻烦，**不得不**使用匿名内部类；
- 必须覆盖重写抽象`run`方法，所以方法名称、方法参数、方法返回值**不得不**再写一遍，且不能写错；
- 而实际上，**似乎只有方法体才是关键所在**。



![](img/02-Lambda.png)

Lambda表达式写法,代码如下：

Lambda是一个**匿名函数**，可以理解为一段可以传递的代码。

借助Java 8的全新语法，上述`Runnable`接口的匿名内部类写法可以通过更简单的Lambda表达式达到等效：

```java
public class Demo04LambdaRunnable {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("多线程任务执行！")).start(); // 启动线程
	}
}
```

这段代码和刚才的执行效果是完全一样的，可以在1.8或更高的编译级别下通过。从代码的语义中可以看出：我们启动了一个线程，而线程任务的内容以一种更加简洁的形式被指定。

**Lambda的优点**  简化匿名内部类的使用，语法更加简单。

## 1.3 Lambda的格式

### 1.3.1标准格式:

Lambda省去面向对象的条条框框，格式由**3个部分**组成：

* 一些参数
* 一个箭头
* 一段代码

Lambda表达式的**标准格式**为：

```
(参数类型 参数名称) -> { 代码语句 }
```

**格式说明：**

* 小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
* `->`是新引入的语法格式，代表指向动作。
* 大括号内的语法与传统方法体要求基本一致。

**匿名内部类与lambda对比:**

```java
new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("多线程任务执行！");
			}
}).start();
```

```java
() -> System.out.println("多线程任务执行！")
```

- 前面的一对小括号即`run`方法的参数（无），代表不需要任何条件；
- 中间的一个箭头代表将前面的参数传递给后面的代码；
- 后面的输出语句即业务逻辑代码。

**练习无参数无返回值的Lambda** 

```java
public interface Fly {
    public  abstract  void fly();

}

public class Test {
    public static void main(String[] args) {
        method(new Fly() {
            @Override
            public void fly() {

                System.out.println("飞");
            }
        });

        method(() -> {
            System.out.println("就这样飞了");
        });

    }

    public static  void method(Fly f){
        f.fly();
    }
}

```

**练习有参数有返回值的Lambda** 
下面举例演示 java.util.Comparator<T>接口的使用场景代码，其中的抽象方法定义为： 

- public abstract int compare(T o1, T o2); 

当需要对一个对象集合进行排序时， Collections.sort方法需要一个 Comparator接口实例来指定排序的规则。 传统写法 
如果使用传统的代码对 ArrayList集合进行排序，写法如下：

```java
public class Person { 
  private String name; 
  private int age; 
}
```

```java
public class Test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("柳岩", 38));
        list.add(new Person("唐嫣", 18));
        list.add(new Person("金莲", 138));
        list.add(new Person("大郎", 8));

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(list);
    }
}
```

这种做法在面向对象的思想中，似乎也是“理所当然”的。其中 Comparator接口的实例（使用了匿名内部类）代表 了“按照年龄从小到大”的排序规则。

接下来使用Lambda改写:

```java
public class Test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("柳岩", 38));
        list.add(new Person("唐嫣", 18));
        list.add(new Person("金莲", 138));
        list.add(new Person("大郎", 8));

//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        Collections.sort(list,(Person o1,Person o2)->{
            return o1.getAge() - o2.getAge();
        });

        System.out.println(list);
    }
}
```

### 1.3.2 省略格式:

**省略规则**

在Lambda标准格式的基础上，使用省略写法的规则为：

1. 小括号内参数的类型可以省略；
2. 如果小括号内**有且仅有一个参**，则小括号可以省略；
3. 如果大括号内**有且仅有一个语句**，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。

> 备注：掌握这些省略规则后，请对应地回顾本章开头的多线程案例。

```java
Runnable接口简化:
1. () -> System.out.println("多线程任务执行！")
Comparator接口简化:
2. Arrays.sort(array, (a, b) -> a.getAge() - b.getAge());
```

**以后我们调用方法时,看到参数是接口就可以考虑使用Lambda表达式,Lambda表达式相当于是对接口中抽象方法的重写.**

## **1.4 Lambda表达式原理(了解)**

我们现在已经会使用Lambda表达式了。现在同学们肯定很好奇Lambda是如何实现的，现在我们就来探究Lambda 表达式的底层实现原理。

```java
public interface Fly {
    public  abstract  void fly();
}
```

```java
public class Test {
    public static void main(String[] args) {
        //使用匿名内部类实现
        method(new Fly() {
            @Override
            public void fly() {
                System.out.println("我就这么飞了!");
            }
        });

    }
    public static void method(Fly f){
        f.fly();
    }
}
```

使用匿名内部类的方式我们发现编译后的class文件会多一个Test$1的class文件

![04_匿名内部类](img\04_匿名内部类.png)

对这个文件进行反编译得到结果

```java
import java.io.PrintStream;
static class Test$1 implements Fly
{
	public void fly()
	{
		System.out.println("我就这么飞了!");
	}
	Test$1()
	{
	}
}
```

OK,我们发现的确是定义了一个类实现了Fly接口并重写了fly方法

那么接下来我们看看Lambda表达式的情况:

```java
public class Test {
    public static void main(String[] args) {
        //使用Lambda表达式
        method(()->{
            System.out.println("我也飞飞飞了");
        });

    }
    public static void method(Fly f){
        f.fly();
    }
}
```

运行程序，控制台可以得到预期的结果，但是并没有出现一个新的类，也就是说Lambda并没有在编译的时候产生一 个新的类。

![](img\05_Lambda.png)

注意Lambda这种方式没办法使用反编译工具直接编译,我们借助java提供的javap命令，对字节码进行反汇编，查看字节码指令。

格式 (DOS命令行)

```
javap -c -p 类名    //注意需要在class文件所在的目录中执行
```

![](img\06_命令.png)

执行后我们看到如下结果

```java
Compiled from "Test.java"
public class com.doit.demo08.Test {
  public com.doit.demo08.Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: invokedynamic #2,  0              // InvokeDynamic #0:fly:()Lcom/doit/demo08/Fly;
       5: invokestatic  #3                  // Method method:(Lcom/doit/demo08/Fly;)V
       8: return

  public static void method(com.doit.demo08.Fly);
    Code:
       0: aload_0
       1: invokeinterface #4,  1            // InterfaceMethod com/doit/demo08/Fly.fly:()V
       6: return

  //这个是类中多出来的方法 叫做lambda$main$0
  private static void lambda$main$0();
    Code:
       0: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #6                  // String 我也飞飞飞了
       5: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```

可以看到在类中多出了一个私有的静态方法 lambda$main$0。这个方法里面放的是什么内容呢？我们通过断点调试 来看看：

![](img\07_方法名.png)

可以确认 lambda$main$0 里面放的就是Lambda中的内容，我们可以这么理解 lambda$main$0 方法：

```java
 private static void lambda$main$0(){
   	 System.out.println("我也飞飞飞了");
 }
```

关于这个方法 lambda$main$0 的命名：以lambda开头，因为是在main()函数里使用了lambda表达式，所以带有 $main表示，因为是第一个，所以$0。

如何调用这个方法呢？其实Lambda在运行的时候会生成一个内部类，为了验证是否生成内部类，可以在运行时加 上 -Djdk.internal.lambda.dumpProxyClasses ，加上这个参数后，运行时会将生成的内部类class码输出到一个文 件中。使用java命令如下：

```
java -Djdk.internal.lambda.dumpProxyClasses 要运行的包名.类名
```

注意:由于我们的类都有包名,所以需要退出包运行

![08_运行时类](img\08_运行时类.png)

OK,运行成功,这个命令会把一个运行时生成的class输出到一个文件中,看class的文件夹

![09_运行时类](img\09_运行时类.png)

将文件进行反编译:

```java
final class Test$$Lambda$1 implements Fly
{
	public void fly()
	{
		Test.lambda$main$0();
	}
	private Test$$Lambda$1()
	{
	}
}
```

可以看到这个匿名内部类实现了 Fly接口，并且重写了 fly方法， fly方法调用 Test.lambda$main$0()，也就是调用Lambda中的内容。最后可以将Lambda理解为

```java
//注意这个代码不能编译运行 仅限于理解lamdbda
public class Test {
    public static void main(String[] args) {
        //使用Lambda表达式
        method(new  Fly() {
            public void fly()
            {
                Test.lambda$main$0();
            }
        });
    }
    
    private static void lambda$main$0(){
   	 System.out.println("我也飞飞飞了");
 	}
    public static void method(Fly f){
        f.fly();
    }
}
```

**结论:**

匿名内部类在编译的时候会一个class文件 
Lambda在程序运行的时候形成一个类 

1. 在类中新增一个方法,这个方法的方法体就是Lambda表达式中的代码 
2. 还会形成一个匿名内部类,实现接口,重写抽象方法 
3. 在接口的重写方法中会调用新生成的方法.

## 1.4 Lambda的前提条件

Lambda的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有两个问题需要特别注意：

1. 使用Lambda必须具有接口，且要求**接口中有且仅有一个抽象方法**。
   无论是JDK内置的`Runnable`、`Comparator`接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
2. 使用Lambda必须具有接口作为方法参数。
   也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。

> 备注：有且仅有一个抽象方法的接口，称为“**函数式接口**”。

# 第二章 函数式接口

## 2.1 概述

函数式接口在Java中是指：**有且仅有一个抽象方法的接口**。

函数式接口，即适用于函数式编程场景的接口。而Java中的函数式编程体现就是Lambda，所以函数式接口就是可以适用于Lambda使用的接口。只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利地进行推导。

> 备注:从应用层面来讲，Java中的Lambda可以看做是匿名内部类的简化格式，但是二者在原理上不同。

### 格式

只要确保接口中有且仅有一个抽象方法即可：

```java
修饰符 interface 接口名称 {
    public abstract 返回值类型 方法名称(可选参数信息);
    // 其他非抽象方法内容
}
```

由于接口当中抽象方法的`public abstract`是可以省略的，所以定义一个函数式接口很简单：

```java
public interface MyFunctionalInterface {	
	void myMethod();
}
```

### 2.1 FunctionalInterface注解

与`@Override`注解的作用类似，Java 8中专门为函数式接口引入了一个新的注解：`@FunctionalInterface`。该注解可用于一个接口的定义上：

```java
@FunctionalInterface
public interface MyFunctionalInterface {
	void myMethod();
}
```

一旦使用该注解来定义接口，编译器将会强制检查该接口是否确实有且仅有一个抽象方法，否则将会报错。不过，即使不使用该注解，只要满足函数式接口的定义，这仍然是一个函数式接口，使用起来都一样。

## 2.2 常用函数式接口

我们知道使用Lambda表达式的前提是需要有函数式接口。而Lambda使用时不关心接口名，抽象方法名，只关心抽 象方法的参数列表和返回值类型。因此为了让我们使用Lambda方便，JDK提供了大量常用的函数式接口。它们主要在`java.util.function`包中被提供.

### Supplier接口

`java.util.function.Supplier<T>`接口，它意味着"供给" , 对应的Lambda表达式需要“**对外提供**”一个符合泛型类型的对象数据。

**抽象方法 : get** 

仅包含一个无参的方法：`T get()`。用来获取一个泛型参数指定类型的对象数据。

```java
public class Test {
    public static void main(String[] args) {
        //匿名内部类
        Supplier<String>  s = new Supplier<String>() {
            @Override
            public String get() {
                return "abc";
            }
        };

        System.out.println(s.get());
        //lambda
        Supplier<String> s2 = ()->"abc";

        System.out.println(s2.get());

    }
}
```

**求数组元素最大值**

使用`Supplier`接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。提示：接口的泛型请使用`java.lang.Integer`类。

**代码示例:**

```java
public class DemoIntArray {
    public static void main(String[] args) {
        int[] array = { 10, 20, 100, 30, 40, 50 };
        printMax(() -> {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {              
                  	max = array[i];
                }
            }
            return max;
        });
    }

    private static void printMax(Supplier<Integer> supplier) {
        int max = supplier.get();
        System.out.println(max);
    }
}
```

### Consumer接口

`java.util.function.Consumer<T>`接口则正好相反，它不是生产一个数据，而是**消费**一个数据，其数据类型由泛型参数决定。

**抽象方法：accept**

`Consumer`接口中包含抽象方法`void accept(T t)`，意为消费一个指定泛型的数据。基本使用如：

```java
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        //匿名内部类
        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        c.accept(100);

        //lambda
       Consumer<Integer> c2 = (i) -> System.out.println(i);

       c2.accept(200);
    }
}
```

**练习:使用Consumer接口作为方法的参数将一个字符串转换为大写并打印**

```java
public class Test {
    public static void main(String[] args) {
        getUpper("world", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });
      
        getUpper("hello",(s)->{
            System.out.println(s.toUpperCase());
        });
    }
    public static  void getUpper(String s ,Consumer<String> consumer){
            consumer.accept(s);
    }
}
```

**默认方法：andThen**

如果一个方法的参数和返回值全都是`Consumer`类型，那么就可以实现效果：消费一个数据的时候，首先做一个操作，然后再做一个操作，实现组合。而这个方法就是`Consumer`接口中的default方法`andThen`。下面是JDK的源代码：

```java
default Consumer<T> andThen(Consumer<? super T> after) {
    Objects.requireNonNull(after);
    return (T t) -> { accept(t); after.accept(t); };
}
```

> 备注：`java.util.Objects`的`requireNonNull`静态方法将会在参数为null时主动抛出`NullPointerException`异常。这省去了重复编写if语句和抛出空指针异常的麻烦。

要想实现组合，需要两个或多个Lambda表达式即可，而`andThen`的语义正是“一步接一步”操作。例如两个步骤组合的情况：

```java
public class Test {
    public static void main(String[] args) {
        printString("Hello", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());
            }
        });
      
      
       printString("hello",
                s-> System.out.println(s.toUpperCase()),
                s -> System.out.println(s.toLowerCase()));
    }
    public static  void printString(String s ,Consumer<String> consumer,Consumer<String> consumer2){
//            consumer.accept(s);
//            consumer2.accept(s);

        consumer.andThen(consumer2).accept(s);
    }
}
```

运行结果将会首先打印完全大写的HELLO，然后打印完全小写的hello。当然，通过链式写法可以实现更多步骤的组合。

### Function接口

`java.util.function.Function<T,R>`接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。有进有出，所以称为“函数Function”。

**抽象方法：apply**

`Function`接口中最主要的抽象方法为：`R apply(T t)`，根据类型T的参数获取类型R的结果。使用的场景例如：将`String`类型转换为`Integer`类型。

```java
public class Test {
    public static void main(String[] args) {

        Function<String,Integer> f = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        Integer apply = f.apply("100");
        System.out.println(apply);


        Function<String,Integer> f2 = s -> Integer.parseInt(s);
        System.out.println(f2.apply("200"));

    }

}
```

**练习:**  使用Function接口作为方法参数 将一个存储字符串名字的集合,转换为一个存储Person对象的集合

```java
public class Test {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        list.add("柳岩");
        list.add("唐嫣");
        change(list, new Function<String, Person>() {
            @Override
            public Person apply(String s) {
                return new Person(s);
            }
        });


        change(list,s -> new Person(s));

    }

    public static void  change(List<String> list , Function<String, Person> f){
        List<Person> personList = new ArrayList<>();
        for (String name : list) {
            Person p = f.apply(name);
            personList.add(p);
        }

        System.out.println(personList);
    }

}
```

**默认方法：andThen**

`Function`接口中有一个默认的`andThen`方法，用来进行组合操作。JDK源代码如：

```java
default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
    Objects.requireNonNull(after);
    return (T t) -> after.apply(apply(t));
}
```

该方法同样用于“先做什么，再做什么”的场景，和`Consumer`中的`andThen`差不多：

```java
public class Test {
    public static void main(String[] args) {

        method("10",s -> {
            return Integer.parseInt(s);
        },s->{
            return s*=10;
        });

    }
    //将字符串转为 int 在扩大10倍
    private static void method( String str,Function<String, Integer> one, Function<Integer, Integer> two) {
//        Integer i = one.apply(str);
//        Integer num = two.apply(i);
//        System.out.println(num);

        Integer num = one.andThen(two).apply(str);
        System.out.println(num);

    }

}
```

第一个操作是将字符串解析成为int数字，第二个操作是乘以10。两个操作通过`andThen`按照前后顺序组合到了一起。

> 请注意，Function的前置条件泛型和后置条件泛型可以相同。

### Predicate接口

有时候我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。这时可以使用`java.util.function.Predicate<T>`接口。

**抽象方法：test**

`Predicate`接口中包含一个抽象方法：`boolean  test(T t) `。用于条件判断的场景：

```java
public class Test {
    public static void main(String[] args) {
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.endsWith(".java");
            }
        };

        System.out.println(p.test("abc.java"));

        Predicate<String> p2 = s -> s.endsWith(".java");

        System.out.println(p2.test("aaa.java"));
    }

}
```

练习:使用Predicate作为方法参数 判断一个字符串是否很长 如果长度大于5则为true 小于5则为false

```java
public class Test {
    public static void main(String[] args) {

       isLong("aaa", new Predicate<String>() {
           @Override
           public boolean test(String s) {

               return  s.length()>=5;
           }
       });

       isLong("bbbaa",s -> s.length()>=5);
    }

    public static void isLong(String s , Predicate<String> p){
        boolean test = p.test(s);
        System.out.println(test);
    }

}
```

**默认方法：and**

既然是条件判断，就会存在与、或、非三种常见的逻辑关系。其中将两个`Predicate`条件使用“与”逻辑连接起来实现“**并且**”的效果时，可以使用default方法`and`。其JDK源码为：

```java
default Predicate<T> and(Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return (t) -> test(t) && other.test(t);
}
```

如果要判断一个字符串既要包含大写“H”，又要包含大写“W”，那么：

```java
public class Test {

    public static void main(String[] args) {
        method("Helloworld" ,s -> s.contains("H"), s -> s.contains("W"));
    }
    private static void method(String str ,Predicate<String> one, Predicate<String> two) {
        boolean b1 = one.test(str);
        boolean b2 = two.test(str);
        System.out.println("字符串符合要求吗：" + (b1 && b2));


        boolean isValid = one.and(two).test(str);
        System.out.println("字符串符合要求吗：" + isValid);
    }

}
```

**默认方法：or**

与`and`的“与”类似，默认方法`or`实现逻辑关系中的“**或**”。JDK源码为：

```java
default Predicate<T> or(Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return (t) -> test(t) || other.test(t);
}
```

如果希望实现逻辑“字符串包含大写H或者包含大写W”，那么代码只需要将“and”修改为“or”名称即可，其他都不变：

```java
public class Test {

    public static void main(String[] args) {
        method("Helloworld" ,s -> s.contains("H"), s -> s.contains("W"));
    }
    private static void method(String str ,Predicate<String> one, Predicate<String> two) {
        boolean b1 = one.test(str);
        boolean b2 = two.test(str);
        System.out.println("字符串符合要求吗：" + (b1 || b2));


        boolean isValid = one.and(two).test(str);
        System.out.println("字符串符合要求吗：" + isValid);
    }

}
```

**默认方法：negate**

“与”、“或”已经了解了，剩下的“非”（取反）也会简单。默认方法`negate`的JDK源代码为：

```java
default Predicate<T> negate() {
    return (t) -> !test(t);
}
```

从实现中很容易看出，它是执行了test方法之后，对结果boolean值进行“!”取反而已。一定要在`test`方法调用之前调用`negate`方法，正如`and`和`or`方法一样：

```java
public class Test {
    public static void main(String[] args) {

       isLong("aaa", new Predicate<String>() {
           @Override
           public boolean test(String s) {

               return  s.length()<5;
           }
       });

       isLong("bbbaa",s -> s.length()>=5);
    }

    public static void isLong(String s , Predicate<String> p){
        boolean test = p.test(s);
        System.out.println(!test);
        boolean b2 =  p.negate().test(s);
        System.out.println(b2);
    }

}
```

# 第三章 方法引用[了解]

## 概述和方法引用符

来看一个简单的函数式接口以应用Lambda表达式 , 在accept方法中接收字符串 , 目的就是为了打印显示字符串 , 那么通过Lambda来使用它的代码很简单：

```java
public class DemoPrintSimple {
    private static void printString(Consumer<String> data, String str) {
        data.accept(str);
    }
    public static void main(String[] args) {
      	printString(s -> System.out.println(s), "Hello World");
    }
}
```

由于lambda表达式中,调用了已经实现的println方法 ,可以使用方法引用替代lambda表达式.

**符号表示 :** `::`

**符号说明 :**  双冒号为方法引用运算符，而它所在的表达式被称为**方法引用**。

**应用场景 : **如果Lambda要表达的函数方案 , 已经存在于某个方法的实现中，那么则可以使用方法引用。

> 如上例中，System.out对象中有个println(String)方法 , 恰好就是我们所需要的 , 那么对于Consumer接口作为参数，对比下面两种写法，完全等效：
>
> - Lambda表达式写法：s -> System.out.println(s);
>   拿到参数之后经Lambda之手，继而传递给System.out.println方法去处理。
> - 方法引用写法：System.out::println
>   直接让System.out中的println方法来取代Lambda。

**推导与省略 : ** 如果使用Lambda，那么根据“**可推导就是可省略**”的原则，无需指定参数类型，也无需指定的重载形式——它们都将被自动推导。而如果使用方法引用，也是同样可以根据上下文进行推导。函数式接口是Lambda的基础，而方法引用是Lambda的简化形式。

## 方法引用简化

只要“引用”过去就好了：

```java
public class DemoPrintRef {
    private static void printString(Consumer<String> data, String str) {
        data.accept(str);
    }
    public static void main(String[] args) {
      	printString(System.out::println, "HelloWorld");
    }
}
```

请注意其中的双冒号`::`写法，这被称为“**方法引用**”，而双冒号是一种新的语法。

## 扩展的引用方式

### 对象名--引用成员方法

这是最常见的一种用法，与上例相同。如果一个类中已经存在了一个成员方法，则可以通过对象名引用成员方法，代码为：

```java
public class DemoMethodRef {
     public static void main(String[] args) {
        String str = "hello";
        printUP(str::toUpperCase);
    }

    public static void printUP(Supplier< String> sup ){
        String apply =sup.get();
        System.out.println(apply);
    }
}
```

### 类名--引用静态方法

由于在`java.lang.Math`类中已经存在了静态方法`random`，所以当我们需要通过Lambda来调用该方法时,可以使用方法引用 , 写法是：

```java
public class DemoMethodRef {
  public static void main(String[] args) {
        printRanNum(Math::random);
    }

    public static void printRanNum(Supplier<Double> sup ){
        Double apply =sup.get();
        System.out.println(apply);
    }
}
```

在这个例子中，下面两种写法是等效的：

- Lambda表达式：`n -> Math.abs(n)`
- 方法引用：`Math::abs`

### 类--构造引用

由于构造器的名称与类名完全一样，并不固定。所以构造器引用使用`类名称::new`的格式表示。首先是一个简单的`Person`类：

```java
public class Person {
    private String name;
    public Person(String name) {
      	this.name = name;
    }
    public String getName() {
      	return name;
    }
}
```

要使用这个函数式接口，可以通过方法引用传递：

```java
public class Demo09Lambda {
    public static void main(String[] args) {
		String name = "tom";
        Person person = createPerson(Person::new, name);
        System.out.println(person);
        
    }

    public static Person createPerson(Function<String, Person> fun , String name){
        Person p = fun.apply(name);
        return p;

    }
}
```

在这个例子中，下面两种写法是等效的：

- Lambda表达式：`name -> new Person(name)`
- 方法引用：`Person::new`

### 数组--构造引用

数组也是`Object`的子类对象，所以同样具有构造器，只是语法稍有不同。如果对应到Lambda的使用场景中时，需要一个函数式接口：

在应用该接口的时候，可以通过方法引用传递：

```java
public class Demo11ArrayInitRef {   
   public static void main(String[] args) {

        int[] array = createArray(int[]::new, 3);
        System.out.println(array.length);

    }

    public static int[] createArray(Function<Integer , int[]> fun , int n){
        int[] p = fun.apply(n);
        return p;

    }
}
```

在这个例子中，下面两种写法是等效的：

- Lambda表达式：`length -> new int[length]`
- 方法引用：`int[]::new`

> 注意 : 
> 方法引用是对Lambda表达式符合特定情况下的一种缩写，它使得我们的Lambda表达式更加的精简，也可以理解为Lambda表达式的缩写形式 , 同学们可以尝试着 , 将之前使用lambda的地方 , 改写成方法引用的形式 ,不过要注意的是方法引用只能"引用"已经存在的方法!  





# 第四章 Stream流

在Java 8中，得益于Lambda所带来的函数式编程，引入了一个**全新的Stream概念**，用于解决已有集合类库既有的弊端。

## 4.1 引言

**传统集合的多步遍历代码**

几乎所有的集合（如`Collection`接口或`Map`接口等）都支持直接或间接的遍历操作。而当我们需要对集合中的元素进行操作的时候，除了必需的添加、删除、获取外，最典型的就是集合遍历。例如：

```java
public class Demo10ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        for (String name : list) {
          	System.out.println(name);
        }
    }  
}
```

这是一段非常简单的集合遍历操作：对集合中的每一个字符串都进行打印输出操作。

**循环遍历的弊端**

Java 8的Lambda让我们可以更加专注于**做什么**（What），而不是**怎么做**（How），这点此前已经结合内部类进行了对比说明。现在，我们仔细体会一下上例代码，可以发现：

- for循环的语法就是“**怎么做**”
- for循环的循环体才是“**做什么**”

为什么使用循环？因为要进行遍历。但循环是遍历的唯一方式吗？遍历是指每一个元素逐一进行处理，**而并不是从第一个到最后一个顺次处理的循环**。前者是目的，后者是方式。

试想一下，如果希望对集合中的元素进行筛选过滤：

1. 将集合A根据条件一过滤为**子集B**；
2. 然后再根据条件二过滤为**子集C**。

那怎么办？在Java 8之前的做法可能为：

这段代码中含有三个循环，每一个作用不同：

1. 首先筛选所有姓张的人；
2. 然后筛选名字有三个字的人；
3. 最后进行对结果进行打印输出。

```java
public class Demo11NormalFilter {
  	public static void main(String[] args) {
      	List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
              	zhangList.add(name);
            }
        }

        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
              	shortList.add(name);
            }
        }

        for (String name : shortList) {
          	System.out.println(name);
        }
    }
}
```

每当我们需要对集合中的元素进行操作的时候，总是需要进行循环、循环、再循环。这是理所当然的么？**不是。**循环是做事情的方式，而不是目的。另一方面，使用线性循环就意味着只能遍历一次。如果希望再次遍历，只能再使用另一个循环从头开始。

那，Lambda的衍生物Stream能给我们带来怎样更加优雅的写法呢？

**Stream的更优写法**

下面来看一下借助Java 8的Stream API，什么才叫优雅：

```java
public class Demo12StreamFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream()
          	.filter(s -> s.startsWith("张"))
            .filter(s -> s.length() == 3)
            .forEach(s -> System.out.println(s));
    }
}
```

直接阅读代码的字面意思即可完美展示无关逻辑方式的语义：**获取流、过滤姓张、过滤长度为3、逐一打印**。代码中并没有体现使用线性循环或是其他任何算法进行遍历，我们真正要做的事情内容被更好地体现在代码中。

## 4.2 流式思想概述

**注意：Stream和IO流(InputStream/OutputStream)没有任何关系，请暂时忘记对传统IO流的固有印象**

Stream流式思想类似于工厂车间的“**生产流水线**”，Stream流不是一种数据结构，不保存数据，而是对数据进行加工 处理。Stream可以看作是流水线上的一个工序。在流水线上，通过多个工序让一个原材料加工成一个商品。

![](img/02-流水线.jpeg)

当需要对多个元素进行操作（特别是多步操作）的时候，考虑到性能及便利性，我们应该首先拼好一个“模型”步骤方案，然后再按照方案去执行它。

![](img/01-流式思想示意图.png)

> Stream API能让我们快速完成许多复杂的操作，如筛选、切片、映射、查找、去除重复，统计，匹配和归约。Stream是流式思想,相当于工厂的流水线,对集合中的数据进行加工处理

## 4.3 获取流方式

`java.util.stream.Stream<T>`是Java 8新加入的最常用的流接口。（这并不是一个函数式接口。）

获取一个流非常简单，有以下几种常用的方式：

- 所有的`Collection`集合都可以通过`stream`默认方法获取流；
- `Stream`接口的静态方法`of`可以获取数组对应的流。

**方式1 : 根据Collection获取流**

首先，`java.util.Collection`接口中加入了default方法`stream`用来获取流，所以其所有实现类均可获取流。

```java
import java.util.*;
import java.util.stream.Stream;
/*
    获取Stream流的方式

    1.Collection中 方法
        Stream stream()
    2.Stream接口 中静态方法
        of(T...t) 向Stream中添加多个数据
 */
public class Demo13GetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // ...
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        // ...
        Stream<String> stream2 = set.stream();
    }
}
```



**方式2: 根据数组获取流**

如果使用的不是集合或映射而是数组，由于数组对象不可能添加默认方法，所以`Stream`接口中提供了静态方法`of`，使用很简单：

```java
import java.util.stream.Stream;

public class Demo14GetStream {
    public static void main(String[] args) {
        String[] array = { "张无忌", "张翠山", "张三丰", "张一元" };
        Stream<String> stream = Stream.of(array);
    }
}
```

> 备注：`of`方法的参数其实是一个可变参数，所以支持数组。

## 4.4 常用方法

流模型的操作很丰富，这里介绍一些常用的API。这些方法可以被分成两种：

- **终结方法**：返回值类型不再是`Stream`接口自身类型的方法，因此不再支持类似`StringBuilder`那样的链式调用。本小节中，终结方法包括`count`和`forEach`方法。
- **非终结方法**：返回值类型仍然是`Stream`接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方法均为非终结方法。）

> 备注：本小节之外的更多方法，请自行参考API文档。

### forEach : 逐一处理

虽然方法名字叫`forEach`，但是与for循环中的“for-each”昵称不同，该方法**并不保证元素的逐一消费动作在流中是被有序执行的**。

```java
void forEach(Consumer<? super T> action);
```

该方法接收一个`Consumer`接口函数，会将每一个流元素交给该函数进行处理。例如：

```java
import java.util.stream.Stream;

public class Demo15StreamForEach {
    public static void main(String[] args) {
        Stream<String> stream =  Stream.of("大娃","二娃","三娃","四娃","五娃","六娃","七娃","爷爷","蛇精","蝎子精");
        //Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        stream.forEach((String str)->{System.out.println(str);});
    }
}
```

在这里，lambda表达式`(String str)->{System.out.println(str);}`就是一个Consumer函数式接口的示例。

### filter：过滤

可以通过`filter`方法将一个流转换成另一个子集流。方法声明：

```java
Stream<T> filter(Predicate<? super T> predicate);
```

该接口接收一个`Predicate`函数式接口参数（可以是一个Lambda）作为筛选条件。

![fliter](img\fliter.jpg)

基本使用**

Stream流中的`filter`方法基本使用的代码如：

```java
public class Demo16StreamFilter {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.filter((String s) -> {return s.startsWith("张");});
    }
}
```

在这里通过Lambda表达式来指定了筛选的条件：必须姓张。

### count：统计个数

正如旧集合`Collection`当中的`size`方法一样，流提供`count`方法来数一数其中的元素个数：

```java
long count();
```

该方法返回一个long值代表元素个数（不再像旧集合那样是int值）。基本使用：

```java
public class Demo17StreamCount {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.filter(s -> s.startsWith("张"));
        System.out.println(result.count()); // 2
    }
}
```

### limit：取用前几个`limit`方法可以对流进行截取，只取用前n个。方法签名：

```java
Stream<T> limit(long maxSize):获取Stream流对象中的前n个元素,返回一个新的Stream流对象
```

参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作。

![limit](img\limit.jpg)

基本使用：

```java
import java.util.stream.Stream;

public class Demo18StreamLimit {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.limit(2);
        System.out.println(result.count()); // 2
    }
}
```

### skip：跳过前几个

如果希望跳过前几个元素，可以使用`skip`方法获取一个截取之后的新流：

```java
Stream<T> skip(long n): 跳过Stream流对象中的前n个元素,返回一个新的Stream流对象
```

如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。

![skip](img\skip.jpg)

基本使用：

```java
import java.util.stream.Stream;

public class Demo19StreamSkip {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.skip(2);
        System.out.println(result.count()); // 1
    }
}
```

### concat：组合

如果有两个流，希望合并成为一个流，那么可以使用`Stream`接口的静态方法`concat`：

```java
static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b): 把参数列表中的两个Stream流对象a和b,合并成一个新的Stream流对象
```

> 备注：这是一个静态方法，与`java.lang.String`当中的`concat`方法是不同的。

该方法的基本使用代码如：

```java
import java.util.stream.Stream;

public class Demo20StreamConcat {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("张无忌");
        Stream<String> streamB = Stream.of("张翠山");
        Stream<String> result = Stream.concat(streamA, streamB);
    }
}
```

### **distinct**:去重

如果需要去除重复数据，可以使用 distinct方法。方法签名：

```
Stream<T> distinct()
```

![distinct](img\distinct.jpg)

基本使用:

```java
public class Test {
    public static void main(String[] args) {
      Stream.of(22, 33, 22, 11, 33)
                .distinct()
                .forEach(s-> System.out.println(s));

    }
}
```

### map:映射

如果需要将流中的元素映射到另一个流中，可以使用 map方法。方法签名：

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
```

该接口需要一个 Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。

![map](img\map.jpg)

基本使用:

```
public class Test {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("11", "22", "33");
        Stream<Integer> result = original.map(Integer::parseInt);
        result.forEach(s -> System.out.println(s + 10));

    }
}
```

## 4.5 Stream综合案例

现在有两个`ArrayList`集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）**依次**进行以下若干操作步骤：

1. 第一个队伍只要名字为3个字的成员姓名；
2. 第一个队伍筛选之后只要前3个人；
3. 第二个队伍只要姓张的成员姓名；
4. 第二个队伍筛选之后不要前2个人；
5. 将两个队伍合并为一个队伍；
6. 打印整个队伍的姓名信息。

两个队伍（集合）的代码如下：

```java
public class Demo21ArrayListNames {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");
		// ....
    }
}
```

**传统方式** 

使用for循环 , 示例代码:

```java
public class Demo22ArrayListNames {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        // ...

        List<String> two = new ArrayList<>();
        // ...

        // 第一个队伍只要名字为3个字的成员姓名；
        List<String> oneA = new ArrayList<>();
        for (String name : one) {
            if (name.length() == 3) {
                oneA.add(name);
            }
        }

        // 第一个队伍筛选之后只要前3个人；
        List<String> oneB = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            oneB.add(oneA.get(i));
        }

        // 第二个队伍只要姓张的成员姓名；
        List<String> twoA = new ArrayList<>();
        for (String name : two) {
            if (name.startsWith("张")) {
                twoA.add(name);
            }
        }

        // 第二个队伍筛选之后不要前2个人；
        List<String> twoB = new ArrayList<>();
        for (int i = 2; i < twoA.size(); i++) {
            twoB.add(twoA.get(i));
        }

        // 将两个队伍合并为一个队伍；
        List<String> totalNames = new ArrayList<>();
        totalNames.addAll(oneB);
        totalNames.addAll(twoB);        

        // 打印整个队伍的姓名信息。
        for (String name : totalNames) {
            System.out.println(name);
        }
    }
}
```

运行结果为：

```
宋远桥
苏星河
洪七公
张二狗
张天爱
张三
```

**Stream方式** 

等效的Stream流式处理代码为：

```java
public class Demo23StreamNames {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        // ...

        List<String> two = new ArrayList<>();
        // ...

        // 第一个队伍只要名字为3个字的成员姓名；
        // 第一个队伍筛选之后只要前3个人；
        Stream<String> streamOne = one.stream().filter(s -> s.length() == 3).limit(3);

        // 第二个队伍只要姓张的成员姓名；
        // 第二个队伍筛选之后不要前2个人；
        Stream<String> streamTwo = two.stream().filter(s -> s.startsWith("张")).skip(2);

        // 将两个队伍合并为一个队伍；
        // 根据姓名创建Person对象；
        // 打印整个队伍的Person对象信息。
        Stream.concat(streamOne, streamTwo).forEach(s->System.out.println(s));
    }
}
```

运行效果完全一样：

```
宋远桥
苏星河
洪七公
张二狗
张天爱
张三
```

## 4.6 函数拼接与终结方法[了解]

在上述介绍的各种方法中，凡是返回值仍然为`Stream`接口的为**函数拼接方法**，它们支持链式调用；而返回值不再为`Stream`接口的为**终结方法**，不再支持链式调用。如下表所示：

| 方法名     | 方法作用  | 方法种类 | 是否支持链式调用 |
| ------- | ----- | ---- | -------- |
| count   | 统计个数  | 终结   | 否        |
| forEach | 逐一处理  | 终结   | 否        |
| filter  | 过滤    | 函数拼接 | 是        |
| limit   | 取用前几个 | 函数拼接 | 是        |
| skip    | 跳过前几个 | 函数拼接 | 是        |
| concat  | 组合    | 函数拼接 | 是        |

## 4.7 Stream流中的结果到集合中

Stream流提供 collect方法，其参数需要一个 java.util.stream.Collector<T,A, R>接口对象来指定收集到哪 种集合中。java.util.stream.Collectors 类提供一些方法，可以作为  Collector`接口的实例： 

- public static <T> Collector<T, ?, List<T>> toList()：转换为 List集合。 
- public static <T> Collector<T, ?, Set<T>> toSet()：转换为 Set集合。 

下面是这两个方法的基本使用代码

```java
public class Test {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        //转换为list集合
        List<String> list = stream.collect(Collectors.toList());
        //转换为set集合
        Set<String> set = stream.collect(Collectors.toSet());
        //转换为ArrayList集合
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        //转换为HashSet集合
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
    }

}
```

## 4.8 Stream流中的结果到数组中

Stream提供 toArray方法来将结果放到一个数组中，返回值类型是Object[]的：

```java
Object[] toArray();
```

其使用场景如：

```java
public class Test {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aa", "bb", "cc");

        Object[] objects = stream.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}
```



