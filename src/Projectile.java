import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	public Projectile(int x, int y, int width, int height, boolean isActive) {
		super(x, y, width, height, isActive);
		// TODO Auto-generated constructor stub
		speed = 10;
	}
void update() {
	y-=speed;
}
void draw(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(x, y, width, height);
}
}
