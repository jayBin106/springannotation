package beanLife.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lenovo on 2018/8/31.
 */
@Component
public class Cat2 {

    public Cat2() {
        System.out.println("cat2 午餐构造方法。。。");
    }

    @PostConstruct
    public void aaa() throws Exception {
        System.out.println("Cat2   @PostConstruct。。。。");
    }

    @PreDestroy
    public void bbb() throws Exception {
        System.out.println("Cat2  @PreDestroy。。。");
    }
}
