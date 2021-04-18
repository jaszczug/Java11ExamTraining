package io;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CopyTest {

	public static void main(String[] args) throws IOException {
		
		Path currentFile = Paths.get("files/test.txt");
		Path outputFile = Paths.get("files/scratch/new.txt");
		Path directory = Paths.get("files/scratch/");
		
	    CopyOption[] options = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES };
		
		Files.copy(currentFile, outputFile, options);   //java.nio.file.NoSuchFileException, java.nio.file.FileAlreadyExistsException
		Files.copy(outputFile, directory, options);
		if ( isDirEmpty(directory)) {
			Files.delete (outputFile);  //java.nio.file.DirectoryNotEmptyException
		} else {

		}
	}
	
	
	private static boolean isDirEmpty(final Path directory) throws IOException {
	    try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory)) {
	        return !dirStream.iterator().hasNext();
	    }
	}

}
