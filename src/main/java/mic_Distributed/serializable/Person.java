package mic_Distributed.serializable;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/9/3.
 */
public class Person implements Serializable {
    @Protobuf(fieldType = FieldType.STRING)
    private String name;
    @Protobuf(fieldType = FieldType.INT32)
    private int age;
    private static int height;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Person.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
