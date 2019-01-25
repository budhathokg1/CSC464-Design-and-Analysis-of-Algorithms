/*
 * Author: Ganesh Budhathoki
 * Class: CSC 464
 * Instructor: Dr. Ward
 * Date: 09/05/2018
 */
import java.util.*;
public class ModularExponentiation {

	public static void main(String[] args) {
		int x, N, y, result;
		Scanner in = new Scanner(System.in);
		try{
			System.out.print("Enter integer x(base): ");
			x = in.nextInt();	
			System.out.print("Enter integer N(modulus): ");
			N = in.nextInt();
			System.out.print("Enter integer y(exponent): ");
			y = in.nextInt();
			in.close();
			result = modexp(x, y, N);
			System.out.println(x + "^" + y + " mod " + N + " is " + result);
		}
		catch(InputMismatchException ex){
			System.out.println("Enter valid integer.\n" + ex);
		}


	}
	
	private static int modexp(int x, int y, int N){
		if(y == 0)
			return 1;
		int z = modexp(x, (int) Math.floor(y/2), N);
		if(y%2 == 0){
			return ((int) Math.pow(z, 2)) % N;
		}
		else
			return (x * (int) Math.pow(z, 2)) % N;
		
	}

}
