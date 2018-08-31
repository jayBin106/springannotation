package springAutoton.Filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 引入注解的过滤类
 * <p>
 * metadataReader :读取到正在扫描类的信息
 * metadataReaderFactory：读取到其他类的任何信息
 *
 * /返回true的类才会被过滤出来
 * Created by lenovo on 2018/8/30.
 */

public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取类资源的信息（如类路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("扫描到的类名称：" + className);
        if (className.contains("Dao")) {
            return true;
        }
        return false;
    }
}
