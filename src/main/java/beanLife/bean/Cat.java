package beanLife.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2018/8/31.
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    @Value("小明")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public Cat() {
        System.out.println("name-----" + name);
        System.out.println("cat 午餐构造方法。。。");
    }

    public void destroy() throws Exception {
        System.out.println("name-----" + name);
        System.out.println("Cat  destroy销毁方法。。。。");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat  afterPropertiesSet为属性赋值方法。。。");
    }
}
