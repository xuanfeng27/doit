# day20 字节流、字符流、属性集

## 今日内容

- 字节流
- 字符流
- 属性集

## 第一章 IO流

### 1.1 什么是IO

生活中，你肯定经历过这样的场景。当你编辑一个文本文件，忘记了`ctrl+s` ，可能文件就白白编辑了。当你电脑上插入一个U盘，可以把一个视频，拷贝到你的电脑硬盘里。那么数据都是在哪些设备上的呢？键盘、内存、硬盘、外接设备等等。

我们把这种数据的传输，可以看做是一种数据的流动，按照流动的方向，以内存为基准，分为`输入input` 和`输出output` ，即流向内存是输入流，流出内存的输出流。

Java中I/O操作主要是指使用`java.io`包下的内容，进行输入、输出操作。**输入**也叫做**读取**数据，**输出**也叫做作**写出**数据。

### 1.2 IO的分类

根据数据的流向分为：**输入流**和**输出流**。

- **输入流** ：把数据从`其他设备`上读取到`内存`中的流。 
- **输出流** ：把数据从`内存` 中写出到`其他设备`上的流。

根据数据的类型分为：**字节流**和**字符流**。

- **字节流** ：以字节为单位，读写数据的流。
- **字符流** ：以字符为单位，读写数据的流。

### 1.3 IO的流向说明图解

![](img/1_io.jpg)

### 1.4 IO流顶层父类

| 类                    | 含义                              |
| -------------------- | ------------------------------- |
| java.io.OutputStream | 字节输出流顶层父类，抽象类，定义了写出数据方法write()。 |
| java.io.InputStream  | 字节输入流顶层父类，抽象类，定义了读取数据方法read()。  |
| java.io.Writer       | 字符输出流顶层父类，抽象类，定义了写出数据方法write()。 |
| java.io.Reader       | 字符输入流顶层父类，抽象类，定义了读取数据方法read()。  |

## 第二章 字节流

### 2.1 一切都是字节

一切文件数据(文本、图片、视频等)在存储时，都是以二进制数字的形式保存，都一个一个的字节，那么传输时一样如此。所以，字节流可以传输任意文件数据。在操作流的时候，我们要时刻明确，无论使用什么样的流对象，底层传输的始终为二进制数据。

**提示**：8个二进制位为1个字节，0000-0000 是1个字节。

### 2.2 字节输出流OutputStream

`java.io.OutputStream `抽象类是表示字节输出流的所有类的超类，将指定的字节信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `public void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  
- `public void write(byte[] b)`：将 b.length字节从指定的字节数组写入此输出流。  
- `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。  
- `public abstract void write(int b)` ：将指定的字节输出流。

**注意**：close方法，当完成流的操作时，必须调用此方法，释放系统资源。

### 2.3 FileOutputStream类

`OutputStream`有很多子类，我们从最简单的一个子类开始。

`java.io.FileOutputStream `类是文件输出流，用于将数据写出到文件。

**构造方法**

- `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
- `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有这个文件，会清空这个文件的数据。

```java
public class FileOutputStreamConstructor  {
    public static void main(String[] args) throws IOException{
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);
      
        // 使用文件名称创建流对象
        //FileOutputStream fos = new FileOutputStream("b.txt");
    }
}
```

**写出字节数据**

- **写出字节**：`write(int b)` 方法，每次可以写出一个字节数据，代码使用演示：

```java
public static void main(String[] args) throws IOException {
    // 使用文件名称创建流对象
    FileOutputStream fos = new FileOutputStream("fos.txt");     
    // 写出数据
    fos.write(97); // 写出第1个字节
    fos.write(98); // 写出第2个字节
    fos.write(99); // 写出第3个字节
    // 关闭资源
    fos.close();
}
```

**注意**：

1. 虽然参数为int类型四个字节，但是只会保留一个字节的信息写出。
2. 写出的整数被直接写在目的文件中。
3. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。

- **写出字节数组**：`write(byte[] b)`，每次可以写出数组中的数据，代码使用演示：

