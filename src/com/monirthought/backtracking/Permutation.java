package com.monirthought.backtracking;

import java.util.Scanner;

/**
 * Generate all permutation of a given string.
 * 
 * @author Moniruzzaman Md
 *
 */
public class Permutation {

	final private int MAXN = 7;
	private int[] flag = new int[MAXN];
	private String input = null;
	StringBuffer tempString = null;

	/**
	 * Recursively generates all permutations.
	 * 
	 * @param index
	 * @param level
	 */
	private void generatePermutation(int index, int level) {

		tempString.setCharAt(level, input.charAt(index));

		flag[index] = 1;

		for (int i = 0; i < input.length(); i++) {
			if (flag[i] == 0) {
				generatePermutation(i, level + 1);
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
		for (int i = 0; i < this.input.length(); i++) {
			this.generatePermutation(i, 0);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		new Permutation().readInput();
	}
}
