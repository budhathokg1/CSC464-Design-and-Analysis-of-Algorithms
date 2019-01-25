import java.util.Scanner;
public class DaysOfMonth {

	public static void main(String[] args) {
		int days;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a month (first three letters with the first letter in uppercase):");
		String month = in.nextLine();
		System.out.println("Enter a year: ");
		int year = in.nextInt();
		boolean isLeap = isLeapYear(year);
			if(month.equals("Jan") || month.equals("Mar") || month.equals("May") || month.equals("Jul")||
				month.equals("Aug") || month.equals("Oct") || month.equals("Dec")){
				System.out.println(month + " " +  year + " has 31 days");
			}
			else if(month.equals("Feb")){
				if(isLeap)
					System.out.println(month + " " + year + " has 29 days");
				else
					System.out.println(month + " " + year + " has 28 days");
			}
			else{
				System.out.println(month + " " + year + " has 30 days");

					
			}
			
		
	}
	
	public static boolean isLeapYear(int year){
		return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? true : false;
	}
	
	
}
