# ArrayList 集合全面解析

## 第一章 ArrayList集合底层数据结构

### 1.1 ArrayList 集合介绍

- List接口的可调整大小的数组实现
- 数组:一旦初始化长度就不可以发生改变

### 1.2 数组结构介绍

- 增删慢：每次删除元素，都需要更改数组长度、拷贝以及移动元素位置。
- 查询快：由于数组在内存中是一块连续空间，因此可以根据地址+索引的方式快速获取对应位置上的元素。

## 第三章  ArrayList源码分析

### 3.1 构造方法

|           **Constructor**            |             Constructor描述             |
| :----------------------------------: | :-----------------------------------: |
|             ArrayList()              |            构造一个初始容量为十的空列表             |
|    ArrayList(int initialCapacity)    |            构造具有指定初始容量的空列表             |
| ArrayList(Collection<? extends E> c) | 构造一个包含指定集合的元素的列表，按照它们由集合的迭代器返回的   顺序" |

### 3.2 案例演示

**案例一:空参构造ArrayList()**

```java
public class Test01 {
	public static void main(String[] args) {
		//这行代码做了什么?
		//真的构造一个初始容量为十的空列表?
		ArrayList<String> list = new ArrayList<String>();
	}
}
```

源码分析:

```java
public class ArrayList<E> {
    /**
    * 默认初始容量
    */
    private static final int DEFAULT_CAPACITY = 10;
    /**
    * 空数组
    */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
    * 默认容量的空数组
    */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
    * 集合真正存储数组元素的数组
    */
    transient Object[] elementData;
    /**
    * 集合的大小
    */
    private int size;

    public ArrayList() {
   		 this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
}
```

**结论:**通过空参构造方法创建集合对象并未构造一个初始容量为十的空数组,而是将DEFAULTCAPACITY_EMPTY_ELEMENTDATA地址赋值给elementData

**案例二:指定容量的构造ArrayList(int initialCapacity)**

```java
public class Test01 {
    public static void main(String[] args) {
    	//这行代码ArrayList底层做了什么?
    	ArrayList<String> list = new ArrayList<String>(5);
    }
}
```

源码分析:

```java
public class ArrayList<E> {
    //initialCapacity = 5
    public ArrayList(int initialCapacity) { 
    	//判断初始容量initialCapacity是否大于0 
      	if (initialCapacity > 0) {
    		//创建一个数组,且指定长度为initialCapacity
    		this.elementData = new Object[initialCapacity];
    	} else if (initialCapacity == 0) {
            //如果initialCapacity容量为0，把EMPTY_ELEMENTDATA的地址赋值给elementData
   	 		this.elementData = EMPTY_ELEMENTDATA;
    	} else {
    		//以上两个条件都不满足报错
    		throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
    	}
	}
}
```

**结论:**根据ArrayList构造方法参数创建了一个指定容量的数组.

**案例三:带参构造集合ArrayList(Collection<? extends E> c)**

