package Chapter10.p3;

import lombok.Data;
import lombok.ToString;

import java.util.Optional;

/**
 * @ClassName Car
 * @Author cuizhigang
 * @Date 2020/8/14 14:00
 * @Description Car
 * @Version 1.0
 */
@Data
@ToString
public class Car {
    private Optional<Insurance> insurance;
}
