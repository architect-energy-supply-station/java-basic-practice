package io;

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
	public static void main(String[] args) {
		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/";
		Path sourcePath= Paths.get(filePath+"filetest.txt");
		Path targetPath= Paths.get(filePath+"source/"+"filetest.txt");

		try {
			if (!Files.exists(targetPath)) {
				System.out.println("目标文件的路径: "+Files.copy(sourcePath, targetPath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
