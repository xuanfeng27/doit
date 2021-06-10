# Java String 的内存模型

##### 来源https://isudox.com/2016/06/22/memory-model-of-string-in-java-language/

#####  https://isudox.com/2016/02/17/difference-between-string-stringbuilder-stringbuffer/

#### 内存模型

内存有栈和堆这两个概念：

- 栈 [statck](https://en.wikipedia.org/wiki/Stack-based_memory_allocation): 栈区是内存中遵循先进后出（LIFO）原则的一块存储区域。在现代计算机系统中，每个线程在内存中都保有自己的一段栈空间。栈区存储基本类型，int, short, long, byte, float, double, boolean, char（注意，不包括 String，String 不是基本类型），以及对象的引用，比如 `int a = 1;` a 和 1 都存储在栈区，`Date date = new Date();` date 存储在栈区， new Date() 的对象则存储在堆区。线程中方法的调用也记录在栈区中，使得方法的结果能返回到正确的位置。栈区内存由系统自动分配并释放；
- 堆 [heap](https://en.wikipedia.org/wiki/Memory_management#HEAP): 堆区存放由用户通过 new 操作创建的对象。系统不会自动释放堆区内存，比如 C++ 中执行 `new` 分配内存，执行 `delete` 释放被占用的内存。Java 因为 GC 机制，由 JVM 承担了手动释放内存的操作。

```
String s1 = "hello,world!"; // 通过字面值

String s2 = new String("hello,world!"); // 通过 new 关键字
```

栈因为严格遵循 LIFO， 其存取速度明显快于堆区。但栈区的数据和生命周期是在编译时就确定的，而堆区则可以在运行时动态分配内存空间。

```
int foo()
{
    char *pBuffer; // 没有分配空间，除了指针本身，它被分配在了栈区
    bool b = true; // 分配在栈区
    if(b)
    {
        // 在栈区分配 500 byte 空间
        char buffer[500];
        // 在堆区分配 500 byte 空间
        pBuffer = new char[500];
    } // buffer 的内存被释放, pBuffer 的还存在
} // 如果没有执行 delete[] pBuffer，就会发生内存泄漏;
```

通过字面值和 `new` 关键字创建字符串对象引用 s1、s2 和字符串 “hello,world!” 分别都存储在内存什么地方，一个个分析。 字符串 “hello,world!” 在堆区申请空间存储，因为字符串是常量具有不可变性，它被存储在堆区的一块名叫 “String Constant Pool” 的字符串常量池中，字符串常量池中的字符串只存在一份，即如果常量池中已存在 “hello,world!"，那么 s1 不会在常量池中申请新的空间，而是直接把引用指向已存在的字符串内存地址。另外，s1 是字符串 “hello,world!” 的引用，存储在栈区。前面讲到，由关键字 `new` 创建的对象被分配在了堆区，但和字面值赋值不同的是，`new` 出来的对象不只是在分配在堆区的字符串常量池，在 `new` 一个新的 String 对象时，首先会在堆区创建该 String 对象，并让栈区的对象引用指向它，然后在常量池中查询是否已存在相同内容的字符串，如果有，就将堆区的空间和常量池中的空间通过 `String.inter()` 关联起来，如果没有，则在常量池中申请空间存放该字符串对象，再做关联。

```
public class TestString {
    public static void main(String[] args) {
        // 由字面值创建字符串
        String s1 = "hello,world!";
        String s2 = "hello,world!";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        // 由 new 关键字创建字符串
        String s3 = new String("hello,world!");
        String s4 = new String("hello,world!");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

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
```

#### String

先看 JDK 里的源码：

```java
package java.lang;

public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];

    /** Cache the hash code for the string */
    private int hash; // Default to 0
```

String 具有 immutable 特性，即不可变，一旦创建后就无法再被更改。String 变量被存储在内存的常量字符串池中。因为不可变对象都是线程安全的，所以 String 也是线程安全的。对 String 变量进行拼接、截取等操作后，原有的字符串对象保持不变，操作后得到的结果返回给新的 String 对象。值相同的 String 对象共享同一段内存池区域，即引用同一块内存地址。

`==` 比较了对象所引用的内存地址，地址相同则返回 true；`Objects.equals()` 方法则只是比较了对象的值。

#### StringBuilder 和 StringBuffer

StringBuilder 和 StringBuffer 比较类似，就放在一起比较。二者都是继承了类 AbstractStringBuilder，和 String 不同，它们都是 mutable 的，随时可以改变值。StringBuffer 拥有和 StringBuilder 部分相同的方法，下面截取了 JDK 的源码：

```java
 public final class StringBuffer extends AbstractStringBuilder
        implements java.io.Serializable, CharSequence {
    public synchronized StringBuffer insert(int offset, char c) {
        super.insert(offset, c);
        return this;
    }
}
public final class StringBuilder extends AbstractStringBuilder
        implements java.io.Serializable, CharSequence {
    public StringBuilder insert(int offset, char c) {
        super.insert(offset, c);
        return this;
    }
```

可以看到在 StringBuffer 的方法里加入了关键字 synchronized 修饰，表明 StringBuffer 是线程安全的，相反的，StringBuilder 就是非线程安全。也正因此，StringBuffer 的处理效率不如 StringBuilder。到这，就算是理解了为什么 IDEA 会给出建议性的提示，把 StringBuffer 变量声明为 StringBuilder 变量。

#### 结论

把上面的异同汇总在下面的表格里

|          |     String     | StringBuilder | StringBuffer |
| :------: | :------------: | :-----------: | :----------: |
|  内存区  | 常量 String 池 |      堆       |      堆      |
| 线程安全 |       是       |      否       |      是      |
|  可变性  |       否       |      是       |      是      |
|   性能   |       快       |      快       |      慢      |

参考的应用场景

- String: 如果不需要改变字符串的值，考虑使用 String 变量；
- StringBuilder: 如果需要改变字符串的值，且只会被一个线程访问，可以使用 StringBuilder 变量；
- StringBuffer: 如果需要改变字符串的值，且可能被多个线程访问，使用 StringBuffer 变量以保证线程安全；