package Chapter4.p3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName IterateOnce
 * @Author cuizhigang
 * @Date 2020/8/11 13:48
 * @Description IterateOnce
 * @Version 1.0
 */
public class IterateOnce {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "8", "in", "action");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
        // 运行结果
        // Java
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // 8
        //	at java.util.stream.AbstractPipeline.sourceStageSpliterator(AbstractPipeline.java:279)
        // in
        //	at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:580)
        // action
        //	at Chapter4.p3.IterateOnce.main(IterateOnce.java:20)
    }
}