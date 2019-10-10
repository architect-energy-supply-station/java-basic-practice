package io.src.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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
public class InsertContentTest {
 public static void main(String[] args) throws IOException {
//    向指定的文件，指定位置，插入指定内容
  String pathT = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/ioTest/FilesTest.txt";
  RandomAccessFile randomAccessFile = new RandomAccessFile(new File(pathT), "rw");
  long length = randomAccessFile.length();
  System.out.println(length);
//  randomAccessFile.seek();


//    向指定的文件，指定位置，替换内容（要求中文输入）,实现乱码效果

 }


}

