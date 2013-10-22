import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void testIsEndGame(){
		GameField newGameField = new GameField();
		assertFalse(newGameField.isEndGame());
	}
	@Test
	public void testWhatIsTheEnd(){
		GameField newGameField = new GameField();
		assertEquals(0, newGameField.whatIsTheEnd());
	}
	@Test
	public void  testTakeUpSignField(){
		GameField newGameField = new GameField();
		Coordinate testCoordinate = new Coordinate(1, 2, 'X');
		char sign[][] = newGameField.getSignField();
		newGameField.takeUpField(testCoordinate);
		assertEquals('X', sign[testCoordinate.getX()][testCoordinate.getY()]);
	}
}
