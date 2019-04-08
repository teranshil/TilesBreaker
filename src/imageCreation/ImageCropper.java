package imageCreation;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageCropper {
	private final static ImageCropper instance = new ImageCropper();
	private BufferedImage originalImage;

	private ImageCropper() {
	}

	public static ImageCropper getInstance() {
		return instance;
	}

	public BufferedImage cropper(File file, Dimension dimension) {
		try {
			originalImage = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Can't read image");
		}

		return originalImage.getSubimage(840, 0, (int) dimension.getWidth(), (int) dimension.getHeight());
	}
}
