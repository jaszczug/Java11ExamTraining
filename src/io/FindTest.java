package io;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FindTest {
	public static void main(String[] args) throws Throwable {
		Files
		.find(Paths.get("."), 1, (p,a)->a.isDirectory() )  //BiPredicate
		.forEach(System.out::println);
		}
}
