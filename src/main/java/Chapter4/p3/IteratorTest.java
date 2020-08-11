package Chapter4.p3;

import Chapter4.p1.Dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName IteratorTest
 * @Author cuizhigang
 * @Date 2020/8/11 13:57
 * @Description IteratorTest
 * @Version 1.0
 */
public class IteratorTest {
    /**
     * 使用for-each的外部迭代
     * @param menu
     */
    public List<String> outerIterate1(List<Dish> menu) {
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
        return names;
    }

    /**
     * 使用iterator的外部迭代
     * @param menu
     */
    public List<String> outerIterate2(List<Dish> menu) {
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            names.add(iterator.next().getName());
        }
        return names;
    }

    /**
     * 使用流的内部迭代
     * @param menu
     */
    public List<String> innerIterate(List<Dish> menu) {
        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        return names;
    }
}
