import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SocServer {

	static ArrayList<Socket> soclist=new ArrayList();
	static ArrayList<String> user=new ArrayList();
	private static BufferedReader br1;
	public static void main(String[] args) throws Exception {
		System.out.println("starting server");
		int port=1783;
		ServerSocket ss = new ServerSocket(port);
		
		
		
		while(true)
		{
			Socket socket1 = ss.accept();
			 System.out.println("connected");
			// soclist.add(socket1);
			 //new ServerThread(socket1).run();
			 Thread t=new Thread(new ServerThread(socket1));
			 t.start();
		//	 addUser(socket);
	         
		}
	}
/*	private static void addUser(Socket socket) throws Exception {
		br1=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String name=br1.readLine();
		user.add(name);
	}*/

}
