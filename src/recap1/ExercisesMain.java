package recap1;

public class ExercisesMain {
	public static int getComplementar(int n) {
		int perfectRound = 1;
		int copyOfN = n;
		while(n != 0) {
			perfectRound *= 10;
			n /= 10;
		}
		return (perfectRound - copyOfN);
	}
	
	public static int getPow(int b, int e) {
		int power = 1;
		for(int i = 0; i < e; i++) {
			power *= b;
		}
		return power;
	}
	public static void printPower(int b, int e) {
		for(int i = 0; i <= e; i++) {
			int res = getPow(b, i);
			System.out.print(res + " ");
		}
		System.out.println();
	}
	
	public static int getMultipleOf5Lower(int n) {
		return n - (n % 5);
	}
	
	public static int getMultipleOf5Upper(int n) {
		return  (n % 5 == 0) ? n : (n - (n % 5)) + 5;
	}
	////multiple of 5
	///return n - (n % 5)
	//return 5 * (n / 5)
	///sau cu for descrescator pana se divide cu 5
	///b. return  (n%5==0) ? n : (n - (n%5)) + 5;
	public static int sumOfDivProprii(int n) {
		int sum = 1;
		for(int i = 2; i <= n/2; i++) {
			if(n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	
	public static boolean areFriends(int a, int b) {
		if(sumOfDivProprii(a) == b && sumOfDivProprii(b) == a) {
			return true;
		}
		return false;
	}
	
	public static void printFriendsNumbers(int lowerLimit, int upperLimit) {
		for(int i = lowerLimit; i <= upperLimit; i++) {
			for(int j = i + 1; j <= upperLimit; j++) {
				if(areFriends(i, j)) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	public static void printFriendsNumbersOpt(int lowerLimit, int upperLimit) {
		for(int i = lowerLimit; i <= upperLimit; i++) {
			int sumDivI = sumOfDivProprii(i);
			int sumDivBack = sumOfDivProprii(sumDivI);
			if(i == sumDivBack && sumDivI > i) {
				System.out.println(i + " " + sumDivI);
			}
		}
	}
	
	public static boolean checkIfPrime(int n) {
		for(int i = 2; i <= n /2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void printSumsOfPrimeNumbers(int upperLimit) {
		int sum = 0;
		System.out.print(upperLimit + " -> ");
		for(int i = 2; i <= upperLimit; i++) {
			if(checkIfPrime(i)) {
				sum += i;
				if(sum > upperLimit) {
					break;
				}
				System.out.print(sum + " ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("The complement of 123 is: " + getComplementar(123));
		System.out.print("The powers of 2 from 0 to 10: ");
		printPower(2, 10);
		System.out.println("Numbers 220 and 284 are friends?: " + areFriends(220, 284));
		System.out.println("Multiple of 5 lower than 18: " + getMultipleOf5Lower(20));
		System.out.println("Multiple of 5 upper than 20: " + getMultipleOf5Upper(20));
		printFriendsNumbersOpt(1, 10000);
		printSumsOfPrimeNumbers(100);
	}

}
