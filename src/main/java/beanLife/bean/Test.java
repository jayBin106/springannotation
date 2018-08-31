package beanLife.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lenovo on 2018/8/30.
 */
public class Test {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
    @org.junit.Test
    public void test01() {
        System.out.println("IOC容器初始化。。。");
        Object student = context.getBean("student");
        Object student2 = context.getBean("student");
        Object student3 = context.getBean("student");

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IOC BeanName:-----------"+name);
        }
        context.close();
    }
    @org.junit.Test
    public void test02() {
        System.out.println("IOC容器初始化。。。");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IOC BeanName:-----------"+name);
        }
        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat);
        context.close();
    }

    @org.junit.Test
    public void test03() {

        System.out.println("IOC容器初始化。。。");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IOC BeanName:-----------"+name);
        }

        Student cat = (Student) context.getBean("student");
        System.out.println(cat);
//        ConfigurableEnvironment environment = context.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);
//        String property1 = environment.getProperty("db.user");
//        System.out.println(property1);
//        context.close();
    }
}
