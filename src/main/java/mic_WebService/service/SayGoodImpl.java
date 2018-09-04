package mic_WebService.service;

import javax.jws.WebService;

/**
 * Created by lenovo on 2018/9/4.
 */
@WebService
public class SayGoodImpl implements ISayGood {
    public String sayHello(String name) {
        System.out.println("sayHello....方法。。");
        return name + "goodMorning";
    }
}
