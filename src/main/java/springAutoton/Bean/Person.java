package springAutoton.Bean;

/**
 * Created by lenovo on 2018/8/30.
 */
public class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "mic_Distributed.serializable.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
