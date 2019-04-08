package util;

public class Vector2f {

	public float vectorX = 0, vectorY = 0;
	public static float worldX, worldY;

	public Vector2f() {
		vectorX = 0;
		vectorY = 0;
	}

	public Vector2f(float vectorX, float vectorY) {
		this.vectorX = vectorX;
		this.vectorY = vectorY;
	}

	public Vector2f(Vector2f vector) {
		new Vector2f(vector.vectorX, vector.vectorY);
	}

	// setters and getters
	public void setVector(Vector2f vector) {
		this.vectorX = vector.vectorX;
		this.vectorY = vector.vectorY;
	}

	public void setVector(float vectorX, float vectorY) {
		this.vectorX = vectorX;
		this.vectorY = vectorY;
	}

	public static void setWorldVar(float worldX, float worldY) {
		Vector2f.worldX = worldX;
		Vector2f.worldY = worldY;
	}

	public Vector2f getWorldVar() {
		return new Vector2f(vectorX - worldX, vectorY - worldY);
	}

	public void addX(int x) {
		vectorX += x;
	}

	public void addY(int y) {
		vectorY += y;
	}

	public void setY(int y) {
		vectorY = y;
	}

	public void setX(int x) {
		vectorX = x;
	}
}
