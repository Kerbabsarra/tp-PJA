package Devoir2Pja;
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class ThreadTask extends Thread {
	   Scanner in=null;
	   PrintWriter out= null;
       Socket s1= null;
       public ThreadTask(Socket s) {
			s1=s;
		}
       @Override
		public void run() {
    	   try {
    		   in=new Scanner(s1.getInputStream());
    		   out=new PrintWriter(s1.getOutputStream(),true);
    		   
    		   File parent = new File("C:\\Users\\IOIOIOIOI\\eclipse-workspace\\Devoir2Pja\\parent");//here is the directory where all the directoires are 
    	    	String parentPath= parent.getAbsolutePath();
    	    	
    	       while(true) {
    	    		String msg= in.nextLine();
    	    		System.out.println(msg);
    	    		String[] commande = msg.split(" ");
    	    		
    	    	
    		    if (commande[0].equals("List")) {
    		    	
    		    	File dirCherche = new File (parentPath+"\\"+commande[1]);
    		    	
    		    	if (dirCherche.isDirectory()) {
    		    		out.println("List");
    		    		String fileList[] = dirCherche.list();
    		    		int size= fileList.length;
    		    		out.println(size);
    		    		
    		    		for(int i=0;i<size;i++) 
    		    			out.println(fileList[i]);
    		    			
    		    	}else 
    		             out.println("ERROR:repository does not exist");
    		    	
    		    }else if (commande[0].equals("Get")) {
    		           
    		    	File fileCherche = new File (parentPath+"\\"+commande[1]+".txt");
    		    	if(fileCherche.isFile()) {
    		    		out.println("Get");
    		    		Scanner fileSc= new Scanner (fileCherche);
    		    	    while(fileSc.hasNextLine()) {
    		    	    	String line= fileSc.nextLine();
    		    	    	out.println(line);
    		    	    }
    		    	    	
    		    	   
    		    	}else
    		    		out.println("ERROR:File does not exist");
    		    	
    		    	
    		    }else if (commande[0].equals("Quit")) {
    		    	out.println("Quit");
    				s1.close();
    				in.close();
    				out.close();
    				System.out.println("session ended");
    		    }
    		    else {
    		    out.println("ERROR:enter valide command");}
    		
    		  
    	       }//while
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}

	

}
