package flows;

public class Loop1 {

	public static void main(String[] args) {
		
		//int[] tab = new int[]{};
		
		int i =0;
		for (;i<10;i++) {			
			System.out.print(++i+",");			
		}		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
		
		char[][] macierz = {{'a','b','c'},{'n','m','l'},{'x','y','z'}};
		
		for(char[] row: macierz) {
			for(char col: row) {
				System.out.print(col);
			}
			System.out.print(" ");
		}
		

	}

}
