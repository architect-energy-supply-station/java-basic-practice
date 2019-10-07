package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

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
	public static void main(String[] args) throws IOException {
		//读取本类文件中的内容，并进行打印
		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/io/InputAndReaderTest.java";
		FileInputStream fileInputStream = new FileInputStream(filePath);

		System.setIn(fileInputStream);
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");

		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}

		fileInputStream.close();
	}

}
