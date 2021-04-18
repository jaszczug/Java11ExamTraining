package generic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
/**
 * Generic Class
 * @author jaszczug
 *
 * @param <T>
 */
public class Box <T> {
	
	
	private T item;
	
	public void set(T t) { this.item = t; }
    public T get() { return item; }

}
