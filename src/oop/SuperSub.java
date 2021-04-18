package oop;

public class SuperSub {
	
	int a ;

	public static void main(String[] args) {		
		new Sub(1);		
	}	
}

class Super {
	public Super() {
		//a=5; //not OK
		this(2); //must be first line
		System.out.println(3);
	}

	public Super(int i) {
		System.out.println(i);
	}
}

class Sub extends Super { //If explicit call to parent constructor not made, the subclass' constructor
	//will automatically invoke super(). (the default constructor of the base class, if there is one)
	
	public Sub() {
		System.out.println(0);
	}

	public Sub(int i) {
		//super(); ///if skipped it will be added auto..
		System.out.println(i);
	}
	
}