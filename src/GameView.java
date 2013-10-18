import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameView {
	private static final int KIND_OF_GAME[]  = { 0, 1, 2 };
	private static final int PERSON_PLAY	 = 1;
	private static final int COMPUTER_0_PLAY = 2;
	private static final int COMPUTER_X_PLAY = 3;
	private static final int SIZE 			 = 3;
	private static final int MAX_INPUT 		 = 3;
	private static final int MIN_INPUT 		 = 1;
	
	public static int getNumberForCordinates() {
		int number = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			number = Integer.parseInt(br.readLine());
			if (number < MIN_INPUT && number > MAX_INPUT) {
				System.out
						.println("Sorry, but the numberber was wrong!!!\n It should be from "+ MIN_INPUT 
								+ " to "+ MAX_INPUT +" included.\n Please, try again.");
				number = getNumberForCordinates() + 1;
			}
		} catch (NumberFormatException e) {
			System.out.println("Not a numberber!!");
			number = getNumberForCordinates() + 1;
		} catch (IOException e) {
			number = getNumberForCordinates() + 1;
		}
		return number - 1;
	}

	public static Coordinate getCoordinateFromUser() {
		Coordinate coordinate = new Coordinate();
		System.out.println("Input row: ");
		coordinate.setX(getNumberForCordinates());
		System.out.println("Input column: ");
		coordinate.setY(getNumberForCordinates());
		return coordinate;
	}

	public int chooseKindOfGame() {
		System.out
				.println("Choose type of Game:\n"+ PERSON_PLAY +
						" - play with person\n"+ COMPUTER_0_PLAY + " - play X against computer\n" 
						+ COMPUTER_X_PLAY + " - play 0 against computer");
		int kindOfGame;
		do {
			kindOfGame = GameView.getNumberForCordinates();
		} while (!isKindOfGameReal(kindOfGame));
		return kindOfGame;
	}

	private boolean isKindOfGameReal(int kindOfGame) {
		for (int i = 0; i < KIND_OF_GAME.length; i++){
			if (kindOfGame == KIND_OF_GAME[i]){
				return true;
			}
		}
		return false;
	}
	
	public static void askForMove(char sign){
		System.out.println(sign + " move");
	}
	
	public static void winnerShowing(char sign){
		if (sign != 0){
			System.out.println("Congratulations " + sign + " win!");
		} else { 
			System.out.println("Standoff");
		}
	}
	
	public static void printOutField(char signField[][]){
		for (int i = 0; i < SIZE; i++ ){
			System.out.println("      |     |");
			System.out.println("   " + signField[i][0] + "  |  " + signField[i][1] +"  |  "+ signField[i][2]);
			System.out.println("      |     |");
			if (i != 2){
				System.out.println(" -----+-----+-----");
			}
		}
	}
}
