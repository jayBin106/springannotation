package springAutoton.config_Test.one;

import org.springframework.context.annotation.*;
import springAutoton.Bean.Person;
import springAutoton.Filter.MyTypeFilter;

/**
 * config_Test
 * Created by lenovo on 2018/8/30.
 */
@Configuration
//排除某些注解
//@ComponentScan(value = "springAutoton", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, Service.class})})
//只包含某些注解 useDefaultFilters=false :关闭默认配置
//FilterType.ANNOTATION  按照注解过滤
//FilterType.CUSTOM      自定义过滤规则
@ComponentScan(value = "springAutoton", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, value = MyTypeFilter.class)
}, useDefaultFilters = false)
public class PersonConfig {

    /**
     * 1，
     * prototype：多例模式ioc容器启动后并不会生成对象，放入IOC，而是每次获取时，才回创建对象
     * singleton: 单例模式IOC容器启动就会生成对象，放入IOC。每次获取都相同
     * request ：同一次请求生成一次对象
     * session： 同一个会话，生成一次对象
     * <p>
     * 2，Lazy注解。当单例模式是，容器启动时就回加载bean，但是加载这个对象后就会在获取时，才会加载。
     *
     * @return
     */
//    @Scope(value = "prototype")
    @Lazy
    @Bean(name = "person")
    public Person getPerson() {
        System.out.println("IOC容器创建Bean对象");
        return new Person("小红", 12);
    }
}
