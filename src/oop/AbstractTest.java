package oop;


public class AbstractTest extends AbClass implements Iner { //both has the same method but it is not issue

	@Override   //cant reduce visibility
    public void m(String s) {  //cant throw new exceptions
		// TODO Auto-generated method stub	
	}	
	public static void main(String[] args) {
		AbstractTest m  = new AbstractTest();
		m.m("");
	}

}


abstract class AbClass {
	abstract void m(String s) ;
}


interface Iner {  // by deafult all methods are public and abstrct
	void m(String s);
}

abstract class AbClassInt  implements Iner {
	//public abstract void m(String s); //without it it is also OK
}
