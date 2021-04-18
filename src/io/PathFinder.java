package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathFinder {

	public static void main(String[] args) {
		Path defaultRoot = Paths.get(System.getProperty("user.dir")).getRoot();
		
		System.out.println(defaultRoot );
		
		Path path = Paths.get("tmp", "joa", "..", "doe");
		
		System.out.println(path );
		
		
		path = defaultRoot.resolve(path);
		
		System.out.println(path );
		
		
		System.out.println(path.getName(2) );
		
		
		
		List<String> lines = Arrays.asList("1st line", "2nd line");
		 
		try {
			Files.write(Paths.get("file6.txt"), 
			                lines, 
			                StandardCharsets.UTF_8,
			                StandardOpenOption.CREATE, 
			                StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Files.walk(Paths.get("/path/to/folder"))
			 .filter(Files::isRegularFile)
			 .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
