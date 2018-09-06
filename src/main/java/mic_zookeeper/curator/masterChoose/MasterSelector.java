package mic_zookeeper.curator.masterChoose;

import mic_zookeeper.curator.CuratorClientUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2018/9/6.
 */
public class MasterSelector {
    CuratorFramework curatorFramework = CuratorClientUtils.getCuratorFramework();

    private final static String MASTER_PATH = "/master"; //需要争抢的节点

    private UserCenter server;  //其他服务器

    private UserCenter master;  //master节点

    private boolean isRunning = false;

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public MasterSelector() throws Exception {
        PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework, MASTER_PATH, true);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        //添加监听操作
        childrenCache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
            switch (pathChildrenCacheEvent.getType()) {
                case CHILD_ADDED:
                    System.out.println("增加子节点");
                    break;
                case CHILD_UPDATED:
                    System.out.println("更新子节点");
                    break;
                case CHILD_REMOVED:
                    System.out.println("移除子节点");
                    break;
            }
        });
        System.in.read();
    }

    /**
     * 开始选举
     */
    public void start() throws Exception {
        if (!isRunning) {
            isRunning = true;
            //创建service节点
            String forPath = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(MASTER_PATH, server.getMc_name().getBytes());
            master = server;
            System.out.println(master + "->我现在已经是master，你们要听我的");
            scheduledExecutorService.schedule(() -> {

            }, 2, TimeUnit.MILLISECONDS);
        }
    }
}
