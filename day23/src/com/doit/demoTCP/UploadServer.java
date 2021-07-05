package com.doit.demoTCP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: UploadServer
 * @Author: zll
 * @CreateTime: 2021/7/5 16:01
 * @Desc: java 程序
 * @Version: 1.0
 */
/*
    文件上传服务端


    数据源:客户端
    数据目的:

    1.创建服务端对象 绑定端口号
    2.调用accept方法 获取正在连接的客户端对象
    3.获取字节输入流对象
    4.创建FileOutputStream对象 绑定数据目的
    5.循环读写
    6.获取字节输出流对象
    7.向客户端返回数据 "上传成功"
    8.关闭资源

 */
//文件上传服务端
public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5555);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                3,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            Socket socket = ss.accept();
            pool.submit(() -> {
                InputStream in = null;
                FileOutputStream fos = null;
                OutputStream out = null;
                try {
                    in = socket.getInputStream();
                    String fileName = "pic.zll.com"+ System.currentTimeMillis() + new Random().nextInt(99999) + ".jpg";
                    fos = new FileOutputStream("d:\\" + fileName);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = in.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    System.out.println("---------------服务端接收完毕---------------------");
                    out = socket.getOutputStream();
                    out.write("上传成功".getBytes());


                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }finally {
                                try {
                                    socket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        }

                    }


                }

            });

        }

        //ss.close();
    }
}
