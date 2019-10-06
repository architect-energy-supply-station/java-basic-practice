package io;

import java.io.File;
import java.io.FileFilter;

/**
 * https://www.cnblogs.com/demingblog/p/6051834.html
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 15:47
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class FileFilterTest {
    //以lambda表达式实现文件过滤
    public static void main(String[] args) {
        File file = new File("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file");

        FileFilter fileFilter=new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (!pathname.isDirectory()&&pathname.getName().endsWith(".txt")){
                    return true;
                }
                return false;
            }
        };
        File[] files = file.listFiles(fileFilter);
        for (File file1 : files) {
            System.out.println(file1.getName());
        }


    }
}
