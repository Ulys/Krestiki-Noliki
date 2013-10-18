import java.util.Random;


public class ComputerOpponent {
	private static Random RAND_3 = new Random();
	private int generateNum(){
		return RAND_3.nextInt(3);
	}
	
	public Coordinate generateCoordinate(){
		Coordinate cord = new Coordinate();
		cord.setX(generateNum());
		cord.setY(generateNum());
		return cord;
	}
}
