package io.src.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

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
public class OutputAndWriter {
//    通过复制本类的内容创建一个同名的同内容的txt文件
public static void main(String args[]) throws IOException {

    String pathT = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/io";
    String pathO = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src";
    Path pathTwo = Paths.get(pathT);
    Path pathOne = Paths.get(pathO);
//复制文件到目标文件
//    Files.copy(pathOne, pathTwo.resolve(pathOne.getFileName()),REPLACE_EXISTING);

    String pathValue = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/io/test.java";
    Path pathva = Paths.get(pathValue);
    Object attribute = Files.getAttribute(pathva,"", LinkOption.NOFOLLOW_LINKS);
    System.out.println(attribute);

}


}
