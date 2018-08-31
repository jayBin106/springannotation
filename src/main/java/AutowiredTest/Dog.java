package AutowiredTest;

import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/8/31.
 */
@Repository
public class Dog {
    private String name;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
