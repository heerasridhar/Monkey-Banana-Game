package com.monkeybanana.game;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;


public class Banana {
	
	private Image bananaImage;
	private int xCoordinateBanana;
	private int yCoordinateBanana;
	private final int RAND_SAMPLE = 600;
	private int BananaWidth = GrassLand.STEP_SIZE;
	private int BananaHeight = GrassLand.STEP_SIZE;
	
	public Banana() {
		ImageIcon MonkeyImage = new ImageIcon(this.getClass().getResource("/com/monkeybanana/game/Banana.png"));
		bananaImage = MonkeyImage.getImage();	
		positionBananaRandomly();
	}
		
	public int getWidthBanana(){
		return BananaWidth;
	}

	public int getHeightBanana() {
		return BananaHeight;
	}

	public void positionBananaRandomly() {

		Random random = new Random();
		xCoordinateBanana = random.nextInt(GrassLand.GRID_COUNT)* GrassLand.STEP_SIZE;
		yCoordinateBanana = random.nextInt(GrassLand.GRID_COUNT)* GrassLand.STEP_SIZE;
	}

	public Image getImageBanana() {
		return bananaImage;
	}

	public int getXCoordinateBanana() {
		return xCoordinateBanana;
	}

	public int getYCoordinateBanana() {
		return yCoordinateBanana;
	}	
}
