import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;

public ObjectManager(Rocketship rocket) {
	this.rocket = rocket;
}

ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
}

ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random = new Random();
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}void update(){
for(Alien a:aliens) {
a.update();
if(a.y<0) {
	a.isActive = false;
}

for(Projectile p:projectiles) {
	p.update();
	if(p.y>Frame.HEIGHT) {
		p.isActive = false;
	}
}
}
}

void draw(Graphics g) {
	rocket.draw(g);
	for(Alien a:aliens) {
		a.draw(g);
	}
	for(Projectile p:projectiles) {
		p.draw(g);
	}
}

void purgeObjects() {
	for(Alien a: aliens) {
		if(a.isActive=false) {
			aliens.remove(a);
		}
		for(Projectile p: projectiles) {
			if(p.isActive=false) {
				projectiles.remove(p);
			}
		}
	}
}
}
