package gameEngine;

import gameStates.GameStateManager;
import gameStates.PlayState;

public class GameManager {
	public static void main(String[] args) {
		GameStateManager.getInstance()
		        .addGameState(PlayState.getInstance());
		Engine asdEngine = Engine.createInstance();
	}
}
