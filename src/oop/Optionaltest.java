package oop;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Optionaltest {

	public static void main(String[] args) {
		Optionaltest client = new Optionaltest();
		  //Gives you a number between 0 and 2^1024 - 1
		  BigInteger number = new BigInteger(1024, new Random()); 
		  System.out.println(number);
		  var v = client.getRotatedHost(number);
		  System.out.println(v.get());  

	}	
	
	public static final List<String> HOSTS = List.of("abc.xyz", "def.xyz");  

	private Optional<String> getRotatedHost(BigInteger ssoToken) {
	  if (HOSTS.size() > 1) { 
	   // return Optional.of(HOSTS.get(ssoToken.hashCode() % HOSTS.size())); // can generate exceptions
		  return Optional.of(HOSTS.get(Math.floorMod(ssoToken.hashCode(), HOSTS.size())));	  
		  
	  }    
	  return Optional.empty();        
	}

}
