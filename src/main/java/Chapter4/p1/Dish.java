package Chapter4.p1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Dish
 * @Author cuizhigang
 * @Date 2020/8/11 10:46
 * @Description Dish
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Dish {
    private final String name;
    private final Boolean vegetarian;
    private final Integer calories;
    private final Type type;

    public enum Type {
        FISH,
        MEAT,
        OTHER
    }
}
