package io;

import java.util.Scanner;

public class TestConsole {

	public static void main(String[] args) {
		
		
		// Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);  
        String s = in.nextLine();        
        in.close();
        System.out.printf("You entered string %s" , s);
  
		
		
		//String text=System.console().readLine();    //does not work in eclipse
		//System.out.println("Text is: "+text);    
	}

}
