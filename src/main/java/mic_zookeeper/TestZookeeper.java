package mic_zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 原生api，增删改差
 * <p>
 * <p>
 * * CountDownLatch计数器执行过程：创建的时候是1，然后异步操作直接走到countDownLatch.await();，这一步让线程等待，然后异步执行countDownLatch.countDown();后计数器为0，
 * 然后就回释放调 线程。继续走下去
 * Created by lenovo on 2018/9/5.
 */
public class TestZookeeper {
    private final static String ZookeeperString = "192.168.1.226:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static ZooKeeper zooKeeper = null;

    public TestZookeeper() {
        try {
            zooKeeper = new ZooKeeper(ZookeeperString, 5000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(countDownLatch.getCount());
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                        countDownLatch.countDown();
                        System.out.println(watchedEvent.getState());
                        System.out.println(countDownLatch.getCount());
                    }
                }
            });
            countDownLatch.await();
            System.out.println(countDownLatch.getCount());
            System.out.println(zooKeeper.getState());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //创建节点
    public static String create(String key, String value) throws KeeperException, InterruptedException {
        String result = zooKeeper.create(key, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        return result;
    }

    //查询节点
    public static void select(String key, String value) throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        TestZookeeper testZookeeper = new TestZookeeper();
        System.out.println("创建成功：" + testZookeeper.create("/join", "123"));
        testZookeeper.select("/join", "123");
    }

}