```java
public class Test03 {
    public static void main(String[] args) {
        //ArrayList(Collection <? extends E> c) 构造一个包含指定集合的元素的列表，按照它们由集合的迭		 代器返回的顺序。
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //这行代码做了什么?
        ArrayList<String> list1 = new ArrayList<>(list);

        for (String s : list1) {
            System.out.println(s);
        }
    }
}
```

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    public ArrayList(Collection<? extends E> c) {
        //将构造方法中的参数转成数组
        elementData = c.toArray();

        if ((size = elementData.length) != 0) {
            // 再次进行判断
            if (elementData.getClass() != Object[].class)
                // 数组的创建和拷贝
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // 就把空数组的地址赋值给集合存元素的数组
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    //将集合转数组的方法
    public Object[] toArray() {
        //调用数组工具类的方法
        return Arrays.copyOf(elementData, size);
    }
}

public class Arrays {
    public static <T> T[] copyOf(T[] original, int newLength) {
        //再次调用方法得到一个数组
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        //不管三元运算符的结果如何,都会创建一个新的数组
        //新数组的长度一定是和集合的size一样
        T[] copy = ((Object)newType == (Object)Object[].class)
            ? (T[]) new Object[newLength]
            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        //数组的拷贝
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        //返回新数组
        return copy;
    }
}
```

### **3.3 添加方法**

|                   方法名                    |                  **描述**                  |
| :--------------------------------------: | :--------------------------------------: |
|         public boolean add(E e)          |             将指定的元素追加到此列表的末尾。             |
|  public void add(int index, E element)   |            在此列表中的指定位置插入指定的元素             |
| public boolean addAll(Collection<? extends E> c) | 按指定集合的Iterator返回的顺序将指定集合中的所有元素追加到此列表的末尾。 |
| public boolean addAll(int index, Collection<? extends E> c) |       将指定集合中的所有元素插入到此列表中，从指定的位置开始。       |

-  **public boolean add(E e)  将指定的元素追加到此列表的末尾。**

```java
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("多易教育");

    }
}
```

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};
    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    //集合存元素的数组
    Object[] elementData;
    //集合的长度
    private int size;
    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;
	//追加元素
    public boolean add(E e) {  e= abc
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) { =10
        //如果elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA说明是第一次添加元素
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //第一次添加元素用默认的容量10 与 传入的最小容量1做比较 获取最大值
           //给minCapacity赋值 第一次 minCapacity为10
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
		
        ensureExplicitCapacity(minCapacity);//10
    }
    
    private void ensureExplicitCapacity(int minCapacity) {=10
      
           //该值一开始为0 当对集合进行修改时+1
            modCount++;
		//当传入的数值 大于 实际存储元素数组的长度时调用扩容方法
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    //扩容方法
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;//0
        // >> : 右移,右移几位就相当于除以2的几次幂
        // << : 左移,左移几位就相当于乘以2的几次幂
        //扩容的核心算法: 原容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);//0
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
 }
```

- **public void add(int index, E element) 在此列表中的指定位置插入指定的元素**

```java
public class Test02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("多");
        list.add("教");
        list.add("育");
        list.add(1, "易");
        System.out.println(list);
    }
}
```

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    public void add(int index, E element) {
            rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);
        elementData[index] = element;
        size++;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

     private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        //只有容量不够的情况下才会调用 核心扩容的grow方法
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
     }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

 }
```

-  **public boolean addAll(Collection<? extends E> c)   按指定集合的Iterator返回的顺序将指定集合中的所有元素追加到此列表的末尾。**

```java
public class Test03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("多");
        list.add("易");
        System.out.println(list);

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("教");
        list1.add("育");

        //将list1集合的所有元素一次性添加到集合list
        list.addAll(list1);

        System.out.println(list);
    }
}
```

效果:

![05_add](img\05_add.png)

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    public boolean addAll(Collection<? extends E> c) {
        //把有数据的集合转成数组
        Object[] a = c.toArray();
        //有数据集合长度赋值给numNew
        int numNew = a.length;
        //校验以及扩容
        ensureCapacityInternal(size + numNew);  // Increments modCount
        //真正拷贝的代码
        System.arraycopy(a, 0, elementData, size, numNew);
        //集合的长度进行更改
        size += numNew;
        //根据numNew的值返回是否添加成功
        return numNew != 0;
    }

 }
```

-  **public boolean addAll(int index, Collection<? extends E> c) 将指定集合中的所有元素插入到此列表中，从指定的位置开始。**

```java
public class Test04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("多");
        list.add("育");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("易");
        list1.add("教");

        //将list1中的数据添加到list集合指定所以为1的位置
        list.addAll(1,list1);

        System.out.println(list);
    }
}
```

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

     public boolean addAll(int index, Collection<? extends E> c) {
        //校验索引
        rangeCheckForAdd(index);
        //将数据源转成数组
        Object[] a = c.toArray();
        //记录数据源的长度 2
        int numNew = a.length;
        //目的就是为了给集合存储数据的数组进行扩容
        ensureCapacityInternal(size + numNew);

        //numMoved:代表要移动元素的个数 --> 1个
        //numMoved: 数据目的(集合list1)的长度-调用addAll的第一个参数 (索引1)
        int numMoved = size - index;
        //判断需要移动的个数是否大于0
        if (numMoved > 0)
            //使用System中的方法arraycopy进行移动
            System.arraycopy(elementData, index, elementData, index + numNew,
                             numMoved);
        //才是真正将数据源(list)中的所有数据添加到数据目的(lsit1)
        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
 }

