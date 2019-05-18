import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
}
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;

Rocketship rocket = new Rocketship(250, 750, 50, 50, false);

void updateMenuState(){
	
}
void updateGameState() {
	
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
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	rocket.draw(g);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.YELLOW);
	g.drawString("Game Over", 120, 100);
	g.setFont(menuFont);
	g.setColor(Color.YELLOW);
	g.drawString("You killed so many enemies", 120, 350);
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
	System.out.println("action");
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
		else {
			currentState++;
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
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}

