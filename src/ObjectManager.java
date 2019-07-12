
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	int score = 0;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
		System.out.println(projectiles.size());
	}

	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (Alien a : aliens) {
			a.update();
			System.out.println(a.y);
			if (a.y > LeagueInvaders.HEIGHT) {
				
				a.isActive = false;
			}	
		}
		for (Projectile p : projectiles) {
				p.update();
				if (p.y <0) {
					p.isActive = false;
				}
			}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Alien a : aliens) {
			a.draw(g);
		}
		for (Projectile p : projectiles) {
			p.draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien a = aliens.get(i);
			if (!a.isActive) {
				aliens.remove(a);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if (!p.isActive) {
				projectiles.remove(p);
				System.out.println("remove projectile");
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (rocket.collisionBox.intersects(a.collisionBox)) {
				a.isActive = false;
				rocket.isActive = false;
			}
			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					a.isActive = false;
					p.isActive = false;
					System.out.println("collide");
				}
			}
		}
	}
	
	int scoreGetter() {
		return score;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
