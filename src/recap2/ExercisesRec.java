package recap2;

import java.util.Arrays;

public class ExercisesRec {
	public static int reversedNumberRec(int n) {
		String number = String.valueOf(n);
		int len = number.length() - 1;
		if(n == 0) {
			return 0;
		} 
		return reversedNumberRec(n/10) + (n % 10) * (int)Math.pow(10, len);
	}
	
	public static int reversedNumberIterative(int n) {
		int reversed = 0;
		while(n != 0) {
			int lastDigit = n % 10;
			reversed = reversed * 10 + lastDigit; 
			n /= 10;
		}
		return reversed;
	}
	
	public static int aPowerbRec(int a, int b) {
		if(b == 0) {
			return 1;
		}
		b--;
		return aPowerbRec(a, b) * a;
	}
	
	public static int aPowerbIterative(int a, int b) {
		int prod = 1;
		for(int i = 0; i < b; i++) {
			prod *= a;
		}
		return prod;
	}
	
	public static int[] shift0sToLeft(int[] array) {
		int[] zerosArray = new int[array.length];
		int[] nonZerosArray = new int[array.length];
		int numberOfZeros = 0;
		int numberOfNonZeros = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 0) {
				zerosArray[numberOfZeros] = array[i];
				numberOfZeros++;
			} else {
				nonZerosArray[numberOfNonZeros] = array[i];
				numberOfNonZeros++;
			}
		}
		zerosArray = Arrays.copyOf(zerosArray, numberOfZeros);
		nonZerosArray = Arrays.copyOf(nonZerosArray, numberOfNonZeros);
		int[] result = Arrays.copyOf(zerosArray, numberOfZeros + numberOfNonZeros);
		System.arraycopy(nonZerosArray, 0, result, zerosArray.length, nonZerosArray.length);
		return result;
	}
	
	public static void bubbleSortIncr(double[] values) {
		boolean swapped = false;
		int k = 1;
		while(!swapped) {
			swapped = true;
			for(int i = 0; i < values.length - k; i++) {
				if(values[i] > values[i + 1]) {
					double temp = values[i + 1];
					values[i + 1] = values[i];
					values[i] = temp;
					swapped = false;
				}
			}
			k++;
		}
	}
	
	public static void bubbleSortDecr(double[] values) {
		boolean swapped = false;
		int k = 1;
		while(!swapped) {
			swapped = true;
			for(int i = 0; i < values.length - k; i++) {
				if(values[i] < values[i + 1]) {
					double temp = values[i + 1];
					values[i + 1] = values[i];
					values[i] = temp;
					swapped = false;
				}
			}	
		}
		k++;
	}
	
	public static void printArray(double[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Reversed number recursive: " + reversedNumberRec(12343));
		System.out.println("Reversed number iterative: " + reversedNumberIterative(12343));
		
		System.out.println("A powered B recursive: " + aPowerbRec(2, 5));
		System.out.println("A powered B iterative: " + aPowerbIterative(2, 5));
		
		int[] array = new int[] {0, 2, 1, 0, -1, 14, 0, -6};
		int[] result = shift0sToLeft(array);
		printArray(result);
		
		double[] array2 = new double[] { 0, 2.3, 1.2, 1.21, 9.5, 7.4, 0};
		bubbleSortIncr(array2);
		printArray(array2);
		
		array2 = new double[] { 0, 2.3, 1.2, 1.21, 9.5, 7.4, 0};
		bubbleSortDecr(array2);
		printArray(array2);
	}

}
