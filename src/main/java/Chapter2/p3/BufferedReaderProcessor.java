package Chapter2.p3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @ClassName BufferedReaderProcessor
 * @Author cuizhigang
 * @Date 2020/8/7 15:33
 * @Description BufferedReaderProcessor
 * @Version 1.0
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader br) throws IOException;
}
