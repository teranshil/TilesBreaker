package imageCreation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	private BufferedImage image;

	public Image(String path) {
		try {
			image = ImageIO.read(new File(path));
//			for (int i = 0; i < 40; i++) {
//				image.setRGB(30 + i, 30, 255);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BufferedImage getImage() {
		image.flush();
		return image;
	}

}
