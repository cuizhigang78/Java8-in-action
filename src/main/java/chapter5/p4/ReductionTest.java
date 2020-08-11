package chapter5.p4;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ReductionTest
 * @Author cuizhigang
 * @Date 2020/8/11 16:50
 * @Description ReductionTest 归约
 * @Version 1.0
 */
public class ReductionTest {

    public void  sumByReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().reduce(0, (a, b) -> a + b);
    }

    public void  maxByReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().reduce(0, Integer::max);
    }
}
