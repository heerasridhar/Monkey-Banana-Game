package com.monkeybanana.game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GrassLand extends JPanel {
	
	public static final int SCREEN_WIDTH = 700;
    public static final int SCREEN_HEIGHT = 700;
    public static final int OUTER_HEIGHT = 800;
    public static final int GRID_COUNT = 50;
	public static final int STEP_SIZE = (SCREEN_HEIGHT - 50)/GRID_COUNT;
	private final int DELAY = 15;

	private Monkey monkey;
	private Timer timer;	
	private Banana banana;
	private int eatCount = 25; /* Number of bananas to eat*/
	private JLabel statusbar;
	private JPanel topPanel;
	private JLabel timeLabel;
	private JPanel bottomPanel; 
	private int gameVar = 0;

	int bananaTime = 0;	
	Image backImage;
	 
	
	public GrassLand() {
    	addKeyListener(new KeyStrokes()); 
        setFocusable(true);
        setPreferredSize(new Dimension(SCREEN_WIDTH, OUTER_HEIGHT));
        monkey = new Monkey();
		banana = new Banana();
		ImageIcon backImageIcon = new ImageIcon(this.getClass().getResource("/com/monkeybanana/game/grass.png"));
		backImage = backImageIcon.getImage();
		setLayout(new BorderLayout());
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(600, 50));
		
		statusbar = new JLabel("Total bananas Left : "+eatCount);
		timeLabel = new JLabel("Total time Left : ");
		
		topPanel.add(statusbar);
		topPanel.add(timeLabel);
		add(topPanel, BorderLayout.SOUTH);

		Timer timer1 = new Timer(1000, new ActionListener() {
		    public int count = 100;
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if(eatCount == 0 && count>0){
		        	timeLabel.setText("You won.");
		        	((Timer)e.getSource()).stop();
		        	gameVar = 1;
		        	repaint();
		        }else if(count<=0 && eatCount!=0){
		        	 timeLabel.setText("You Lose." );
		        	 ((Timer)e.getSource()).stop();
		        	 gameVar = 2;
		        	 repaint();
		        }else {
		            timeLabel.setText(" Total time Left : "+Integer.toString(count));
		            count--;
		            bananaTime++;
		            if (bananaTime == 10){
						banana.positionBananaRandomly();
						repaint();
						bananaTime = 0;
		}
		        }
	}

		});
		timer1.start();
	}


	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	if (gameVar == 0){
		g2d.drawImage(backImage, 0, 0, 760, 760, this);
		g2d.drawImage(monkey.getImage(), monkey.getXCoordinate(), monkey.getYCoordinate(), this);
		g2d.drawImage(banana.getImageBanana(), banana.getXCoordinateBanana(), banana.getYCoordinateBanana(), this);	
	}
	else if (gameVar == 1){
		gameFinished(g2d,gameVar);
	}else if (gameVar == 2){
		gameFinished(g2d,gameVar);
	}
	
	Toolkit.getDefaultToolkit().sync();
	}

	private void checkPosition() {
		Rectangle r1 = new Rectangle(monkey.getXCoordinate(), monkey.getYCoordinate(), monkey.getWidthMonkey(),monkey.getHeightMonkey());
		Rectangle r2 = new Rectangle(banana.getXCoordinateBanana(), banana.getYCoordinateBanana(), banana.getWidthBanana(),banana.getHeightBanana());
		if(r1.intersects(r2)) {
			eatCount--;
			statusbar.setText("Total Bananas Remaining to Eat : " + eatCount);
			banana.positionBananaRandomly();
			bananaTime = 0;
		}
		
	}
	
	private void gameFinished(Graphics2D g2d, int gameVar2) {

		if (gameVar2 == 1){
			ResultDisplay("You Win. Score : "+(25-eatCount) *10 , g2d);
		}else {
			ResultDisplay("You Lose. Score : "+(25-eatCount) * 10, g2d);
		}
	   
	}

	private void ResultDisplay (String string, Graphics2D g2d) {

		 Font font = new Font("Verdana", Font.BOLD, 20);
		    FontMetrics metr = this.getFontMetrics(font);
		    g2d.setFont(font);
		    g2d.drawString(string,
		            (SCREEN_WIDTH - metr.stringWidth(string)) / 2,
		            SCREEN_HEIGHT / 2);
	}

	 private class KeyStrokes extends KeyAdapter {
	        @Override
	        public void keyReleased(KeyEvent e) {
	            	monkey.keyRelease(e);
                    checkPosition();
	            	repaint();
	        }
	        @Override
	        public void keyPressed(KeyEvent e) {
	            monkey.keyPress(e);
                checkPosition();
	            repaint();
	        }
	          
	    }

}



