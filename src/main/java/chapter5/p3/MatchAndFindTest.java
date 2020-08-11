package chapter5.p3;

import chapter5.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @ClassName MatchAndFindTest
 * @Author cuizhigang
 * @Date 2020/8/11 16:29
 * @Description MatchAndFindTest
 * @Version 1.0
 */
public class MatchAndFindTest {

    public void matchByAnyMatch(List<Dish> menu) {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is vegetarian friendly!");
        }
    }

    public void matchByAllMatch(List<Dish> menu) {
        boolean isHealthy = menu.stream().allMatch((dish) -> dish.getCalories() < 1000);
    }

    public void matchByNoneMatch(List<Dish> menu) {
        boolean isHealthy = menu.stream().noneMatch((dish) -> dish.getCalories() >= 1000);
    }

    public void findByFindAny(List<Dish> menu) {
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }

    public void findByFindFirst() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        // 找到第一个平方能被3整除的数的平方
        Optional<Integer> first = someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();
    }
}
