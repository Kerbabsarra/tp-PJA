
import java.io.*;
import java.io.RandomAccessFile;




public class classe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

           try{

    //here we will work of deserilizing the file 
    RandomAccessFile raf= new RandomAccessFile("empdirect.dat", "rw");
    FileInputStream filein = new FileInputStream("emp.dat");
    ObjectInputStream in= new ObjectInputStream(filein);
    Object obj=null;

     while((obj= in.readObject()) instanceof EndOffile == false)
{
   

String s= (((employee)obj).name+((employee)obj).address+((employee)obj).number);
raf.writeChars(s);   
}

in.close();
raf.close();
    }//try
    catch(Exception e){
      e.printStackTrace();
    }//catch

    }//main


    
}//class 2