package Chapter2.p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName FunctionTest
 * @Author cuizhigang
 * @Date 2020/8/7 16:33
 * @Description FunctionTest
 * @Version 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"),
                s -> s.length());
        System.out.println(l);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
