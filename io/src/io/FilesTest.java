package io.src.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
//    将整个工具类的方法都操作一遍，自己设计需求
public static void main(String[] args) throws IOException {


    String nameOne="/Users/cookr/cookFile/WorkSpace/java-basic-practice/io/src/io";
    Path path3 = Paths.get(nameOne);
    Path pathOne = Paths.get(nameOne+"FilesTest");
    System.out.println("pathOne路径：" + pathOne);
    if (!Files.exists(pathOne)) {
        System.out.println("首先创建所有不存在的父目录来创建目录。" + Files.createDirectories(pathOne));
    }

    Path pathTwo = Paths.get(nameOne + "Test");
    System.out.println("pathTwo路径" + pathTwo);
    if (!Files.exists(pathTwo)) {
        System.out.println("创建一个新的目录" + Files.createDirectory(pathTwo));
    }


    Path path1 = Paths.get(pathOne + "/FilesTest.txt");
    if (!Files.exists(path1)) {
        System.out.println("创建一个新的和空的文件" + Files.createFile(path1));
    }

    Path path2 = Paths.get(pathTwo  +"/FilesTest.txt");

//  两个path都是文件才可成功
    if (!Files.exists(path2)) {
        System.out.println("为现有文件创建新的链接（目录条目） （可选操作）" + Files.createLink( path2,Paths.get(nameOne+"/FilesTest.java")));
    }

//    创建到目标的符号链接 （可选操作）
//    System.out.println("创建到目标的符号链接（可选操作）" + Files.createSymbolicLink( Paths.get(pathOne+"/FilesTestTwo.txt"),Paths.get(nameOne+"/FilesTestTwo.java")));

//    System.out.println("在指定的目录中创建一个新目录，使用给定的前缀生成其名称" + Files.createTempDirectory(pathTwo,"newTest"));

//    System.out.println("在默认临时文件目录中创建一个新目录，使用给定的前缀生成其名称" + Files.createTempDirectory("newTest"));

//    System.out.println("在指定的目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称。" + Files.createTempFile(pathTwo,"123",".txt"));
    //删除文件
//Files.delete(Paths.get(pathTwo+"/1236386955195061091827.txt"));

       // System.out.println("读取文件属性的值。" + Files.getAttribute(path1,"lastModifiedTime"));

       // System.out.println("返回给定类型的文件属性视图。。" + Files.getFileAttributeView(path3, AclFileAttributeView.class));

//        System.out.println("返回表示文件所在文件存储区的 FileStore" + Files.getFileStore(path2));

//        System.out.println("返回文件的上次修改时间 " + Files.getLastModifiedTime(path2));

//        System.out.println("返回文件的所有者。 " + Files.getOwner(path2));

//        System.out.println("返回文件的POSIX文件权限。 " + Files.getPosixFilePermissions(path2));

//        System.out.println("测试文件是否是目录。 " + Files.isDirectory(path2));

//        System.out.println("测试文件是否可执行。 " + Files.isExecutable(path2));

//        System.out.println("告知文件是否被 隐藏。 " + Files.isHidden(path2));

//        System.out.println("测试文件是否可读。 " + Files.isReadable(path2));

//        System.out.println("测试文件是否是具有不透明内容的常规文件。。 " + Files.isRegularFile(path2));

//        System.out.println("测试两个路径是否找到相同的文件。。 " + Files.isSameFile(path1,path2));

//        System.out.println("测试文件是否是符号链接。 " + Files.isSymbolicLink(path2));

//        System.out.println("测试文件是否可写。。 " + Files.isWritable(path2));

//        System.out.println("从 Stream读取文件中的所有行。。 " + Files.lines(path2));

   //从 Stream读取文件中的所有行
//    Files.lines(path2).forEach(s -> {
//        System.out.println(s);
//    });

//从文件中读取所有行作为 Stream
//    Files.lines(path2, Charset.defaultCharset()).forEach(s -> {
//        System.out.println(s);
//    });

//返回一个懒惰的填充 Stream ，其元素是 Stream中的条目
//    Files.list(path3).forEach(path -> {
//        System.out.println(path.toString());
//    });

    //打开一个文件进行阅读，返回一个 BufferedReader以高效的方式从文件读取文本。
//    BufferedReader bufferedReader = Files.newBufferedReader(path2);
//    bufferedReader.lines().forEach(s -> {
//        System.out.println(s);
//    });
//    System.out.println(Files.newBufferedReader(path2).readLine());

//    打开或创建一个写入文件，返回一个 BufferedWriter ，可以用来以有效的方式将文本写入文件+++++++++++++++++++++++++++++++++++待解决

//    Charset charset = Charset.forName("UTF-8");
//    BufferedWriter bufferedWriter = Files.newBufferedWriter(path2,charset, StandardOpenOption.APPEND);
//    String text = "\n++++++++++++from java2s.com+++++++++++++++++";
//    bufferedWriter.write(text);
//    bufferedWriter.newLine();
//    bufferedWriter.flush();

    //打开或创建文件，返回可访问的字节通道以访问该文件。
//    SeekableByteChannel seekableByteChannel = Files.newByteChannel(path2);
//    System.out.println(seekableByteChannel.size());

//打开一个目录，返回一个DirectoryStream以遍历目录中的所有条目。
//    Files.newDirectoryStream(path3).forEach(path -> {
//        System.out.println(path);
//    });

//    打开一个目录，返回一个DirectoryStream来迭代目录中的条目。
//    DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//        @Override
//        public boolean accept(Path file) throws IOException {
//            return (Files.size(file) > 800L);
//        }
//    };
//    DirectoryStream<Path> paths = Files.newDirectoryStream(path3, filter);
//    paths.forEach(path -> {
//        System.out.println(path);
//    });

//    打开一个文件，返回输入流以从文件中读取
//    InputStream inputStream = Files.newInputStream(path2);
//    System.out.println(inputStream.read());

//    打开或创建文件，返回可用于向文件写入字节的输出流

//    OutputStream outputStream = Files.newOutputStream(path2);

//    测试此路径所在的文件是否不存在。
//    System.out.println(Files.notExists(path2));

//    探测文件的内容类型
//    System.out.println(Files.probeContentType(path2));

//    读取文件中的所有字节
//    Files.readAllLines(path2).forEach(s -> {
//        System.out.println(s);
//    });
//
//    从文件中读取所有行
//    Files.readAllLines(path2).forEach(s ->{
//        System.out.println(s);
//    });
//    读取文件的属性作为批量操作
//    System.out.println(Files.readAttributes(path2, BasicFileAttributes.class));

//    设置文件属性的值。
//    System.out.println(Files.setAttribute(path2, " lastAccessTime", FileTime.fromMillis(System.currentTimeMillis())));

//    更新文件上次修改的时间属性
//    System.out.println(Files.setLastModifiedTime(path2, FileTime.fromMillis(System.currentTimeMillis())));
//    更新文件所有者++++++++++++++++++++++++++++++待解决
//    UserPrincipalLookupService lookupService =
//            provider(path2).getUserPrincipalLookupService();
//    UserPrincipal joe = lookupService.lookupPrincipalByName("joe");
//    Files.setOwner(path2, lookupService);

//    设置文件的POSIX权限。
//    Set<PosixFilePermission> posixFilePermissions = new HashSet<>();
//    posixFilePermissions.add(PosixFilePermission.GROUP_EXECUTE);
//    System.out.println(Files.setPosixFilePermissions(path2, posixFilePermissions));

//    返回文件的大小（以字节为单位）
//    System.out.println(Files.size(path2));
    // 返回一个 Stream ，它通过 Path根据给定的起始文件的文件树懒惰地填充 Path
//    Files.walk(path2).forEach(path -> {
//        System.out.println(path);
//    });

//    走一个文件树
//    Path path = Files.walkFileTree(path3,new SimpleFileVisitor<Path>(){});
////    System.out.println(path);

//    将字节写入文件。
//    String string = "将文件写这段字节";
//    byte[] bytes = string.getBytes();
//    Files.write(path1, bytes, StandardOpenOption.APPEND);
//    将文本行写入文件
//
//    ArrayList<String> strings = new ArrayList<>();
//    strings.add("第一");
//    strings.add("第二");
//    strings.add("第三");
//    strings.add("第四");
//    strings.add("第五");
////    Iterator<String> iterator = strings.iterator();
//    Charset charset = Charset.forName("UTF-8");
//Files.write(path1,strings,charset, StandardOpenOption.APPEND);


}


}
