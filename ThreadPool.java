import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		ArrayList<String> list;

		try {
			Scanner s = new Scanner(new File("hosts.txt"));
			list = new ArrayList<String>();
			while (s.hasNext()) {
				list.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException ex) {
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

