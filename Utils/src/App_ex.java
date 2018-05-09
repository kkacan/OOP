import java.util.InputMismatchException;
import java.util.Scanner;

public class App_ex {
	
	private static final int AGE = 100;
	private static int cnt = 1;
	private static Scanner sc;

	public static void main(String[] args) {

		int gueage;

		int low;
		int upp;
		boolean proc = true;
		sc = new Scanner(System.in);

		while (proc) {

			try {

				System.out.println("Enter lower bound: ");
				low = sc.nextInt();
				System.out.println("Enter upper bound: ");
				upp = sc.nextInt();
				System.out.println("Enter your guess: ");
				gueage = sc.nextInt();

				if (guessAge(low, upp, gueage)) {

					System.out.println("Proceede 1 = y / 2 = n");
					if (sc.nextInt() == 1) {
						proc = true;
						cnt++;
					} else {
						proc = false;
					}

				} else {
					proc = false;
				}

			} catch (InputMismatchException ex) {
				sc.next();
				System.out.println("Invalid input... \n" + "Enter a integer....");
			} catch (AgeInputException e) {

				System.out.println(e.getMessage());
				System.out.println("Your lower bound: " + e.getLower() + " is higher then upper value: " + e.getUpper());
				System.out.println("Your guess is: " + e.getVal());
			}

		}

	}

	public static boolean guessAge(int low, int upp, int age) throws AgeInputException {

		if (low > upp) {

			String str = "Error in bounds --> lower must be less of upper!";

			throw new AgeInputException(low, upp, age, str);

		}

		if (age == AGE) {

			System.out.println("You entered: " + age + " and you guess!");
			System.out.println("You guess after: " + cnt + " times!");
			System.out.println("Game is over --> You won");
			return false;
		} else if (AGE >= upp) {
			System.out.println("Targeted value is greater or equal then upper bound: " + upp);
			return true;
		} else if (AGE <= low) {
			System.out.println("Targeted value is lower or equal then lower bound: " + low);
			return true;
		} else {
			return true;
		}

	}

}
