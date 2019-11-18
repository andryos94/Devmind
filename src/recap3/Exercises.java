package recap3;

import java.util.Arrays;

public class Exercises {
	public static int containsChar(char[] array, char key) {
		boolean contains = false;
		int pos = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				contains = true;
				pos = i;
			}
		}
		if (contains == true) {
			return pos;
		}
		return 0;
	}

	public static void printCharWithMaxFrequency(String sentence, String key) {
		String sentenceWithoutSpaces = sentence.replaceAll(" ", "").toLowerCase();
		char[] arrayChars = new char[sentenceWithoutSpaces.length()];
		int[] arrayCounts = new int[sentenceWithoutSpaces.length()];
		int counter = 0;
		int numberOfElem = 0;
		for (int i = 0; i < sentenceWithoutSpaces.length(); i++) {
			int position = containsChar(arrayChars, sentenceWithoutSpaces.charAt(i));
			if (position > 0) {
				counter = arrayCounts[position];
				counter++;
				arrayCounts[position] = counter;
			} else {
				arrayChars[numberOfElem] = sentenceWithoutSpaces.charAt(i);
				counter = arrayCounts[numberOfElem];
				counter++;
				arrayCounts[numberOfElem] = counter;
				numberOfElem++;
			}
		}
		arrayChars = Arrays.copyOf(arrayChars, numberOfElem);
		arrayCounts = Arrays.copyOf(arrayCounts, numberOfElem);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arrayCounts.length; i++) {
			if (arrayCounts[i] > max) {
				max = arrayCounts[i];
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arrayCounts.length; i++) {
			if (arrayCounts[i] < min) {
				min = arrayCounts[i];
			}
		}

		if (key.equalsIgnoreCase("max_aparition")) {
			for (int i = 0; i < arrayCounts.length; i++) {
				if (arrayCounts[i] == max) {
					System.out.println("Character '" + arrayChars[i] + "' appears " + max + " times.");
				}
			}
		} else if (key.equalsIgnoreCase("min_aparition")) {
			for (int i = 0; i < arrayCounts.length; i++) {
				if (arrayCounts[i] == min) {
					System.out.println("Character '" + arrayChars[i] + "' appears " + min + " times.");
				}
			}
		} else {
			System.out.println("The key parameter must be min_aparition or max_aparition");
		}

	}

	public static String removeAllNonLetters(String sentence) {
		String output = "";
		for (int i = 0; i < sentence.length(); i++) {
			if (Character.isLetter(sentence.charAt(i))) {
				output += sentence.charAt(i);
			}
		}
		return output;
	}

	public static void printCharArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void printIntArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static boolean anagramSolver(String anag1, String anag2) {
		String anag1Letter = removeAllNonLetters(anag1).toLowerCase();
		char[] arrayCharsAnag1 = new char[anag1Letter.length()];
		int[] arrayCountsAnag1 = new int[anag1Letter.length()];
		int counter = 0;
		int numberOfElem = 0;
		for (int i = 0; i < anag1Letter.length(); i++) {
			int position = containsChar(arrayCharsAnag1, anag1Letter.charAt(i));
			if (position > 0) {
				counter = arrayCountsAnag1[position];
				counter++;
				arrayCountsAnag1[position] = counter;
			} else {
				arrayCharsAnag1[numberOfElem] = anag1Letter.charAt(i);
				counter = arrayCountsAnag1[numberOfElem];
				counter++;
				arrayCountsAnag1[numberOfElem] = counter;
				numberOfElem++;
			}
		}
		arrayCharsAnag1 = Arrays.copyOf(arrayCharsAnag1, numberOfElem);
		arrayCountsAnag1 = Arrays.copyOf(arrayCountsAnag1, numberOfElem);
		printCharArray(arrayCharsAnag1);
		printIntArray(arrayCountsAnag1);

		String anag2Letter = removeAllNonLetters(anag2).toLowerCase();
		char[] arrayCharsAnag2 = new char[anag2Letter.length()];
		int[] arrayCountsAnag2 = new int[anag2Letter.length()];
		counter = 0;
		numberOfElem = 0;
		for (int i = 0; i < anag2Letter.length(); i++) {
			int position = containsChar(arrayCharsAnag2, anag2Letter.charAt(i));
			if (position > 0) {
				counter = arrayCountsAnag2[position];
				counter++;
				arrayCountsAnag2[position] = counter;
			} else {
				arrayCharsAnag2[numberOfElem] = anag2Letter.charAt(i);
				counter = arrayCountsAnag2[numberOfElem];
				counter++;
				arrayCountsAnag2[numberOfElem] = counter;
				numberOfElem++;
			}
		}
		arrayCharsAnag2 = Arrays.copyOf(arrayCharsAnag2, numberOfElem);
		arrayCountsAnag2 = Arrays.copyOf(arrayCountsAnag2, numberOfElem);
		printCharArray(arrayCharsAnag2);
		printIntArray(arrayCountsAnag2);

		if (arrayCharsAnag1.length != arrayCharsAnag2.length) {
			return false;
		}

		for (int i = 0; i < arrayCharsAnag1.length; i++) {
			int position = containsChar(arrayCharsAnag2, arrayCharsAnag1[i]);
			if (!(position > 0) && !(arrayCharsAnag1[i] == arrayCharsAnag2[position])) {
				return false;
			}
		}
		return true;
	}

	public static String[][] method() {
		String[] rez = { "fdsdfsd", "dfsa" };
		String[] rez2 = { "fdsdfsd", "dfsa", "fdadfaf" };
		String[][] aux = new String[2][];
		aux[0] = rez;
		aux[1] = rez2;
		return aux;
	}

	public static int convertStringToNumber(String number) {
		int prod = 1;
		int intNumber = 0;
		for (int i = number.length() - 1; i >= 0; i--) {
			intNumber = intNumber + prod * (number.charAt(i) - 48);
			prod *= 10;
		}
		return intNumber;
	}

	public static String[] lettersMatch(String[] words, String key, int matchKey) {
		String[] cachedStrings = new String[words.length];
		int[] lettersCount = new int[words.length];
		int numberOfElem = 0;
		int matchCount = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < key.length(); j++) {
				///word length < key length
				if (j + 1 > words[i].length()) {
					break;
				}
				if (words[i].toLowerCase().charAt(j) == key.toLowerCase().charAt(j)) {
					matchCount++;
				}
			}
			lettersCount[i] = matchCount;
			matchCount = 0;
		}
		
		for(int i = 0; i < words.length; i++) {
			if(lettersCount[i] >= matchKey) {
				cachedStrings[numberOfElem] = words[i];
				numberOfElem++;
			}
		}
		return Arrays.copyOf(cachedStrings, numberOfElem);
	}

	public static void displayArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Max aparitions:");
		printCharWithMaxFrequency("Simple sentence.", "max_aparition");
		printCharWithMaxFrequency("Becoming a programmer is like gaining super powers!", "max_aparition");
		System.out.println("Min aparitions:");
		printCharWithMaxFrequency("Simple sentence.", "min_aparition");
		printCharWithMaxFrequency("Becoming a programmer is like gaining super powers!", "min_aparition");
		System.out.println("Anagram solver!");
		System.out.println("fairy tales! <--> rail, safety");
		System.out.println(anagramSolver("fairy tales!", "rail, safety"));
		System.out.println("silver bullet <--> sunny day");
		System.out.println(anagramSolver("silver bullet", "sunny day"));
		System.out.println("Covert String to Integer");
		System.out.println(convertStringToNumber("2516348"));

		String[][] test = method();
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}

		String[] str = new String[] { "clothes", "ant", "drop", "Fly", "racoon", "class", "Plane" };
		displayArray(lettersMatch(str, "plot", 1));
		displayArray(lettersMatch(str, "plot", 2));
		displayArray(lettersMatch(str, "plot", 3));
	}

}
