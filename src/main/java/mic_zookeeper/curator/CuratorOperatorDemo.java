package mic_zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2018/9/5.
 */
public class CuratorOperatorDemo {
    CuratorFramework curatorFramework = CuratorClientUtils.getCuratorFramework();

    @Test
    public void create() throws Exception {
        String forPath = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/curator", "123".getBytes());
        System.out.println("节点创建成功-----》" + forPath);
    }

    @Test
    public void select() throws Exception {
        Stat stat = new Stat();
        System.out.println("stat----->" + stat);
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/curator2");
        System.out.println("查询数据---》" + Integer.valueOf(new String(bytes)));
    }

    @Test
    public void delete() throws Exception {
        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/curator2");
    }

    @Test
    public void update() throws Exception {
        Stat stat = curatorFramework.setData().forPath("/curator", "666".getBytes());
        System.out.println("更新创建成功-----》" + stat);
    }

    /**
     * CountDownLatch计数器执行过程：创建的时候是1，然后异步操作直接走到countDownLatch.await();，这一步让线程等待，然后异步执行countDownLatch.countDown();后计数器为0，
     * 然后就回释放调 线程。继续走下去
     *
     * @throws Exception
     */
    @Test
    public void 异步操作() throws Exception {
        //线程池
        ExecutorService service = Executors.newFixedThreadPool(1);
        //计数器
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        //回调方法
        BackgroundCallback callback = new BackgroundCallback() {
            //异步操作完成的方法
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                //打印线程的名称，和结果
                System.out.println("线程名称------》" + Thread.currentThread().getName());
                System.out.println("响应的结果吗------》" + curatorEvent.getResultCode());
                System.out.println("当前操作类型------》" + curatorEvent.getType());
                countDownLatch.countDown();
            }
        };
        String forPath = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).inBackground(callback, service).forPath("/curator2", "123".getBytes());
        System.out.println("异步操作：\n,节点创建成功-----》" + forPath);
        countDownLatch.await();
        service.shutdown();

    }

    /**
     * 两个操作同时进行，有个失败就进行事物回滚
     *
     * @throws Exception
     */
    @Test
    public void 事务操作() throws Exception {
        Collection<CuratorTransactionResult> commit = curatorFramework.inTransaction()
                .create().forPath("/curator3", "123".getBytes()).and()    //新增操作
                .setData().forPath("/curator2", "666".getBytes()).and().commit();  //更新节点
        for (CuratorTransactionResult curatorTransactionResult : commit) {
            System.out.println("返回 类型----》" + curatorTransactionResult.getType());
            System.out.println("返回 for地址----》" + curatorTransactionResult.getForPath());
            System.out.println("返回result地址----》" + curatorTransactionResult.getResultPath());
            System.out.println("返回ResultStat----》" + curatorTransactionResult.getResultStat());
        }
    }
}
