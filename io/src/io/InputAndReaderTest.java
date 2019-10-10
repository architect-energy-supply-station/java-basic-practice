package io.src.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 15:50
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class InputAndReaderTest {
    String string = "hello";
    //    读取本类文件中的内容，并进行打印
    public static void main(String[] args) throws IOException {
        String pathS = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/ioo/FilesTest.java";
        Path path = Paths.get(pathS);
        List<String> strings = Files.readAllLines(path);
        for (String string : strings) {
            System.out.println(string);
        }


    }
}
