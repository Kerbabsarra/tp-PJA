import java.io.*;
import java.util.Scanner;


public class class3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrez le numero d'employee que vous voulez afficher ");
        int z= sc.nextInt();
        sc.close();
    try{

    
    //here we will work of deserilizing the file 
    FileInputStream filein = new FileInputStream("emp.dat");
    ObjectInputStream in= new ObjectInputStream(filein);
    Object obj=null;

     while((obj= in.readObject()) instanceof EndOffile == false)
{
    if(((employee)obj).number == z)
System.out.println(((employee)obj).name+((employee)obj).address+((employee)obj).number);
    else
    System.out.println("le numero que vous avez inserer ne correspond a aucun employe");
    break;
}

in.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }

    }//main

}//class3