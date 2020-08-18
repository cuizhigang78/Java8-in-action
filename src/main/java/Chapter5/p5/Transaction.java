package Chapter5.p5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Transaction
 * @Author cuizhigang
 * @Date 2020/8/12 11:00
 * @Description Transaction
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@ToString
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

}