```java
public static void main(String[] args) throws IOException {
    // 使用文件名称创建流对象
    FileOutputStream fos = new FileOutputStream("fos.txt");     
    // 字符串转换为字节数组
    byte[] b = "abcdef".getBytes();
    // 写出字节数组数据
    fos.write(b);
    // 关闭资源
    fos.close();
}
```

- **写出指定长度字节数组**：`write(byte[] b, int off, int len)` ,每次写出从off索引开始，len表示写出的个字节个数。

```java
public static void main(String[] args) throws IOException {
    // 使用文件名称创建流对象
    FileOutputStream fos = new FileOutputStream("fos.txt");     
    // 字符串转换为字节数组
    byte[] b = "abcde".getBytes();
    // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
    fos.write(b,2,2);
    // 关闭资源
    fos.close();
}
```

**数据追加续写**

经过以上的演示，每次程序运行，创建输出流对象，都会清空目标文件中的数据。如何保留目标文件中数据，还能继续添加新数据呢？

- `public FileOutputStream(File file, boolean append)`： 创建文件输出流以写入由指定的 File对象表示的文件。  
- `public FileOutputStream(String name, boolean append)`： 创建文件输出流以指定的名称写入文件。  

这两个构造方法，参数中都需要传入一个boolean类型的值，`true` 表示追加数据，`false` 表示清空原有数据。这样创建的输出流对象，就可以指定是否追加续写了，代码使用演示：

```java
 public static void main(String[] args) throws IOException {
     // 使用文件名称创建流对象
     FileOutputStream fos = new FileOutputStream("fos.txt"，true);     
     // 字符串转换为字节数组
     byte[] b = "abcde".getBytes();
     // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
     fos.write(b); 
     // 关闭资源
     fos.close();
 }
```

### 2.4 IO中write方法的源码解析

- 我调用write方法写出数据的时候，JDK源代码中最终调用的方法是writeBytes()方法。
- `private native void writeBytes(byte b[], int off, int len, boolean append)throws IOException`
  - 方法是本地方法是和操作系统交互的方法。
  - 操作系统本身就具有IO功能，因此JVM是调用操作系统中的功能实现数据的读写！

### 2.5 字节输入流InputStream

`java.io.InputStream `抽象类是表示字节输入流的所有类的超类，可以读取字节信息到内存中。它定义了字节输入流的基本共性功能方法。

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。    
- `public abstract int read()`： 从输入流读取数据的下一个字节。 
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

### 2.6 FileInputStream类

`java.io.FileInputStream `类是文件输入流，从文件中读取字节。

**构造方法**

- `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 
- `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出`FileNotFoundException` 

```java
public class FileInputStreamConstructor {
    public static void main(String[] args) throws IOException{
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileInputStream fos = new FileInputStream(file);
      
        // 使用文件名称创建流对象
        FileInputStream fos = new FileInputStream("b.txt");
    }
}
```

**读取字节数据**

- **读取字节**：`read`方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回`-1`，代码使用演示：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象
    FileInputStream fis = new FileInputStream("read.txt");
    // 读取数据，返回一个字节
    int read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    read = fis.read();
    System.out.println((char) read);
    // 读取到末尾,返回-1
    read = fis.read();
    System.out.println( read);
    // 关闭资源
    fis.close();
}
```

**注意**：如果文件中存在-1，我们在读取文件时也不会直接读取到-1，因为-1是两个字节，即`-`和`1`。每个文件都会被操作系统赋予一个结束的标识，JVM调用操作系统功能实现文件读取的，因此操作系统读取到文件结束标识后，会将表示返回到JVM中，而JVM接收到文件结束标识后，返回read()方法-1。

使用循环改进：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象
    FileInputStream fis = new FileInputStream("read.txt");
    // 定义变量，保存数据
    int b = 0 ;
    // 循环读取
    while ((b = fis.read())!=-1) {
    	System.out.println((char)b);
    }
    // 关闭资源
    fis.close();
}
```

**使用字节数组读取**

