package ProfileTest;

/**
 * Created by lenovo on 2018/8/31.
 */
public class DateBase {
    private String name;

    private String password;

    public DateBase() {
    }

    public DateBase(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "DateBase{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
