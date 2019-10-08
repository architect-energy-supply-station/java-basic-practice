package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * 理解有误
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
		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/test.txt";

		//向指定的文件，指定位置，插入指定内容
		String context = "我今天好开心啊";
		RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
		randomAccessFile.seek(20);
		randomAccessFile.write(("追加的内容是："+context).getBytes());




		//向指定的文件，指定位置，替换内容（要求中文输入）,实现乱码效果---编程思想
		//FileOutputStream fos = new FileOutputStream("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/outputFile1.txt");
		//OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//osw.write("你好啊今天分享了敲代码的思路和过程");
		//osw.close();

		File temp = File.createTempFile("sun",null);
		temp.deleteOnExit();

		RandomAccessFile randomAccessFile1 = new RandomAccessFile(filePath, "rw");

		//使用临时文件来保存插入后的数据
		FileOutputStream temOut = new FileOutputStream(temp);
		FileInputStream temIn = new FileInputStream(temp);

		randomAccessFile1.seek(45);
		byte[] bbuf = new byte[64];
		//用于保存实际读取的字节数
		int hasRead=0;

		//使用循环方式读取插入后点后的数据
		while ((hasRead = randomAccessFile1.read(bbuf)) > 0) {
			temOut.write(bbuf, 0, hasRead);
		}
		//下面代码用于插入内容
		String context1 = "读取一组文件属性作为批量操作";

		randomAccessFile1.seek(45);
		randomAccessFile1.write(context1.getBytes());

		while ((hasRead = temIn.read(bbuf)) > 0) {
			randomAccessFile1.write(bbuf, 0, hasRead);
		}
	}

}

