package mic_zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.junit.Test;

/**
 * 三种watcher来做节点 监控
 * pathcache  监视一个路径下节点的创建，删除，节点数据更新
 * NodeCache  监视一个节点的创建，更新，删除
 * TreeCache  pathcache + NodeCache  的合体
 */
public class CuratorEventDemo {
    CuratorFramework curatorFramework = CuratorClientUtils.getCuratorFramework();

    //节点变化NodeCache,进行监听操作。
    @Test
    public void create() throws Exception {
        final NodeCache nodeCache = new NodeCache(curatorFramework, "/curator", false);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(() -> System.out.println("节点数据发生变化,变化后的结果" + "--->" + new String(nodeCache.getCurrentData().getData())));
        curatorFramework.setData().forPath("/curator", "菲菲".getBytes());
        curatorFramework.setData().forPath("/curator", "菲菲2".getBytes());
        curatorFramework.setData().forPath("/curator", "菲菲3".getBytes());
        System.in.read();
    }


    @Test
    public void 子节点变化监听事件() throws Exception {
        PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework, "/jay", true);
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
}
