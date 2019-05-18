import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int x, int y, int width, int height, boolean isActive) {
		super(x, y, width, height, isActive);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
void draw(Graphics g) {
	g.setColor(Color.blue);
	g.fillRect(x, y, width, height);
}
public void right() {
	x+=speed;
}
public void left() {
	x-=speed;
}
public void up() {
	y-=speed;
}
public void down() {
	y+=speed;
}
}
