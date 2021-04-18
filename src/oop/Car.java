package oop;

public class Car {
	
	
	
	//test pass by value
	
	void startEngine(Integer speed, StringBuilder sb) {
	    speed++;		
		
		sb.append("Starting");
	}	
	
	int x = 1;
	
	static void test(Car car) {
		
		car.x++;
	}
	
	static {
		
	}	

	public static void main(String[] args) {
		JetEngine e = new JetEngine();	
		
		Integer startS = Integer.valueOf(10);
		StringBuilder builder = new StringBuilder();
		Car c = new Car();		
		c.startEngine(startS , builder);
		
		
		System.out.println(startS +  builder.toString());
		
		c.x++;
		
		test(c);
		
		c.setEngine(e);
		SwissKnife sni = (a) -> "Welcome, " + a;
	}
	
	void setEngine(Object engine) {
		System.out.println("Unknown engine");
	}
	void setEngine(GenericEngine engine) {
		System.out.printf("I have engine: %s", engine.engType);
	}
	
	void setEngine(CombustionEngine engine) {
		System.out.printf("I have engine: %s", engine.engType);
	}
}


class GenericEngine {public String engType = "GE-001";}

class CombustionEngine extends GenericEngine {public String engType = "CE-001";}


class JetEngine extends CombustionEngine {public String engType = "JT-001";}

