package Chapter4.p4;

import Chapter4.p1.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName DishFilter
 * @Author cuizhigang
 * @Date 2020/8/11 10:45
 * @Description DishFilter
 * @Version 1.0
 */
public class DishFilter {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
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

        DishFilter filter = new DishFilter();
        List<String> list = filter.filterThreeHighCaloricDishes(menu);
        System.out.println(list);
        // 运行结果
        // filtering pork
        // mapping pork
        // filtering beef
        // mapping beef
        // filtering chicken
        // mapping chicken
        // [pork, beef, chicken]
    }

    public List<String> filterThreeHighCaloricDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }

}












































