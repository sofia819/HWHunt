package sl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapDisplay extends JFrame {
	
	private int width = 1200;
	private int height = 1100;
	private JPanel p = new JPanel();
	private String mapName = "CWH";
	
	public static void main (String[] args) throws IOException{
		new MapDisplay();
	}
	
	public MapDisplay() throws IOException{
		super("Map");
		setSize(width, height);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		BufferedImage myPicture = ImageIO.read(new File("./HW/HW_image/CWH.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		p.add(picLabel);
		add(p);
		//setVisible(true);
	}
}