public final class System {
	/*
    	参数
            src - 源数组。
            srcPos - 源数组中的起始位置。
            dest - 目标数组。
            destPos - 目的地数据中的起始位置。
            length - 要复制的数组元素的数量。
	*/
    public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
}
```

- 如何计算元素移动的位置&数量

```java
public class ArrayCopyMethodTest {
    public static void main(String[] args) {
        //数据源: list
        String[] src = {"易","教"};
        //数据目的: list1
        String[] dest = {"多","育",null,null,null,null,null,null,null,null};
        /*
        int numNew = a.length;
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                             numMoved);
         */
        //获取数据源的长度 2
        int numNew = src.length;
        //numMoved = 集合真实长度 - 要存的索引位置
        //要移动元素的个数为:1
        int numMoved = 2 - 1;
        //判断是否需要移动元素
        if (numMoved > 0)
            //src - 源数组。
            //srcPos - 源数组中的起始位置。
            //dest - 目标数组。
            //destPos - 目的地数据中的起始位置。
            //length - 要复制的数组元素的数量
            //先通过数组复制 将数组中的元素 移动的到指定位置
            System.arraycopy(dest, 1, dest, 1+2,
                    numMoved);

        System.out.println(Arrays.toString(dest));
        //在将数据源数组的元素 复制到数据目的的数值中
        System.arraycopy(src,0,dest,1,2);
        System.out.println(Arrays.toString(dest));
    }
}

```

效果如下:

![06_位置](img\06_位置.png)

### 3.4 删除方法

- **public E remove(int index) 根据索引删除**

```java
public class Test01 {
    public static void main(String[] args) { ArrayList<String> list = new ArrayList<>();
        list.add("多");
        list.add("易");
        list.add("教");
        list.add("育");

        //根据索引删除元素
        String value = list.remove(3);
        System.out.println("删除的元素为: "+value);
        System.out.println("集合的元素: "+list);

    }
}
```

效果如下:

​	![07_删除](img\07_删除.png)

源码分析:

```java
public E remove(int index) {
  		//范围校验
        rangeCheck(index);
        //实际修改数++
        modCount++;
  	   //获取到原来的元素
        E oldValue = elementData(index);
		//计算移动元素的个数 4-1-1
        int numMoved = size - index - 1;
        //如果需要移动元素个数大于0,就使用arrayCopy方法进行拷贝
		//注意:数据源和数据目的就是elementData
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        ////将源集合最后一个元素置为null,尽早让垃圾回收机制对其进行回收
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
```

- **public boolean  remove(Object obj) 根据索引删除**

```java
public class Test01 {
    public static void main(String[] args) { ArrayList<String> list = new ArrayList<>();
        list.add("多");
        list.add("易");
        list.add("教");
        list.add("育");

        //根据索引删除元素
        boolean b = list.remove("育");
        System.out.println("删除是否成功:"+b);
        System.out.println("集合的元素: "+list);

    }
}
```

效果如下:

![08_删除2](img\08_删除2.png)

源码分析:

```java
public boolean remove(Object o) {
  		//判断要删除的元素是否为null
        if (o == null) {
          	//遍历集合
            for (int index = 0; index < size; index++)
                //判断集合的元素是否为null
                if (elementData[index] == null) {
                  	//如果相等,调用fastRemove方法快速删除
                    fastRemove(index);
                    return true;
                }
        } else {
            ////遍历集合
            for (int index = 0; index < size; index++)
              	//用o对象的equals方法和集合每一个元素进行比较
                if (o.equals(elementData[index])) {
                  	////如果相等,调用fastRemove方法快速删除
                    fastRemove(index);
                    return true;
                }
        }
  		//如果集合没有该元素,那么就会返回false 
        return false;
    }
     private void fastRemove(int index) {
        //实际修改次数+1
        modCount++;
        //计算移动元素的个数
        int numMoved = size - index - 1;
       	//如果需要移动的个数大于0,调用arrayCopy方法进行拷贝
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        //将集合最后一个元素置为null,尽早被释放
        elementData[--size] = null; // clear to let GC do its work
    }

```

### **3.5 修改方法**

- **public E set(int index, E element) 修改指定索引处的元素**

```java
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("曹操");
        list.add("刘备");
        list.add("孙权");
        list.add("诸葛亮");

        //根据索引修改集合元素
        String value = list.set(3, "赵云");
        System.out.println("set方法返回值: "+value);
        System.out.println("集合的元素: "+list);
    }
}
```

效果如下:

![09_修改](img\09_修改.png)

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    public E set(int index, E element) {
        //校验索引
        rangeCheck(index);
        //根据索引取出元素 --> 被替换的元素
        E oldValue = elementData(index);
        //把element存入到elementData数组中
        elementData[index] = element;
        //返回被替换的元素
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
 }
```

