package Chapter2.p2;

import Chapter1.p1.Apple;

/**
 * @ClassName ApplePredicate
 * @Author cuizhigang
 * @Date 2020/8/7 11:12
 * @Description ApplePredicate 谓词，根据Apple的某些属性，返回一个boolean值
 * @Version 1.0
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
