package springAutoton.config_Test.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import springAutoton.Bean.Person;
import springAutoton.Bean.RedFactory;
import springAutoton.Condition.LinuxCondition;
import springAutoton.Condition.WindowsCondition;

/**
 * config_Test
 * Created by lenovo on 2018/8/30.
 */
//@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class PersonConfig2 {
    /**
     * Conditional 如果LinuxCondition返回true，则加载mayunBean实例
     *
     * @return
     */
    @Conditional(value = LinuxCondition.class)
    @Bean(name = "mayun")
    public Person mayun() {
        return new Person("马云", 55);
    }

    @Conditional(value = WindowsCondition.class)
    @Bean(name = "mahuateng")
    public Person mahuateng() {
        return new Person("马化腾", 44);
    }

    @Bean(name = "BeanFactory")
    public RedFactory redFactory(){
        return new RedFactory();
    }
}
