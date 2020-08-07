package Charpter2.p1;

import Charpter1.p1.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilterGreenApple
 * @Author cuizhigang
 * @Date 2020/8/7 10:49
 * @Description FilterGreenApple
 * @Version 1.0
 */
public class FilterGreenApple {
    public static void main(String[] args) {

    }

    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
}
