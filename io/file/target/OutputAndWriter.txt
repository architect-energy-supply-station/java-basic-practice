package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	public static void main(String[] args) throws IOException {
		String inPutPath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/io/OutputAndWriter.java";
		String outPutPath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/target/OutputAndWriter.txt";

		File file1 = new File(outPutPath);
		if (!file1.exists()) {
			file1.createNewFile();
		}

		FileInputStream fileInputStream = new FileInputStream(inPutPath);
		FileOutputStream fileOutputStream = new FileOutputStream(outPutPath);

		byte[] bytes = new byte[32];
		int hasRead=0;
		while ((hasRead = fileInputStream.read(bytes)) > 0) {
			fileOutputStream.write(bytes,0,hasRead);
		}
		fileInputStream.close();
		fileOutputStream.close();

	}
}
