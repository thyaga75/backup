package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int temp;
		boolean isPrime = true;
		System.out.println("Enter the number >1 to find if it is prime: \n");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bufferedReader.readLine());
		if (num > 1) {
			for (int i = 2; i <= num / 2; i++) {
				temp = num % i;
				if (temp == 0) {
					isPrime = false;
					break;
				}
			}
			// If isPrime is true then the number is prime else not
			if (isPrime)
				System.out.println(num + " is Prime Number");
			else
				System.out.println(num + " is not Prime Number");
		} else
			System.out.println("Please enter the number >1 to find if it is prime: \n");
	}

}
