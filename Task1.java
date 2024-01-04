import java.util.Random;
import java.util.Scanner;

public class RandomGenrator {

	public static final int Min_Range = 1;
	public static final int Max_Range = 100;
	public static final int Max_Attempts = 6;
	public static final int Max_Rounds = 3;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int totalScore = 0;
		System.out.println("What is your name?");
		String name = sc.nextLine();
		System.out.println(name +" "+ "Welcome to random guessing genrator game!");
		for (int i = 1; i <= Max_Rounds; i++) {
			int number = random.nextInt(Max_Range) + Min_Range;
			int attempts = 0;
			System.out.println("Guess the number in between"+" "+Min_Range+" "+Max_Range);
			System.out.println();
			System.out.println("Guess the number :");
			while (attempts < Max_Attempts) {
				int guessNum = sc.nextInt();
				attempts++;
				int leftAttempts = Max_Attempts-attempts;
				if (guessNum == number) {
					int score = Max_Attempts - attempts;
					totalScore = totalScore + score;
					System.out.println("Congrats you guessed correctly"+" "+attempts+" "+score);
					break;
				} else if (guessNum < number) {
					System.out.println("The number is greater than"+" "+guessNum+" "+"attempts left :"+leftAttempts);
					System.out.println();
				}

				else if (guessNum > number) {
					System.out.printf("The number is less than"+" "+guessNum+" "+"attempts left :"+leftAttempts);
					System.out.println();
				}
			}

			if (attempts == Max_Attempts) {
				System.out.println();
				System.out.println("The Random Number Is :"+" "+number);
			}
		}

		System.out.println("Game Over. Total Score :"+" "+totalScore);
		sc.close();
	}

}
