package com.monirthought.sieveoferatosthenes;

/**
 * Implementation of Sieve Of Eratosthenes algorithm to generate all primes up
 * to 100
 * 
 * @author Moniruzzaman Md
 *
 */
public class SieveOfEratosthenes {

	private final int LIMIT = 100;
	private int[] flag = new int[LIMIT + 1];
	private int[] primes = new int[LIMIT];
	private int totalPrimes = 0;

	/**
	 * Sieve Of Eratosthenes algorithm implementation
	 * 
	 * @return
	 */
	public void implementSieve() {
		for (int i = 2; i * i <= LIMIT;) {
			for (int j = i + i; j <= LIMIT; j += i) {
				flag[j] = 1;
			}
			/* find the next prime */
			for (i = i + 1; flag[i] == 1 && i <= LIMIT; i++)
				;
		}

		/* Save all primes */
		for (int i = 2; i <= LIMIT; i++) {
			if (flag[i] == 0) {
				primes[totalPrimes++] = i;
			}
		}
	}

	/**
	 * Print all generated primes.
	 * 
	 * @return
	 */
	public void printAllPrime() {
		for (int i = 0; i < this.totalPrimes; i++) {
			System.out.print(primes[i] + " ");
		}
	}

	public static void main(String args[]) {
		SieveOfEratosthenes eratosthenes = new SieveOfEratosthenes();
		eratosthenes.implementSieve();
		eratosthenes.printAllPrime();
	}

}
