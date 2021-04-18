package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import streams.Employee;

public class TestSerialization {

	public static void main(String[] args) {
		String filename = "employee.ser";
		 if(args.length > 0)
		     {
		       filename = args[0];
		     }
		     Employee time = new Employee("Jan", 4324234.3);
		     FileOutputStream fos = null;
		     ObjectOutputStream out = null;
		     try
		     {
		       fos = new FileOutputStream(filename);
		       out = new ObjectOutputStream(fos);
		       out.writeObject(time);
		       out.close();
		     }
		     catch(IOException ex)
		     {
		       ex.printStackTrace();
		     }
		     
		     FileInputStream fis = null;
		     ObjectInputStream in = null;
		     try
		     {

		     
		     fis = new FileInputStream(filename);
		     in = new ObjectInputStream(fis);
		     Employee empl =  (Employee)in.readObject();
		     System.out.println(empl);
		     }
		     catch(IOException ex)
		     {
		       ex.printStackTrace();
		     } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     finally {
		    	 try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	      }

	

}
