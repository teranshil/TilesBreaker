package renderManager.graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import util.Vector2f;

public class Sprite {

	private final int DEFAULT_TILE_SIZE = 32;
	private int tileWidth = 0, tileHeight = 0;

	private BufferedImage spriteSheetImage = null;
	private int spriteSheetWidth = 0, spriteSheetHeight = 0;
	private BufferedImage[][] spriteSheetArray;
	private int elementsInWidth = 0;
	private int elementsInHeight = 0;

	public Sprite(String fileDirectory) {
		spriteSheetImage = loadSpriteSheet(fileDirectory);

		tileWidth = DEFAULT_TILE_SIZE;
		tileHeight = DEFAULT_TILE_SIZE;

		elementsInWidth = spriteSheetImage.getWidth() / tileWidth;
		elementsInHeight = spriteSheetImage.getHeight() / tileHeight;

		loadSpriteSheetArray();
	}

	public Sprite(String fileDirectory, int tileWidth, int tileHeight) {
		spriteSheetImage = loadSpriteSheet(fileDirectory);

		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;

		elementsInWidth = spriteSheetImage.getWidth() / tileWidth;
		elementsInHeight = spriteSheetImage.getHeight() / tileHeight;
		loadSpriteSheetArray();
	}

	public void setTile(int width, int height) {

		this.tileWidth = width;
		this.tileHeight = height;

		elementsInWidth = spriteSheetImage.getWidth() / tileWidth;
		elementsInHeight = spriteSheetImage.getHeight() / tileHeight;
	}

	private BufferedImage loadSpriteSheet(String fileDirectory) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(fileDirectory));

		} catch (IOException e) {
			System.out.println("Error: Could not load the Sprite Sheet image!");
		}

		return image;
	}

	private void loadSpriteSheetArray() {
		spriteSheetArray = new BufferedImage[elementsInHeight][elementsInWidth]; // not really sure for the positions of
		                                                                         // elementsHeight and elementsWidth
		for (int x = 0; x < elementsInHeight; x++) {
			for (int y = 0; y < elementsInWidth; y++) {
				spriteSheetArray[x][y] = getSprite(x, y);
			}
		}

	}

	public static void drawArrayOfImages(Graphics g, ArrayList<BufferedImage> images, Vector2f vector, int width,
	        int height, int offsetX, int offsetY) {
		float x = vector.vectorX;
		float y = vector.vectorY;

		for (int index = 0; index < images.size(); index++) {
			g.drawImage(images.get(index), (int) x, (int) y, width, height, null);
			x += offsetX;
			y += offsetY;
		}
	}

	public static void drawString(Graphics g, Font font, String word, int width, int height, int offsetX, int offsetY) {

	}

	// getters methods
	public BufferedImage getSpriteSheet() {
		return spriteSheetImage;
	}

	public BufferedImage[] getSpriteSheetArray(int index) {
		return spriteSheetArray[index];
	}

	public BufferedImage[][] getSpritSheetArray2D() {
		return spriteSheetArray;
	}

	public BufferedImage getSprite(int cordinateX, int cordinateY) {
		return spriteSheetImage.getSubimage(cordinateY * tileHeight, cordinateX * tileWidth, tileWidth, tileHeight);
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public int getTileWidth() {
		return tileWidth;
	}

}