### 3.6 获取方法

- **public  E  get(int  index) 获取指定索引的元素**

```java
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("曹操");
        list.add("刘备");
        list.add("孙权");
        list.add("诸葛亮");

        //根据索引获取集合元素
        String value = list.get(1);
        System.out.println("get方法返回值: "+value);
        System.out.println("集合的元素: "+list);
    }
}
```

效果如下:

![10_获取](img\10_获取.png)

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;


    public E get(int index) {
        //校验索引
        rangeCheck(index);
        //根据索引获取数组(集合)中的元素
        return elementData(index);
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
 }
```

### 3.7 toString方法

- **public  String toString()  把集合中的数据转换为字符串**

```java
public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("多");
        list.add("易");
        list.add("教");
        list.add("育");

        //将集合的元素转换为字符串
        String str = list.toString();
        System.out.println(str);

        //System.out.println("集合的元素: "+list);
    }
}
```

源码分析:

```java
 //ArrayList集合的爷爷类
 public abstract class AbstractCollection<E> {

    public String toString() {
        //获取迭代器
        Iterator<E> it = iterator();
        //判断迭代器是否有元素
        if (! it.hasNext())
            return "[]";
        //创建StringBuilder
        StringBuilder sb = new StringBuilder();
        //先追加了'['
        sb.append('[');
        //无限循环
        for (;;) {
            //调用迭代器的next方法取出元素,且将光标向下移动
            E e = it.next();
            //三元判断
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                //没有元素,在缓冲区的最后追加']',且把整个缓冲区的数据转成字符串
                //然后再介绍该方法
                return sb.append(']').toString();

            //有元素,就直接追加
            sb.append(',').append(' ');
        }
    }
 }
public class ArrayList<E> {
  	 //获取迭代器的方法
    public Iterator<E> iterator() {
        //创建了一个对象
        return new Itr();
    }
  	 
    //ArrayList集合的内部类 --> 迭代器的源码
    private class Itr implements Iterator<E> {
        int cursor;       // 光标,默认值就是0
        int lastRet = -1; // 记录-1
        // 将集合实际修改次数赋值给预期修改次数
        // 获取迭代器的时候,那么expectedModCount的值也就是 3
        int expectedModCount = modCount;

        //判断集合是否有元素
        public boolean hasNext() {
            //光标是否不等于集合的size 3
            return cursor != size;
        }

        public E next() {
            checkForComodification();
            //光标赋值给i = 0
            int i = cursor;
            //判断,如果大于集合的size就说明没有元素了
            if (i >= size)
                throw new NoSuchElementException();
            //把集合存储数据数组的地址赋值给该方法的局部变量
            Object[] elementData = ArrayList.this.elementData;
            //进行判断,如果条件满足就会产生并发修改异常
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            //光标自增
            cursor = i + 1;
            //从数组中取出元素且返回
            return (E) elementData[lastRet = i];
        }

