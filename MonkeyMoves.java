package com.monkeybanana.game;

import java.awt.event.KeyEvent;



public class MonkeyMoves {
	
	public MonkeyMoves KeyRelease(KeyEvent eve, Monkey monk) {
		
		int key = eve.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            monk.setXcoordinate(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            monk.setXcoordinate(0);
        }

        if (key == KeyEvent.VK_UP) {
            monk.setYCoordinate(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            monk.setYCoordinate(0);
        }
		
		return new MonkeyMoves();
	}

	public MonkeyMoves keyPress(KeyEvent eve, Monkey monk) {
		
		int key = eve.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            monk.setXcoordinate(-GrassLand.STEP_SIZE);
            monk.setYCoordinate(0);
        }

        if (key == KeyEvent.VK_RIGHT) {

        	monk.setXcoordinate(GrassLand.STEP_SIZE);
        	monk.setYCoordinate(0);
            
        }

        if (key == KeyEvent.VK_UP) {
        	
            monk.setYCoordinate(-GrassLand.STEP_SIZE);
            monk.setXcoordinate(0);
        }

        if (key == KeyEvent.VK_DOWN) {

        	monk.setYCoordinate(GrassLand.STEP_SIZE);
        	monk.setXcoordinate(0);
        }	

        monk.move();		
		return new MonkeyMoves();
	}



}
