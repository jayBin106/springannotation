package mic_zookeeper.curator.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class CuratorLockWatcher implements Watcher{

    private CountDownLatch latch;

    public CuratorLockWatcher(CountDownLatch latch) {
        this.latch = latch;
    }

    public void process(WatchedEvent event) {
        if(event.getType()== Event.EventType.NodeDeleted){
            latch.countDown();
        }
    }
}
