package flows;

import java.util.Arrays;

public class BinaySearch {

	public static void main(String[] args) {
		
		
		int[]  arrayInt = new int[] {1,44,5,3,6,77,55};
		
		Arrays.sort(arrayInt);
		
		for(int num:arrayInt)
		System.out.print(num+",");
		
		int r = Arrays.binarySearch(arrayInt, 27);  //-5?
		
		System.out.println(~r);

	}

}
