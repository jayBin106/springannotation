package AutowiredTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/8/31.
 */
@Repository
public class Person {

//    @Qualifier("dog2")
    @Autowired
    Dog dog;

    @Autowired
    Red red;

    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", red=" + red +
                ", name='" + name + '\'' +
                '}'+red.getApplicationContext();
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
