package beanLife.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by lenovo on 2018/8/30.
 */
public class Student {
    @Autowired
    Cat cat;

    @Autowired
    Cat2 cat2;

    @Value("${db.user}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
        System.out.println("1111111。。。。");
    }

    public void init() {
        System.out.println("init初始化。。");
    }


    public void destroy() {
        System.out.println("destroy销毁方法。。。");
    }

    @Override
    public String toString() {
        return "Student{" +
                "cat=" + cat +
                ", cat2=" + cat2 +
                ", name='" + name + '\'' +
                '}';
    }
}
