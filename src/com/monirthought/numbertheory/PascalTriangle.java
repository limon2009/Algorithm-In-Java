package com.monirthought.numbertheory;

/**
 * Pascal Triangle Generation
 *  1
 *  1 1
 *  1 2 1
 *  1 3 3 1
 *  1 4 6 4 1
 * 
 * @author Md Moniruzzaman
 *
 */
public class PascalTriangle {
	final private int LIMIT = 15;
	private int[][] record = new int[2][LIMIT + 1];

	/**
	 * Draw Triangle
	 */
	private void drawTriangle() {
		int currentIndex = 1;
		int previousIndex = 0;
		/* Print very first number of the triangle */
		System.out.println("1");
		for (int i = 2; i <= LIMIT; i++) {
			/* First number always 1 */
			record[currentIndex][1] = 1;
			
			/* Print first number of a row */
			System.out.print("1");
			
			for (int j = 2; j < i; j++) {
				/* Calculate current number adding previous row's two numbers */
				record[currentIndex][j] = record[previousIndex][j] + record[previousIndex][j - 1];
				System.out.print(" " + record[currentIndex][j]);
			}
			
			/* Save last number of current row */
			record[currentIndex][i] = 1;
			
			/* Print last number of a row */
			System.out.println(" 1");

			/* Swap current index & previous index */
			currentIndex = currentIndex == 0 ? 1 : 0;
			previousIndex = previousIndex == 0 ? 1 : 0;
		}
	}

	public static void main(String arg[]) {
		new PascalTriangle().drawTriangle();
	}
}
