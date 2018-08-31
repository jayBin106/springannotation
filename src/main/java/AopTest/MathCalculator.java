package AopTest;

/**
 * 逻辑计算类
 * Created by lenovo on 2018/8/31.
 */
public class MathCalculator {
    public int count(int i, int j) {
        System.out.println("方法进行中。。。");
        return i / j;
    }
}
