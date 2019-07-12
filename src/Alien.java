import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed=1;
		if(needImage) {
			loadImage("alien.png");
		}
	}
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
void update() {
	y+=speed;
	super.update();
}
void draw(Graphics g) {
	if(gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
void loadImage (String imageFile) {
	if(needImage) {
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			gotImage = true;
		} catch (Exception e) {
			
		}
		needImage = false;
	}
}
}
