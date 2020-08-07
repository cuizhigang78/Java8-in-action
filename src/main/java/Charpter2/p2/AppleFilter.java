package Charpter2.p1;

import Charpter1.p1.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AppleFilter
 * @Author cuizhigang
 * @Date 2020/8/7 10:49
 * @Description AppleFilter
 * @Version 1.0
 */
public class AppleFilter {

    // 2.1.1 初试牛刀：筛选绿苹果
    public static List<Apple> filterApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 2.1.2 再展身手，把颜色作为参数
    public static List<Apple> filterApples(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 2.1.2 再展身手，把重量作为参数
    public static List<Apple> filterApples(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
    
    // 2.1.3 第三次尝试：对你能想到的每个属性做筛选
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || !flag && apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
}
