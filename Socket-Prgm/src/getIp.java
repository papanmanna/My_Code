import java.net.InetAddress;
import java.net.UnknownHostException;

public class getIp {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		System.out.println(InetAddress.getLocalHost().getHostAddress());
	}

}
