package io;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.*;


public class FilesReader {
	public static void main(String[] args) {
		
		File dir = new File("C:\\Kuba");
		Path path = Paths.get("data");
		Path defaultRoot = Paths.get(System.getProperty("user.dir")).getRoot();
		try {
			
			boolean pathExists =
			        Files.exists(path, LinkOption.NOFOLLOW_LINKS);
			 System.out.println("Creating dic..." +defaultRoot.resolve(path));
			if(!pathExists) {
			   
				Path newDir = Files.createDirectory(path);
				
				
			} else {
				try (Stream<Path> paths = Files.walk(Paths.get("c:/kuba"))) {
				    paths
				        .filter(Files::isRegularFile)
				        .forEach(System.out::println);
				} 
				
				
				for (final File fileEntry : dir.listFiles()) {
			        if (fileEntry.isDirectory()) {
			           // listFilesForFolder(fileEntry);
			        } else {
			            System.out.println(fileEntry.getName());
			        }
			    }
				
				
				System.out.println("Dictionary " + path + " exists");
			}
		    
		    
		} catch(FileAlreadyExistsException e){
			e.printStackTrace();
		    // the directory already exists.
		} catch (IOException e) {
		    //something else went wrong
		    e.printStackTrace();
		}
	}
	
}
