package com.doit.demoBS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: BSSever
 * @Author: zll
 * @CreateTime: 2021/7/5 19:42
 * @Desc: java 程序
 * @Version: 1.0
 */
public class BSServer {
    public static void main(String[] args) throws IOException {
        //创建服务器对象
        ServerSocket ss = new ServerSocket(3333);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        while (true) {
            Socket thisSocket = ss.accept();

            pool.submit(()->{
                InputStream in = null;
                BufferedReader br = null;
                FileInputStream fis = null;
                OutputStream out = null;
                try {
                    in = thisSocket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);
                    br = new BufferedReader(isr);

                    String str = br.readLine();
                    String s = str.split(" ")[1].substring(1);
                    System.out.println(Thread.currentThread().getName() + "......"+ s);

                    fis = new FileInputStream(s);
                    out = thisSocket.getOutputStream();

                    //固定写法，加上
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    out.write("Content-Type:text/html\r\n".getBytes());
                    out.write("\r\n".getBytes());

                    byte[] buf = new byte[1024];
                    int len = 0;
                    while ((len = fis.read(buf))!= -1){
                        out.write(buf, 0, len);
                    }

                }catch (IOException e){
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
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }finally {
                                try {
                                    br.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }finally {
                                    try {
                                        thisSocket.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }

                        }

                    }

                }
            });

        }

       // ss.close();

    }
}