        //校验预期修改集合次数是否和实际修改集合次数一样
        final void checkForComodification() {
            if (modCount != expectedModCount)
                //如果不一样,就会产生并发修改异常
                throw new ConcurrentModificationException();
        }
    } 
}
```

### 3.8 迭代器

-  **public Iterator<E> iterator() 普通迭代器**

源码同上(在讲toString方法的时候已经讲过基本操作,通过以下两个案例进行一步分析源码)

**案例一: 已知集合：List list= new ArrayList();里面有三个元素："hello"、"Java"、"PHP"，使用迭代器遍历获取集合的每一个元素.**

```java
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("Java");
        list.add("PHP");
        //获取迭代器
        Iterator<String> it = list.iterator();
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
    }
}
```

**案例二: 已知集合：List list= new ArrayList();里面有三个元素："hello"、"Java"、"PHP"，使用迭代器遍历集合看有没有"PHP"这个元素，如果有，就使用集合对象删除该元素**

```java
public class Test02 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("Java");
        list.add("PHP");
        //获取迭代器
        Iterator<String> it = list.iterator();
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            if(s.equals("PHP")) {
                list.remove("PHP");
            }
        }
    }
}
```

**控制台结果:并发修改异常**

![11_并发](img\11_并发.png)

源码分析:(应该从获取迭代器的时候就进入到源代码中):

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    //查看add方法其目的就是为了找到记录集合实际修改次数的变量
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    //获取迭代器的方法
    public Iterator<E> iterator() {
        //创建了一个对象
        return new Itr();
    }

    //ArrayList内部类
	//一定要注意观察 Itr 类中的几个成员变量
    private class Itr implements Iterator<E> {
        int cursor;       // 光标,默认值就是0
        int lastRet = -1; // 记录-1
       //将实际修改集合次数 赋值 给预期修改次数
	   //在迭代的过程中,只要实际修改次数和预期修改次数不一致就会产生并发修改异常
       //由于expectedModCount是Itr的成员变量,那么只会被赋值一次!!!
       //同时由于集合调用了三次add方法,那么实际修改集合次数就是 3,因此expectedModCount的值也是 3
        int expectedModCount = modCount;

        //判断集合是否有元素
        public boolean hasNext() {
            //光标是否不等于集合的size 3
            return cursor != size;
        }

        public E next() {
          	//每次获取元素,会先调用该方法校验 预期修改次数是否 == 实际修改次数
            /* tips:
              if(s.equals("hello")) 
              		{ list.remove("hello");
              }
              当if表达式的结果为true,那么集合就会调用remove方法
            */
          
            checkForComodification();
            //把下一个元素的索引赋值给i 
            int i = cursor;
            //判断,如果大于集合的size就说明没有元素了
            if (i >= size)
                throw new NoSuchElementException();
            //将集合底层存储数据的数组赋值给迭代器的局部变量 elementData
            Object[] elementData = ArrayList.this.elementData;
            //再次判断,如果下一个元素的索引大于集合底层存储元素的长度 并发修改异常
		   //注意,尽管会产生并发修改异常,但是这里显示不是我们要的结果
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            //每次成功获取到元素,下一个元素的索引都是当前索引+1
            cursor = i + 1;
            //从数组中取出元素且返回
            return (E) elementData[lastRet = i];
        }

        //校验预期修改集合次数是否和实际修改集合次数一样
        final void checkForComodification() {
          	//如果预期修改次数 和 实际修改次数不相等 就产生并发修改异常
            if (modCount != expectedModCount)
                //如果不一样,就会产生并发修改异常
                throw new ConcurrentModificationException();
        }
    }

    //集合删除元素的方法
    public boolean remove(Object o) {
        //判断要删除的元素是否为null
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            //遍历集合
            for (int index = 0; index < size; index++)
                //拿着要删除的元素和集合的每一个元素进行比较
                if (o.equals(elementData[index])) {
                    //如果相等就调用方法进行删除
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    //真正删除元素的方法
    private void fastRemove(int index) {
        //在删除的方法中集合实际修改次数会自增
        //集合实际修改次数为:4 但是预期修改次数为:3
        modCount++;
        //计算集合要移动元素的个数
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //移动的核心代码
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        //就是让删除的元素置为null,就是为了尽快被垃圾回收机制回收
        //还有一个很关键的操作,集合的长度也发生了改变
        elementData[--size] = null; // clear to let GC do its work
    }
 }
/*
	结论:
    一,集合每次调用add方法的时候,实际修改次数变量的值都会自增一次
    二,在获取迭代器的时候,集合只会执行一次将实际修改集合的次数赋值给预期修改集合的次数
    三,集合在删除元素的时候也会针对实际修改次数的变量进行自增的操作
*/
```

**案例二: 已知集合：List list= new ArrayList();里面有三个元素："hello"、"PHP"、"Java"，使用迭代器遍历集合看有没有"PHP"这个元素，如果有，就使用集合对象删除该元素**

```java
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");

        //获取迭代器
        Iterator<String> it = list.iterator();
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            if(s.equals("PHP")) {
                list.remove("PHP");
            }
        }
        System.out.println(list);
    }
}
```

效果如下:(并没有报并发修改异常)

![12_并发2](img\12_并发2.png)

原因解释:

![13_并发3](C:\Users\Think\Desktop\ArrayLIst原理\img\13_并发3.png)

- **default  void remove()迭代器中的remove方法,删除集合中的元素**

