package gameStates;

import java.awt.Graphics2D;

import inputHandeling.KeyInput;

public abstract class GameState {

	public GameState() {
	}

	protected abstract void render(Graphics2D g2D);

	protected abstract void update();

	protected abstract void input(KeyInput input);

	protected abstract void displayFPS(Graphics2D g2D);

}
