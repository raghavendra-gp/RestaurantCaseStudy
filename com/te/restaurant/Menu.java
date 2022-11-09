package com.te.restaurant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static Scanner scanner = new Scanner(System.in);

	static int[] or = new int[5];

	public static int[] order(String[] items, int[] rates) {
		boolean end = false;
		int sum = 0;

		do {
			System.out.println("Select items from the menu below: \n");
			System.out.println("\tMENU\n");

			for (int i = 0; i < items.length; i++)
				System.out.println((i + 1) + "        " + items[i] + "      " + rates[i]);

			System.out.println("\nEnter your choice: ");
			int choice = scanner.nextInt();
			if (choice > 0 && choice < 6) {

				System.out.println("your ordered: " + items[choice - 1]);
				System.out.println("Enter the quantity: ");
				int q = scanner.nextInt();
				try {
					or[choice - 1] += q;

				} catch (ArrayInsertionException e) {
					throw new ArrayInsertionException("Insufficient Fund!!");
				}
				
			}

			System.out.println("Do want to continue: (y/n)");
			char ch = scanner.next().charAt(0);

			if (ch == 'y')
				order(items, rates);

			else
				//throw new InputMismatchException("Enter (y/n) ");
			break;

		} while (end);

		return or;

	}

	public static void total(String[] items, int[] rates, int[] choi) {
		int sum = 0;
		System.out.println("Your Orders are:\n");
		for (int i = 0; i < choi.length; i++) {
			if (choi[i] != 0) {
				sum += choi[i] * rates[i];
				System.out.println(items[i] + "    " + choi[i] + "  =  " + rates[i] * choi[i] + "rs");
			}
		}

		System.out.println("The total bill is: " + sum);
	}

	public static void main(String[] args) {

		String items[] = { "Dosa", "Roti", "Idli", "Vada", "Poha" };
		int rates[] = { 80, 100, 30, 20, 40 };

		int[] choi = order(items, rates);
		total(items, rates, choi);

	}

}
