package gameWindow;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import inputHandeling.KeyInput;

public class Window {

	private final static int WINDOW_WIDTH = 320;
	private static final int WINDOW_HEIGHT = 220;
	private final String WINDOW_TITLE = "Tiles Breaker";
	private static float scale = 3.0f; // 960 / 660

	private BufferStrategy bs;
	private Canvas canvas;
	private Graphics2D g2D;
	private BufferedImage image;
	private KeyInput input;

	public Window() {

		JFrame frame = new JFrame(WINDOW_TITLE);
		Dimension dimension = new Dimension((int) (WINDOW_WIDTH * scale), (int) (WINDOW_HEIGHT * scale));

		image = new BufferedImage((int) (WINDOW_WIDTH * scale), (int) (WINDOW_HEIGHT * scale),
		                          BufferedImage.TYPE_INT_RGB);
		input = KeyInput.iNSTANSE_KEYINPUT;

		canvas = new Canvas();

		canvas.setPreferredSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setMaximumSize(dimension);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		canvas.createBufferStrategy(2);
		canvas.setFocusable(true);
		canvas.requestFocus();
		bs = canvas.getBufferStrategy();
		g2D = (Graphics2D) bs.getDrawGraphics();

		canvas.addKeyListener(input);
		canvas.addMouseMotionListener(input);
		canvas.addKeyListener(input);

	}

	public void update() {
		g2D.setColor(Color.BLACK);
//		g.drawImage(image, 0, 0, (int) (WINDOW_WIDTH * scale), (int) (WINDOW_HEIGHT * scale), null);
//		g.setColor(Color.RED);
//		g.fillRect(0, 0, 800, 600);

		// Have to be uncomment to render
//		render.render(g2D);
		Toolkit.getDefaultToolkit()
		        .sync();
		bs.show();

	}

	public KeyInput getKeyInputInstace() {
		return input;
	}

	public BufferedImage getImage() {
		return image;
	}

	public Graphics2D getGraphics() {
		return g2D;
	}

	public static int getWindowWidth() {
		return (int) (WINDOW_WIDTH * scale);

	}

	public static int getWindowHeight() {
		return (int) (WINDOW_HEIGHT * scale);

	}
}
