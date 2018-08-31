package springAutoton.ImportSelect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by lenovo on 2018/8/30.
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param annotationMetadata  获取当前类的注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String[] classNames = annotationMetadata.getMemberClassNames();
        for (String className : classNames) {
            System.out.println(className);
        }
        return new String[]{"springAutoton.Bean.Red", "springAutoton.Bean.Yellow"};
    }
}
