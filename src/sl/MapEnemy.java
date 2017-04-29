package sl;

import java.util.ArrayList;

public class MapEnemy {
	private String name;
	private ArrayList<Enemy> enemy;
	
	public MapEnemy(String name, ArrayList<Enemy> enemy){
		this.name = name;
		this.enemy = enemy;
	}
	
	public Enemy[] getEnemy(){
		return enemy.toArray(new Enemy[enemy.size()]);
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name + "\n" + enemy.toString();
		
	}
}
