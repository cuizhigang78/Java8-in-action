package Chapter2.p2;

import Chapter1.p1.Apple;

/**
 * @ClassName AppleHeavyWeightPredicate
 * @Author cuizhigang
 * @Date 2020/8/7 11:14
 * @Description AppleHeavyWeightPredicate
 * @Version 1.0
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
