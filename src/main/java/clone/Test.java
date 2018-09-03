package clone;


import java.io.IOException;

/**
 * Created by lenovo on 2018/9/3.
 */
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("李老师");
        Student student = new Student("小明", teacher);
        try {
            Student studentClone = (Student) student.sleepClone();
            System.out.println("原对象-----" + student);
            studentClone.setTeacher(new Teacher("陈老师 "));
            System.out.println("克隆对象---" + studentClone);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
