package Chapter12.p1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * @ClassName LocalDateTest
 * @Author cuizhigang
 * @Date 2020/8/18 13:48
 * @Description LocalDateTest
 * @Version 1.0
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        System.out.println("year = " + year);
        Month month = date.getMonth();
        System.out.println("month = " + month.getValue());
        int day = date.getDayOfMonth();
        System.out.println("day = " + day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        int len = date.lengthOfMonth();
        System.out.println("len = " + len);
        boolean leap = date.isLeapYear();
        System.out.println("leap = " + leap);
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);
        // year = 2014
        // month = 3
        // day = 18
        // dayOfWeek = TUESDAY
        // len = 31
        // leap = false
        // today = 2020-08-18
    }
}
