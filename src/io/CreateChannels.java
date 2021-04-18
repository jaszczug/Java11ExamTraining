package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class CreateChannels {

	public static void main(String[] args) {
		FileInputStream in;
		try {
			in = new FileInputStream(new File("test.txt"));
		    FileChannel fc = in.getChannel();
		    
		    ReadableByteChannel newChannel = Channels.newChannel(in);
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		RandomAccessFile aFile;
		try {
			aFile = new RandomAccessFile("data/nio-data.txt", "rw");
			FileChannel      inChannel = aFile.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
