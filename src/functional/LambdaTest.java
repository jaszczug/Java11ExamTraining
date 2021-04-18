package functional;

import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class LambdaTest {

	public static void main(String[] args) {
		    Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
		    
		    Consumer<String> c2 = (x) -> System.out.println(x.toUpperCase());
		    
		    c.andThen(c2).accept("Java2s.com");

	}
	
	
	
	public IntSupplier doStuff(int [] vals, int i) {
		// line n1
		return () -> vals[i];
		}

}
