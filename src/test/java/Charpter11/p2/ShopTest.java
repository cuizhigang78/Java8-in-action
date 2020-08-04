package Charpter11.p2;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ShopTest
 * @Author Maxwell
 * @Date 2020/8/3 11:03
 * @Description ShopTest
 * @Version 1.0
 */
public class ShopTest {

    /**
     * 使用传统同步API查询价格
     */
    @Test
    public void test1() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        double price = shop.getPrice("my favorite product");
        // 服务响应所需时间
        long invocationTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        System.out.printf("Price is %.2f%n", price);
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 获取程序运行完成时间
        long retrievalTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        /**
         * 运行结果
         *
         * Invocation returned after 1000 msecs
         * Price is 200.29
         * Price returned after 2047 msecs
         */
    }

    /**
     * 使用传统异步API查询价格
     */
    @Test
    public void test2() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        // 服务响应所需时间
        long invocationTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 在计算商品价格
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 获取程序运行完成时间
        long retrievalTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        /**
         * 运行结果
         *
         * Invocation returned after 5 msecs
         * Price is 200.29
         * Price returned after 1036 msecs
         */
    }

    /**
     * 使用传统异步API查询价格
     */
    @Test
    public void test3() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsyncOnException("my favorite product");
        // 服务响应所需时间
        long invocationTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 在计算商品价格
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 获取程序运行完成时间
        long retrievalTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        /**
         * 运行结果
         *
         * Invocation returned after 9 msecs
         * java.util.concurrent.ExecutionException: java.lang.ArithmeticException: / by zeros
         */
    }

    /**
     * 使用传统异步API查询价格
     */
    @Test
    public void test4() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsyncBySupply("my favorite product");
        // 服务响应所需时间
        long invocationTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 在计算商品价格
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 获取程序运行完成时间
        long retrievalTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        /**
         * 运行结果
         *
         * Invocation returned after 9 msecs
         * java.util.concurrent.ExecutionException: java.lang.ArithmeticException: / by zeros
         */
    }


    private void doSomethingElse() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}