package sl;

import java.util.ArrayList;
import java.util.Scanner;

public class EnemyChooser {
	private static String[] name = {"Azys Lla", "The Churning Mists", "Coerthas Western Highlands", 
									"The Dravanian Forelands", "The Dravanian Hinterlands", "The Sea of Clouds"};
	private static MapEnemy[] maps = new MapEnemy[name.length];
	
	public EnemyChooser(){
		makeMap();
	}
	
	public void makeMap(){
		DataReader dr = new DataReader("./data");
		ArrayList<ArrayList<Enemy>> a = dr.buildList();
		for(int i = 0; i < name.length; i++){
			maps[i] = new MapEnemy(name[i], a.get(i));
		}
	}
	
	public void displayList(int index){
		System.out.println(name[index]);
		Enemy[] enemy = maps[index].getEnemy();		// get list of enemies
		for(int i = 0; i < enemy.length; i++){
			String result = (i + 1) + ") " + enemy[i].getName();
			System.out.println(result);
		}
	}
	
	public void chooseInput(int index){
		ArrayList<Integer> num = new ArrayList<>();
		Enemy[] enemy = maps[index].getEnemy();		// get list of enemies
		Scanner in = new Scanner(System.in);
		System.out.println("Choose input (any letter to quit): ");
		while(in.hasNextInt()){
			int input = in.nextInt();
			if(input < enemy.length)
				num.add(input);
		}
		for(Integer i : num){
			System.out.println(enemy[i - 1].toString());
		}
		in.close();
	}
	
	public static void main(String[] args){
		int num = 2;
		EnemyChooser ec = new EnemyChooser();
		ec.displayList(num);
		ec.chooseInput(num);
	}
}
