package Chapter5.p5;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @ClassName TransactionCenter
 * @Author cuizhigang
 * @Date 2020/8/12 11:05
 * @Description TransactionCenter
 * @Version 1.0
 */
public class TransactionCenter {

    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    private List<Transaction> transactions = asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        TransactionCenter center = new TransactionCenter();
        //System.out.println(center.findTransactionBy2011());
        // System.out.println(center.findCities());
        // System.out.println(center.findTradersByCambridge());
        // System.out.println(center.findAllTraderNames());
        // System.out.println(center.hasWorkInMilan());
        // center.printCambridgeTraderValue();
        // System.out.println(center.maxValue());
        System.out.println(center.minTransaction());
    }

    /**
     * 找到2011年所有交易并按交易额排序
     * @return
     */
    public List<Transaction> findTransactionBy2011() {
        List<Transaction> result = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparingInt(Transaction::getValue))
                .collect(toList());
        return result;
    }

    /**
     * 交易员都在哪些不同的城市工作过
     * @return
     */
    public List<String> findCities() {
        List<String> result = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        return result;
    }

    /**
     * 查找所有来自于剑桥的交易员，交按姓名排序
     * @return
     */
    public List<Trader> findTradersByCambridge() {
        List<Trader> result = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getCity))
                .collect(toList());
        return result;
    }

    /**
     * 返回所有交易员的姓名字符串，按字母排序
     * @return
     */
    public String findAllTraderNames() {
        String result = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                //.reduce("", (s1, s2) -> s1 + s2);
                .collect(joining());
        return result;
    }

    /**
     * 有没有交易员在米兰工作的
     * @return
     */
    public boolean hasWorkInMilan() {
        boolean result = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        return result;
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    public void printCambridgeTraderValue() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * 所有交易中，最高的交易额是多少
     * @return
     */
    public int maxValue() {
        Optional<Integer> result = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        return result.get();
    }

    /**
     * 所有交易中，最高的交易额是多少
     * @return
     */
    public Transaction minTransaction() {
        Optional<Transaction> result = transactions.stream()
                .min(comparing(Transaction::getValue));
        return result.get();
    }
}
