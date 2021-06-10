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