`read(byte[] b)`，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回`-1` ，代码使用演示：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象.
    FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
    // 定义变量，作为有效个数
    int len ；
    // 定义字节数组，作为装字节数据的容器   
    byte[] b = new byte[2];
    // 循环读取
    while (( len= fis.read(b))!=-1) {
    // 每次读取后,把数组变成字符串打印
    	System.out.println(new String(b));
    }
    // 关闭资源
    fis.close();
}
```

错误数据`d`，是由于最后一次读取时，只读取一个字节`e`，数组中，上次读取的数据没有被完全替换，所以要通过`len` ，获取有效的字节，代码使用演示：

```java
public static void main(String[] args) throws IOException{
    // 使用文件名称创建流对象.
    FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
    // 定义变量，作为有效个数
    int len ；
    // 定义字节数组，作为装字节数据的容器   
    byte[] b = new byte[2];
    // 循环读取
    while (( len= fis.read(b))!=-1) {
    // 每次读取后,把数组的有效字节部分，变成字符串打印
    	System.out.println(new String(b，0，len));//  len 每次读取的有效字节个数
    }
    // 关闭资源
    fis.close();
}
```

## 第三章 IO流中的异常处理

在字节流的案例中，我们一直使用的是throws抛出异常。如果出现异常的话，程序将不会执行close()方法，因此异常需要使用try catch进行处理。

- try外声明变量，try内建立对象。
  - 目的是提升变量的作用域。
- finally中进行资源释放。
  - 进行流对象非空判断。
  - 如果有多个流对象，单独进行释放

```java
public static void main(String[] args){
	FileOutputStream fos = null;
    try{
    	fos.write(100);
    }catch(IOException ex){
    	ex.PrintStackTrace();
    }finally{
        if(fos!=null)
            try{
                fos.close();
            }catch(IOException ex){
                ex.PrintStackTrace();
            }
    }
}
```

## 第四章 文件复制

使用字节流可以进行任何文件的复制，因为字节流操作的是组成文件的最小单元-字节。

复制原理图解：

![](img/2_copy.jpg)

**案例实现**

```java
 public static void main(String[] args) throws IOException {
     // 1.创建流对象
     // 1.1 指定数据源
     FileInputStream fis = new FileInputStream("D:\\test.jpg");
     // 1.2 指定目的地
     FileOutputStream fos = new FileOutputStream("test_copy.jpg");

     // 2.读写数据
     // 2.1 定义数组
     byte[] b = new byte[1024];
     // 2.2 定义长度
     int len;
     // 2.3 循环读取
     while ((len = fis.read(b))!=-1) {
         // 2.4 写出数据
         fos.write(b, 0 , len);
     }

     // 3.关闭资源
     fos.close();
     fis.close();
}
```

## 第五章 字符流

当使用字节流读取文本文件时，可能会有一个小问题。就是遇到中文字符时，可能不会显示完整的字符，那是因为一个中文字符可能占用多个字节存储。所以Java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件。

### 2.1 字符输入流【Reader】

`java.io.Reader`抽象类是表示用于读取字符流的所有类的超类，可以读取字符信息到内存中。它定义了字符输入流的基本共性功能方法。

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源。    
- `public int read()`： 从输入流读取一个字符。 
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。

### 2.2 FileReader类

`java.io.FileReader `类是读取字符文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

> 小贴士：
>
> 1. 字符编码：字节与字符的对应规则。Windows系统的中文编码默认是GBK编码表。
>
>    idea中UTF-8
>
> 2. 字节缓冲区：一个字节数组，用来临时存储字节数据。

**构造方法**

- `FileReader(File file)`： 创建一个新的 FileReader ，给定要读取的File对象。   
- `FileReader(String fileName)`： 创建一个新的 FileReader ，给定要读取的文件的名称。  

当你创建一个流对象时，必须传入一个文件路径。类似于FileInputStream 。

- 构造举例，代码如下：

```java
public class FileReaderConstructor throws IOException{
    public static void main(String[] args) {
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileReader fr = new FileReader(file);
      
        // 使用文件名称创建流对象
        FileReader fr = new FileReader("b.txt");
    }
}
```

**读取字符数据**

1. **读取字符**：`read`方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回`-1`，循环读取，代码使用演示：

```java
public class FRRead {
    public static void main(String[] args) throws IOException {
      	// 使用文件名称创建流对象
       	FileReader fr = new FileReader("read.txt");
      	// 定义变量，保存数据
        int b ；
        // 循环读取
        while ((b = fr.read())!=-1) {
            System.out.println((char)b);
        }
		// 关闭资源
        fr.close();
    }
}
```

> 小贴士：虽然读取了一个字符，但是会自动提升为int类型。

1. **使用字符数组读取**：`read(char[] cbuf)`，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回`-1` ，代码使用演示：

```java
public class FRRead {
    public static void main(String[] args) throws IOException {
      	// 使用文件名称创建流对象
       	FileReader fr = new FileReader("read.txt");
      	// 定义变量，保存有效字符个数
        int len ；
        // 定义字符数组，作为装字符数据的容器
         char[] cbuf = new char[2];
        // 循环读取
        while ((len = fr.read(cbuf))!=-1) {
            System.out.println(new String(cbuf));
        }
		// 关闭资源
        fr.close();
    }
}
```

获取有效的字符改进，代码使用演示：

```java
public class FISRead {
    public static void main(String[] args) throws IOException {
      	// 使用文件名称创建流对象
       	FileReader fr = new FileReader("read.txt");
      	// 定义变量，保存有效字符个数
        int len ；
        // 定义字符数组，作为装字符数据的容器
        char[] cbuf = new char[2];
        // 循环读取
        while ((len = fr.read(cbuf))!=-1) {
            System.out.println(new String(cbuf,0,len));
        }
    	// 关闭资源
        fr.close();
    }
}
```

### 2.3 字符输出流【Writer】

`java.io.Writer `抽象类是表示用于写出字符流的所有类的超类，将指定的字符信息写出到目的地。它定义了字节输出流的基本共性功能方法。

- `public abstract void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  
- `public abstract void flush() ` ：刷新此输出流并强制任何缓冲的输出字符被写出。  
- `public void write(int c)` ：写出一个字符。
- `public void write(char[] cbuf)`：将 b.length字符从指定的字符数组写出此输出流。  
- `public abstract void write(char[] b, int off, int len)` ：从指定的字符数组写出 len字符，从偏移量 off开始输出到此输出流。  
- `public void write(String str)` ：写出一个字符串。

