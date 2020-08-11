package Chapter4.p1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
        List<String> list = null;
        list = filter.filterLowCaloricDishes7(menu);
        System.out.println(list);
        list = filter.filterLowCaloricDishes8(menu);
        System.out.println(list);
    }

    /**
     * 使用Java 7筛选低热量菜肴
     * @param menu
     * @return
     */
    public List<String> filterLowCaloricDishes7(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesNames = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesNames.add(dish.getName());
        }
        return lowCaloricDishesNames;
    }

    /**
     * 使用Java 8筛选低热量菜肴
     * @param menu
     * @return
     */
    public List<String> filterLowCaloricDishes8(List<Dish> menu) {
        List<String> lowCaloricDishesNames = menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        return lowCaloricDishesNames;
    }

    /**
     *
     * @param menu
     * @return
     */
    public List<String> filterThreeHighCaloricDishes(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
    }

}












































