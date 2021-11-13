import java.io.*;
import java.util.Scanner;

public class classe1 {
	  public static void main(String [] args)
	   {  Scanner sc =new Scanner(System.in);
		  System.out.println("entrer le nombre d'objet a sérialiser\n");
		  int no = sc.nextInt();
		  System.out.printf("le nombre d'objet a sérialiser = %d\n",no);
		  System.out.println("************");
		  
		  
	      try
	      {  
	          employee[] Employees = new employee[no];
	         FileOutputStream fileOut = new FileOutputStream("emp.dat");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    
	         for(int i=0 ; i<no ; i++) {
	        	  System.out.println("entrer le nom ,l'address ,le SSN , le number");
				  Employees[i]= new employee(sc.next(),sc.next(),sc.nextInt(),sc.nextInt());
		   	      System.out.println(Employees[i].toString());
		   	      System.out.println("*****************");
		   	       out.writeObject(Employees);
		   		  }
	   	      out.close();
	         fileOut.close();
	         System.out.printf("donnees serialisees sauvegardees dans emp.dat");
	      }
	      catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	   }
	  
	  
}