package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;

public class ListDir {

	public static void main(String[] args) throws IOException {
		
		String HOME = System.getProperty("user.home");
		Path home = Paths.get(HOME);
		
		BasicFileAttributeView basicView = 
		  Files.getFileAttributeView(home, BasicFileAttributeView.class);
		
		basicView.readAttributes().isDirectory();
		
		
		Path dir = Paths.get("./files").toAbsolutePath();
		
		//System.out.println(dir);
		
		
		System.out.println("Search in:" + dir.normalize());
		
		//Files.lines(dir).forEach(System.out::println);
		
		Files.walk(dir).filter(Files::isDirectory).forEach(System.out::println);
		
		
		//OK
		Files.walk(dir.normalize()).filter(Files::isRegularFile).forEach(System.out::println);
		
		
		Files.find(dir, 1, (x,y)-> Files.isDirectory(x)).forEach(System.out::println);
		
		
		//OK
		
		Files.find(dir, 1, (x,y)-> !Files.isDirectory(x)).forEach(System.out::println);

	}

}
