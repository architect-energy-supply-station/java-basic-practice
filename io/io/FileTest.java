package io;

import java.io.File;
import java.io.IOException;

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
	public static void main(String[] args) throws IOException {

		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/";

		//以当前路径创建一个file对象
		File file = new File(filePath + "test.txt");
		file.createNewFile();

		//获取文件名
		System.out.println("获取文件名: " + file.getName());

		//获取相对路径的父路径
		System.out.println("获取相对路径的父路径: " + file.getParent());

		//获取绝对路径
		System.out.println("获取绝对路径: " + file.getAbsolutePath());

		//获取上一级路径
		System.out.println("获取上一级路径: " + file.getAbsoluteFile().getParent());

		//在当前路径创建临时文件

		File tempFile = File.createTempFile("sun", ".word", new File(filePath));
		System.out.println("在当前路径创建临时文件： " + tempFile.getName());


		//当jvm退出时，自动删除该文件
		tempFile.deleteOnExit();

		//以当前系统时间为文件名创建一个新的文件夹
		File fileDir = new File(String.valueOf(System.currentTimeMillis()));
		System.out.println("以当前系统时间为文件名创建一个新的文件夹");
		fileDir.mkdir();


		//判断文件对象是否存在
		if (file.exists()) {
			System.out.println("判断文件对象是否存在：文件存在");
		}

		//用指定的file对象创建一个文件名为filetest.txt的文件
		File fileTest = new File(filePath + "filetest.txt");
		fileTest.createNewFile();

		//用指定的file对象创建一个文件目录
		File file3 = new File(filePath + "sunshine");
		System.out.println("用指定的file对象创建一个文件目录");
		file3.mkdir();


		//列出当前路径下的所有文件和路径
		File fileDirList = new File(filePath);
		for (String s : fileDirList.list()) {
			System.out.println("列出当前路径下的所有文件和路径: " + s);
		}

		//列出所有的磁盘根路径
		File[] filesRoots = File.listRoots();
		for (File file4 : filesRoots) {
			System.out.println("列出所有的磁盘根路径: "+file4);
		}
	}

}
