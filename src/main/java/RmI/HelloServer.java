package RmI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by lenovo on 2018/9/3.
 */
public class HelloServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        ISayHello sayHello = new SayHelloImpl();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/sayHello", sayHello);
        System.out.println("服务端启动成功。。。");
    }
}
