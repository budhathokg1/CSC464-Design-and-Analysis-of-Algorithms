import java.util.*;
import java.io.*;
public class HotelStops {

	public static void main(String[] args) throws FileNotFoundException {
		int currentStop = 0;
		int tempPen = 0;
		int index = 0;
		int prev = -1;
		Scanner input = new Scanner(new File("HW1Data.txt"));
		System.out.print("Enter the number of stops available: ");//ghhhhhhh
		Scanner input1 = new Scanner(System.in); //gjhjhjhjhj
		int size = input1.nextInt() + 1;//gffffff
		input1.close();
		int[] penalities = new int[size];
		penalities[0] = tempPen;
		int[] stops = new int[size]; //hotels for me
		stops[0] = currentStop;	//hotels for me
		int[] prevStops = new int[size];
		prevStops[0] = prev;
		index ++;
		prev++;
		while(input.hasNext()){
			currentStop = input.nextInt();
			stops[index] = currentStop;
			if(index == 1){
				prevStops[index] = prev;
				penalities[index] = (int) Math.pow((200 - tempPen),2);
			}
			else{
				int amount = penalities[index-1] + (int)Math.pow((200 - (stops[index-1] - stops[index])),2);
				prev = index - 1;
				tempPen = amount;
				for(int i = index - 2; i >= 0; i--){
					amount = penalities[i] + (int)Math.pow(200 - (stops[index] - stops[i]),2);
					if(tempPen > amount){
						prev = i;
						tempPen = amount;
					}
						
				}
				penalities[index] = tempPen;
				prevStops[index] = prev;
				
			}
			index++;
		}
		for(int i= 0; i < prevStops.length; i++){
			System.out.println(prevStops[i]);
		}
		input.close();
		int precedingIndex = prevStops[stops.length - 1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(prevStops.length - 1);
		while(precedingIndex >= 0 ){
			list.add(precedingIndex);
			precedingIndex = prevStops[precedingIndex];
		}

		for(int i = list.size()-1; i >= 0; i--){
			System.out.println("Distance: " + stops[list.get(i)] + " Total Penalty: " + penalities[list.get(i)]);
		}
		
	}

}
