import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height, boolean isActive) {
		super(x, y, width, height, isActive);
		// TODO Auto-generated constructor stub
		speed=1;
	}
void update() {
	y+=speed;
}
void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
}
}
