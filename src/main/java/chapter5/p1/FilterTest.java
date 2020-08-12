package chapter5.p1;

import chapter5.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName FilterTest
 * @Author cuizhigang
 * @Date 2020/8/11 15:38
 * @Description FilterTest
 * @Version 1.0
 */
public class FilterTest {

    public List<Dish> filterByPredicate(List<Dish> menu) {
        List<Dish> vegetarianMenu =
                menu.stream().filter(Dish::isVegetarian).collect(toList());
        return vegetarianMenu;
    }

    public void filterByDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public List<Dish> filterByLimit(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());
        return dishes;
    }

    public List<Dish> filterBySkip(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());
        return dishes;
    }
}
