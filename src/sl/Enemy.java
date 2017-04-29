package sl;

public class Enemy {
	String name;
	double x, y;
	public Enemy(String name, double x, double y){
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName(){
		return name;
	}
	
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public String getCoor(){
		return getX() + "	" + getY();
	}
	
	public String toString(){
		int col = 26;
		String result = getName();
		while(col - name.length() > 0){
			result += " ";
			col--;
		}
		result += getCoor();
		return result;
	}
}
