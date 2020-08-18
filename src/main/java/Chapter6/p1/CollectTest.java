package Chapter6.p1;

import Chapter6.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @ClassName CollectTest
 * @Author cuizhigang
 * @Date 2020/8/13 10:28
 * @Description CollectTest
 * @Version 1.0
 */
public class CollectTest {

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

        CollectTest test = new CollectTest();
        test.groupingByTest2(menu);
    }

    public void countingTest(List<Dish> menu) {
        //menu.stream().collect(Collectors.counting());
        menu.stream().count();
    }

    public void MaxByAndMinByTest(List<Dish> menu) {
        menu.stream().max(Comparator.comparingInt(Dish::getCalories));
    }
    
    public void groupingByTest(List<Dish> menu) {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        // {
        //     OTHER=[Dish(name=french fries, vegetarian=true, calories=530, type=OTHER), Dish(name=rice, vegetarian=true, calories=350, type=OTHER), Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER), Dish(name=pizza, vegetarian=true, calories=550, type=OTHER)],
        //     FISH=[Dish(name=prawns, vegetarian=false, calories=300, type=FISH), Dish(name=salmon, vegetarian=false, calories=450, type=FISH)],
        //     MEAT=[Dish(name=pork, vegetarian=false, calories=800, type=MEAT), Dish(name=beef, vegetarian=false, calories=700, type=MEAT), Dish(name=chicken, vegetarian=false, calories=400, type=MEAT)]
        // }
        System.out.println(dishesByType);
    }

    public void multiGroupingByTest(List<Dish> menu) {
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByCaloricLevel =
                menu.stream()
                        .collect(
                                groupingBy(Dish::getType,
                                        groupingBy(dish -> {
                                            if (dish.getCalories() <= 400) {
                                                return Dish.CaloricLevel.DIET;
                                            } else if (dish.getCalories() <= 700) {
                                                return Dish.CaloricLevel.NORMAL;
                                            } else {
                                                return Dish.CaloricLevel.FAT;
                                            }
                                        })
                                )
                        );
        //{
        //	OTHER={
        //		NORMAL=[
        //			Dish(name=french fries, vegetarian=true, calories=530, type=OTHER),
        //			Dish(name=pizza, vegetarian=true, calories=550, type=OTHER)
        //			],
        //		DIET=[
        //			Dish(name=rice, vegetarian=true, calories=350, type=OTHER),
        //			Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)
        //			]
        //	},
        //	MEAT={
        //		NORMAL=[
        //			Dish(name=beef, vegetarian=false, calories=700, type=MEAT)
        //		],
        //		DIET=[
        //			Dish(name=chicken, vegetarian=false, calories=400, type=MEAT)
        //		],
        //		FAT=[
        //			Dish(name=pork, vegetarian=false, calories=800, type=MEAT)
        //		]
        //	},
        //	FISH={
        //		NORMAL=[
        //			Dish(name=salmon, vegetarian=false, calories=450, type=FISH)
        //		],
        //		DIET=[
        //			Dish(name=prawns, vegetarian=false, calories=300, type=FISH)
        //		]
        //	}
        //}
        System.out.println(dishesByCaloricLevel);
    }

    public void groupingByTest2(List<Dish> menu) {
        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
        // {OTHER=4, FISH=2, MEAT=3}
        System.out.println(typesCount);
    }
}
