[TOC]



# OnJava8

### https://lingcoder.github.io/OnJava8/#/book/05-Control-Flow

基本类型有自己对应的包装类型，如果你希望在堆内存里表示基本类型的数据，就需要用到它们的包装类。代码示例：

```java
char c = 'x';
Character ch = new Character(c);
```

或者你也可以使用下面的形式：

```java
Character ch = new Character('x');
```

基本类型自动转换成包装类型（自动装箱）

```java
Character ch = 'x';
```

相对的，包装类型转化为基本类型（自动拆箱）：

```java
char c = ch;
```

### [测试对象等价](https://lingcoder.github.io/OnJava8/#/book/04-Operators?id=测试对象等价)

关系运算符 `==` 和 `!=` 同样适用于所有对象之间的比较运算

```java
public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = 47;
        Integer n2 = 47;
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
    }
}
```

输出结果：

```
true
false
```

表达式 `System.out.println(n1 == n2)` 将会输出比较的结果。因为两个 **Integer** 对象相同，所以先输出 **true**，再输出 **false**。但是，尽管对象的内容一样，对象的引用却不一样。`==` 和 `!=` 比较的是对象引用，所以输出实际上应该是先输出 **false**，再输出 **true**（译者注：如果你把 47 改成 128，那么打印的结果就是这样，因为 Integer 内部维护着一个 IntegerCache 的缓存，默认缓存范围是 [-128, 127]，所以 [-128, 127] 之间的值用 `==` 和 `!=` 比较也能能到正确的结果，但是不推荐用关系运算符比较，具体见 JDK 中的 Integer 类源码）

### 一、Object类中的equals()方法

这是Object类中的equals()方法的声明

```
    public boolean equals(Object obj) {
        return (this == obj);
    }
```

可以看到，Object中的equals方法是直接比较对象的地址。由于Object类是所有类的基类，我们在创建一个新类时，如果调用其equals方法，则默认比较的也是对象的地址。

JDK中一些常见的类都已经为我们重写了equals方法，所以我们可以直接使用equals进行内容比较。**如果是我们自定义的类，则就需要我们自己去重写equals方法了**.

```java
@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car c = (Car) obj;
			return batch == c.batch;
		}
		return false;
	}
```

使用instanceof来判断引用obj所指向的对象的类型，如果obj是Car类对象，就可以将其强制转为Car对象，然后比较两辆Car的批次，相等返回true，否则返回false。当然如果obj不是 Car对象，自然也得返回false
————————————————
版权声明：本文为CSDN博主「zejian_」的原创文章，
原文链接：https://blog.csdn.net/javazejian/article/details/51348320

### String 覆盖equals方法

```java
//from String.java;
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

```
equals()方法实现了等价关系，即：

