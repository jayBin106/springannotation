package springAutoton.ImportSelect;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import springAutoton.Bean.RainBow;

/**
 * Created by lenovo on 2018/8/30.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param annotationMetadata 当前类的注解信息
     * @param registry           bean定义的注册类，可以通过该类自定义注册类。
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("springAutoton.Bean.Red");
        //如果IOC中有RED的bena
        if (definition) {
            RootBeanDefinition definition1 = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow", definition1);
        }
    }
}
