package streams;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable, Cloneable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private String name;
    transient private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String string, double salary) {
		this.salary = salary;
		name = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
	    return Objects.hash(this.name, this.salary);
	}

	  @Override
	 public String toString() {
	    return "Emp{" + "name=" + this.name + ", salary='" + this.salary + '\''  + '}';
	 }
	  
	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Employee))
	      return false;
	    Employee emp = (Employee) o;
	    return Objects.equals(this.name, emp.name) && Objects.equals(this.salary, emp.salary);
	  } 
	
	  @Override
	public Object clone() throws CloneNotSupportedException {
	        Employee clone = null;
	        try
	        {
	            clone = (Employee) super.clone();
	 
	            //Copy new date object to cloned method
	         //   clone.setName((String) this.getName().clone());
	        } 
	        catch (CloneNotSupportedException e) 
	        {
	            throw new RuntimeException(e);
	        }
	        return clone;
	    }
	  
}
