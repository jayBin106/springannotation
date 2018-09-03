package serializable;

import java.io.*;

/**
 * Created by lenovo on 2018/9/3.
 */
public class Test {
    @org.junit.Test
    public void test01() {
        SerializePerson();
        Person.setHeight(11);
        DeSerialzePerson();
    }

    private static void SerializePerson() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person")));
            oo.writeObject(new Person("小明", 18));
            System.out.println("序列化成功。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void DeSerialzePerson() {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person = (Person) oi.readObject();
            System.out.println("反序列化成功。。。");
            System.out.println(person);
            System.out.println(Person.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
