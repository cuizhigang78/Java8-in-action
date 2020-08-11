package Chapter2.p2;

import Chapter1.p1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AppleFilter
 * @Author cuizhigang
 * @Date 2020/8/7 10:49
 * @Description AppleFilter
 * @Version 1.0
 */
public class AppleFilter {

    public static void main(String[] args) {
        Apple apple1 = new Apple("green", 120);
        Apple apple2 = new Apple("red", 200);
        List<Apple> apples = Arrays.asList(apple1, apple2);
        List<Apple> result = filterApples(apples, new AppleHeavyWeightPredicate());
        System.out.println(result);

        prettyPrintApple(apples, new AppleFancyFormatter());
    }
    
    // 第四次尝试：根据抽象条件筛选
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
