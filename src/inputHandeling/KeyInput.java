package inputHandeling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public class KeyInput implements MouseMotionListener, MouseListener, MouseInputListener, KeyListener {

	private boolean[] buttons = new boolean[256];
	private boolean[] lastButton = new boolean[256];
	private int mouseX = 0, mouseY = 0;
	private int lastButtonPressed = 0;
	public static final KeyInput iNSTANSE_KEYINPUT = new KeyInput();

	private KeyInput() {
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		buttons[e.getKeyCode()] = true;
		lastButtonPressed = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		buttons[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

	}

	public int getMouseCordinateX() {
		return mouseX;
	}

	public int getMouseCordinateY() {
		return mouseY;
	}

	public int getLastButtonPressed() {
		return lastButtonPressed;
	}

	public int getKeyPressed() {
		return lastButtonPressed;
	}

	public boolean[] getKeys() {
		return buttons;
	}
}