自反性：对于任何非空引用x，x.equals(x)应该返回true；
对称性：对于任何引用x和y，如果x.equals(y)返回true，那么y.equals(x)也应该返回true；
传递性：对于任何引用x、y和z，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也应该返回true；
一致性：如果x和y引用的对象没有发生变化，那么反复调用x.equals(y)应该返回同样的结果；
非空性：对于任意非空引用x，x.equals(null)应该返回false；
```

## 二、hashCode()方法

### 1.hashcode()方法概述

hashCode()方法用于返回调用该方法的对象的散列码值。hashCode能唯一确定一个对象，不同的对象具有不同的hashCode

**一个类如果重写了equals方法，通常也必须重写hashCode()方法，目的是为了维护hashCode()方法的常规约定，该约定声明相等的对象必须具有相等的散列码。**

**1.一个对象的hashcode可以改变么？**

应该说，当一个可变对象的内部状态改变时，其哈希码通常也会改变。但是，当该对象配合HashMap等使用时，我们必须确保该对象不会发生变化，以防其哈希代码发生改变。比如，使用HashMap时，我们经常将String型对象作为key，String就是不可变类型。

**2.Java中两个对象的 hashCode相同，则 equals比较也一定为 true，对吗?**

两个对象equals相等，则它们的hashcode必须相等，反之则不一定。
两个对象==相等，则其hashcode一定相等，反之不一定成立。





### [高精度数值][]

在 Java 中有两种类型的数据可用于高精度的计算。它们是 `BigInteger` 和 `BigDecimal`。尽管它们大致可以划归为“包装类型”，但是它们并没有对应的基本类型。BigInteger 支持任意精度的整数。可用于精确表示任意大小的整数值，同时在运算过程中不会丢失精度。 BigDecimal 支持任意精度的定点数字。例如，可用它进行精确的货币计算。

### [作用域](https://lingcoder.github.io/OnJava8/#/book/03-Objects-Everywhere?id=作用域)

大多数程序语言都有作用域的概念。作用域决定了在该范围内定义的变量名的可见性和生存周期。在 C、 C++ 和 Java 中，作用域是由大括号 `{}` 的位置决定的。

### [对象作用域](https://lingcoder.github.io/OnJava8/#/book/03-Objects-Everywhere?id=对象作用域)

Java 对象与基本类型具有不同的生命周期。当我们使用 `new` 关键字来创建 Java 对象时，它的生命周期将会超出作用域。因此，下面这段代码示例：

```java
{
    String s = new String("a string");
} 
// 作用域终点s
```

上例中，引用 s 在作用域终点就结束了。但是，引用 s 指向的字符串对象依然还在占用内存。在这段代码中，我们无法在这个作用域之后访问这个对象，因为唯一对它的引用 s 已超出了作用域的范围。在后面的章节中，我们还会学习怎么在编程中传递和复制对象的引用。

方法名和参数列表统称为**方法签名**（signature of the method）。签名作为方法的唯一标识。

如果你想在代码中使用一些额外的类库，那么就必须在程序文件的开始处使用 **import** 关键字来导入它们。之所以说是额外的，因为有一些类库已经默认自动导入到每个文件里了。例如：`java.lang` 包。



## [Java没有sizeof](https://lingcoder.github.io/OnJava8/#/book/04-Operators?id=java没有sizeof)

在 C/C++ 中，经常需要用到 `sizeof()` 方法来获取数据项被分配的字节大小。C/C++ 中使用 `sizeof()` 最有说服力的原因是为了移植性，不同数据在不同机器上可能有不同的大小，所以在进行大小敏感的运算时，程序员必须对这些类型有多大做到心中有数。例如，一台计算机可用 32 位来保存整数，而另一台只用 16 位保存。显然，在第一台机器中，程序可保存更大的值。所以，移植是令 C/C++ 程序员颇为头痛的一个问题。

Java 不需要 ` sizeof()` 方法来满足这种需求，因为所有类型的大小在不同平台上是相同的。我们不必考虑这个层次的移植问题 —— Java 本身就是一种“与平台无关”的语言。

```java
// operators/Overflow.java
// 厉害了！数据溢出了！
public class Overflow {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }
}
```

输出结果：

```text
big = 2147483647
bigger = -4!
```

编译器没有报错或警告，运行时一切看起来都无异常。诚然，Java 是优秀的，但是还不足够优秀。

4)匿名内部类(掌握)
匿名内部类就是没有类名的内部类
匿名内部类的定义与匿名内部类对象的创建必须在一起, 匿名内部类只使用一次



## [this关键字](https://lingcoder.github.io/OnJava8/#/book/06-Housekeeping?id=this关键字)

对于两个相同类型的对象 **a** 和 **b**，你可能在想如何调用这两个对象的 `peel()` 方法：

```java
// housekeeping/BananaPeel.java

