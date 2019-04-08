package gameStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameWindow.Window;
import inputHandeling.KeyInput;
import renderManager.entities.Enemy;
import renderManager.entities.Player;
import renderManager.graphics.Font;
import renderManager.graphics.Sprite;
import util.ScaleImage;
import util.Vector2f;

public class PlayState extends GameState {

	private static final PlayState instance = new PlayState();
	private int mouseX = 20, mouseY = 20;
	private Graphics2D graphics;
	private Font font;
	private BufferedImage[] images;
	private ScaleImage scaledImage;
	private boolean isExecuted = false;
	// entities
	private Player player;
	private Enemy enemy;

	private Sprite playerAnimations;
	private Sprite enemyAnimations;
	private KeyInput keyInput;

	private PlayState() {
		super();
		// scaleImage initialization
		scaledImage = new ScaleImage();
		// player initialization
		playerAnimations = new Sprite("sources/Entities/Player/playerFrames.png", 32, 32);
		player = new Player(playerAnimations, new Vector2f(300, 300), 32, 32);
		player.setSize(32, 32);

		// enemy initialization
		enemyAnimations = new Sprite("sources/Entities/Enemy/goblinFrames.png", 64, 64);
		enemy = new Enemy(enemyAnimations, new Vector2f(100, 100), 64, 64);

		// font initialization
		font = new Font("sources/fonts/secondFont.png", 8, 8);
		images = font.getRow(1);

	}

	@Override
	protected void render(Graphics2D g2D) {
		graphics = g2D;
		g2D.setColor(Color.BLACK);
		g2D.fillRect(0, 0, Window.getWindowWidth(), Window.getWindowHeight());

		InitialRendering(g2D, images);

		displayFPS(g2D);

		player.render(g2D);
		enemy.render(g2D);
	}

	@Override
	protected void update() {
		player.update();
		enemy.update();
//		System.err.println("Player X: " + player.getVector().vectorX + " Y: " + player.getVector().vectorY);
//		System.err.println("Enemy X: " + enemy.getVector().vectorX + " Y: " + enemy.getVector().vectorY);
//		System.err.println("Distance between entities: " + player.getCollision()
//		        .getDistance());
//		System.out.println(player.getCollision()
//		        .circleCollisionCheck(enemy.getVector(), 128));
	}

	public void InitialRendering(Graphics2D g2D, BufferedImage[] images) {
		int x = 10;
		int y = 100;
		int scale = 4;
		ScaleImage imageScale = new ScaleImage();
//		for (BufferedImage image : images) {
//			g2D.drawImage(imageScale.scaleImage(image, scale), x, y, null);
//			x += 8 * scale;
//		}
		BufferedImage[] sentenceElements = font.getSentence("Barbov sucks");

		int xOne = 10;
		int yOne = 10;

		for (BufferedImage image : sentenceElements) {
			g2D.drawImage(imageScale.scaleImage(image, scale), xOne, yOne, null);
			xOne += 7 * scale;
		}
//		g2D.drawImage(imageScale.scaleImage(font.getLetter('a'), scale), 100, 100, null);
	}

	public static PlayState getInstance() {
		return instance;
	}

	@Override
	protected void input(KeyInput input) {
		player.input(input);
	}

	@Override
	protected void displayFPS(Graphics2D g2D) {

//		System.err.println(Engine.getInstance());

//		int numberWidth = 0;
//		int scaleNum = 5;
//
//		for (int index = number.get().length - 1; index >= 0; index--) {
//			g2D.drawImage(scaledImage.scaleImage(number.get()[index], scaleNum), numberWidth, 100, null);
//			numberWidth += (8 * scaleNum);
//		}
	}

}
