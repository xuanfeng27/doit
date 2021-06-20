package com.doit.selfDefineException;

/**
 * @ClassName: AgeOutOfBoundsException
 * @Author: zll
 * @CreateTime: 2021/6/20 17:31
 * @Desc: java 程序
 * @Version: 1.0
 */

public class AgeOutOfBoundsException extends RuntimeException {
    public AgeOutOfBoundsException(String s) {
       super(s);
        //System.out.println(s);
    }

    public AgeOutOfBoundsException() {
    }
}
