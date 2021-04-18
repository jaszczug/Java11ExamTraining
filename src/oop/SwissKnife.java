package oop;

@FunctionalInterface
interface SwissKnife {

	default int compare(int i1, int i2) {
		return i1 -i2;
	}
	
	
	static void run() {
		
	}
	
	String welcomify(String s);
}
