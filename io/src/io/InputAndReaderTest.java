package io.src.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream("io/src/io/Sat Oct 05 20:53:50 CST 20198168935797560705999.txt");
//            try {
//                System.out.println("输入流中有字节数"+fileInputStream.available());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            FileOutputStream fileOutputStream = new FileOutputStream("io/src/io/Sat Oct 05 20:53:50 CST 20198168935797560705999.txt");
//
//            System.out.println(fileInputStream.markSupported());
//            byte[] bytes = new byte[10];
//            int i = 0;
//            int index = 0;
//
//            try {
//                i = fileInputStream.read(bytes);
//                while (i != -1) {
//                    bytes[index] = (byte) i;
//                    index++;
//                }
//
//                String s = new String(bytes,0,50);
//                System.out.println(s);
////                System.out.println(bytes);
////                try {
////                    fileOutputStream.write(bytes);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//                bytes.clone();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        String pathS = "/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/ioo/FilesTest.java";
        Path path = Paths.get(pathS);


        List<String> strings = Files.readAllLines(path);
        for (String string : strings) {
            System.out.println(string);
        }


    }
}
