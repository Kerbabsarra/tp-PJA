package Devoir2Pja;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {

	public static void main(String[] args)throws Exception {
		 Socket s= new Socket("localhost",9998);
		 
		 PrintWriter out= new PrintWriter (s.getOutputStream(),true);         
		 Scanner in= new Scanner (s.getInputStream());
		 Scanner scanner = new Scanner(System.in);
		 

		     while(true) { 
			 System.out.println("enter a command List +your Repository name to get the list of files within,or  Get +the file name you want to get,Or Quit for quiting");
			 String commande= scanner.nextLine();//read keyboard
			 out.println(commande);
			 String response=in.nextLine();
			 
			 
		     if(response.equals("List")) {
		      
			  int size= in.nextInt(); 
				    for(int i=0;i<size;i++) {
		 			System.out.println(in.nextLine());
				    }
				 
		  //repository 
		 }else if (response.equals("Get")) {
			 
			 while(in.hasNextLine())  {
				 String line=in.nextLine();
				 System.out.println(line);
				
			 }
		 } else if (response.equals("Quit")) {
			 System.out.println("session ended");
			 in.close();
			 out.close();
			 s.close();
			 scanner.close();
		 }else
			 //here we print all Errors
			 System.out.println(response);
	
   }//while
		 
		
	
		    

	}//main

}//class
