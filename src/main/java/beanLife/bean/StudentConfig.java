package beanLife.bean;

import org.springframework.context.annotation.*;

/**
 * Created by lenovo on 2018/8/30.
 */
@PropertySource(value = "classpath:/dbconfig.properties")
@ComponentScan("beanLife.bean")
@Configuration
public class StudentConfig {


    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Student student() {
        return new Student();
    }

    //加载首选Bean
    @Primary
    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("小王");
        return cat;
    }
}
