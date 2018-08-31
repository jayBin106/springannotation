package beanLife.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2018/8/31.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /*
    在任何bean初始化方法之前调用
    * */
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        System.out.println(o+"----->"+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        System.out.println(o+"----->"+s);
        return o;
    }
}
