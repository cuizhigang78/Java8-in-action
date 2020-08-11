package Chapter2.p2;

import Chapter1.p1.Apple;

/**
 * @ClassName AppleFancyFormatter
 * @Author cuizhigang
 * @Date 2020/8/7 11:40
 * @Description AppleFancyFormatter
 * @Version 1.0
 */
public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
