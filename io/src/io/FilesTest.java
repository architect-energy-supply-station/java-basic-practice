package io.src.io;

import java.io.*;
import java.nio.file.*;

/**
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 16:07
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class FilesTest {
//    将整个工具类的方法都操作一遍，自己设计需求
public static void main(String[] args) throws IOException {

    File fileSource = new File("/io/src/io/test.java");
//
//    File fileTatget = new File("io/src");
//    try {
//        Path copy = Files.copy(Paths.get(fileSource.getPath()), Paths.get(fileTatget.getPath()), LinkOption.NOFOLLOW_LINKS);
//        System.out.println(copy);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }

    FileInputStream fileInputStream = new FileInputStream(fileSource);

    String pathT = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/io/TestTWO.java";
    String pathO = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/io/Test.java";
    Path pathTwo = Paths.get(pathT);
    Path pathOne = Paths.get(pathO);

    Files.copy(pathOne, pathTwo);


}
}
