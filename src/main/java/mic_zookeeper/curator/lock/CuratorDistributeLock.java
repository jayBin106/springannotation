package mic_zookeeper.curator.lock;

import mic_zookeeper.curator.CuratorClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2018/9/6.
 */
public class CuratorDistributeLock {
    CuratorFramework curatorFramework = CuratorClientUtils.getCuratorFramework();
    private String lockID = "";
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public CuratorDistributeLock() {
    }

    public CuratorDistributeLock(CuratorFramework curatorFramework, String lockID, CountDownLatch countDownLatch) {
        this.curatorFramework = curatorFramework;
        this.lockID = lockID;
        this.countDownLatch = countDownLatch;
    }

    public boolean lock() {
        try {
            lockID = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/LOCKS/", "123".getBytes());
            System.out.println(Thread.currentThread().getName() + "->成功创建了lock节点[" + lockID + "], 开始去竞争锁");
            List<String> list = curatorFramework.getChildren().forPath("/LOCKS");
//            Collections.sort(list, (String s1, String s2) -> s1.compareTo(s2));
//            list.forEach(s -> System.out.println("子节点----" + s));
            //排序，从小到大
            SortedSet<String> strings = new TreeSet<>();
            list.forEach(s -> strings.add("/LOCKS/" + s));
            //拿到最小节点
            String first = strings.first();
            if (first.equals(lockID)) {
                //表示当前是 最小节点
                System.out.println(Thread.currentThread().getName() + "->成功获得锁，lock节点为:[" + lockID + "]");
                return true;
            }
            //获取小于locakID的元素集合
            SortedSet<String> strings1 = strings.headSet(lockID);
            if (!strings1.isEmpty()) {
                String last = strings1.last();  //拿到比当前LOCKID这个几点更小的上一个节点
                Stat stat = curatorFramework.checkExists().forPath(last);
                countDownLatch.await(5, TimeUnit.MILLISECONDS);
                System.out.println(last);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean unlock() {
        try {
            curatorFramework.delete().forPath(lockID);
            System.out.println(Thread.currentThread().getName() + "->开始释放锁:[" + lockID + "]");
            System.out.println("节点[" + lockID + "]成功被删除");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            //线程
            new Thread(() -> {
                CuratorDistributeLock lock = null;
                try {
                    lock = new CuratorDistributeLock();
                    latch.countDown();
                    latch.await();
                    lock.lock();
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lock == null) {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }


}
