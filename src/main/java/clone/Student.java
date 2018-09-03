package clone;

import java.io.*;

/**
 * Created by lenovo on 2018/9/3.
 */
public class Student implements Serializable {
    private String name;
    private Teacher teacher;

    public Student(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    //深度克隆
    public Object sleepClone() throws IOException, ClassNotFoundException {
        //序列化
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(stream);
        oos.writeObject(this);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(stream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        return ois.readObject();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
