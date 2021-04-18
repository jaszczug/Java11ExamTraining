package generic;

public class GenericFunc {

	public static <T> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)	       
	            ++count;
	    return count;
	}
	
}
