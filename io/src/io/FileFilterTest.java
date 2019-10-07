package io.src.io;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 15:47
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class FileFilterTest   {
    //以lambda表达式实现文件过滤

    public static void main(String[] args) {


        File file = new File("io/src/io");
        String s = "FilesTest.java";
        File[] javas = file.listFiles((f) -> !f.isDirectory() && f.getName().endsWith("java"));

        for (File java : javas) {
            System.out.println(java);
        }


    }


}
