package renderManager.animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import util.ScaleImage;

public class Animation {

	private BufferedImage[] frames;
	private int numberOfFrames = 0;
	private int currentFrame = 0;
	private int countForDelay = 0;
	private int delay = 0;
	private int count = 0;
	private int scaleImage = 0;
	private int entityX = 0;
	private int entityY = 0;
	private ScaleImage imageScale;

	public Animation(BufferedImage[] frames) {
		imageScale = new ScaleImage();
		setFrames(frames);
	}

	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;
		this.numberOfFrames = frames.length;
	}

	public void renderAnimation(Graphics2D g2D, int entityX, int entityY) {
		this.entityX = entityX;
		this.entityY = entityY;
		for (BufferedImage frame : frames) {
			if (count >= delay) { // have to be replaced with 'delay'
				g2D.drawImage(imageScale.scaleImage(frame, scaleImage), entityX, entityY, null);
				count = 0;
			} else
				count++;
		}
//		if (count < frames.length) {
//			g2D.drawImage(imageScale.scaleImage(frames[count], scaleImage), entityX, entityY, null);
//			count++;
//		} else {
//			count = 0;
//		}

	}

	public void update(int entityX, int entityY) { // have to be finished
		this.entityX = entityX;
		this.entityY = entityY;
	}

	// setters and getters
	public BufferedImage getCurrentFrame(int frameIndex) {
		return frames[frameIndex];
	}

	public void setNumberOfFrames(int numberOfFrames) {
		this.numberOfFrames = numberOfFrames;
	}

	public int getNumberOfFrames() {
		return numberOfFrames;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getDelay() {
		return this.delay;
	}

	public int getScaleImage() {
		return scaleImage;
	}

	public void setScaleImage(int scaleImage) {
		this.scaleImage = scaleImage;
	}

}
