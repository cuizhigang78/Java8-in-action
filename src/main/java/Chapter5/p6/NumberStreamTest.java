package Chapter5.p6;

import Chapter5.Dish;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName NumberStreamTest
 * @Author cuizhigang
 * @Date 2020/8/12 14:06
 * @Description NumberStreamTest
 * @Version 1.0
 */
public class NumberStreamTest {
    /**
     * 计算热量总和
     * @param menu
     * @return
     */
    public int sum(List<Dish> menu) {
        int result = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        return result;
    }

    /**
     * 把原始流转换成一般流
     * @param menu
     */
    public void box(List<Dish> menu) {
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    }

    /**
     * 计算热量最大值
     * @param menu
     * @return
     */
    public int max(List<Dish> menu) {
        OptionalInt max = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        // 如果没有最大值，显式提供一个默认最大值
        return max.orElse(1);
    }
}
