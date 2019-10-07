package io.src.io;

import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;

import static java.nio.file.Files.readAttributes;

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
    public static void main(String[] args) throws IOException {
        //    指定自己某个路径上的任意一个文件，读取并且修改其中的属性
        File file = new File("io/src/io");



            BasicFileAttributes attributes = readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
        System.out.println(attributes);
        System.out.println("创建时间:"+ attributes.creationTime());
        System.out.println("是否是文件:"+ attributes.isDirectory());
        System.out.println("是否是其他:"+ attributes.isOther());
        System.out.println("是否是常规文件:"+ attributes.isRegularFile());
        System.out.println("是否符号链接:"+ attributes.isSymbolicLink());
        System.out.println("最后访问时间:"+ attributes.lastAccessTime());
        System.out.println("最后修改时间:"+ attributes.lastModifiedTime());


        //修改最后修改时间
        long currentTimeMillis = System.currentTimeMillis();
        FileTime ft = FileTime.fromMillis(currentTimeMillis);
        Files.setLastModifiedTime(Paths.get(file.getPath()),ft);

        // 属性：文件本身的内容

    }
}
