import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.List;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		List<String> list;

		try {
			list = Files.readAllLines(new File("hosts.txt").toPath(), Charset.defaultCharset());
		} catch (IOException ex) {
			System.out.println(ex);
			return;
		}

		for (String host : list) {
			Runnable worker = new PingHost(host);
			executor.execute(worker);
		}

		executor.shutdown();

		while (!executor.isTerminated()) {
		}
	}
}

