package AutowiredTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by lenovo on 2018/8/31.
 */
@Component
public class Red implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext+-----" + applicationContext);
        //获得配置信息，供其他类使用
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String s) {
        System.out.println("BeanNameAware-----------"+s);
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("海楼你好 ${os.name} 我是#{777*888888}");
        System.out.println("EmbeddedValueResolverAware，字符串解析--------------"+s);
    }
}
