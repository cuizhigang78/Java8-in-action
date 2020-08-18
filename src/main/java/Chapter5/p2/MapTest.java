package Chapter5.p2;

import Chapter5.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName MapTest
 * @Author cuizhigang
 * @Date 2020/8/11 15:56
 * @Description MapTest
 * @Version 1.0
 */
public class MapTest {

    public static void main(String[] args) {
        MapTest test = new MapTest();
        System.out.println(test.flatMapUniqueCharacters());
    }

    public List<String> mapDishes(List<Dish> menu) {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        return dishNames;
    }

    public List<String> flatMapUniqueCharacters() {
        List<String> words = Arrays.asList("hello", "world");
        List<String> uniqueCharacters = words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        return uniqueCharacters;
    }
}
