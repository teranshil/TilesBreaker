package renderManager.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import inputHandeling.KeyInput;
import renderManager.animation.Animation;
import renderManager.collision.Collision;
import renderManager.graphics.Sprite;
import util.ScaleImage;
import util.Vector2f;

public abstract class Entity {

	protected int scale;
	// rectangle
	protected Rectangle rectRepresentation;
	// key listener
	protected Sprite sprite;
	protected Vector2f vector;
	// frames variables
	protected BufferedImage[] framesAnimation;
	protected Animation animation;
	// protected int entitySize;
	protected int width, height;
	protected int lastFrame = -2;
	// Collision
	protected Collision collision;
	private ScaleImage imageScale;
	// controls
	protected final int DEFEAULT_POSITION = 1;
	protected final int UP = 0;
	protected final int DOWN = 2;
	protected final int LEFT = 3;
	protected final int RIGHT = 4;
	protected int entityX = 0;
	protected int entityY = 0;
	// controls check
	protected boolean isUp = false;
	protected boolean isDown = false;
	protected boolean isLeft = false;
	protected boolean isRight = false;

	public Entity(Sprite sprite, Vector2f vector, int width, int height) {
		this.sprite = sprite;
		this.vector = vector;
		this.width = width;
		this.height = height;
		animation = new Animation(sprite.getSpriteSheetArray(DEFEAULT_POSITION));
		imageScale = new ScaleImage();
	}

	public void setCircleCollision(float circleRadius) {
		collision = new Collision(vector, circleRadius);
	}

	public void setBoxCollision(int width, int height) {
		collision = new Collision(vector, width, height);
	}

	protected void setSize(int width, int height) {
		rectRepresentation = new Rectangle(new Dimension(width, height));
	}

	protected Collision getCollision() {
		return collision;
	}

	public Vector2f getVector() {
		return vector;
	}

	public void setAnimation(int currentFrame, int frameDelay) {

		// TODO
		if (currentFrame != lastFrame && currentFrame != -1) {
//			framesAnimation = sprite.getSpriteSheetArray(currentFrame);
			animation.setFrames(sprite.getSpriteSheetArray(currentFrame));
			lastFrame = currentFrame;
			animation.setDelay(frameDelay);

		} else if (currentFrame == -1 && currentFrame != lastFrame) {
			animation.setDelay(frameDelay);
			BufferedImage[] stateLessImage = { animation.getCurrentFrame(0) };
			animation.setFrames(stateLessImage);
			lastFrame = currentFrame;
//			framesAnimation = new BufferedImage[] { sprite.getSprite(0, 0) };
//			animation.setFrames(sprite.getSpriteSheetArray(currentFrame));
//			lastFrame = currentFrame;
		}
//		animation = new Animation(sprite.getSpriteSheetArray(currentAnimation));
//		animation.setDelay(frameDelay);
	}

	abstract public void render(Graphics2D g2D);

	abstract public void update();

	abstract public void input(KeyInput input);

	public int getEntityX() {
		return entityX;
	}

	public void setEntityX(int entityX) {
		this.entityX = entityX;
	}

	public int getEntityY() {
		return entityY;
	}

	public void setEntityY(int entityY) {
		this.entityY = entityY;
	}
}
