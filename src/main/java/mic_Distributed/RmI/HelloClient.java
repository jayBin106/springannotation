package mic_Distributed.RmI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by lenovo on 2018/9/3.
 */
public class HelloClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        ISayHello hello = (ISayHello) Naming.lookup("rmi://localhost:8888/sayHello");
        System.out.println(hello);
        System.out.println(hello.sayHello("小明"));
    }
}
