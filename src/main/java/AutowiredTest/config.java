package AutowiredTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by lenovo on 2018/8/31.
 */
@ComponentScan("AutowiredTest")
@Configuration
public class config {

    @Primary
    @Bean(name = "dog2")
    public Dog dog() {
        return new Dog("小黄");
    }
}