### 2.4 FileWriter类

`java.io.FileWriter `类是写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。

**构造方法**

- `FileWriter(File file)`： 创建一个新的 FileWriter，给定要读取的File对象。   
- `FileWriter(String fileName)`： 创建一个新的 FileWriter，给定要读取的文件的名称。  

当你创建一个流对象时，必须传入一个文件路径，类似于FileOutputStream。

- 构造举例，代码如下：

```java
public class FileWriterConstructor {
    public static void main(String[] args) throws IOException {
   	 	// 使用File对象创建流对象
        File file = new File("a.txt");
        FileWriter fw = new FileWriter(file);
      
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("b.txt");
    }
}
```

**基本写出数据**

**写出字符**：`write(int b)` 方法，每次可以写出一个字符数据，代码使用演示：

```java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");     
      	// 写出数据
      	fw.write(97); // 写出第1个字符
      	fw.write('b'); // 写出第2个字符
      	fw.write('C'); // 写出第3个字符
      	fw.write(30000); // 写出第4个字符，中文编码表中30000对应一个汉字。
      
      	/*
        【注意】关闭资源时,与FileOutputStream不同。
      	 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
        */
        // fw.close();
    }
}
输出结果：
abC田
```

> 小贴士：
>
> 1. 虽然参数为int类型四个字节，但是只会保留一个字符的信息写出。
> 2. 未调用close方法，数据只是保存到了缓冲区，并未写出到文件中。

**关闭和刷新**

因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。如果我们既想写出数据，又想继续使用流，就需要`flush` 方法了。

- `flush` ：刷新缓冲区，流对象可以继续使用。
- `close` ：关闭流，释放系统资源。关闭前会刷新缓冲区。

代码使用演示：

```java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");
        // 写出数据，通过flush
        fw.write('刷'); // 写出第1个字符
        fw.flush();
        fw.write('新'); // 继续写出第2个字符，写出成功
        fw.flush();
      
      	// 写出数据，通过close
        fw.write('关'); // 写出第1个字符
        fw.close();
        fw.write('闭'); // 继续写出第2个字符,【报错】java.io.IOException: Stream closed
        fw.close();
    }
}
```

