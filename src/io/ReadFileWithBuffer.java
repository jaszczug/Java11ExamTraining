package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileWithBuffer {

	public static void main(String[] args) {
		
		try(BufferedReader fileReader = new BufferedReader(new FileReader("c:/test.txt"))) {
		    System.out.print(fileReader.readLine());
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

	}

}
