package com.monkeybanana.game;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class Game extends JFrame{


	public Game() {
		inititialiseGUI();
	}

	private void inititialiseGUI() {

			add(new GrassLand());
			setResizable(false);
			pack();
		    setTitle("Monkey Banana Game");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
		
			@Override
			public void run() {

				JFrame frame = new Game();
				frame.setVisible(true);				
			}
		});
	}
}
