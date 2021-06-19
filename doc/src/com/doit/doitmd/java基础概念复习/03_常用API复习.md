# **常用API复习资料**

**1.Object类的toString方法返回的是什么?equals方法比较的是什么?子类重写后返回什么?比较什么?**

```
Object中toString返回的是对象的地址值 子类重写后一般获取成员变量的值
Object中equals方法比较的对象的地址值 子类重写后一般比较成员变量的值
```

**2.方法重载和方法重写区别?**

```
方法重载: 
		同一个类中 方法名相同 参数列表不同  个数不同 类型不同 顺序不同
方法重写 
		继承后,子类觉得父类方法不够强 可以重新定义此方法 要求方法声明一致 
```

**3.如何获取当前日期对象?getTime方法获取到的毫秒值开始时间是谁?**

```
Date now = new Date();
时间原点:1970-1-1 00:00:00
```

**4.日期如何转换为指定格式的字符串?字符串如何解析成日期?**

```
    //格式化：从 Date 到 String
     Date d = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
     String s = sdf.format(d);
     System.out.println(s);
     System.out.println("--------");

     //从 String 到 Date
     String ss = "2048-08-09 11:11:11";
     //ParseException
     SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date dd = sdf2.parse(ss);
     System.out.println(dd);
```

**5.如何获取日历类的对象?通过日历对象获取到年**

```
Calendar cal = Calendar.getInstance();
int year = cal.get(Calendar.YEAR);
```

**6.System类的复制数组的方法是什么参数是什么?**

```
public static void arrayCopy(Object src, int srcPos, Object dest, int destPos, int length)
- Object src：要复制的数据源数组
- int srcPost：数据源数组的开始索引
- Object dest：复制后的目的数组
- int destPos：目的数组开始索引
- int length：要复制的数组元素的个数

```

**7.冒泡排序的原理是什么?代码**

```
相邻两个元素进行比较,前面的元素如果比后面的元素大则交换
 		//定义一个数组
        int[] arr = {7, 6, 5, 4, 3};
        System.out.println("排序前：" + arrayToString(arr));
        // 这里减1，是控制每轮比较的次数
        for (int x = 0; x < arr.length - 1; x++) {
            // -1是为了避免索引越界，-x是为了调高比较效率
            for (int i = 0; i < arr.length - 1 - x; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("排序后：" + arrayToString(arr));
```

**8.二分查找的原理是什么?代码?**

```
取数组中间的元素和被查找的元素进行比较，如果被查找元素大于数组中间元素，就舍去数组元素的一半，对另一半继续进行查找
 public static int binarySearch(int[]arr,int key){
        //最小索引
        int low = 0;
        //最大索引
        int height = arr.length - 1;
        //初始化中间索引
        int mid = 0;
        //循环折半，最小索引小于等于最大索引时，才能折半
        while (low <= height){
            //折半，计算中间索引
            mid = (height + low) / 2;
            if(key > arr[mid]){
                //元素大于数组中间索引元素，移动最小索引
                low = mid + 1;
            }else if(key < arr[mid]){
                //元素小于数组中间索引元素，移动最大索引
                height = mid - 1;
            }else{
                //查询到元素，返回索引
                return mid;
            }
        }
        //循环查找结束后，找不到元素，返回-1
        return - 1;
    }
```

**9.如何进行超大数的计算?如何进行小数的精确计算?**

```
java.math.BigInteger类，不可变的任意精度的整数。如果运算中，数据的范围超过了long类型后，可以使用BigInteger类实现，该类的计算整数是不限制长度的。
java.math.BigDecimal类，不可变的、任意精度的有符号十进制数。该类可以实现超大浮点数据的精确运算。
```

**10.代码演示自动装箱和拆箱**

```
Integer  i = 10; //自动装箱
int  a = i;//自动拆箱
```

**11.字符串如何转换为基本类型?基本类型如何转换为字符串?**

```
//int --- String
  String s1 = 10 + "";
  //String ---int
  int a = Integer.parseInt("10");
```

**12.异常的继承体系?编译时异常和运行时异常区别?**

```
Throwable
- Error:严重错误Error
- Exception:表示编译时异常,必须处理不处理不能运行
		- RuntimeException:运行时异常,可以处理,可以不处理,推荐不处理一般出现运行时异常都是代码有问题 需要改代码

```

**13.throw关键字和throws关键字的区别**

```
throw 异常对象   在方法中使用 抛出异常对象
throws 异常的类型  在方法的声明上使用  声明异常
```

**14.如何异常没有捕获到finally代码块中的内容是否会执行?**

```
会执行!只有System.exit(0)的时候finally中的内容才不会被执行
```

**15.父类方法没有抛异常子类重写父类方法时能不能抛异常?**

```
不能,父类方法不抛异常,子类重写方法也不能抛异常,有异常 try catch
```

