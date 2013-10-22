
public class Coordinate {
	private int x;
	private int y; 
	private char sign;
	
	Coordinate(){
		x = -1;
		y = -1;
		sign = 0;
	}
	Coordinate(int x, int y, char sign){
		this.x = x;
		this.y = y;
		this.sign = sign;
	}
	Coordinate(Coordinate coordinate){
		this.x = coordinate.getX();
		this.y = coordinate.getY();
		if (coordinate.getSign() != 0)
			this.sign = coordinate.getSign();
	}
	
	public void setCoordinate(Coordinate coordinate){
		this.x = coordinate.getX();
		this.y = coordinate.getY();
		if (coordinate.getSign() != 0)
			this.sign = coordinate.getSign();
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setSign(char sign){
		this.sign = sign;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public char getSign(){
		return sign;
	}
}