class Banana {
    void peel(int i) {
        /*...*/
    }
}
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(), b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}
```

如果只有一个方法 `peel()` ，那么怎么知道调用的是对象 **a** 的 `peel()`方法还是对象 **b** 的 `peel()` 方法呢？编译器做了一些底层工作，所以你可以像这样编写代码。`peel()` 方法中第一个参数隐密地传入了一个指向操作对象的

引用。因此，上述例子中的方法调用像下面这样：

```java
Banana.peel(a, 1)
Banana.peel(b, 2)
```

这是在内部实现的，你不可以直接这么编写代码，编译器不会接受，但能说明到底发生了什么。假设现在在方法内部，你想获得对当前对象的引用。但是，对象引用是被秘密地传达给编译器——并不在参数列表中。方便的是，有一个关键字: **this** 。

### [static 的含义](https://lingcoder.github.io/OnJava8/#/book/06-Housekeeping?id=static-的含义)

记住了 **this** 关键字的内容，你会对 **static** 修饰的方法有更加深入的理解：**static** 方法中不会存在 **this**。你不能在静态方法中调用非静态方法（反之可以）。**静态方法是为类而创建的，不需要任何对象**。事实上，这就是静态方法的主要目的，静态方法看起来就像全局方法一样，但是 Java 中不允许全局方法，一个类中的静态方法可以访问其他静态方法和静态属性。一些人认为静态方法不是面向对象的，因为它们的确具有全局方法的语义。使用静态方法，因为不存在 **this**，所以你没有向一个对象发送消息。的确，如果你发现代码中出现了大量的 **static** 方法，就该重新考虑自己的设计了。然而，**static** 的概念很实用，许多时候都要用到它。至于它是否真的"面向对象"，就留给理论家去讨论吧。

### GC

要想理解 Java 中的垃圾回收，先了解其他系统中的垃圾回收机制将会很有帮助。一种简单但速度很慢的垃圾回收机制叫做*引用计数*。每个对象中含有一个引用计数器，每当有引用指向该对象时，引用计数加 1。当引用离开作用域或被置为 **null** 时，引用计数减 1。因此，管理引用计数是一个开销不大但是在程序的整个生命周期频繁发生的负担。垃圾回收器会遍历含有全部对象的列表，当发现某个对象的引用计数为 0 时，就释放其占用的空间（但是，引用计数模式经常会在计数为 0 时立即释放对象）。这个机制存在一个缺点：如果对象之间存在循环引用，那么它们的引用计数都不为 0，就会出现应该被回收但无法被回收的情况。对垃圾回收器而言，定位这样的循环引用所需的工作量极大。引用计数常用来说明垃圾回收的工作方式，但似乎从未被应用于任何一种 Java 虚拟机实现中。

在更快的策略中，垃圾回收器并非基于引用计数。它们依据的是：对于任意"活"的对象，一定能最终追溯到其存活在栈或静态存储区中的引用。这个引用链条可能会穿过数个对象层次，由此，如果从栈或静态存储区出发，遍历所有的引用，你将会发现所有"活"的对象。对于发现的每个引用，必须追踪它所引用的对象，然后是该对象包含的所有引用，如此反复进行，直到访问完"根源于栈或静态存储区的引用"所形成的整个网络。你所访问过的对象一定是"活"的。注意，这解决了对象间循环引用的问题，这些对象不会被发现，因此也就被自动回收了。

在这种方式下，Java 虚拟机采用了一种*自适应*的垃圾回收技术。至于如何处理找到的存活对象，取决于不同的 Java 虚拟机实现。其中有一种做法叫做停止-复制（stop-and-copy）。顾名思义，这需要先暂停程序的运行（不属于后台回收模式），然后将所有存活的对象从当前堆复制到另一个堆，没有复制的就是需要被垃圾回收的。另外，当对象被复制到新堆时，它们是一个挨着一个紧凑排列，然后就可以按照前面描述的那样简单、直接地分配新空间了。

这种模式称为标记-清扫（mark-and-sweep），Sun 公司早期版本的 Java 虚拟机一直使用这种技术。对一般用途而言，"标记-清扫"方式速度相当慢，但是当你知道程序只会产生少量垃圾甚至不产生垃圾时，它的速度就很快了。

"标记-清扫"所依据的思路仍然是从栈和静态存储区出发，遍历所有的引用，找出所有存活的对象。但是，每当找到一个存活对象，就给对象设一个标记，并不回收它。只有当标记过程完成后，清理动作才开始。在清理过程中，没有标记的对象将被释放，不会发生任何复制动作。"标记-清扫"后剩下的堆空间是不连续的，垃圾回收器要是希望得到连续空间的话，就需要重新整理剩下的对象。



### [初始化的顺序](https://lingcoder.github.io/OnJava8/#/book/06-Housekeeping?id=初始化的顺序)

在类中变量定义的顺序决定了它们初始化的顺序。即使变量定义散布在方法定义之间，它们仍会在任何方法（包括构造器）被调用之前得到初始化。

```java
class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1); // Before constructor

    House() {
        // Show that we're in the constructor:
        System.out.println("House()");
        w3 = new Window(33); // Reinitialize w3
    }

    Window w2 = new Window(2); // After constructor

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3); // At end
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f(); // Shows that construction is done
    }
}
```

```java
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
```

### 方法的重写(override/overwrite) 

定义：在子类中可以根据需要对从父类中继承来的方法进行改造，也称 为方法的重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。

 要求： 

1. 子类重写的方法必须和父类被重写的方法具有相同的方法名称、参数列表 

2. 子类重写的方法的返回值类型不能大于父类被重写的方法的返回值类型

3. 子类重写的方法使用的访问权限不能小于父类被重写的方法的访问权限 子类不能重写父类中声明为private权限的方法 

4. 子类方法抛出的异常不能大于父类被重写方法的异常  

   注意： 子类与父类中同名同参数的方法必须同时声明为非static的(即为重写)，或者同时声明为 static的（不是重写）。因为static方法是属于类的，子类无法覆盖父类的方法

   

对于class的权限修饰只可以用public和default(缺省)。

  public类可以在任意地方被访问。

  default类只可以被同一个包内部的类访问。

#### 关键字—super 

在Java类中使用super来调用父类中的指定操作：

 super可用于访问父类中定义的属性

 super可用于调用父类中定义的成员方法

 super可用于在子类构造器中调用父类的构造器

 注意：

 尤其当子父类出现同名成员时，可以用super表明调用的是父类中的成员

 super的追溯不仅限于直接父类

 super和this的用法相像，this代表本类对象的引用，super代表父类的内存 空间的标识

#### 调用父类的构造器 

**子类中所有的构造器默认都会访问父类中空参数的构造器 。**

 当父类中没有空参数的构造器时，子类的构造器必须通过this(参数列表)或者super(参数列表)语句指定调用本类或者父类中相应的构造器。同时，只能”二选一” ，且必须放在构造器的首行 

如果子类构造器中既未显式调用父类或本类的构造器，且父类中又没有无参的构造器，则编译出错。

#### this和super的区别

| 区别点     | this                                                    | super                                     |
| ---------- | ------------------------------------------------------- | ----------------------------------------- |
| 访问属性   | 访问本类中的属性，如果本类没有此属性则从父类中继续查找  | 直接访问父类中的属性                      |
| 调用方法   | 访问本类中的方法，如果本类没 有此方法则从父类中继续查找 | 直接访问父类中的方法                      |
| 调用构造器 | 调用本类构造器，必须放在构造器的首行                    | 调用父类构造器，必须 放在子类构造器的首行 |



#### 多态小结 

多态作用： 

 提高了代码的通用性，常称作接口重用 

 前提： 

 需要存在继承或者实现关系

  有方法的重写

 成员方法： 

 编译时：要查看引用变量所声明的类中是否有所调用的方法。

  运行时：调用实际new的对象所属的类中的重写方法。

 成员变量：

  不具备多态性，只看引用变量所声明的类。

#### instanceof 操作符

 x instanceof A：检验x是否为类A的对象，返回值为boolean型。

### 对象类型转换 (Casting )

基本数据类型的Casting：

 自动类型转换：

小的数据类型可以自动转换成大的数据类型 如long g=20; double d=12.0f 

强制类型转换：可以把大的数据类型强制转换(casting)成小的数据类型 如 float f=(float)12.0; int a=(int)1200L 

#### 对Java对象的强制类型转换称为造型：

 从子类到父类的类型转换可以自动进行 

从父类到子类的类型转换必须通过造型(强制类型转换)实现

 **无继承关系的引用类型间的转换是非法的** 

在造型前可以使用instanceof操作符测试一个对象的类型

##### 子类继承父类

 若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的 同名方法，系统将不可能把父类里的方法转移到子类中。

 对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的 实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量

```java
对象类型转换举例
public class Test {
    public void method(Person e) { // 设Person类中没有getschool() 方法
    // System.out.pritnln(e.getschool()); //非法,编译时错误
        if (e instanceof Student) {
            Student me = (Student) e; // 将e强制转换为Student类型
            System.out.pritnln(me.getschool());
        }
    }
    public static void main(String[] args){
    Test t = new Test();
    Student m = new Student();
    t.method(m);
    }
}
```

```java
Object类是所有Java类的根父类
如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
public class Person {
...
}
等价于：
public class Person extends Object {
...
}
Object类中的主要结构
    public Object() 构造 构造器
    public boolean equals(Object obj) 普通 对象比较  String改写了方法
    public int hashCode() 普通 取得Hash码    
    public String toString() 普通 对象打印时调用   String改写了方法
