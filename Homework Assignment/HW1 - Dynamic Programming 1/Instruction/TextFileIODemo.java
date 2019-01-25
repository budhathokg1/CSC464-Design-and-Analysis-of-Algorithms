import java.util.*;
import java.io.*;

public class TextFileIODemo {
  public static void main(String[] args) throws FileNotFoundException {	
  	// Here is code for reading from a text file.		
	Scanner dataFile = new Scanner(new File("HW1Data.txt"));
	ArrayList<Integer> hotels = new ArrayList<>();
	hotels.add(0); // optional line
	while (dataFile.hasNextLine())
		hotels.add(dataFile.nextInt());
	dataFile.close();

	// Here is code for writing to a text file.
	PrintWriter outputFile = new PrintWriter("HW1Output.txt");
	outputFile.println("Hello text file!");
	outputFile.close();
	// ...
