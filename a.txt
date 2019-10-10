package io.src.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static java.io.File.createTempFile;

/**
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 15:19
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class FileTest {
    public static void main(String[] args) {
//        以当前路径创建一个file对象
        File file = new File("io/src/io");
        File fileT = new File("io/src/ioo");
        System.out.println("filed对象"+file);

        try {
            String ss = "Writer";
            createTempFile(ss, ".java",fileT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  获取文件名
//        String[] strings = file.list();
//        System.out.println("文件名"+strings);
        String name = file.getName();
        System.out.println("文件名"+name);



//        获取相对路径的父路径
        String parent = file.getParent();
        System.out.println("相对路径的父路径"+parent);


//        获取绝对路径
        System.out.println("获取绝对路径"+file.getAbsolutePath());


//    获取上级路径
        System.out.println("获取上级路径"+file.getParentFile());



//        在当前路径创建临时文件--------????
        try {
            boolean createNewFile= file.createNewFile();
            System.out.println("临时文件为"+createNewFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


//    当jvm退出时，自动删除该文件
//        file.deleteOnExit();


        // 以当前系统时间为文件名创建一个新的文件夹

//判断文件对象是否存在
        System.out.println(file.exists());
//用指定的file对象创建一个文件名为filetest.txt的文件--------?????
        try {
            Date date = new Date();
            String s = date.toString();

            File iotext = createTempFile("test", ".java", file);
        } catch (IOException e) {
            e.printStackTrace();
        }


//用指定的file对象创建一个文件目录
        fileT.mkdir();


//列出当前路径下的所有文件和路径

        String[] list = file.list();
        for (String s : list) {
            System.out.println("当前io文件下有："+s);
        }
//        列出所有的磁盘根路径
        File[] files = File.listRoots();
        for (File file1 : files) {
            System.out.println(file1);
//            System.out.println(file1.list());
        }
    }




}
