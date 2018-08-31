package springAutoton.config_Test.two;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import springAutoton.Bean.Person;

/**
 * Created by lenovo on 2018/8/30.
 */
public class TestPerson2 {
    //加载spring配置
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);

    @Test
    public void test02() {
        System.out.println("IOC容器启动完成。。。");
        /**
         * 返回所有在IOC容器中的bean
         */
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IOC容器中的bean》》》》" + name);
        }
        System.out.println("------------------------------------------------------------------------");
        //获取类型对象的所有bean
        String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
        System.out.println("------------------------------------------------------------------------");
        //获取容器配置信息
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("操作系统信息：" + property);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("多例模式生成bean");
        Object beanFactory = context.getBean("BeanFactory");
        Object beanFactory2 = context.getBean("BeanFactory");
        System.out.println(beanFactory == beanFactory2);
        System.out.println(beanFactory.getClass());
        System.out.println(beanFactory2.getClass());

    }
}
