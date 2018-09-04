package mic_WebService.service;

import javax.xml.ws.Endpoint;

/**
 * Created by lenovo on 2018/9/4.
 */
public class Test {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/vip/good", new SayGoodImpl());

        System.out.println("publish success------------");
    }
}