```java
public class Test04 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");
        //获取迭代器
        Iterator<String> it = list.iterator();
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            if(s.equals("hello")) {
                it.remove();
            }
        }
        System.out.println(list);
    }
}
```

效果如下:

![14_并发4](img\14_并发4.png)

**源码分析:(应该从获取迭代器的时候就进入到源代码中):**

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    //查看add方法其目的就是为了找到记录集合实际修改次数的变量
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    //获取迭代器的方法
    public Iterator<E> iterator() {
        //创建了一个对象
        return new Itr();
    }

    //ArrayList集合的内部类 --> 迭代器的源码
    private class Itr implements Iterator<E> {
        int cursor;       // 光标,默认值就是0
        int lastRet = -1; // 记录-1
        // 将集合实际修改次数赋值给预期修改次数
        // 获取迭代器的时候,那么expectedModCount的值也就是 3
        int expectedModCount = modCount;

        //判断集合是否有元素
        public boolean hasNext() {
            //光标是否不等于集合的size 3
            return cursor != size;
        }

         //迭代器自带的方法
         public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                //把实际修改集合次数赋值给预期修改次数
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public E next() {
            checkForComodification();
            //光标赋值给i = 0
            int i = cursor;
            //判断,如果大于集合的size就说明没有元素了
            if (i >= size)
                throw new NoSuchElementException();
            //把集合存储数据数组的地址赋值给该方法的局部变量
            Object[] elementData = ArrayList.this.elementData;
            //进行判断,如果条件满足就会产生并发修改异常
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            //光标自增
            cursor = i + 1;
            //从数组中取出元素且返回
            return (E) elementData[lastRet = i];
        }

        //校验预期修改集合次数是否和实际修改集合次数一样
        final void checkForComodification() {
            if (modCount != expectedModCount)
                //如果不一样,就会产生并发修改异常
                throw new ConcurrentModificationException();
        }
    }

    //集合删除元素的方法
    public boolean remove(Object o) {
        //判断要删除的元素是否为null
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            //遍历集合
            for (int index = 0; index < size; index++)
                //拿着要删除的元素和集合的每一个元素进行比较
                if (o.equals(elementData[index])) {
                    //如果相等就调用方法进行删除
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    //真正删除元素的方法
    private void fastRemove(int index) {
        //在删除的方法中集合实际修改次数会自增
        //集合实际修改次数为:4 但是预期修改次数为:3
        modCount++;
        //计算集合要移动元素的个数
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //移动的核心代码
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        //就是让删除的元素置为null,就是为了尽快被垃圾回收机制回收
        elementData[--size] = null; // clear to let GC do its work
    }

    //集合删除的方法
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

 }
/*
 结论:
    一,迭代器调用remove方法删除元素,其实底层真正还是调用集合自己的删除方法来删除元素
    二,在调用remove方法中会每次都给预期修改次数的变量赋值
 */
```

### 3.9 清空方法

- **public void clear(); 清空集合中元素**

```java
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");
        System.out.println("清空前的集合: "+list);
        //清空集合所有元素
        list.clear();
        System.out.println("清空后的集合: "+list);
    }
}
```

效果如下:

![15_清空集合](img\15_清空集合.png)

源码分析:

```java
public class ArrayList<E> {
	//长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    //清空集合元素的方法
    public void clear() {
        //实际修改次数自增
        modCount++;
        //遍历集合
        for (int i = 0; i < size; i++)
            //把数组的每一个位置都置为null,让垃圾回收期尽早地回收
            elementData[i] = null;
        //把集合的长度置为0
        size = 0;
    }
}
```

### 4.0 包含方法

- **public   boolean   contains(Object obj)判断集合是否包含指定元素**

```java
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");

        //需求:如果集合中没有JavaSE该元素,请添加一个JavaSE元素
//        method(list);

        //解决方式二:使用集合contains方法判断,根据判断的结果决定是否要添加元素
        if (!list.contains("JavaSE")){
            //添加元素到集合
            list.add("JavaSE");
        }

        System.out.println(list);

    }

    private static void method(List<String> list) {
        //解决方式一:循环遍历集合,判断集合是否包含JavaSE,如果没有包含就调用集合的add方法进行添加操作
        //定义一个标记
        boolean flag = false;
        //遍历集合
        for (String value : list) {
            //对遍历到的元素进行判断
            if(value.equals("JavaSE")){
                //更改标记的值
                flag = true;
                //结束循环
                break;
            }
        }

        //根据标记的状态决定是否要添加元素到集合
        if(!flag){
            //添加元素到集合
            list.add("JavaSE");
        }

        System.out.println(list);
    }
}

