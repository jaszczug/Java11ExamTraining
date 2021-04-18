package oop;

enum Outcome {
	SUCCESS, FAILURE;

	{
		System.out.print("IO ");
	}

	Outcome() {
		System.out.print("CO ");
	}

	static {
		System.out.print("SO ");
	}
}

class TestCase {
	Outcome result;

	public TestCase() {
		System.out.print("CTC ");
	}

	{
		System.out.print(" before ITC ");
		result = Outcome.SUCCESS;  // here start to constrct Enum
		System.out.print("ITC ");
	}
}


class StartTest {
	{
		System.out.print("Init ");
	}
	static {
		System.out.print("StaticInit ");
	}
	StartTest() {
		System.out.print("Constructor ");
	}
	
}

public class TestEnum {
	
	StartTest st;
	
	static {
		System.out.print("StaticInit Main ");
	}
	

	public static void main(String[] args) {
		//TestEnum te = new TestEnum();
		//StartTest st = new StartTest();
TestCase tc1 = new TestCase();
//TestCase tc2 = new TestCase();
}
}