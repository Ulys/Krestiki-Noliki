

public class MainGame {
	private static GameController playGame(){
		GameController game = new GameController();
		return game;
	}
	
	public static void main(String[] args){               
		GameController newGame = playGame();
		newGame.playGame();
	}
}
