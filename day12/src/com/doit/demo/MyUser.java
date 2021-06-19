package com.doit.demo;

/**
 * @ClassName: MyUser
 * @Author: zll
 * @CreateTime: 2021/6/19 19:56
 * @Desc: java 程序
 * @Version: 1.0
 */
public class MyUser {
    private String userName;
    private String password;

    public MyUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public MyUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser myUser = (MyUser) o;

        if (!userName.equals(myUser.userName)) return false;
        return password.equals(myUser.password);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
