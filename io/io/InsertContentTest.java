package io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

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

	public static void main(String[] args) {
		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/";
		Path path = Paths.get(filePath + "test.txt");

		//向指定的文件，指定位置，插入指定内容
		String content = "向指定的文件，指定位置，插入指定内容";
		byte[] array = content.getBytes();

		try {
			System.out.println("插入指定内容的路径: "+Files.write(path, array));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//向指定的文件，指定位置，替换内容（要求中文输入）,实现乱码效果
		Path path1 = Paths.get(filePath + "sun8776085306107926734.word");

		String context1 = "向指定的文件，指定位置，替换内容（要求中文输入）,实现乱码效果";
		char[] chars = context1.toCharArray();
		//Path write = Files.write(path1,chars, StandardCharsets.US_ASCII, LinkOption.valueOf("link"));


	}

}

