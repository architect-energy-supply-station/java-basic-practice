package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @author bill-smith liuwb
 * @Package io
 * @Date 2019/10/5 16:08
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class WatchServiceTest {
	public static void main(String[] args) {
		//在当前路径位置上，建立一个文件
		String filePath = "/Users/sunshinezhang/Documents/Team3/code/java-basic-practice/io/src/file/";

		File file = new File(filePath + "watchFile");
		file.mkdir();
		//并监控该文件，已发生变化，就输出文件的变化，打印其内容
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Paths.get(filePath + "watchFile").register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			while (true) {

				//retrieve key
				WatchKey key = watchService.take();

				// process events
				for (WatchEvent<?> pollEvent : key.pollEvents()) {
					System.out.println("文件：" + pollEvent.context() + "发生了如下事件：" + pollEvent.kind());
				}

				// reset the key
				boolean reset = key.reset();
				if (!reset) {
					// object no longer registered
					break;
				}

			}


		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
