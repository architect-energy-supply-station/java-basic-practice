package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;

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
public class FilesTest {

	//将整个(Files)工具类的方法都操作一遍，自己设计需求
	public static void main(String[] args) throws IOException {
		String pathCopy = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/";

		//首先创建所有不存在的父目录来创建目录
		Path path = Paths.get(pathCopy + "directoriesFiles");
		System.out.println("path: " + path);
		if (!Files.exists(path)) {
			System.out.println("首先创建所有不存在的父目录来创建目录 " + Files.createDirectories(path));
		}

		//创建一个新的目录
		Path path1 = Paths.get(pathCopy + "directoryFiles");
		System.out.println("path1: " + path1);

		if (!Files.exists(path1)) {
			System.out.println("创建一个新的目录 " + Files.createDirectory(path1));
		}

		//创建一个新的空文件
		if (!Files.exists(Paths.get(path + "/newFile.txt"))) {
			Files.createFile(Paths.get(path + "/newFile.txt"));
		}

		//将文件复制到目标文件
		if (!Files.exists(Paths.get(path + "/newFile.txt"))) {
			Files.copy(Paths.get(path + "/newFile.txt"), Paths.get(path1 + "/newFile.txt"));
		}

		//将输入流中的所有字节复制到文件
		String content = "将输入流中的所有字节复制到文件";
		byte[] array = content.getBytes();
		InputStream inputStream = new ByteArrayInputStream(array);
		if (!Files.exists(Paths.get(path1 + "/inputFile.txt"))) {
			Files.copy(inputStream, Paths.get(path1 + "/inputFile.txt"));
		}


		//将文件中的所有字节复制到输出流
		OutputStream outputStream = new ByteArrayOutputStream();
		Files.copy(Paths.get(path + "/newFile.txt"), outputStream);
		System.out.println("将文件中的所有字节复制到输出流：" + outputStream);

		//为现有文件创建新的链接（目录条目） （可选操作）
		if (!Files.exists(Paths.get(path1 + "/inputFile.txt"))) {
			System.out.println("为现有文件创建新的链接： " + Files.createLink(Paths.get(path1 + "/newFile1.txt"), Paths.get(path1 + "/inputFile.txt")));
		}

		//在指定的目录中创建一个新目录，使用给定的前缀生成其名称
		Files.createTempDirectory(path, "zmh");

		//在指定的目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称
		Path tempFile = Files.createTempFile(path, "zmh", "sunshine");

		//删除文件
		Files.delete(tempFile);

		//删除文件（如果存在）
		Files.deleteIfExists(Paths.get(pathCopy + "./existFiles.txt"));

		//返回一个 Stream ，它通过搜索基于给定起始文件的文件树中的文件来懒惰地填充 Path
		//Files.find()

		//返回表示文件所在文件存储区的FileStore
		System.out.println("返回表示文件所在文件存储区的FileStore" + Files.getFileStore(path));

		//读取文件属性的值
		System.out.println("读取文件属性的值: " + Files.getAttribute(Paths.get(path1 + "/inputFile.txt"), "lastModifiedTime"));


		//返回给定类型的文件属性视图
		BasicFileAttributeView fileAttributeView = Files.getFileAttributeView((Paths.get(path1 + "/inputFile.txt")), BasicFileAttributeView.class);
		System.out.println("返回给定类型的文件属性视图: " + fileAttributeView.readAttributes().creationTime());

		//文件的上次修改时间
		System.out.println("文件的上次修改时间: " + Files.getLastModifiedTime(path));

		//返回文件的所有者
		System.out.println("返回文件的所有者: " + Files.getOwner(path));

		//返回文件的POSIX文件权限
		System.out.println("返回文件的POSIX文件权限: " + Files.getPosixFilePermissions(path));


		//测试文件是否是目录
		System.out.println("测试文件是否是目录: " + Files.isDirectory(path));

		//测试文件是否可执行
		System.out.println("测试文件是否可执行: " + Files.isExecutable(path));

		//告知文件是否被隐藏
		System.out.println("告知文件是否被隐藏: " + Files.isHidden(path));

		//测试文件是否可读
		System.out.println("测试文件是否可读: " + Files.isReadable(path));

		//测试文件是否是具有不透明内容的常规文件
		System.out.println("测试文件是否是具有不透明内容的常规文件: " + Files.isRegularFile(path));

		//测试两个路径是否找到相同的文件
		System.out.println("测试两个路径是否找到相同的文件: " + Files.isSameFile(path, path1));

		//测试文件是否是符号链接
		System.out.println("测试文件是否是符号链接: " + Files.isSymbolicLink(path));

		//测试文件是否可写
		System.out.println("测试文件是否可写: " + Files.isWritable(path));


		//从Stream读取文件中的所有行
		Files.lines(Paths.get(path + "/newFile.txt")).forEach(line -> System.out.println("从Stream读取文件中的所有行: " + line));

		//从文件中读取所有行作为Stream
		Files.lines((Paths.get(path + "/newFile.txt")), Charset.forName("UTF-8")).forEach(line -> System.out.println("从文件中读取所有行作为Stream: " + line));

		//返回一个懒惰的填充 Stream ，其元素是 Stream中的条目
		Files.list(path).forEach(path2 -> System.out.println("返回一个懒惰的填充 Stream ，其元素是 Stream中的条目 " + path2));

		//将文件移动或重命名为目标文件
		if (Files.exists(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/test.txt")) && !Files.exists(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/directoriesFiles/test.txt"))) {
			Files.move(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/test.txt"), Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/directoriesFiles/test.txt"));
		}

		//打开一个文件进行阅读，返回一个 BufferedReader以高效的方式从文件读取文本
		System.out.println("打开一个文件进行阅读: " + Files.newBufferedReader(Paths.get(path + "/newFile.txt")).readLine());

		//打开一个文件进行阅读，返回一个 BufferedReader ，可以用来以有效的方式从文件读取文本
		System.out.println("以有效的方式,打开一个文件进行阅读: " + Files.newBufferedReader(Paths.get(path + "/newFile.txt"), Charset.forName("UTF-8")).readLine());

		//打开或创建一个写入文件，返回一个 BufferedWriter ，可以用来以有效的方式将文本写入文件
		System.out.println("以有效的方式将文本写入文件: " + Files.newBufferedWriter(Paths.get(path + "test1.txt"), Charset.forName("UTF-8")));

		//打开或创建一个写入文件，返回一个 BufferedWriter以高效的方式写入文件
		System.out.println("高效的方式打开或创建一个写入文件: " + Files.newBufferedWriter(Paths.get(path + "test1.txt")));

		//打开或创建文件，返回可访问的字节通道以访问该文件
		System.out.println("打开或创建文件，返回可访问的字节通道以访问该文件: " + Files.newByteChannel(Paths.get(path + "test1.txt")).position());

		//打开一个目录，返回一个DirectoryStream以遍历目录中的所有条目。
		System.out.println("打开一个目录，返回一个DirectoryStream以遍历目录中的所有条目: " + Files.newDirectoryStream(path));

		//打开一个目录，返回一个DirectoryStream来迭代目录中的条目。
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path file) throws IOException {
				return (Files.size(file) > 8192L);
			}
		};
		DirectoryStream<Path> paths = null;
		paths = Files.newDirectoryStream(path, filter);
		System.out.println("迭代目录中的条目: " + paths.iterator());

		//打开一个目录，返回一个DirectoryStream来迭代目录中的条目。
		DirectoryStream<Path> paths1 = Files.newDirectoryStream(path, "*.txt");
		System.out.println("打开一个目录，返回一个DirectoryStream来迭代目录中的条目: " + paths1.iterator().hasNext());

		//打开一个文件，返回输入流以从文件中读取。
		System.out.println("打开一个文件，返回输入流以从文件中读取。: " + Files.newInputStream(Paths.get(path + "/newFile.txt")).read());

		//打开或创建文件，返回可用于向文件写入字节的输出流。
		System.out.println("打开或创建文件，返回可用于向文件写入字节的输出流: " + Files.newOutputStream(Paths.get(path + "/newFile.txt")).toString());

		//测试此路径所在的文件是否不存在。
		System.out.println("测试此路径所在的文件是否不存在: " + Files.notExists(Paths.get(path + "/newFile.txt")));
		//探测文件的内容类型。
		System.out.println("探测文件的内容类型: " + Files.probeContentType(Paths.get(path + "/newFile.txt")));

		//读取文件中的所有字节。
		System.out.println("读取文件中的所有字节: " + Files.readAllBytes(Paths.get(path + "/newFile.txt")));

		//从文件中读取所有行。
		System.out.println("从文件中读取所有行: " + Files.readAllLines(Paths.get(path + "/newFile.txt")));

		//从文件中读取所有行。
		System.out.println("从文件中读取所有行: " + Files.readAllLines(Paths.get(path + "/newFile.txt"), Charset.forName("UTF-8")));

		//读取文件的属性作为批量操作。
		System.out.println("读取文件的属性作为批量操作: " + Files.readAttributes(Paths.get(path1 + "/newFile.txt"), BasicFileAttributes.class));

		//读取一组文件属性作为批量操作。
		System.out.println("读取一组文件属性作为批量操作: " + Files.readAttributes(Paths.get(path1 + "/newFile.txt"), "lastModifiedTime"));

		//设置文件属性的值。
		FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
		Files.setAttribute(Paths.get(path1 + "/newFile.txt"), "lastAccessTime", fileTime);

		//更新文件上次修改的时间属性。
		Files.setAttribute(Paths.get(path1 + "/newFile.txt"), "lastModifiedTime", fileTime);

		//更新文件所有者。
		FileOwnerAttributeView ownerView = Files.getFileAttributeView(Paths.get(path1 + "/newFile.txt"), FileOwnerAttributeView.class);
		System.out.println("获取文件的所有者：" + ownerView.getOwner());
		UserPrincipal userPrincipal = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("sunshinezhang");
		System.out.println(userPrincipal);
		ownerView.setOwner(userPrincipal);

		//设置文件的POSIX权限。
		Set<PosixFilePermission> perms = EnumSet.allOf(PosixFilePermission.class);
		System.out.println("设置文件的POSIX权限； " + Files.setPosixFilePermissions(Paths.get(path1 + "/newFile.txt"), perms));

		//返回文件的大小（以字节为单位）。
		System.out.println("返回文件的大小（以字节为单位）:" + Files.size(Paths.get(path1 + "/newFile.txt")));

		//返回一个 Stream ，它通过 Path根据给定的起始文件的文件树懒惰地填充 Path 。
		System.out.println("给定的起始文件" + Files.walk(Paths.get(path1 + "/newFile.txt")));

		//返回一个 Stream ，它是通过走根据给定的起始文件的文件树懒惰地填充 Path 。
		System.out.println("给定的起始文件：" + Files.walk(Paths.get(path1 + "/newFile.txt"), 100));

		//一个文件树。
		Files.walkFileTree(Paths.get(pathCopy), new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				// return super.preVisitDirectory(dir, attrs);
				System.out.println("正在访问：" + dir + "目录");
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				// return super.visitFile(file, attrs);
				System.out.println("\t正在访问" + file + "文件");
				if (file.endsWith("FilesTest.java")) {
					System.out.println("******FilesTest.java******");
					return FileVisitResult.TERMINATE; // 找到了就终止
				}
				return FileVisitResult.CONTINUE; // 没找到继续找
			}

		});


		//将字节写入文件。
		String content1 = "将字节写入文件";
		byte[] array1 = content1.getBytes();
		System.out.println("将字节写入文件: " + Files.write(Paths.get(path1 + "/newFile.txt"), array1));


		//将文本行写入文件。
		ArrayList<String> lines = new ArrayList<>();
		lines.add("今天分享了敲代码的思路和过程");
		Files.write(Paths.get(path1 + "/newFile.txt"), lines, StandardOpenOption.APPEND);//传入枚举对象，打开追加开关

		//将文本行写入文件---乱码
		Files.write(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/outputFile.txt"), lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);//传入枚举对象，打开追加开关
		FileInputStream inputStream1 = new FileInputStream("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/file/outputFile.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream1, "US-ASCII");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("输出: " + bufferedReader.readLine());

	}

}
