package AutowiredTest;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lenovo on 2018/8/31.
 */
public class Test {

    @org.junit.Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config.class);
        String[] type = context.getBeanDefinitionNames();
        for (String s : type) {
            System.out.println(s);
        }
        Dog bean = (Dog) context.getBean("dog");
        System.out.println(bean);
        Person bean2 = (Person) context.getBean("person");
        System.out.println(bean2);
    }
}
