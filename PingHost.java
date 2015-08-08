import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class PingHost implements Runnable {
	private String host;
	private InetAddress address;

	public PingHost(String host) {
		this.host = host;
	}

	public void run() {
		try {
			address = InetAddress.getByName(host);
		} catch (UnknownHostException ex) {
			System.out.println(ex);
			return;
		}

		try {
			if (!(address.isReachable(1000))) {
				System.out.println(host);
			}
		} catch (IOException ex) {
			System.out.println(ex);
			return;
		}
	}
}

