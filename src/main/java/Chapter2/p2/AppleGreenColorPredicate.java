package Chapter2.p2;

import Chapter1.p1.Apple;

/**
 * @ClassName AppleGreenColorPredicate
 * @Author cuizhigang
 * @Date 2020/8/7 11:14
 * @Description AppleGreenColorPredicate
 * @Version 1.0
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
