import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable  {

	
    private Socket socket = null;
	private PrintWriter os;
	private BufferedReader br1;
	private Scanner sc;

    public ServerThread(Socket s) throws IOException {
        socket = s;
        

    }

    public synchronized void run() {
    	
 		 try {
 			 br1=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 
			 sc=new Scanner(System.in);
		} catch (IOException e1) {
			//e1.printStackTrace();
		}
 		Thread t1=new Thread(new Runnable(){	 	
				public synchronized void  run()
 				 {
					String line="";
					while(true){
					
						 
						 try {
							 line=sc.nextLine();
							os=new PrintWriter(socket.getOutputStream());
							 os.println(line);
							 os.flush();
							 Thread.sleep(110);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
						
						 
					/*	 for(Socket s: SocServer.soclist){
							 try {
								 if(s.isConnected()){
									 os=new PrintWriter(s.getOutputStream());
									 os.println("Server:"+line);
									 os.flush();
								 }
								 else
									 SocServer.soclist.remove(socket);
							} catch (IOException e) {
								// e.printStackTrace();
							}		
						 }*/
					 }
					 }
			 });
 	   t1.start();
 	   Thread t2=new Thread(new Runnable(){
 	          public void run()
 	          {
 	        	 String response ="";	
 	            	while(true){
 	            		try {
							
							if(response.compareTo("QUIT")!=0 && socket.isConnected()){
								response=br1.readLine();
								System.out.println(response);
							}
							else{
								System.out.println("Disconnectd from "+socket.getLocalAddress());
								br1.close();
							//	Thread.sleep(20);
								socket.close();
								//SocServer.soclist.remove(socket);
								break;
							}
						} catch (Exception e) {
							System.out.println("error");
							break;
						}
 	            	
 	            			
 	            		}
 	            		
 	            	}
 	            });
 	         t2.start();
    }
}
