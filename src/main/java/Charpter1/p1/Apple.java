package Charpter1.p1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName Apple
 * @Author Maxwell
 * @Date 2020/8/4 17:10
 * @Description Apple
 * @Version 1.0
 */
@Data
public class Apple {

    private String color;
    private Integer weight;
    // 存货
    private List<Apple> inventory;

    public Apple(String color, Integer weight) {
        super();
        this.color = color;
        this.weight = weight;
    }

    public static void main(String[] args) {
        Apple greenApple = new Apple("green", 100);
        Apple redApple = new Apple("red", 200);
        List<Apple> inventory = Arrays.asList(greenApple, redApple);

        List<Apple> result;

        result = Apple.filterGreenApples(inventory);
        result = Apple.filterHeavyApples(inventory);

        result = Apple.filtersApples(inventory, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return isGreenApple(apple);
            }
        });

        result = Apple.filtersApples(inventory, (Apple a) -> a.getWeight() > 150);

        result = Apple.filtersApples(inventory, (Apple a) -> a.getWeight() > 80 || "red".equals(a.getColor()));

        result = Apple.filterGreenApples(inventory);
        result = Apple.filterHeavyApples(inventory);

        System.out.println(result);
    }

    /**
     * 筛选出绿苹果
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选出重量大于150的苹果
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 判断是否绿苹果
     * @param apple
     * @return
     */
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    /**
     * 判断苹果重量是否超过150
     * @param apple
     * @return
     */
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    // 写出来是为了清晰，正常只要从java.util.function导入就可以了
    public interface Predicate<T> {
        boolean test(T t);
    }

    static List<Apple> filtersApples(List<Apple> inventory, Predicate<Apple> p) {
        // 方法作为Predicate参数p传递进去（见附注栏“什么是谓词？”）
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
