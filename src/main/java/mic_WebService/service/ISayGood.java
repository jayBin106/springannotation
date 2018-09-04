package mic_WebService.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by lenovo on 2018/9/4.
 */
@WebService
public interface ISayGood {
    @WebMethod
    public String sayHello(String name);
}
