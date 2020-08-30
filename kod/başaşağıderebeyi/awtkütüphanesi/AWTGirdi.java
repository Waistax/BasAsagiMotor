/**
 * başaşağıderebeyi.awtkütüphanesi.AWTGirdi.java
 * 0.5 / 29 Ağu 2020 / 12:20:15
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.awtkütüphanesi;

import başaşağıderebeyi.motor.*;

import java.awt.event.*;

public class AWTGirdi extends Girdi implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
	public AWTGirdi() {
		super(256, 8);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		tuşGirdisi[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		tuşGirdisi[e.getKeyCode()] = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		düğmeGirdisi[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		düğmeGirdisi[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		kaydırmaGirdisi += e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		imleçGirdisi.yaz(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		imleçGirdisi.yaz(e.getX(), e.getY());
	}
}
