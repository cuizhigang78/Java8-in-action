package Chapter2.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName PredicateTest
 * @Author cuizhigang
 * @Date 2020/8/7 15:55
 * @Description PredicateTest
 * @Version 1.0
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> listOfString = Arrays.asList("", "2", "3");
        List<String> filter = filter(listOfString, s -> !s.isEmpty());
        System.out.println(filter);
    }

    // 原始方法
    public static <T> List<T> filter(List<T> list) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (!((String)s).isEmpty()) {
                results.add(s);
            }
        }
        return results;
    }

    // 使用Predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
