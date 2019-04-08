package renderManager.entities;

import java.awt.Graphics2D;

import inputHandeling.KeyInput;
import renderManager.graphics.Sprite;
import util.Vector2f;

public class Enemy extends Entity {

	public Enemy(Sprite sprite, Vector2f vector, int width, int height) {
		super(sprite, vector, width, height);
		animation.setScaleImage(2);
		// sets how to detect collision between entities
		setCircleCollision(256);
	}

	@Override
	public void render(Graphics2D g2d) {
		animation.renderAnimation(g2d, entityX, entityY);
	}

	@Override
	public void update() {
		setAnimation(0, 30);
	}

	// won't be used
	@Override
	public void input(KeyInput input) {

	}

}
