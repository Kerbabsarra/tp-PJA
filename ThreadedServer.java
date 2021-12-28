package Devoir2Pja;

import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer {

	public static void main(String[] args) throws Exception {
		
		ServerSocket sc= new ServerSocket(9998);
		System.out.println("Server listening on port "+sc.getLocalPort());
		Socket s= null;
		while(true) {
		s= sc.accept();
		System.out.println("client connected");
		ThreadTask t= new ThreadTask(s);
		t.start();
		}
		
		
		

	}

}
