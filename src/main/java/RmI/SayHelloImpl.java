package RmI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by lenovo on 2018/9/3.
 */
public class SayHelloImpl extends UnicastRemoteObject implements ISayHello {
    public SayHelloImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return name + "上学去啦。。。。";
    }

}
