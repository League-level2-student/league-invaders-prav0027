import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
@Override
public void paintComponent(Graphics g) {
	if(currentState==MENU) {
		drawMenuState(g);
	}
	else if(currentState==GAME) {
		drawGameState(g);
	}
	else if(currentState==END) {
		drawEndState(g);
	}
	if(needImage) {
		loadImage("space.png");
	}
}
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;

Rocketship rocket = new Rocketship(250, 750, 50, 50);

ObjectManager objectManager = new ObjectManager(rocket);

void updateMenuState(){
	
}
void updateGameState() {
	objectManager.update();
	if(!rocket.isActive) {
		currentState=END;
	}
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("LEAGUE INVADERS", 30, 100);
	g.setFont(menuFont);
	g.setColor(Color.YELLOW);
	g.drawString("Press ENTER to start", 130, 400);
	g.drawString("Press SPACE for instructions", 100, 600);
	
}
void drawGameState(Graphics g) {
	if(gotImage) {
		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
	} else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	objectManager.draw(g);
	
}
void loadImage(String imageFile) {
	if(needImage) {
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			gotImage = true;
		} catch(Exception e) {
			
		}
		needImage = false;
	}
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("Game Over", 120, 100);
	g.setFont(menuFont);
	g.setColor(Color.YELLOW);
	g.drawString("You killed "+objectManager.getScore() +" enemies", 120, 350);
	g.drawString("Press ENTER to restart", 130, 600);
	
}



Font titleFont;
Font menuFont;
Timer frameDraw;
public GamePanel() {
	titleFont = new Font("Arial", Font.PLAIN, 48);
	menuFont = new Font("Arial", Font.PLAIN, 24);
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
}

Timer alienSpawn;

void startGame() {
	alienSpawn = new Timer(1000, objectManager);
	alienSpawn.start();
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState==MENU) {
		updateMenuState();
	}
	else if(currentState==GAME) {
		updateGameState();
	}
	else if(currentState==END) {
		updateEndState();
	}
	repaint();
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		if(currentState==END) {
			currentState=MENU;
		}
		else if(currentState==MENU) {
			currentState=GAME;
			startGame();
		}
		else if(currentState==GAME) {
			currentState=END;
			alienSpawn.stop();
			rocket = new Rocketship(250, 750, 50, 50);
			objectManager = new ObjectManager(rocket);
		}
	}
	if(currentState==GAME) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(rocket.y>Frame.HEIGHT) {
			rocket.up();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(rocket.y<750) {
				rocket.down();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(rocket.x>0) {
			rocket.left();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(rocket.x<450) {
			rocket.right();
			}
		}
	}
	if(e.getKeyCode()==KeyEvent.VK_SPACE) {
		if(currentState==GAME) {
		objectManager.addProjectile(rocket.getProjectile());
		}
		
		if(currentState==MENU) {
			JOptionPane.showMessageDialog(null, "Use arrow keys to move. Press SPACE to fire. Try not to die.");
		}
	}
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}

