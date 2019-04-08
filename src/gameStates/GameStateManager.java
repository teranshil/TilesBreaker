package gameStates;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Optional;

import gameWindow.Window;
import inputHandeling.KeyInput;
import util.Vector2f;

public class GameStateManager {

	private static final GameStateManager manager = new GameStateManager();
	private ArrayList<GameState> states = new ArrayList<>();

	private Vector2f mapVector = new Vector2f(Window.getWindowWidth(), Window.getWindowHeight());

	private GameStateManager() {
		Vector2f.setWorldVar(mapVector.vectorX, mapVector.vectorY);
	}

	public void render(Graphics2D g2D) {
		states.stream()
		        .forEach(e -> e.render(g2D));
	}

	public void update() {
		Vector2f.setWorldVar(mapVector.vectorX, mapVector.vectorY);
		states.stream()
		        .forEach(e -> e.update());
	}

	public void input(KeyInput input) {
		states.forEach(e -> e.input(input));
	}

	public void removeGameState(GameState state) {
		states.remove(state);
	}

	public void addGameState(GameState state) {
		states.add(state);
	}

	public static GameStateManager getInstance() {
		return manager;
	}

	private Optional<GameState> findElement(GameState state) {
		return states.stream()
		        .filter(e -> e.equals(state))
		        .findFirst();
	}

	public GameState getState(GameState state) {
		Optional<GameState> gameState = findElement(state);
		if (gameState.isPresent())
			return gameState.get();
		else
			return null;

	}
}
