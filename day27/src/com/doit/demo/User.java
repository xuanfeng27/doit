package com.doit.demo;

/**
 * @ClassName: User
 * @Author: zll
 * @CreateTime: 2021/7/12 10:16
 * @Desc: java ³ÌÐò
 * @Version: 1.0
 */
public class User {
    private String cid;
    private String cname;

    public User() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "User{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
