public class GameController {
	private final int PERSON_PLAY     = 0;
	private final int COMPUTER_0_PLAY = 1;
	private final int COMPUTER_X_PLAY = 2;
	private final GameField model = new GameField();	
	private final static GameView view = new GameView();
	private final ComputerOpponent comp = new ComputerOpponent();
	
	public void playGame(){
		switch (view.chooseKindOfGame()){
		case PERSON_PLAY: playWithPerson();
			break;
			
		case COMPUTER_0_PLAY: playWithComputer0();
			break;
			
		case COMPUTER_X_PLAY: playWithComputerX();
			break;
		}
	}
	
	private void getMoveFromUser(Coordinate coordinate){ 
		do{
			coordinate.setCoordinate(GameView.getCoordinateFromUser());
		} while (!model.isFieldCellFree(coordinate));
	}

	private Coordinate getCompCoordinate(Coordinate coordinate){
		do{
			Coordinate newCoordinate = new Coordinate(comp.generateCoordinate());
			coordinate.setCoordinate(newCoordinate);
			
		} while (!model.isFieldCellFree(coordinate));
		return coordinate;
	}
	
	private void move(char sign){
		Coordinate coordinate = new Coordinate();
		GameView.askForMove(sign);
		getMoveFromUser(coordinate);
		coordinate.setSign(sign);
		model.takeUpField(coordinate);
	}
	
	private void computerMove(char sign){
		Coordinate coordinate = new Coordinate();
		coordinate.setSign(sign);
		coordinate.setCoordinate(getCompCoordinate(coordinate));
		model.takeUpField(coordinate);
	}
	
	private void playWithPerson(){
		boolean isXMove = true;
		while (!model.isEndGame())
		{
			if (isXMove){
				move('X');
			} else {
				move('0');
			}
			isXMove = !isXMove;
			GameView.printOutField(model.getSignField());
		}
		GameView.showWinner(model.showWinner());
		
	}
	
	private void playWithComputerX(){
		boolean isXMove = true;
		while (!model.isEndGame())
		{
			if (isXMove){
				move('X');
			} else {
				computerMove('0');
				GameView.printOutField(model.getSignField());
			}
			isXMove = !isXMove;
		}
		GameView.printOutField(model.getSignField());
		GameView.showWinner(model.showWinner());
	}
	
	private void playWithComputer0(){
		boolean isXMove = true;
		while (!model.isEndGame())
		{
			if (isXMove){
				computerMove('X');
				GameView.printOutField(model.getSignField());
			} else {
				move('0');
			} 
			isXMove = !isXMove;
		}
		GameView.printOutField(model.getSignField());
		GameView.showWinner(model.showWinner());
	}
	
}