```

效果如下:

![16_包含](img\16_包含.png)

源码分析:

```java
public class ArrayList<E> {
    //长度为0的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量为空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //集合存元素的数组
    Object[] elementData;

    //集合的长度
    private int size;

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    //判断是否包含的方法
    public boolean contains(Object o) {
        // 根据 indexOf方法返回的结果 和 0 进行比较
        // 如果大于等于0 就说明找到(包含)了,否则就说明没有找到(未包含)
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        //判断要找的元素否为null
        if (o == null) {
            //循环遍历集合
            for (int i = 0; i < size; i++)
                //进行判断
                if (elementData[i]==null)
                    //找到之后返回该元素的索引
                    return i;
        } else {
            //循环遍历集合
            for (int i = 0; i < size; i++)
                //拿着集合的每一个元素和要找的元素进行比较内容
                if (o.equals(elementData[i]))
                    //返回该元素在集合的索引
                    return i;
        }
        //在if 和 else中都没有执行return,就返回-1 说明没有找到
        return -1;
    }
}
/*
	结论:底层也是通过循环遍历集合,取出一个个的元素和要找的元素进行比较
*/
```

### 4.1 判断集合是否为空

- **public   boolean   isEmpty();判断集合是否为空**

```java
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");

        boolean b = list.isEmpty();
        System.out.println(b);
        System.out.println(list);
    }
}
```

源码分析:

```java
   public boolean isEmpty() {
        //根据集合的长度返回对应的结果
        return size == 0;
    }
```

## 第四章 自定义ArrayList集合

```java
package com.doit.demo06;

import java.util.Arrays;

public class MyArrayList<E> {
    //定义一个数组用来存储数据
    private Object[] data;
    //定义一个空数组用来进行初始化;
    private Object[] arr = {};
    //定义一个数组中元素的个数  长度
    private int size;
    //定义一个数组的容量
    private final  int capacity = 10;


    public MyArrayList(){
        data = arr;
    }



    public boolean add(E element){
        //简单扩容
        grow();
        data[size++] = element;
        return true;

    }

    private  void grow(){
        //说明长度为0 需要扩容
        if( arr.length == data.length){
            data = new Object[capacity];
        }

        if(size == data.length){
            //元素的个数 与数组的初始容量相同 需要扩容
            int old = data.length;
            int newCapacity = old  + (old>>1);
            Object[] newArr = new Object[newCapacity];
            //将原来的数组中元素复制到新创建的数组中
            System.arraycopy(data,0,newArr,0,data.length);
            //将新数组的地址 复制给data
            data = newArr;
        }
    }

    public E get(int index){
        //判断索引的方法
        check(index);

        return (E) data[index];
    }

    private void check(int index) {

        if(index <= -1 || index >=size){
            throw new IndexOutOfBoundsException("索引越界了! "+index);
        }
    }

    public E remove(int index){
        //调用get方法 获取到要删除的元素

        E e = get(index);

        //计算要移动元素的个数
        int moveNum = size - index -1 ;
        //如果要移动元素的个数大于0则进行数组动态移动
        if(moveNum>0){
            System.arraycopy(data,index+1,data,index,moveNum);
            //然后将最后的元素置为null 并且长度-1
            data[--size]=null;
        }
        return e;
    }

    public  E set(int index,E element){

        check(index);
        //根据索引获取到修改的元素
        E e = get(index);

        data[index] = element;


        return e;
    }

    /*
        {1,2,3,4,5}
        5-4=1
     */
    public void add(int index ,E element){
        check(index);

        grow();

        //计算要移动的元素的个数
        int moveNum = size - index;
        System.arraycopy(data,index,data,index+1,moveNum);
        data[index] = element;
        size++;

    }

	
    public String toString(){
        if(data.length == 0){
            return "[]";
        }
        String s = "[";
        for(int i = 0 ;i<size;i++){
            if(i !=size-1){
                s+=data[i]+", ";
            }else{
                s+=data[i];
            }
        }

        return s+"]";
    }
  
    public int getSize(){
        return size;
    }
}

```

















