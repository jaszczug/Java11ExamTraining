package oop;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Staff {
	public static void main(String[] args) {
		Map m = new HashMap();
		String s = new String();
		Random r = new Random();
		
		System.out.println(m instanceof Date); //compatible - why ?? because it is interface
		//System.out.println(s instanceof Date); //incompatible types
		//System.out.println(r instanceof Date); //incompatible types
	}   
}
