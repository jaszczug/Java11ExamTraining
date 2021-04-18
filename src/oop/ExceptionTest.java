package oop;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionTest {

	public static void main(String[] args) {	
		try {
			new ExceptionTest().met();  //only checked exceptions we catch
		}
        catch (SQLException | IOException e) {			
			e.printStackTrace();
		}		
	}

	
	void met()  throws SQLException, RuntimeException, IOException { // you can throw checked and unchecked
		 throw new IOException();   //OK		
		 //throw new Error();  //OK why?
	}
	
}
