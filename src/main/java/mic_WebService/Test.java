package mic_WebService;

/**
 * Created by lenovo on 2018/9/4.
 */
public class Test {
    public static void main(String[] args) {
        SayGoodImplService service = new SayGoodImplService();
        mic_WebService.service.SayGoodImpl port = service.getSayGoodImplPort();
        System.out.println(port.sayHello("王二狗"));
    }
}
