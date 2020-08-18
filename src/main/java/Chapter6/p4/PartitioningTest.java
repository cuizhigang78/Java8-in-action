package Chapter6.p4;

import Chapter6.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @ClassName PartitioningTest
 * @Author cuizhigang
 * @Date 2020/8/13 13:59
 * @Description PartitioningTest
 * @Version 1.0
 */
public class PartitioningTest {

    private List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    /**
     * 区分素食和非素食
     */
    @Test
    public void partitionedMenu() {
        Map<Boolean, List<Dish>> result = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(result);
    }

    /**
     * 区分质数和非质数
     */
    @Test
    public void partitionedPrimes() {
        int n = 100;
        Map<Boolean, List<Integer>> result = IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(this::isPrime)
                );
        System.out.println(result);
    }

    /**
     * 判断是否为质数
     * @param candidate
     * @return
     */
    public boolean isPrime(int candidate) {
        // 产生一个自然数范围，从2开始，直至但不包括待测数的平方根
        // 如果待测数字不能被流中任何数字整除，则返回true
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }
}
