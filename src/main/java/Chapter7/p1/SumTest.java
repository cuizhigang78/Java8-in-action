package Chapter7.p1;

import java.util.function.UnaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @ClassName SumTest
 * @Author cuizhigang
 * @Date 2020/8/13 14:35
 * @Description SumTest
 * @Version 1.0
 */
public class SumTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = parallelSum(1000000);
        long end = System.currentTimeMillis();
        System.out.println(sum + "耗时： " + (end - start) + " ms");
    }

    /**
     * 1-n 求和
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        Long resutl = Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
        return resutl;
    }

    /**
     * 1-n 求和
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        Long resutl = Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
        return resutl;
    }
}
