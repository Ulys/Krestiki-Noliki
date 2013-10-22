public class GameField {
	private static final int SIZE = 3;
	public char signField[][] = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
	
	public char[][] getSignField(){
		return signField;
	}
	
	public boolean isFieldCellFree(Coordinate coordinate){
		return signField[coordinate.getX()][coordinate.getY()] == 0;
	}
	
	public void takeUpField(Coordinate coordinate){
		if (isFieldCellFree(coordinate)){	
			takeUpSignField(coordinate);
		}
	}
	
	private boolean isAnyFreeCell(){
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				if (isFieldCellFree(i, j)){
					return true;
				}
			}
		}
		return false;
	}
	
	private void takeUpSignField(Coordinate coordinate){
		signField[coordinate.getX()][coordinate.getY()] = coordinate.getSign();
	}
	
	private boolean isFieldCellFree(int x, int y){
		return signField[x][y] == 0;
	}
	
	public char showWinner(){
		return whatIsTheEnd();
	}
	
	public boolean isEndGame(){
		return isWinnerCombination() || !isAnyFreeCell();
	}
	
	public char whatIsTheEnd(){
		if (isEndGame())
			if (isWinnerCombination()){
				return whoWin();
			} else {
				return 0;
			}
		return 0;
	}
	
	private boolean isWinnerCombination(){
		for (int i = 0; i < SIZE; i++){
			if (horizontalCheck(i) || verticalCheck(i) || diagonalCheck()){
				return true;
			}
		}
		return false;
	}
	
	private char whoWin(){
		for (int i = 0 ; i < SIZE; i++){
			if (horizontalCheck(i)){
				return signField[i][i];
			}
			if (verticalCheck(i)){
				return signField[i][i];
			}
		}
		if(diagonalCheck()){
			return signField[1][1];
		}
		return 0;
	}
	
	private boolean horizontalCheck(int row){
		if (signField[row][0] == 0){
			return false;
		}
		return (signField[row][0] == signField[row][1])&&(signField[row][0] == signField[row][2]);
	}
	
	private boolean verticalCheck(int column){
		if (signField[0][column] == 0){
			return false;
		}
		return (signField[0][column] == signField[1][column])&&(signField[0][column] == signField[2][column]);
	}
	
	private boolean diagonalCheck(){
		if (signField[1][1] == 0){
			return false;
		}
		return firstDiagonalCheck()||secondDiagonalCheck();
	}
	
	private boolean firstDiagonalCheck(){
		return ((signField[0][0] == signField[1][1])&&(signField[1][1] == signField[2][2]));
	}
	
	private boolean secondDiagonalCheck(){
		return ((signField[0][2] == signField[1][1])&&(signField[1][1] == signField[2][0]));
	}
}
