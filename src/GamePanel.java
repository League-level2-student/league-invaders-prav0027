import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
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
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.BLACK);
	g.drawString("Game Over", 30, 100);
	g.setFont(menuFont);
	g.setColor(Color.BLACK);
	g.drawString("You killed so many enemies", 130, 400);
	g.drawString("Press ENTER to restart", 100, 600);
}

Font titleFont;
Font menuFont;
public GamePanel() {
	titleFont = new Font("Arial", Font.PLAIN, 48);
	menuFont = new Font("Arial", Font.PLAIN, 24);
	
}


}

