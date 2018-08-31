package AopTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lenovo on 2018/8/31.
 */
public class Test {
    @org.junit.Test
    public void  get(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.count(1,0);
        System.out.println(bean);
    }
}
