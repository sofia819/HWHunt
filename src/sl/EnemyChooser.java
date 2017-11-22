package sl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnemyChooser {
	private static String[] name = {"Azys Lla", "The Churning Mists", "Coerthas Western Highlands", 
									"The Dravanian Forelands", "The Dravanian Hinterlands", "The Sea of Clouds"};
	private static MapEnemy[] maps = new MapEnemy[name.length];
	private static ArrayList<String> store = new ArrayList<>();	// store enemy chosen
	
	public EnemyChooser(){
		makeMap();
	}
	
	// link map with enemies
	public void makeMap(){
		DataReader dr = new DataReader("./HW/HW_data");
		ArrayList<ArrayList<Enemy>> a = dr.buildList();
		for(int i = 0; i < name.length; i++){
			maps[i] = new MapEnemy(name[i], a.get(i));
		}
	}
	
	// let user choose a map
	public void chooseMap() throws IOException{
		for(int i = 0; i < name.length; i++){
			String result = (i + 1) + ") " + name[i];
			System.out.println(result);
		}
		Scanner in = new Scanner(System.in);
		System.out.print("Choose a map: ");
		int index = in.nextInt() - 1;	// display and actual indices are off by 1
		displayList(index);		// display list of enemies of chosen map
		chooseInput(index);		// let user input choices
		in.close();
	}	
	
	// display list of enemies in chosen map
	public void displayList(int index){
		System.out.println(name[index]);
		Enemy[] enemy = maps[index].getEnemy();		// get list of enemies
		for(int i = 0; i < enemy.length; i++){
			String result = (i + 1) + ") " + enemy[i].getName(); // display and actual indices are off by 1
			System.out.println(result);
		}
	}
	
	// let user input enemies
	public void chooseInput(int index) throws IOException{
		ArrayList<Integer> num = new ArrayList<>();
		Enemy[] enemy = maps[index].getEnemy();		// get list of enemies
		store.add(maps[index].getName());	// add the name of the map to storage
		Scanner in = new Scanner(System.in);
		System.out.println("Choose input (any letter to quit): ");
		while(in.hasNextInt()){
			int input = in.nextInt() - 1; // display and actual indices are off by 1
			if(input < enemy.length && !num.contains(new Integer(input)))
				num.add(input);
		}
		for(Integer i : num){
			System.out.println(enemy[i].toString());
			store.add(enemy[i].toString());	// add to storage
		}
		store.add(""); // add an empty string to insert a blank line between maps
		System.out.print("Continue? (y/n): ");
		in.next(); // skip last input
		if(in.next().equals("y")) {
			chooseMap();
		}
		else{
			writeOut();
			in.close();
		}
	}
	
	public void writeOut() throws IOException{
		 PrintWriter out = new PrintWriter(new FileWriter("./output.txt"));
		 System.out.println("\nOUTPUT");
		 for(String s : store){
			 System.out.println(s);
			 out.println(s);
		 }
		 out.close();
	}
	
	public static void main(String[] args) throws IOException{
		EnemyChooser ec = new EnemyChooser();
		ec.chooseMap();
	}
}
