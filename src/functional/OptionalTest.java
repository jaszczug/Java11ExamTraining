package functional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		 // create a Optional
        Optional<Integer> op
            = Optional.of(2323);
        
        
        Optional<Integer> opt = Optional.ofNullable(null);
        
        
        opt.orElse(123);
  
        
        System.out.println(op.isPresent());

        
        // print supplier
        System.out.println("Optional: "
                           + op);
        
        
        op.get();  //get value
  
        // orElseThrow supplier
        System.out.println(
            "Value by orElseThrow("
            + "ArithmeticException::new) method: "
            + opt.orElseThrow(
                  ArithmeticException::new));
    }

	

}
