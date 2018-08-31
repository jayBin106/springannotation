package springAutoton.config_Test.one;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springAutoton.Bean.Person;

/**
 * Created by lenovo on 2018/8/30.
 */
public class TestPerson {
    //加载spring配置
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);

    @Test
    public void test01(){
        Person bean = context.getBean(Person.class);
        Person bean2 = context.getBean(Person.class);
        System.out.println("Person内容：" + bean);
        System.out.println("两个Bean是否相等:" + (bean == bean2));
        System.out.println("------------------------------------------------------------------------");
        /**
         * 返回所有在IOC容器中的bean
         */
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IOC容器中的bean:" + name);
        }
    }
    @Test
    public void test02(){
        System.out.println("IOC容器启动完成。。。");
        /**
         * 返回所有在IOC容器中的bean
         */
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IOC容器中的bean:" + name);
        }

    }

    public static void main(String[] args) {
    }
}
