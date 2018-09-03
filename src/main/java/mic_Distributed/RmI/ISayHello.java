package mic_Distributed.RmI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lenovo on 2018/9/3.
 */
public interface ISayHello extends Remote {

    public String sayHello(String name) throws RemoteException;
}
