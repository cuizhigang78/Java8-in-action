package Chapter2.p3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName Test
 * @Author cuizhigang
 * @Date 2020/8/7 15:12
 * @Description Test
 * @Version 1.0
 */
public class Test {

    public static final String FILE_PATH = "./src/main/resources/data.txt";

    public static void main(String[] args) throws IOException {
        String result = processFile((BufferedReader br) -> br.readLine());
        System.out.println(result);
    }

    /**
     * 读取第一行
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {
        // 这里使用了Java 7中带资源的try语句，它已经简化了代码，因此你不必显式地关闭资源了
        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_PATH))) {
            return br.readLine();
        }
    }

    /**
     * 读取前两行
     * @return
     * @throws IOException
     */
    public static String processFileTop2() throws IOException {
        // 这里使用了Java 7中带资源的try语句，它已经简化了代码，因此你不必显式地关闭资源了
        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_PATH))) {
            return br.readLine() +"\t" + br.readLine();
        }
    }

    /**
     * 使用函数式接口来传递行为
     * @return
     * @throws IOException
     */
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        return p.process(new BufferedReader(new FileReader(FILE_PATH)));
    }
}
