package ProfileTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 动态配置数据源
 * 第一种：命令行运行：-Dspring.profiles.active=dev
 *
 */
public class Test {


    @org.junit.Test
    public void equals() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev","prod");
        context.register(Config.class);
        context.refresh();

        String[] beanNamesForType = context.getBeanNamesForType(DateBase.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
            DateBase bean = (DateBase) context.getBean(s);
            System.out.println(bean);
        }
    }
}
