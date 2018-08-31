package springAutoton.Bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by lenovo on 2018/8/30.
 */
public class RedFactory implements FactoryBean<Red> {
    public Red getObject() throws Exception {
        System.out.println("FactoryBean生成bean....");
        return new Red();
    }

    //返回Bean的类型
    public Class<?> getObjectType() {
        return Red.class;
    }

    //是否是单例
    public boolean isSingleton() {
        return false;
    }
}
