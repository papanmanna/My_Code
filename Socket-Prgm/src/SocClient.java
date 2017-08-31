import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocClient {

	

	private static Socket socket;
	private static Scanner scanner;
	private static BufferedReader br;
	private static PrintWriter os;

	public static void main(String args[]) throws IOException{

	    try {
	        socket=new Socket("localhost",1783); 
	        scanner= new Scanner(System.in);
	        br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        os= new PrintWriter(socket.getOutputStream());
	    }
	    catch (IOException e){
	        e.printStackTrace();
	        System.err.print("IO Exception");
	    }

		System.out.println("Client Address : "+InetAddress.getLocalHost().getHostAddress());
	    System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

	    Thread t1=new Thread(new Runnable(){	 	
			public void run()
				 {
					String line="";
					while(true){
					
						
					 if(line.compareTo("QUIT")!=0 && socket.isConnected()){ 
						 line=scanner.nextLine();
						 os.println(line);
						 os.flush();
					 }
					 else{
						try {
							br.close();
							Thread.sleep(20);
							socket.close();
							System.out.println("Disconnected");
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
					   }
					} 
				}
			 });
	   t1.start();
	   Thread t2=new Thread(new Runnable(){
	          public void run()
	          {	
	        	  String response="";
	            	while(true){
	            		try {
	            			
						if(response.compareTo("QUIT")!=0 && socket.isConnected()){
							response=br.readLine();
							System.out.println("Server : "+response);
						}
						else{	
							//Thread.sleep(20);
							br.close();
							socket.close();
							System.out.println("Disconnected from Server");
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
	            	} 		
	           }
	       		});
	   t2.start();
	}
}