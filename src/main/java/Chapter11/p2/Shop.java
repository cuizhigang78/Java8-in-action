package Chapter11.p2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @ClassName Shop
 * @Author Maxwell
 * @Date 2020/8/3 10:48
 * @Description Shop
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    private String shopName;

    /**
     * 依据指定产品名称返回价格
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 依据指定产品名称返回价格(异步地)
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        // 创建CompletableFuture对象，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // 在另一个线程中以异步方式执行计算
        new Thread(() -> {
            double price = calculatePrice(product);
            // 需长时间计算的任务结束并得出结果时，设置Future的返回值
            futurePrice.complete(price);
        }).start();
        // 无需等待还没结束的计算，直接返回Future对象
        return futurePrice;
    }

    /**
     * 依据指定产品名称返回价格(异步地)
     * ps 最终版
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncOnException(String product) {
        // 创建CompletableFuture对象，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // 在另一个线程中以异步方式执行计算
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                System.out.println(1);
                // 需长时间计算的任务结束并得出结果时，设置Future的返回值
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        // 无需等待还没结束的计算，直接返回Future对象
        return futurePrice;
    }

    /**
     * 使用工厂方法创建CompletableFuture对象
     * ps 完全等价于 getPriceAsyncOnException
     * ps 最终简化版
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncBySupply(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    /**
     * 计算价格
     * @param product
     * @return
     */
    public double calculatePrice(String product) {
        // 引入一个模拟的延迟
        delay();
        // 依据产品的名称，生成一个随机值作为价格
        int i = 1/0;
        Random random = new Random(43);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 模拟1秒钟延迟的方法
     */
    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
