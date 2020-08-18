package Chapter10.p3;

import java.util.Optional;

/**
 * @ClassName PersonTest
 * @Author cuizhigang
 * @Date 2020/8/14 14:03
 * @Description PersonTest
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        test.optionalOfNullable();
    }

    public void optionalEmpty() {
        Optional<Car> optionalCar = Optional.empty();
        Car car = optionalCar.get();
        System.out.println(car);
        // java.util.NoSuchElementException: No value present
    }

    public void optionalOf() {
        Car car = null;
        Optional<Car> optionalCar = Optional.of(car);
        // java.util.NoSuchElementException: No value present
    }

    public void optionalOfNullable() {
        Car car = null;
        Optional<Car> optionalCar = Optional.ofNullable(car);
        System.out.println(optionalCar);
        // Optional.empty
    }
}