> 小贴士：即便是flush方法写出了数据，操作的最后还是要调用close方法，释放系统资源。

**写出其他数据**

1. **写出字符数组** ：`write(char[] cbuf)` 和 `write(char[] cbuf, int off, int len)` ，每次可以写出字符数组中的数据，用法类似FileOutputStream，代码使用演示：

```java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");     
      	// 字符串转换为字节数组
      	char[] chars = "多易程序员".toCharArray();
      
      	// 写出字符数组
      	fw.write(chars); // 多易程序员
        
		// 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(b,2,2); // 程序
      
      	// 关闭资源
        fos.close();
    }
}
```

1. **写出字符串**：`write(String str)` 和 `write(String str, int off, int len)` ，每次可以写出字符串中的数据，更为方便，代码使用演示：

```java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("fw.txt");     
      	// 字符串
      	String msg = "多易程序员";
      
      	// 写出字符数组
      	fw.write(msg); //多易程序员
      
		// 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(msg,2,2);	// 程序
      	
        // 关闭资源
        fos.close();
    }
}
```

1. **续写和换行**：操作类似于FileOutputStream。

```java
public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象，可以续写数据
        FileWriter fw = new FileWriter("fw.txt"，true);     
      	// 写出字符串
        fw.write("多易");
      	// 写出换行
      	fw.write("\r\n");
      	// 写出字符串
  		fw.write("程序员");
      	// 关闭资源
        fw.close();
    }
}
输出结果:
多易
程序员
```

> 小贴士：字符流，只能操作文本文件，不能操作图片，视频等非文本文件。
>
> 当我们单纯读或者写文本文件时  使用字符流 其他情况使用字节流

## 第六章 属性集

### 6.1 概述

`java.util.Properties ` 继承于` Hashtable` ，来表示一个持久的属性集。它使用键值结构存储数据，每个键及其对应值都是一个字符串。该类也被许多Java类使用，比如获取系统属性时，`System.getProperties` 方法就是返回一个`Properties`对象。

### 6.2 Properties类

**构造方法**

- `public Properties()` :创建一个空的属性列表。

**基本的存储方法**

- `public Object setProperty(String key, String value)` ： 保存一对属性。  
- `public String getProperty(String key) ` ：使用此属性列表中指定的键搜索属性值。
- `public Set<String> stringPropertyNames() ` ：所有键的名称的集合。

```java
public class ProDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 创建属性集对象
        Properties properties = new Properties();
        // 添加键值对元素
        properties.setProperty("filename", "a.txt");
        properties.setProperty("length", "209385038");
        properties.setProperty("location", "D:\\a.txt");
        // 打印属性集对象
        System.out.println(properties);
        // 通过键,获取属性值
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        // 遍历属性集,获取所有键的集合
        Set<String> strings = properties.stringPropertyNames();
        // 打印键值对
        for (String key : strings ) {
          	System.out.println(key+" -- "+properties.getProperty(key));
        }
    }
}
输出结果：
{filename=a.txt, length=209385038, location=D:\a.txt}
a.txt
209385038
D:\a.txt
filename -- a.txt
length -- 209385038
location -- D:\a.txt
```

**与流相关的方法**

- `public void load(InputStream inStream)`： 从字节输入流中读取键值对。 

参数中使用了字节输入流，通过流对象，可以关联到某文件上，这样就能够加载文本中的数据了。文本数据格式:

```
filename=a.txt
length=209385038
location=D:\a.txt
```

加载代码演示：

```java
public class ProDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        // 创建属性集对象
        Properties pro = new Properties();
        // 加载文本中信息到属性集
        pro.load(new FileInputStream("read.txt"));
        // 遍历集合并打印
        Set<String> strings = pro.stringPropertyNames();
        for (String key : strings ) {
          	System.out.println(key+" -- "+pro.getProperty(key));
        }
     }
}
输出结果：
filename -- a.txt
length -- 209385038
location -- D:\a.txt
```

> 小贴士：文本中的数据，必须是键值对形式，可以使用空格、等号、冒号等符号分隔。