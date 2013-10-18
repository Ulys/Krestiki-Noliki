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
			Coordinate newCoordinate = new Coordinate(GameView.getCoordinateFromUser());
			coordinate.setX(newCoordinate.getX());
			coordinate.setY(newCoordinate.getY());
		} while (!model.isFieldCellFree(coordinate));
	}
	
	private Coordinate getCompCoordinate(Coordinate coordinate){
		do{
			Coordinate newcoordinate = new Coordinate(comp.generateCoordinate());
			coordinate.setCoordinate(newcoordinate);
			
		} while (!model.isFieldCellFree(coordinate));
		return coordinate;
	}
	
	private void move(char sign){
		Coordinate coordinate = new Coordinate();
		coordinate.setSign(sign);
		GameView.askForMove(sign);
		getMoveFromUser(coordinate);
		model.takeUpField(coordinate);
	}
	
	private void computerMove(char sign){
		Coordinate coordinate = new Coordinate();
		coordinate.setSign(sign);
		coordinate.setCoordinate(getCompCoordinate(coordinate));
		model.takeUpField(coordinate);
	}
	
	private void playWithPerson(){
		boolean moveIndex = true;
		while (!model.isEndGame())
		{
			if (moveIndex){
				move('X');
			} else {
				move('0');
			}
			moveIndex = !moveIndex;
			GameView.printOutField(model.getSignField());
		}
		GameView.winnerShowing(model.winnerShowing());
		
	}
	
	private void playWithComputerX(){
		boolean moveIndex = true;
		while (!model.isEndGame())
		{
			if (moveIndex){
				move('X');
			} else {
				computerMove('0');
				GameView.printOutField(model.getSignField());
			}
			moveIndex = !moveIndex;
		}
		GameView.printOutField(model.getSignField());
		GameView.winnerShowing(model.winnerShowing());
	}
	
	private void playWithComputer0(){
		boolean moveIndex = true;
		while (!model.isEndGame())
		{
			if (moveIndex){
				computerMove('X');
				GameView.printOutField(model.getSignField());
			} else {
				move('0');
			} 
			moveIndex = !moveIndex;
		}
		GameView.printOutField(model.getSignField());
		GameView.winnerShowing(model.winnerShowing());
	}
	
}
