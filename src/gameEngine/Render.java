package gameEngine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import imageCreation.ImageCropper;
import renderManager.graphics.TileManager;

public class Render {
	private Engine engine;
//	private int[] pixels;
	private Graphics g;

	private boolean isInited = false;

	public Render(Engine engine) {
		this.engine = engine;
	}

	public void render(Graphics g) {
		this.g = g;
		if (!isInited) {

			isInited = true;
		}
		initRender();
	}

	public void clear() {

		// Cool animation
//		Arrays.asList(pixels).stream().forEach(e-> System.out.println(e.toString()));
//		pixels = ((DataBufferInt) engine.getWindow().getImage().getRaster().getDataBuffer()).getData();
//		pixels = ((DataBufferInt) engine.getWindow().getImage().getRaster().getDataBuffer()).getData();
//		for (int i = 0; i < pixels.length; i++) {
//			pixels[i] += i;
//		}
	}

	private void initRender() {
		BufferedReader reader;

		try {
			File file = new File("sources/mapResources/tailsMapping.txt");
			reader = new BufferedReader(new FileReader(file));

			new TileManager();
			File directory = new File("sources/others/sheet.png");
			BufferedImage metalTile = ImageCropper.getInstance()
			        .cropper(directory, new Dimension(70, 70));
//			BufferedImage metalImage = ImageCropper.getInstance()
//					.cropper(new File("sources/others/sheet.png"), new Dimension(70, 70));

			int y = 0;
//			g.drawImage(new Image("sources/others/hero-image.png").getImage(), 40, 40, null);
			String input = reader.readLine()
			        .replaceAll("//s", "");
			while (!input.equals("")) {

				int[] elements = Arrays.stream(input.trim()
				        .split("[!]"))
				        .filter(e -> !e.equals(""))
				        .mapToInt(Integer::parseInt)
				        .toArray();
				y += 45;
				int x = 0;
				for (int i = 0; i < elements.length; i++) {
					if (elements[i] == 1 || elements[i] == 2)
						g.drawImage(metalTile, x, y, null);
//					else if (elements[i] == 3)
//						g.drawImage(metalImage, x, y, null);

					x += 70;
				}
				input = reader.readLine()
				        .replaceAll("//s", "");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			reader.close();
		}
		Toolkit.getDefaultToolkit()
		        .sync();

	}

}
