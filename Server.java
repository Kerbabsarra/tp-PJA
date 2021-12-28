package Devoir2Pja;
import java.net.*;
import java.util.Scanner;
import java.io.*;


public class Server {

	public static void main(String[] args) throws Exception {
		
		ServerSocket sc= new ServerSocket(9998);
		System.out.println("Server listening on port "+sc.getLocalPort());
		Socket s= sc.accept();
		System.out.println("client connected");
		
		
		Scanner scanner= new Scanner(s.getInputStream());
		PrintWriter pr= new PrintWriter (s.getOutputStream(),true);
		
	
		
    	File parent = new File("C:\\Users\\IOIOIOIOI\\eclipse-workspace\\Devoir2Pja\\parent");//here is the directory where all the directoires are 
    	String parentPath= parent.getAbsolutePath();
    	
       while(true) {
    		String msg= scanner.nextLine();
    		System.out.println(msg);
    		String[] commande = msg.split(" ");
    		
    	
	    if (commande[0].equals("List")) {
	    	
	    	File dirCherche = new File (parentPath+"\\"+commande[1]);
	    	
	    	if (dirCherche.isDirectory()) {
	    		pr.println("List");
	    		String fileList[] = dirCherche.list();
	    		int size= fileList.length;
	    		pr.println(size);
	    		
	    		for(int i=0;i<size;i++) 
	    			pr.println(fileList[i]);
	    			
	    	}else 
	            pr.println("ERROR:repository does not exist");
	    	
	    }else if (commande[0].equals("Get")) {
	           
	    	File fileCherche = new File (parentPath+"\\"+commande[1]+".txt");
	    	if(fileCherche.isFile()) {
	    		pr.println("Get");
	    		Scanner fileSc= new Scanner (fileCherche);
	    	    while(fileSc.hasNextLine()) {
	    	    	String line= fileSc.nextLine();
	    	    	pr.println(line);
	    	    }
	    	    	
	    	   
	    	}else
	    		pr.println("ERROR:File does not exist");
	    	
	    	
	    }else if (commande[0].equals("Quit")) {
	    	pr.println("Quit");
			s.close();
			sc.close();
			pr.close();
			System.out.println("session ended");
	    }
	    else {
	    	pr.println("ERROR:enter valide command");}
	
	  
       }//while
		
	}//main

}//class
