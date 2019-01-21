package com.monkeybanana.game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;

public class Monkey {

	private Image image;
	private MonkeyMoves Currentstate;
	private int xCoordinate;
	private int yCoordinate;	
	private int MonkeyWidth = GrassLand.STEP_SIZE;
	private int MonkeyHeight = GrassLand.STEP_SIZE;	
	private int x;
    private int y;


	public Image getImage() {
		return image;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public Monkey() {
		/* 
		Assigning the monkey at random position in wonderland.  
		*/
		Currentstate = new MonkeyMoves();
		ImageIcon MonkeyImage = new ImageIcon(this.getClass().getResource("/com/monkeybanana/game/monkey.png"));
		image = MonkeyImage.getImage();
		Random random = new Random();
		xCoordinate = random.nextInt(GrassLand.GRID_COUNT)* GrassLand.STEP_SIZE;
		yCoordinate = random.nextInt(GrassLand.GRID_COUNT)* GrassLand.STEP_SIZE;
	}	
	
	 public void move() {
	    	int tx = xCoordinate+x;
	    	int ty = yCoordinate+y;
	        if(tx >= 0 && tx<=(GrassLand.SCREEN_WIDTH-MonkeyWidth)) xCoordinate += x;
	        if(ty >= 0 && ty<=(GrassLand.SCREEN_HEIGHT-MonkeyHeight)) yCoordinate += y;
	    }

	public void setXcoordinate(int x) {
		this.x = x;
	}

	public void setYCoordinate(int y) {
		this.y = y;
	}

	public int getWidthMonkey() {
		return MonkeyWidth;
	}

	public int getHeightMonkey() {
		return MonkeyHeight;
	}
	
	public void keyRelease(KeyEvent e) {
		
		Currentstate = Currentstate.KeyRelease(e,this);
		
	}

	public void keyPress(KeyEvent e) {
		Currentstate = Currentstate.keyPress(e,this);
	} 
	
}
