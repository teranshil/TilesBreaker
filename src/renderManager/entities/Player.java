package renderManager.entities;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import inputHandeling.KeyInput;
import renderManager.collision.Collision;
import renderManager.graphics.Sprite;
import util.Vector2f;

public class Player extends Entity {
	private int playerX = 10;
	private int playerY = 10;
	private KeyInput input;
	private double tempDelay = 1.5f;
	private double count = 0;
	private int frameCounter = 0;
	int framesNumber;
	int countTwo = 0;

	public Player(Sprite sprite, Vector2f vector, int width, int height) {
		super(sprite, vector, width, height);
		// set the scale of the displayed image
		animation.setScaleImage(4);
		// sets how to detect the collision
		setCircleCollision(128);
	}

	@Override
	public Collision getCollision() {
		return collision;
	}

	public void setAnimation(int currentAnimation, int frameDelay) {
		super.setAnimation(currentAnimation, frameDelay);
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
	}

	@Override
	public void render(Graphics2D g2d) {

		animation.renderAnimation(g2d, (int) vector.vectorX, (int) vector.vectorY);

	}

	@Override
	public void update() {
		animate();
		collisionDetection();
	}

	public void animate() {
	}

	public void collisionDetection() {
	}

	@Override
	public void input(KeyInput input) {
		int keyPresed = input.getKeyPressed();
		boolean[] buttons = input.getKeys();

		if (buttons[KeyEvent.VK_W]) {
			setAnimation(3, 10);
			entityY -= 5;
		} else if (buttons[KeyEvent.VK_S]) {
			setAnimation(2, 20);
			entityY += 5;
		} else if (buttons[KeyEvent.VK_A]) {
			setAnimation(1, 20);
			entityX -= 5;
		} else if (buttons[KeyEvent.VK_D]) {
			setAnimation(0, 20);
			entityX += 5;
		} else {
			setAnimation(-1, 0);
		}
		vector.setVector(entityX, entityY);
	}
}
