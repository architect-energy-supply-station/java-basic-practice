package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

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
		String pathCopy = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/";

		//首先创建所有不存在的父目录来创建目录
		Path path = Paths.get(pathCopy+"directoriesFiles");
		try {
			if (!Files.exists(path)) {
				System.out.println(Files.createDirectories(path));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//创建一个新的目录
		Path path1 = Paths.get(pathCopy+"directoryFiles");
		try {
			if (!Files.exists(path1)) {
				System.out.println(Files.createDirectory(path1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//创建一个新的和空的文件
		try {
			if (!Files.exists(Paths.get(path + "/newFile.txt"))) {
				Files.createFile(Paths.get(path + "/newFile.txt"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//将文件复制到目标文件
		try {
			if(!Files.exists(Paths.get(path1 + "/newFile.txt"))){
				Files.copy(Paths.get(path + "/newFile.txt"), Paths.get(path1+"/newFile.txt"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//将输入流中的所有字节复制到文件
		String content = "将输入流中的所有字节复制到文件";
		byte[] array = content.getBytes();
		InputStream inputStream = new ByteArrayInputStream(array);
		try {
			if(!Files.exists(Paths.get(path1 + "/inputFile.txt"))){
				Files.copy(inputStream, Paths.get(path1 + "/inputFile.txt"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		//将文件中的所有字节复制到输出流
		OutputStream outputStream = new ByteArrayOutputStream();
		try {
			Files.copy(Paths.get(path + "/newFile.txt"), outputStream);
			System.out.println(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//为现有文件创建新的链接（目录条目） （可选操作）
		try {
			if(!Files.exists(Paths.get(path1 + "/inputFile.txt"))){
				System.out.println(Files.createLink(Paths.get(path1+ "/newFile1.txt"), Paths.get(path1 + "/inputFile.txt")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//在指定的目录中创建一个新目录，使用给定的前缀生成其名称
		try {
			Files.createTempDirectory(path, "zmh");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//在指定的目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称
		try {
			Files.createTempFile(path,"zmh","sunshine");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//删除文件
		File file = new File(pathCopy+"./deleteFile.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.delete(Paths.get(file.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//删除文件（如果存在）
		try {
			Files.deleteIfExists(Paths.get(pathCopy + "./existFiles.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//返回一个 Stream ，它通过搜索基于给定起始文件的文件树中的文件来懒惰地填充 Path
		//Files.find()

		//返回表示文件所在文件存储区的FileStore
		try {
			System.out.println("返回表示文件所在文件存储区的FileStore"+Files.getFileStore(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//读取文件属性的值
		try {
			System.out.println("读取文件属性的值: "+Files.getAttribute(Paths.get(path1 + "/inputFile.txt"), "lastModifiedTime"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//返回给定类型的文件属性视图
		BasicFileAttributeView fileAttributeView = Files.getFileAttributeView((Paths.get(path1 + "/inputFile.txt")), BasicFileAttributeView.class);
		try {
			System.out.println("返回给定类型的文件属性视图: "+fileAttributeView.readAttributes().creationTime());
		} catch (IOException e) {
			e.printStackTrace();
		}

		//文件的上次修改时间
		try {
			System.out.println("文件的上次修改时间: "+Files.getLastModifiedTime(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//返回文件的所有者
		try {
			System.out.println("返回文件的所有者: "+Files.getOwner(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//返回文件的POSIX文件权限
		try {
			System.out.println("返回文件的POSIX文件权限: "+Files.getPosixFilePermissions(path));
		} catch (IOException e) {
			e.printStackTrace();
		}


		//测试文件是否是目录
		System.out.println("测试文件是否是目录: "+Files.isDirectory(path));

		//测试文件是否可执行
		System.out.println("测试文件是否可执行: "+Files.isExecutable(path));

		//告知文件是否被隐藏
		try {
			System.out.println("告知文件是否被隐藏: "+Files.isHidden(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//测试文件是否可读
		System.out.println("测试文件是否可读: "+Files.isReadable(path));

		//测试文件是否是具有不透明内容的常规文件
		System.out.println("测试文件是否是具有不透明内容的常规文件: "+Files.isRegularFile(path));

		//测试两个路径是否找到相同的文件
		try {
			System.out.println("测试两个路径是否找到相同的文件: "+Files.isSameFile(path,path1));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//测试文件是否是符号链接
		System.out.println("测试文件是否是符号链接: "+Files.isSymbolicLink(path));

		//测试文件是否可写
		System.out.println("测试文件是否可写: "+Files.isWritable(path));


		//从Stream读取文件中的所有行
		try {
			System.out.println("从Stream读取文件中的所有行: "+Files.lines(Paths.get(path + "/newFile.txt")).toArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//从文件中读取所有行作为Stream
		try {
			System.out.println("从文件中读取所有行作为Stream"+Files.lines((Paths.get(path + "/newFile.txt")), Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//返回一个懒惰的填充 Stream ，其元素是 Stream中的条目
		try {
			System.out.println("返回一个懒惰的填充 Stream ，其元素是 Stream中的条目"+Files.list(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将文件移动或重命名为目标文件
		try {
			if (Files.exists(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/test.txt"))) {
				Files.move(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/test.txt"), Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/directoriesFiles/test.txt"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开一个文件进行阅读，返回一个 BufferedReader以高效的方式从文件读取文本
		try {
			System.out.println("打开一个文件进行阅读: "+Files.newBufferedReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开一个文件进行阅读，返回一个 BufferedReader ，可以用来以有效的方式从文件读取文本
		try {
			System.out.println("\"以有效的方式,打开一个文件进行阅读:\"+"+Files.newBufferedReader(path, Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开或创建一个写入文件，返回一个 BufferedWriter ，可以用来以有效的方式将文本写入文件
		try {
			Files.newBufferedWriter(Paths.get(path + "test1.txt"), Charset.forName("UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开或创建一个写入文件，返回一个 BufferedWriter以高效的方式写入文件
		try {
			System.out.println("高效的方式打开或创建一个写入文件: "+Files.newBufferedWriter(Paths.get(path + "test1.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开或创建文件，返回可访问的字节通道以访问该文件
		try {
			System.out.println("打开或创建文件，返回可访问的字节通道以访问该文件: "+Files.newByteChannel(Paths.get(path + "test1.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开一个目录，返回一个DirectoryStream以遍历目录中的所有条目。
		try {
			System.out.println("打开一个目录，返回一个DirectoryStream以遍历目录中的所有条目: "+Files.newDirectoryStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开一个目录，返回一个DirectoryStream来迭代目录中的条目。
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path file) throws IOException {
				return (Files.size(file) > 8192L);
			}
		};
		DirectoryStream<Path> paths = null;
		try {
			paths = Files.newDirectoryStream(path, filter);
			System.out.println("迭代目录中的条目: "+paths);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开一个目录，返回一个DirectoryStream来迭代目录中的条目。
		try {
			DirectoryStream<Path> paths1 = Files.newDirectoryStream(path, "*.txt");
			System.out.println(paths1.iterator().hasNext());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开一个文件，返回输入流以从文件中读取。
		try {
			System.out.println("打开一个文件，返回输入流以从文件中读取。: "+Files.newInputStream(Paths.get(path1 + "/newFile.txt")).read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//打开或创建文件，返回可用于向文件写入字节的输出流。
		try {
			System.out.println("打开或创建文件，返回可用于向文件写入字节的输出流: "+Files.newOutputStream(Paths.get(path1 + "/newFile.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//测试此路径所在的文件是否不存在。
		System.out.println("测试此路径所在的文件是否不存在: "+Files.notExists(Paths.get(path1 + "/newFile.txt")));
		//探测文件的内容类型。
		try {
			System.out.println("探测文件的内容类型: "+Files.probeContentType(Paths.get(path1 + "/newFile.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//读取文件中的所有字节。
		try {
			System.out.println("读取文件中的所有字节: "+Files.readAllBytes(Paths.get(path1 + "/newFile.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//从文件中读取所有行。
		try {
			System.out.println("从文件中读取所有行: "+Files.readAllLines(Paths.get(path1 + "/newFile.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//从文件中读取所有行。
		try {
			System.out.println("从文件中读取所有行: "+Files.readAllLines(Paths.get(path1 + "/newFile.txt"),Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//读取文件的属性作为批量操作。
		try {
			System.out.println("读取文件的属性作为批量操作: "+Files.readAttributes(Paths.get(path1 + "/newFile.txt"), BasicFileAttributes.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//读取一组文件属性作为批量操作。
		try {
			System.out.println("读取一组文件属性作为批量操作: "+Files.readAttributes(Paths.get(path1 + "/newFile.txt"), "lastModifiedTime"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		////读取符号链接的目标 （可选操作） 。
		//try {
		//	System.out.println("读取符号链接的目标: "+Files.readSymbolicLink(path));
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		//设置文件属性的值。
		FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
		try {
			Files.setAttribute(Paths.get(path1 + "/newFile.txt"),"lastAccessTime",fileTime);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//更新文件上次修改的时间属性。
		try {
			Files.setAttribute(Paths.get(path1 + "/newFile.txt"),"lastModifiedTime",fileTime);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//更新文件所有者。
		//UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
		//try {
		//	UserPrincipal joe = lookupService.lookupPrincipalByName("joe");
		//	System.out.println("更新文件所有者: "+Files.setOwner(path, joe));
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}

		//设置文件的POSIX权限。
		Set<PosixFilePermission> perms = EnumSet.allOf(PosixFilePermission.class);
		try {
			System.out.println("设置文件的POSIX权限； "+Files.setPosixFilePermissions(Paths.get(path1 + "/newFile.txt"), perms));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回文件的大小（以字节为单位）。
		try {
			System.out.println("返回文件的大小（以字节为单位）:"+Files.size(Paths.get(path1 + "/newFile.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回一个 Stream ，它通过 Path根据给定的起始文件的文件树懒惰地填充 Path 。
		try {
			System.out.println("给定的起始文件"+Files.walk(Paths.get(path1 + "/newFile.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回一个 Stream ，它是通过走根据给定的起始文件的文件树懒惰地填充 Path 。
		try {
			System.out.println("给定的起始文件："+Files.walk(Paths.get(path1 + "/newFile.txt"), 100));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//一个文件树。
		//walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor)

		//Files.walkFileTree(path,EnumSet.noneOf(FileVisitOption.class));
		//走一个文件树。
		//将字节写入文件。
		String content1 = "将字节写入文件";
		byte[] array1 = content1.getBytes();

		try {
			System.out.println("将字节写入文件: "+Files.write(Paths.get(path1 + "/newFile.txt"), array1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将文本行写入文件。
		//Path path1 = Paths.get(filePath + "sun8776085306107926734.word");



		ArrayList<String> lines;
		lines = new ArrayList<>();
		lines.add("上午好 ");

		Set<String> lines2 = new HashSet<>();
		lines2.add("bill");



		try {
			Files.write(Paths.get(path1 + "/newFile.txt"), lines, StandardOpenOption.APPEND);//传入枚举对象，打开追加开关
		} catch (IOException e) {
			e.printStackTrace();
		}


		try {
			FileOutputStream fos = new FileOutputStream("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/outputFile.txt");
		 OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		 osw.write("你好");
		 osw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Files.write(Paths.get("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/outputFile.txt"), lines,Charset.forName("UTF-8"), StandardOpenOption.APPEND);//传入枚举对象，打开追加开关
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileInputStream inputStream1 = new FileInputStream("/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/outputFile.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream1, "ISO-8859-1");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		System.out.println("输出: "+bufferedReader.readLine());
		//		    //创建字节输出流，绑定数据文件
//        FileOutputStream fos=new FileOutputStream("d:\\demo\\gbk.txt");
//        //创建转换流对象，构造方法，绑定字节输出流
//        OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");
//        //转换流写数据
//        osw.write("你好");
//        osw.close();

		//Files.write(Paths.get(path1 + "/newFile.txt"),context2,StandardCharsets.UTF_8,LinkOption.NOFOLLOW_LINKS );
		//将文本行写入文件。,chars,

	}

}
