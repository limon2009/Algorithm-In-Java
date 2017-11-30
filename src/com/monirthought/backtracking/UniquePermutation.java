package com.monirthought.backtracking;

import java.util.Scanner;

/**
 * Generate all unique permutations of a given string.
 * 
 * @author Moniruzzaman Md
 *
 */
public class UniquePermutation {

	final private int MAXN = 7;
	private int[] flag = new int[MAXN];
	private String input = null;
	StringBuffer tempString = null;

	/**
	 * Recursively generates all unique permutations.
	 * 
	 * @param index
	 * @param level
	 */
	private void generatePermutation(int index, int level) {

		tempString.setCharAt(level, input.charAt(index));

		StringBuffer alreadyTaken = new StringBuffer(input.length());

		flag[index] = 1;

		for (int i = 0; i < input.length(); i++) {
			if (flag[i] == 0) {
				if (-1 == alreadyTaken.indexOf(input.charAt(i) + "")) {
					generatePermutation(i, level + 1);
					alreadyTaken.append(input.charAt(i));
				}
			}
		}
		if (level == input.length() - 1) {
			System.out.println(tempString);
		}

		flag[index] = 0;

	}

	/**
	 * Read Input from Console.
	 */
	private void readInput() {
		Scanner scanner = new Scanner(System.in);
		this.input = scanner.nextLine();

		if (this.input.length() > 7) {
			System.exit(0);
		}
		this.tempString = new StringBuffer(this.input);
		StringBuffer alreadyTaken = new StringBuffer(input.length());

		for (int i = 0; i < this.input.length(); i++) {
			if (-1 == alreadyTaken.indexOf(input.charAt(i) + "")) {
				this.generatePermutation(i, 0);
				alreadyTaken.append(input.charAt(i));
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		new UniquePermutation().readInput();
	}

}
