package Charpter11.p1;

import java.util.concurrent.*;

/**
 * @ClassName Test
 * @Author Maxwell
 * @Date 2020/8/3 10:27
 * @Description TestFuture
 * @Version 1.0
 */
public class TestFuture {

    public static void main(String[] args) {
        // 创建ExecutorService，通过它你可以向线程池提交任务
        ExecutorService executor = Executors.newCachedThreadPool();
        // 向ExecutorService提交一个Callable对象
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() {
                // 以异步方式在新的线程中执行耗时的操作
                return doSomeLongComputation();
            }
        });
        // 异步操作进行的同时，可以做其他事
        doSomethingElse();

        try {
            // 获取异步操作的结果，如果最终被阻塞，无法得到结果，那么最多等待1秒钟之后退出
            Double result = future.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // 当前线程在等待过程中被中断
            e.printStackTrace();
        } catch (ExecutionException e) {
            // 计算抛出一个异常
            e.printStackTrace();
        } catch (TimeoutException e) {
            // 在Future对象完成之前超过已过期
            e.printStackTrace();
        }
    }

    private static Double doSomeLongComputation() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("doSomeLongComputation");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0.1D;
    }

    private static void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}
