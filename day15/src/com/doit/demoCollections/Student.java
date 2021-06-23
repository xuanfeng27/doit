package com.doit.demoCollections;

/**
 * @ClassName: Student
 * @Author: zll
 * @CreateTime: 2021/6/23 15:47
 * @Desc: java 程序
 * @Version: 1.0
 */
//可以不实现自然排序接口
public class Student {
    private String id;
    private double score;

    public Student() {
    }

    public Student(String id, double score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", score=" + score +
                '}';
    }
}
