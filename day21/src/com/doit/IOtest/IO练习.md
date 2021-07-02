**1.将一个文件中的内容读取,然后倒叙写回**

```

```

**2.将1.txt中的内容和2.txt中的内容合并 写到3.txt中**

```

```

**3.从类似的文件中的读取信息,然后按照年龄进行排序后将排序后的内容按照格式写回文件中**

liuyan,38-tangyang,18-jinlian,138-dalang,8

```

```

**4.编写一个程序将一个文件夹下的所有.java文件复制到另一个文件夹下,并将后缀改为.jad(单级目录);**

```

```

**5.定义一个方法可以将一个视频文件进行文件拆分 拆分到当前文件夹下的part目录中,定义一个方法可以将拆分的part目录中的文件 合并成视频文件. 拆分大小自己指定  我指定的是 byte[1024*100]** 

**这道题自己粘过去运行,能够看懂即可自己读懂代码的含义后,尝试去写**



拆分前:

![](img\01.png)

拆分后:

​	![02](img\02.png)

![03](img\03.png)

```java
public class Test {
    public static void main(String[] args) throws IOException {

        //文件拆分
        File file=new File("d:\\work\\abc\\1.flv");
        SplitFile(file);

//        //文件合并
//        File dir = new File("d:\\work\\abc\\part");
//        mergeFile(dir);

    }
    //传入要切割的文件
    private static void SplitFile(File file) throws IOException {
        File parentFile = file.getParentFile();
        File destDir = new File(parentFile,"part");

        //健壮性判断，如果不存在，创建多级目录
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        //用读取流关联源文件
        FileInputStream fis = new FileInputStream(file);
        //创建缓冲区，指定每一块文件的大小
        byte[] bytes = new byte[1024 * 100];
        int len = 0;
        //计数器，用来记录碎块数
        int count = 0;

        //循环一次 写到一个文件中 大小为 byte数组的大小
        while ((len = fis.read(bytes)) != -1) {
            //每次需要创建一个新的输出流
            OutputStream out = new FileOutputStream(new File(destDir, (++count) + ".part"));//实例化输出流，并将目的文件传给构造函数，每个块名称不同
            out.write(bytes, 0, len);//写入
            out.close();//每次写入完毕，关闭流
        }

        fis.close();


        //将视频名称和  切割的份数写到配置文件中
        Properties p = new Properties();
        //将被切割文件的信息保存到pro集合中。
        p.setProperty("count", count + "");
        p.setProperty("name", file.getName());


        Writer w = new FileWriter(new File(destDir, "my.properties"));

        //使用store方法存储到硬盘中
        p.store(w, "");
        w.close();

    }

    //合并文件
    private static void mergeFile(File dir) throws IOException {
        //获取当前文件夹下的properties文件
        File[] fileArr = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                return pathname.getName().toLowerCase().endsWith(".properties");
            }
        });

        if(fileArr.length!=1){
            throw new RuntimeException("文件格式不符合规定");
        }

        //读取配置文件中的信息
        File file  = fileArr[0];
        Properties p = new Properties();
        Reader r = new FileReader(file);
        p.load(r);
        String fileName = p.getProperty("name");
        String count = p.getProperty("count");


        //获取所有.part文件
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".part");
            }
        });


        //定义一个集合 用来 存储输入流
        List<InputStream> list = new ArrayList<>();

        for(int i = 1 ;i<=Integer.parseInt(count);i++){
            //获取所有part文件
            File srcFile = new File(dir,i+".part");
            //创建对应的 输入流对象 放入到list集合中
            list.add(new FileInputStream(srcFile));
        }


        //创建字节输出流对象
        File parentFile = dir.getParentFile();
        //确定目标文件
        File destFile = new File(parentFile,fileName);
        OutputStream out = new FileOutputStream(destFile);

        //创建byte数组  和 分块时byte数组大小一致
        byte[] bytes = new byte[1024*100];


        //循环list集合 获取到每个输入流对象  每个输入流读一次  让输出流写数据
        for(InputStream in : list){
            int length = in.read(bytes);
            out.write(bytes, 0, length);
            in.close();
        }


        out.close();


    }

}

```

