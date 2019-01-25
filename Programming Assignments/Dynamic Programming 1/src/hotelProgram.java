import java.io.*;
import java.util.*;

public class hotelProgram {

	public static void main(String[] args) throws FileNotFoundException{
		// Code for reading from a text file.
		//Arraylist to store hotels stop point
		ArrayList<Integer> hotels = new ArrayList<>();
		hotels.add(0);
		Scanner dataFile = new Scanner(new File("HW1Data.txt"));		//Scan new file
		while (dataFile.hasNextInt())									//loops until the file has number
			hotels.add(dataFile.nextInt());								//Insert stop point for hotel into arraylist
		dataFile.close();
		
		int[] penalties = new int[hotels.size()];							//Array for penalties
		int[] previous = new int[hotels.size()];							//Array for previous stops
		ArrayList<Integer> chosenIndex = new ArrayList<>();					//Arraylist for chosen indexes for optimum solution


	}

}
