package obg;
import java.util.Random;
import java.util.Scanner;

public class HighOrLowGame {
	private static String printLives(int x) {
		String lives = "";
		for(int i = 0; i < x; i++) {
			lives += " ♥";
		}
		return lives;
	}

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		char sep1 = 017;
		int lifeCount = 3;
		boolean control = true;
		
		System.out.println(sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " "
				+ sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1);
		System.out.println(sep1 + " WELCOME TO: HIGH OR LOW " + sep1);
		System.out.println(sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " "
				+ sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1 + " " + sep1);
		System.out.println("\nIn this score based game computer will print you a reference number on the screen, and pick a number itself."
				+ "\nEach round you are asked to guess if the computer's pick is eighter HIGHER or LOWER than the number on screen.\nNumbers are always from 0 to 1000. " +
				"You will start with 3 lives, each wrong answer will decrease your lives by one.\nIf you are out of lives, game is over.");
		System.out.println("\nLives: " + printLives(lifeCount));
		System.out.println("Press Enter to start.");
		String enter = scanner.nextLine();
		while (control) {
			
			int reference = random.nextInt(0, 1001);
			int guessThis = random.nextInt(0, 1001);
			System.out.println("\nIs the computer's pick higher or lower than \"" + reference + "\" ?\n");
			System.out.println(sep1 + " Lower: press L " + sep1 + " Higher: press H " + sep1 + " Press 0 to exit " + sep1 + "\n\n");
			char guess = scanner.next().toLowerCase().charAt(0);
			
			switch (guess) {
			case 'h':
				if (reference < guessThis) {
					if (score != 0) {
						score *= 2;
					} else {
						score += 100;
					}
					System.out.println("Correct guess! Score: " + score + "\nLives remaining: " + printLives(lifeCount));
				} else if (reference == guessThis) {
					System.out.println("Number and reference number were same, no penalty applied. Score: " + score + "\nLives remaining: " + printLives(lifeCount));
				} else {
					if(score > 49) {
						score -= 50;
					}
					else {
						score = 0;
					}
					lifeCount--;
						if(lifeCount == 0) {
							System.err.println("End of lives");
							System.out.println("Final Score: " + score);
							control = false;
						}
						else {
							System.err.println("Wrong guess :( Score: " + score + "\nLives remaining: " + printLives(lifeCount));
						}
				}
				break;
			case 'l':
				if (reference > guessThis) {
					if (score != 0) {
						score *= 2;
					} else {
						score += 100;
					}
					System.out.println("Correct guess! Score: " + score + "\nLives remaining: " + printLives(lifeCount));
				} else if (reference == guessThis) {
					System.out.println("Computer's pick and reference number were same, no points were reduced. Score: " 
							+ score + "\nLives remaining: " + printLives(lifeCount));
				} else {
					if(score > 49) {
						score -= 50;
					}
					else {
						score = 0;
					}
					lifeCount--;
						if(lifeCount == 0) {
							System.err.println("End of lives");
							System.out.println("Final Score: " + score);
							control = false;
						}
						else {
							System.err.println("Wrong guess :( Score: " + score + "\nLives remaining: " + printLives(lifeCount));
						}
				}
				break;
			case '0':
				System.err.println(sep1 + " GAME ENDED " + sep1);
				System.out.println("Final Score: " + score);
				control = false;
				break;
			default:
				System.err.println("Undefined choice, available choices are: \n");
				System.err.println(sep1 + " Lower: press L " + sep1 + " Higher: press H " + sep1 + " Press 0 to exit " + sep1 + "\n\n");
			}
		}
	}
}
