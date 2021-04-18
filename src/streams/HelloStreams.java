package streams;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * A simple Java Program to demonstrate how to use map and filter method Java 8.
 * In this program, we'll convert a list of String into a list of Integer and
 * then filter all even numbers.
 */
public class HelloStreams {

  public static void main(String[] args) {	  
	  
	  //create stream from array  and the array from stream
	  String[] arrayOfString = new String[] {"a", "b", "c", "d"};
	  Stream<String>  characters = Stream.of(arrayOfString).map(String::toLowerCase);
	  String[]  newArray = characters.toArray(String[]::new);
	  System.out.println( newArray);	  
	  Arrays.stream(arrayOfString, 2,3);	
	  

	  // transform list and concat results
	  List<String> sampleList = Arrays.asList("Java", "Kotlin");
	  String resultString = sampleList.stream()
	    .map(( var x) -> x.toUpperCase())
	    .collect(Collectors.joining(", "));
	  
	//run in parallel  
    List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    System.out.println("original list: " + numbers);
    List<Integer> even = numbers.stream().parallel()
                                .map(s -> Integer.valueOf(s))
                                .filter(number -> number % 2 == 0)
                                .collect(Collectors.toList());
    System.out.println("processed list, only even numbers: " + even);
    
           
    //generate random ints
    
    IntStream stream2 = IntStream.generate(() 
            -> { return (int)(Math.random() * 10000); }); 
 
    stream2.limit(10).forEach(System.out::println); 
    
    
    
    IntStream stream = IntStream.range(1, 100);     
    List<Integer> primes = stream.filter(HelloStreams::isPrime)
            .boxed()
            .collect(Collectors.toList());
    System.out.println(primes);
    
    
    
    //Closed Range
    IntStream closedRangeStream = IntStream.rangeClosed(5, 10); 
    closedRangeStream.forEach( System.out::println );   //5,6,7,8,9,10
    
	//sort
    List<Employee> empList = new ArrayList<>();
    
    empList.add(new Employee("Kowalski", 323d));
    empList.add(new Employee("Nowak", 323d));
    empList.add(new Employee("Obajtek", 323d));
    empList.add(new Employee("Rambo", 323d));

    List<Employee> employees = empList.stream()
    	      .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
    	      .collect(Collectors.toList());
    
    
    ToDoubleFunction<Integer> ob = a -> a / 2;    
    // using applyAsDouble()
    System.out.println(ob.applyAsDouble(3));
    
    //BiFunction 
    String result = Stream.of("hello", "world").reduce("", (a, b) -> b + "-" + a);
    
    
    Double avgSal = empList.stream()
    	      .mapToDouble(Employee::getSalary)
    	      .average().orElseThrow(NoSuchElementException::new);
    
    
    var numbers2 = List.of(1,35,5,78,3);
    Double avgSal2 = numbers2.stream()
  	      .mapToInt(m->m)
  	      .average().getAsDouble();
    
    empList.removeIf(x  ->  x.getName().equals("Nowak"));
    
    
    Employee[] employees2 = empList.stream().toArray(Employee[]::new);
    
    //distinct
    List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
    List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
    
    
    
    var is = IntStream.range(1, 5);  //1,2,3,4
    var avg = is.filter(i -> i % 5 == 0).average(); // line n1
    is = IntStream.range(1, 5);
    var sum = is.filter(i -> i % 2 != 0).sum(); // line n2
    is = IntStream.range(1, 5);
    var count = is.filter(i-> i % 5 == 0).count(); // line n3
    System.out.print(avg + " " + sum + " " + count);
    
    
    
    List<JavaExam> exams = List.of(
    	    new JavaExam(Level.ASSOCIATE, Version.JAVA_8, "1Z0-808"),
    	    new JavaExam(Level.PROFESSIONAL, Version.JAVA_8, "1Z0-809"),
    	    new JavaExam(Level.ASSOCIATE, Version.JAVA_11, "1Z0-815"),
    	    new JavaExam(Level.PROFESSIONAL, Version.JAVA_11, "1Z0-816"),
    	    new JavaExam(Level.PROFESSIONAL, Version.JAVA_11, "1Z0-819")
    	);
    	var res = exams.stream()
    	    .filter(e->(e.getVer() == Version.JAVA_11 ||
    	                Version.JAVA_8.equals(e.getVer())))
    	    .collect(
    	        Collectors.groupingBy(JavaExam::getVer, 
    	            Collectors.groupingBy(e -> e.getLvl(), 
    	                Collectors.mapping(JavaExam::getCode, Collectors.toList())))); // line n1
    	System.out.print(
    	    res.get(Version.JAVA_11)
    	        .get(Level.PROFESSIONAL)
    	            .get(1)); // line n2
    
    	
    	
    	 List<String> items =
                 Arrays.asList("apple", "apple", "banana",
                         "apple", "orange", "banana", "papaya");

         Map<String, Long> result2 =
                 items.stream().collect(
                         Collectors.groupingBy(
                                 Function.identity(), Collectors.counting()
                         )
                 );
         
         
         Stream stream3 = Stream.of(1, 2, 3); //Will compile fine
         IntStream intStream = IntStream.of(4, 5, 6); //Will compile fine

        // Stream s = IntStream.of(4, 5, 6); //Does not compile
         Stream s2 = IntStream.of(4, 5, 6).mapToObj(e -> e); //mapToObj method is needed
         IntStream is2 = Stream.of(4, 5, 6).mapToInt(e -> e); //mapToInt method is needed

    
  }
  public static boolean isPrime(int i) {
      IntPredicate isDivisible = index -> i % index == 0;
      return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
  }

  
  public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
      @Override
      public boolean test(String t)
      {
          return t.length() > 10;
      }
  };

  public static void predicate_or()
  {

      Predicate<String> containsLetterA = p -> p.contains("A");
      String containsA = "And";
      boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
      System.out.println(outcome);
  }
  
}
