package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import streams.Employee;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		List<Animal> animals = new ArrayList<Animal>();
		
		animals.add(new Cat("Filemon")); //addLast
		print(animals);		
		
		List<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat("Bonifacy"));
		print(cats);		
		
		
		Deque<Animal>  queue  =  new ArrayDeque<Animal>();
		
		queue.addFirst(new Cat("Pusia"));
		queue.addFirst(new Cat("Pusia2"));
		queue.addFirst(new Cat("Pusia3"));				
		
		
		System.out.println(queue.getFirst() );
		
		
		
        // Creating Deque using the ArrayDeque class
        Deque<Integer> numbers = new ArrayDeque<>();

        // add elements to the Deque
        numbers.offer(1);
        numbers.offerLast(2);
        numbers.offerFirst(3);
        System.out.println("Deque: " + numbers);

        
        
        
        // Access elements of the Deque
        int firstElement = numbers.peekFirst();
        System.out.println("First Element: " + firstElement);

        int lastElement = numbers.peekLast();
        System.out.println("Last Element: " + lastElement);

        // Remove elements from the Deque
        int removedNumber1 = numbers.pollFirst();
        System.out.println("Removed First Element: " + removedNumber1);

        int removedNumber2 = numbers.pollLast();
        System.out.println("Removed Last Element: " + removedNumber2);

        System.out.println("Updated Deque: " + numbers);
    

        Deque<String> d = new LinkedList<String>(); 
        //adding elements to the queue using different ways  
        d.add("Java"); // add to tail 
        d.addFirst("Pyhton"); //add to head
        d.addLast("C#"); //add to tail
        d.push("CCNA"); //add to head 
        d.offer("Jquery"); //add to tail
        d.offerFirst("HTML"); //add to head 
        d.offerLast("CSS"); //add to tail        
        
        
        String[] arr = new String[] {"A1", "A2"};

        List<String> ls = new ArrayList<String>(5);
        ls.add("L1");
        ls.add("L2");
        
        
        ArrayList<String> nl = new  ArrayList<String>(ls);
        @SuppressWarnings("unchecked")
		ArrayList<String> arrayListClone = (ArrayList<String>) nl.clone(); //shallow copy by default

        List<String> la = Arrays.asList(arr);
        List<String> lf = List.of(arr);   // factory methods
        List<String> lc = List.copyOf(ls);
        List<String> lu = Collections.unmodifiableList(ls); // you cant modify, but you can see changes in orgin

        arr[1]="A3";
        ls.set(1, "L3");

        // line n1
        System.out.println("nl=" + nl);
        System.out.println("la=" + la);
        System.out.println("lf=" + lf);
        System.out.println("lc=" + lc);
        System.out.println("lu=" + lu);
        
        
        //deep copy
        ArrayList<Employee> employeeList = new ArrayList<>(); 
        ArrayList<Employee> employeeListClone = new ArrayList<>();
         
        Iterator<Employee> iterator = employeeList.iterator();
         
        while(iterator.hasNext())
        {
            //Add the object clones
        	
        	Employee e = (Employee) iterator.next();
            employeeListClone.add((Employee) e.clone());  
        }
        
        
        
        CopyOnWriteArrayList<Integer> numbers3 
        = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});   // iterate over a list in a thread-safe way without an explicit synchronization. (immutable snapshot )
        Iterator<Integer> iterator3 = numbers.iterator();
        numbers3.add(10);
        List<Integer> result3 = new LinkedList<>();
        iterator3.forEachRemaining(result3::add);
        
        
       String[] vals = {"a", null, "b", };
       String[] keys = {null, "m", "b", };
        
       var m = new HashMap<String, String>();
       
       for(int i=0;i<keys.length;i++)
    	   m.put(keys[i], vals[i]);
      
       System.out.println(m.size());
        
        
        
        
	}
	
	
	static void print(List<? extends Animal> list) {
		
		list.forEach(System.out::print);
		
	}
}
