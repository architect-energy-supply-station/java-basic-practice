package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 16:09
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class FileAttributeViewTest {
	//指定自己某个路径上的任意一个文件，读取并且修改其中的属性（创建时间，创建人，，，，，）
	public static void main(String[] args) {
		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/sunshine.txt";

		Path path = Paths.get(filePath);

		//读取文件的属性---修改前
		try {
			BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			System.out.println("文件创建时间： "+fileAttributes.creationTime());
			System.out.println("是否是目录： "+fileAttributes.isDirectory());
			System.out.println("文件的唯一标识： "+fileAttributes.fileKey());
			System.out.println("文件是否是常规文件： "+fileAttributes.isOther());
			System.out.println("是否是具有不透明内容的常规文件： "+fileAttributes.isRegularFile());
			System.out.println("文件是否是符号链接： "+fileAttributes.isSymbolicLink());
			System.out.println("上一次访问的时间： "+fileAttributes.lastAccessTime());
			System.out.println("上次修改的时间： "+fileAttributes.lastModifiedTime());
			System.out.println("文件的大小： "+fileAttributes.size());
		} catch (IOException e) {
			e.printStackTrace();
		}


		//修改文件的属性
		FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
		try {
			Files.setAttribute(path,"lastAccessTime",fileTime);
			Files.setAttribute(path,"basic:lastModifiedTime",fileTime);
		} catch (IOException e) {
			e.printStackTrace();
		}


		System.out.println("-----------------------读取修改后的文件属性---------------------");
		try {
			BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			System.out.println("文件创建时间： "+fileAttributes.creationTime());
			System.out.println("是否是目录： "+fileAttributes.isDirectory());
			System.out.println("文件的唯一标识： "+fileAttributes.fileKey());
			System.out.println("文件是否是常规文件： "+fileAttributes.isOther());
			System.out.println("是否是具有不透明内容的常规文件： "+fileAttributes.isRegularFile());
			System.out.println("文件是否是符号链接： "+fileAttributes.isSymbolicLink());
			System.out.println("上一次访问的时间： "+fileAttributes.lastAccessTime());
			System.out.println("上次修改的时间： "+fileAttributes.lastModifiedTime());
			System.out.println("文件的大小： "+fileAttributes.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
