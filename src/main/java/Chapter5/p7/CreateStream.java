package Chapter5.p7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName CreateStream
 * @Author cuizhigang
 * @Date 2020/8/12 14:18
 * @Description CreateStream
 * @Version 1.0
 */
public class CreateStream {

    public static void main(String[] args) {
        CreateStream c = new CreateStream();
        c.createStreamByFunction3();
    }

    public void createStreamByValue() {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }

    public void createStreamByArray() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }

    public void createStreamByFile() {
        // 你可以使用Files.lines得到一个流，其中的每个元素都对应文件中的一行
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("./src/main/resources/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {

        }
        System.out.println(uniqueWords);
    }

    public void createStreamByFunction() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    public void createStreamByFunction2() {
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    public void createStreamByFunction3() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
