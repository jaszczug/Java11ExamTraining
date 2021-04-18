package functional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CheckNulltest {

	public static void main(String[] args) {		
		
		
	Function<Integer, Integer> func = (var x) -> (x * 2);	
	
	UnaryOperator<Integer> func2 = x -> x * 2;
		
		
	Predicate<String> predicate = (value) -> value != null && !value.isBlank();
	
	List<String> l= Arrays.asList("ewe","",   "ssasa", null, null);
	
	List<String> l2 =  l.stream().filter(predicate).collect(Collectors.toList());	
	
	
	Predicate<String> nonNullPredicate = Objects::nonNull;
	List<String> l4 =  l.stream().filter(nonNullPredicate).collect(Collectors.toList());	  
	
	
	Predicate<String> predicateNull = new CheckForNull();
	
	List<String> l3 =l.stream().filter(predicateNull).collect(Collectors.toList());	
	
	
	System.out.println( l2.size() );
	
	System.out.println( l3.size() );
	}
	
}
