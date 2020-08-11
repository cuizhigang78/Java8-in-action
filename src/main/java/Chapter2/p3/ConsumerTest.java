package Chapter2.p3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName ConsumerTest
 * @Author cuizhigang
 * @Date 2020/8/7 16:25
 * @Description ConsumerTest
 * @Version 1.0
 */
public class ConsumerTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        forEach(list, (Integer i) -> System.out.println(i));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }
}
