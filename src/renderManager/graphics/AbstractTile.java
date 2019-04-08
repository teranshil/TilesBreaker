package renderManager.graphics;

import java.awt.image.BufferedImage;

public abstract class AbstractTile {
	protected int tileX, tileY;
	protected BufferedImage tileImage;
	protected int tileID;

	protected AbstractTile(int tileX, int tileY, int tileID) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.tileID = tileID;
	}

	protected abstract void createdImage(int tileID);

}
