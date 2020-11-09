/**
 * başaşağıderebeyi.awtkütüphanesi.AWTGirdi.java
 * 0.5 / 29 Ağu 2020 / 12:20:15
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.awtkütüphanesi;

import başaşağıderebeyi.girdi.*;

import java.awt.event.*;

public class AWTGirdiDinleyicisi implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Girdi.girdiYaz(e.getKeyCode(), true);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		Girdi.girdiYaz(e.getKeyCode(), false);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Girdi.fareGirdisiYaz(e.getButton(), true);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Girdi.fareGirdisiYaz(e.getButton(), false);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		Girdi.tekerlekGirdisiYaz(e.getWheelRotation());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Girdi.imleçGirdisiYaz(e.getX(), e.getY());
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		Girdi.imleçGirdisiYaz(e.getX(), e.getY());
	}
}
