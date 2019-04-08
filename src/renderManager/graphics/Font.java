package renderManager.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

public class Font {

	private final int DEFAULT_FONT_SIZE = 32;
	private BufferedImage fontImage;
	private int fontWidth = 0, fontHeight = 0;
	private int elementsInWidth = 0, elementsInHeight = 0;
	private BufferedImage[][] allElements;
	private List<BufferedImage> letters;
	private List<BufferedImage> numbers;

	public Font(String fileDirectory) {
		fontWidth = DEFAULT_FONT_SIZE;
		fontHeight = DEFAULT_FONT_SIZE;

		fontImage = loadFontImage(fileDirectory);

		elementsInWidth = fontImage.getWidth() / DEFAULT_FONT_SIZE;
		elementsInHeight = fontImage.getHeight() / DEFAULT_FONT_SIZE;

		allElements = loadElements(fontImage);
	}

	public Font(String fileDirectory, int elementWidth, int elementHeight) {
		fontWidth = elementWidth;
		fontHeight = elementHeight;

		fontImage = loadFontImage(fileDirectory);

		elementsInWidth = fontImage.getWidth() / elementWidth;
		elementsInHeight = fontImage.getHeight() / elementHeight;

		allElements = loadElements(fontImage);
	}

	public BufferedImage loadFontImage(String fileDirectory) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(fileDirectory));
		} catch (Exception e) {
			System.out.println("Error: could not load file directory " + fileDirectory);
		}
		return image;
	}

	public BufferedImage[][] loadElements(BufferedImage image) {
		allElements = new BufferedImage[elementsInHeight][elementsInWidth];

		for (int row = 0; row < elementsInHeight; row++)
			for (int col = 0; col < elementsInWidth; col++)
				allElements[row][col] = getElement(col, row);

		return allElements;
	}

	public BufferedImage[] getRow(int index) {
		return allElements[index];
	}

	public BufferedImage getLetter(char letter) {
		BufferedImage imageLetter = null;
		letters = Arrays.stream(allElements)
		        .flatMap(e -> Arrays.stream(e))
		        .limit(26)
		        .collect(Collectors.toList());
		imageLetter = Character.isUpperCase(letter) ? letters.get(((int) letter) - 65)
		        : letters.get(((int) letter) - 97);
		return imageLetter;
	}

	public BufferedImage[] getSentence(String sentence) {

		BufferedImage spaceImage = null;
		BufferedImage space = null;
		try {
			spaceImage = ImageIO.read(new File("sources/fonts/font.png"));
			space = spaceImage.getSubimage(spaceImage.getWidth() - 9, spaceImage.getHeight() - 13, 9, 13);
		} catch (IOException e1) {
			System.out.println("ERROR: Could not load the space image");
		}

		letters = Arrays.stream(allElements)
		        .flatMap(e -> Arrays.stream(e))
		        .limit(26)
		        .collect(Collectors.toList());

		int[] sentenceData = Arrays.stream(sentence.split(""))
		        .mapToInt(e -> e.charAt(0))
		        .toArray();

		BufferedImage[] sentenceElements = new BufferedImage[sentenceData.length];
//	
		for (int index = 0; index < sentenceData.length; index++) {
			if ((char) sentenceData[index] != ' ') {
				sentenceElements[index] = Character.isUpperCase(sentenceData[index])
				        ? letters.get(sentenceData[index] - 65)
				        : letters.get(sentenceData[index] - 97);
			} else
				sentenceElements[index] = space;
//
		}

		return sentenceElements;
	}

	public Optional<BufferedImage[]> getNumber(int number) {

		numbers = Arrays.stream(allElements)
		        .flatMap(e -> Arrays.stream(e))
		        .skip(26)
		        .collect(Collectors.toList());

		if (number < 9 && number > -9)
			return Optional.of(new BufferedImage[] { numbers.get(number) });
		else
			return Optional.of(transformNumber(number));
	}

	private BufferedImage[] transformNumber(int number) {
		int numberLenght = String.valueOf(number)
		        .length();
		BufferedImage[] allNumbers = new BufferedImage[numberLenght];

		for (int index = 0; index < numberLenght; index++) {
			int tempValue = number % 10;
			allNumbers[index] = numbers.get(tempValue);
			number /= 10;
		}
		return allNumbers;
	}

	private BufferedImage getElement(int x, int y) {
		return fontImage.getSubimage(x * fontWidth, y * fontHeight, fontWidth, fontHeight);
	}
}
