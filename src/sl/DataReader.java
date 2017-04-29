package sl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
	Scanner in;
	private String directory = "";
	
	public DataReader(String folder){
		directory = folder;
	}
	
	public void changeDir(String d){
		directory = d;
	}
	
	public ArrayList<Enemy> readText(File f) throws FileNotFoundException{
		in = new Scanner(f);
		ArrayList<Enemy> enemy = new ArrayList<>();	// array list to store enemies read
		while(in.hasNextLine()){	
			addEnemy(in.nextLine(), enemy);	// make an enemy
		}
		return enemy;
	}
	
	public void addEnemy(String s, ArrayList<Enemy> enemy){
		String[] split = s.split("#");
		enemy.add(new Enemy(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2])));
	}
	
	
	// does not work
	public double[] mapRatio(String map) throws FileNotFoundException{
		Scanner in = new Scanner(new File("./HW/HW_Rel.txt"));
		double[] ratio = new double[2];
		while(in.hasNext()){
			if(in.next().equals(map)){
				double mapX = in.nextDouble();
				double mapY = in.nextDouble();
				double pixX = in.nextDouble();
				double pixY = in.nextDouble();
				ratio[0] = pixX / mapX;
				ratio[1] = pixY / mapY;
			}
			else
				in.nextLine();
		}
		in.close();
		return ratio;
	}
	
	public ArrayList<ArrayList<Enemy>> buildList(){
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();
		ArrayList<ArrayList<Enemy>> a = new ArrayList<ArrayList<Enemy>>();
		for(File f : listOfFiles){
			if (f.isFile() && f.getName().endsWith(".txt")){
				try {
					a.add(readText(f));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		DataReader dr = new DataReader("./HW");
		dr.mapRatio("CWH");
	}
}
