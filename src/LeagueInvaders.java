import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders implements KeyListener{
public static void main(String[] args) {
	LeagueInvaders league = new LeagueInvaders();
	league.setup();
}
GamePanel panel = new GamePanel();
JFrame frame;

public static final int WIDTH = 500;
public static final int HEIGHT = 800;

public LeagueInvaders() {
	frame=new JFrame();
}
void setup() {
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.addKeyListener(panel);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
