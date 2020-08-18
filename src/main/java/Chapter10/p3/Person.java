package Chapter10.p3;

import lombok.Data;

import java.util.Optional;

/**
 * @ClassName Person
 * @Author cuizhigang
 * @Date 2020/8/14 14:00
 * @Description Person
 * @Version 1.0
 */
@Data
public class Person {
    private Optional<Car> car;
}