```

#### 操作符与equals方法

 equals()：所有类都继承了Object，也就获得了equals()方法。还可以重写。
只能比较引用类型，其作用与“==”相同,比较是否指向同一个对象。
格式:obj1.equals(obj2)
特例：当用equals()方法进行比较时，对类**File、String、Date及包装类（Wrapper Class）**来说，是比较类型及内容而不考虑引用的是否是同一个对象；原因：在这些类中**重写了Object**类的equals()方法。
当自定义使用equals()时，可以重写。用于比较两个对象的“内容”是否都相等

#### toString() 方法

 toString()方法在Object类中定义，其返回值是String类型，返回类名和它 的引用地址。 

在进行String与其它类型数据的连接操作时，自动调用toString()方法 Date now=new Date(); System.out.println(“now=”+now); 相当于 System.out.println(“now=”+now.toString()); 

可以根据需要在用户自定义类型中重写toString()方法 如String 类重写了toString()方法，返回字符串的值。 

基本类型数据转换为String类型时，调用了对应包装类的toString()方法 int a=10; System.out.println(“a=”+a);

#### 访问权限修饰符

private 是非常重要的，尤其是在多线程环境中。（在"并发编程"中将看到）。

以下是一个使用 **private** 的例子：

```java
class Sundae {
    private Sundae() {}
    static Sundae makeASundae() {
        return new Sundae();
    }
}

public class IceCream {
    public static void main(String[] args) {
        //x Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
    }
}
```

以上展示了 **private** 的用武之地：控制如何创建对象，防止别人直接访问某个特定的构造器（或全部构造器）。例子中，你无法通过构造器创建一个 **Sundae** 对象，而必须调用 `makeASundae()` 方法创建对象。

