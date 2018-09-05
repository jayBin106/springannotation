package mic_zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created by lenovo on 2018/9/5.
 */
public class CuratorClientUtils {
    private static CuratorFramework curatorFramework;

    private final static String ZookeeperString = "192.168.1.226:2181";

    public static CuratorFramework getCuratorFramework() {
        curatorFramework = CuratorFrameworkFactory.newClient(ZookeeperString, 5000, 5000,
                new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        return curatorFramework;
    }
}
