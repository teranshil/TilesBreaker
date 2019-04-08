package renderManager.collision;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import util.Vector2f;

public class Collision {
	private double circleRadius;
	private int width, height;
	private Vector2f vector;
	private int offSetX, offSetY;
	private int size;
	private Rectangle rectangle;
	private double distance;

	public double getDistance() {
		return distance;
	}

	public Collision(Vector2f vector, int width, int height) {
		this.vector = vector;
		this.width = width;
		this.height = height;
		this.size = width * height;
		this.rectangle = new Rectangle(new Dimension(width, height));
	}

	public Collision(Vector2f vector, float circleRadius) {
		this.vector = vector;
		this.circleRadius = circleRadius;
		this.size = width * height;
	}

	public void setBox(Vector2f vector, int width, int height) {
		this.vector = vector;
		this.width = width;
		this.height = height;
		this.size = width * height;
	}

	public boolean boxCollisionCheck(Vector2f vector, Rectangle rectangle) {
		return this.rectangle.intersects(rectangle);
	}

	public boolean circleCollisionCheck(Vector2f circleVector, int radius) {

		distance = Point2D.distance(circleVector.vectorX, circleVector.vectorY, vector.vectorX, vector.vectorY);

		if (distance <= radius + circleRadius)
			return true;

		return false;
	}

	public void setAreaRadius(Vector2f vector, int areaRadius) {
		this.vector = vector;
		this.circleRadius = areaRadius;
	}

	// the basics getters and setters of variables
	public double getAreaRadius() {
		return circleRadius;
	}

	public void setAreaRadius(double circleRadius) {
		this.circleRadius = circleRadius;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector2f getVector() {
		return vector;
	}

	public void setVector(Vector2f vector) {
		this.vector = vector;
	}

}
