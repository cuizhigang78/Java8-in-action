package chapter5.p5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Trader
 * @Author cuizhigang
 * @Date 2020/8/12 10:59
 * @Description Trader
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trader {
    private String name;
    private String city;
}
