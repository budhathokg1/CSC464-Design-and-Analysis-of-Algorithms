/*
 Author: Ganesh Budhathoki
 Class: CSC 464
 Instructor: Dr.Ward
 Date: 09/02/2018
 */
import java.util.*;
import java.io.*;
public class PlanningTrip {

	public static void main(String[] args) {
		// Code for reading from a text file.
		//Arraylist to store hotels stop point
		ArrayList<Integer> hotels = new ArrayList<>();
		try{ 																//File expception handler
			Scanner dataFile = new Scanner(new File("HW1Data.txt"));		//Scan new file
			while (dataFile.hasNextInt())									//loops until the file has number
				hotels.add(dataFile.nextInt());								//Insert stop point for hotel into arraylist
			dataFile.close();
		}
		catch(FileNotFoundException ex){									//Catch exception
			System.out.println("Type a correct file name.\n" + ex);			//Show error messages
		}
  	
		int[] penalties = new int[hotels.size()];							//Array for penalties
		int[] previous = new int[hotels.size()];							//Array for previous stops
		ArrayList<Integer> chosenIndex = new ArrayList<>();					//Arraylist for chosen indexes for optimum solution

		for (int i = 0; i < hotels.size(); i++) {							//looping through stop point
			int penalty = (int) (Math.pow((200 - hotels.get(i)), 2));
			penalties[i] = 	penalty;	//calculating penalties
			//the three lines below loops and comapres the penalties and updates the penalties and saves the previous index of the stops
			for (int j = 0; j < i; j++) {
				penalty = (int) (penalties[j] + Math.pow((200 - (hotels.get(i) - hotels.get(j))), 2));
				if (penalty < penalties[i]) {
					penalties[i] = (int) (penalties[j] + Math.pow((200 - (hotels.get(i) - hotels.get(j))), 2));
					previous[i] = j + 1;
				}
			}
		}
		//Given the previous index, assort the optimal indexes for the solution
		int index = previous.length-1;
		while(index >= 0){
			chosenIndex.add(index + 1 );
			index = previous[index] - 1;
		}
		try{											//File handler for writing into a file
			PrintWriter outputFile = new PrintWriter("HW1Output.txt");
			outputFile.println("Distance: 0 Total Penalty: 0");
			System.out.println("Distance: 0 Total Penalty: 0");
			for(int i = chosenIndex.size()-1; i >= 0; i --){
				// Code for writing to a text file and printing in the console.
				System.out.println("Distance: " + hotels.get(chosenIndex.get(i)-1) + " Total Penalty: " + penalties[chosenIndex.get(i) - 1]);
				outputFile.println("Distance: " + hotels.get(chosenIndex.get(i)-1) + " Total Penalty: " + penalties[chosenIndex.get(i) - 1]);
			}
			outputFile.close();
		}
		catch(Exception ex){
			System.out.println("Cannot write to the file\n" + ex);
		}

	}

}
