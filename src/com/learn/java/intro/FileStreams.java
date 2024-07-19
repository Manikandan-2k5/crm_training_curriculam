package com.learn.java.intro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * <p>This class uses all the functionalities of File Streams</p>
 */
public class FileStreams {

	public static void main(String[] args) {
		FileStreams streams = new FileStreams();
//		streams.fileInputStream();
//		streams.fileReader();
//		streams.bufferedReader();
//		streams.fileOutputStream();
//		streams.fileWriter();
//		streams.bufferedWriter();
	}
	
	/**
	 * <p>
	 * This method uses the FileInputStream to read raw byte data from the given file.
	 * FileInputStream are mostly used to read file in raw byte format, but you can convert byte to character.
	 * They provide methods for reading the byte and storing it in the byte array.
	 * Mostly suitable for reading image and audio files as they exist in binary format.
	 * </p>
	 */
	public void fileInputStream() {
		/**
		 * Read using FileInputStream.
		 */
		try {
			FileInputStream inputStream = new FileInputStream("/home/manikandans/self-intro.txt");
			byte byteContent;
			System.out.println("Reading self-intro.txt using FileInputStream.\n");
			while((byteContent=(byte)inputStream.read())!=-1) {
				System.out.print((char)byteContent);
			}
			System.out.println("\n");
			inputStream.close();//Closes the stream to avoid resource leaks.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing file.");
		}
		
		/**
		 * Read and storing it in byte array using FileInputStream.
		 */
		
		try {
			FileInputStream inputStream = new FileInputStream("/home/manikandans/self-intro.txt");
			int estimateBytes = inputStream.available();
			System.out.println("Reading and storing self-intro.txt in byte array using FileInputStream.\n");
			System.out.println("Available bytes in the file (Estimation): "+estimateBytes);
			byte[] bytes = new byte[estimateBytes];
			inputStream.read(bytes, 0, estimateBytes);
			System.out.println("\nByte Array: "+toString(bytes));
			inputStream.close();//Closes the stream to avoid resource leaks.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing file.");
		}
		
	}
	
	/**
	 * <p>
	 * This method uses FileReader to read the character data from given file.
	 * Mostly used for reading text files which can be read as characters.
	 * </p>
	 */
	public void fileReader() {
		//Read using FileReader.
		try {
			System.out.println("Reading file using FileReader.\n");
			FileReader reader = new FileReader("/home/manikandans/self-intro.txt");
			while(reader.ready()) {
				System.out.print((char)reader.read());
			}
			reader.close();//Closes the reader stream to avoid resource leaks.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing file.");
		}
		System.out.println();
		
		//Read and store characters from the second line in char array using FileReader and skip method of it.
		try {
			System.out.println("Reading file from second line and storing it in char array.\n");
			FileReader reader = new FileReader("/home/manikandans/self-intro.txt");
			reader.skip(21);//Skips Line 1.
			char[] charArray = new char[125];
			reader.read(charArray);
			System.out.println(charArray);
			reader.close();//Closes the reader stream to avoid resource leaks.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing the file.");
		}
		
	}
	
	/**
	 * <p>
	 * This method uses BufferedReader to read text files.
	 * BufferedReader internally contains a buffer, in which the data from the streams are stored,
	 * So that whenever we read data, it does not reads from the file stream which is costly, instead it reads from the buffer where it loads the data from the stream.
	 * Buffer can be initialized with size. When the size is exhausted, the buffer loads the remaining data from the stream, according to the buffer size.
	 * Efficient and less overhead. 
	 * Buffer Exhaustion: If the data in the buffer is already read and pointer is at end of buffer, 
	 * if a read operation is done after that , then the buffer loads the next data from the stream which is equal to buffer size.
	 * The data in the last buffer will be invalidated.
	 * </p>
	 */
	public void bufferedReader() {
		//Reads file using BufferedReader, of buffer size 21.
		try {
			System.out.println("Reading file using Buffered Reader.\n");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/manikandans/self-intro.txt")), 21);
			while(reader.ready()) {
				System.out.println(reader.readLine());
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing the file.");
		}
		System.out.println();
		
		//Reads Lines from the buffer of the BufferedReader, marks the position and reads, after buffer exhausted, resetting the pointer, which throws IOException.
		try {
			System.out.println("Reading file using Buffered Reader, and Marking and Setting the pointer using mark and reset method.\n");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/manikandans/self-intro.txt")), 21);
			reader.mark(0);//Marks the 0th position.
			while(reader.ready()) {
				System.out.println(reader.readLine());
				reader.reset();//Resets the pointer to the recently marked position. As the buffer is exhausted, it throws IOException.
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing the file.");
		}
		
	}
	
	/**
	 *<p> This method uses the FileOutputStream to write binary or byte data to files.</p>
	 */
	public void fileOutputStream() {
		try {
			FileOutputStream outputStream = new FileOutputStream("/home/manikandans/self-intro.txt", true);//Boolean true allows you to append instead of rewriting the file.
			String string = "I like to play Badminton, Carrom, Chess.\nI like to roam in the streets, especially using cycle.";
			byte[] bytes = string.getBytes();
			outputStream.write(bytes);//Writes the bytes in the array in the stream.
			outputStream.flush();//Bytes in the stream buffer will be flushed to file.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing the file.");
		}
	}
	
	/**
	 * <p>This method uses FileWriter to write characters to files, also encodes characters to bytes using default character encoding.
	 */
	public void fileWriter() {
		try {
			FileWriter writer = new FileWriter("/home/manikandans/self-intro.txt", true);//Boolean true allows you to append instead of rewriting the file.
			String string = "I like to play Badminton, Carrom, Chess.\nI like to roam in the streets, especially using cycle.";
			char[] charArray = string.toCharArray();
			writer.write(charArray);//Writes the characters in the array in the stream.
			writer.flush();//characters in the stream buffer will be flushed to file and will be encoded according to the default encoding.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing the file.");
		}
	}
	
	/**
	 * <p>
	 * This method writes characters to file using BufferedWriter,
	 * when a write operation is done, it is stored in buffer.
	 * After flush method executes, the data in buffer is written in the file stream.
	 * This avoids overhead and improves performance.
	 * </p>
	 */
	public void bufferedWriter() {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/manikandans/self-intro.txt")));
			writer.write("I play e-sports game such as Free Fire.");//This method writes the content in the file at the position where the pointer is placed.
			writer.newLine();//This writes a new line in the file.
			writer.flush();//Flushes the data from the buffer to stream.
			
			writer.append("My favourite place is Kerala.");//This method appends the content at the end of the file.
			writer.flush();//Flushes the data from the buffer to stream.
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
		catch (IOException e) {
			System.out.println("Error while accessing the file.");
		}
	}
	
	/**
	 * This method return the string format of the given byte array.
	 * @param array array to converted to string.
	 * @return string format of array.
	 */
	public String toString(byte[] array) {
		String string = "[";
		for (int i = 0; i < array.length; i++) {
			if(i==array.length-1) {
				string+=array[i]+"]";
				break;
			}
			string+=array[i]+",";
		}
		return string;
	}
	
}
