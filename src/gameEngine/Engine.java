package gameEngine;

import gameStates.GameStateManager;
import gameWindow.Window;

public class Engine implements Runnable {
	private static final double FRAMESPERSECOND = 1.0 / 60.0;
	private static boolean isRunning = false, isRender = false;
	private static Thread thread;
	private Window window;
	private static Engine ENGINEINSTANCE;
	private final GameStateManager stateManager = GameStateManager.getInstance();

	private Engine() {
		// Have to be uncomment to render
//		render = new Render(this);
		window = new Window();

		start();

	} // not sure it can be fabricated to static factory

	public void start() {
		isRender = true;
		isRunning = true;

		thread = new Thread(this);
		thread.run();

	}

	public void stop() {
		isRunning = false;
	}

	public synchronized void run() {
		double currentTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		// variables for FPS calculation
		double fps = 0;
		double frames = 0;
		double frameTime = 0;

		boolean render = false;
		while (isRunning) {
			render = false;
			currentTime = System.nanoTime() / 1000000000.0; //
			passedTime = currentTime - lastTime;
			lastTime = currentTime;

			unprocessedTime += passedTime;
			// frame
			frameTime += passedTime;

			while (unprocessedTime >= FRAMESPERSECOND) {
				unprocessedTime -= FRAMESPERSECOND;
				render = true;

				update();

				if (frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}
			}
			if (render) {
				render();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		stop();
	}

	public void render() {
		// Have to be uncomment to render
//		render.clear();
		window.update();
		stateManager.render(window.getGraphics());
	}

	public void update() {
		stateManager.update();
		stateManager.input(window.getKeyInputInstace());
	}

	public Window getWindow() {
		return window;
	}

	public double getFPS() {
		return 0;
	}

	public static Engine createInstance() {
		ENGINEINSTANCE = new Engine();
		System.out.println(ENGINEINSTANCE);
		return ENGINEINSTANCE;
	}

}
