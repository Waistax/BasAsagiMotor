/**
 * başaşağıderebeyi.arayüz.kutu.KutuÇizer.java
 * 0.22 / 4 Kas 2020 / 21:07:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.kutu;

import başaşağıderebeyi.varlık.*;
import başaşağıderebeyi.çizer.*;

import java.awt.*;

public class KutuÇizer extends Çizer {
	public final Graphics2D çizer;
	
	public KutuÇizer(Topluluk topluluk, Graphics2D çizer) {
		super(topluluk);
		this.çizer = çizer;
	}

	@Override
	public void çiz(Çizim çizim) {
		Kutu kutu = (Kutu)çizim;
		çizer.setColor(new Color(kutu.renk.x, kutu.renk.y, kutu.renk.z, kutu.renk.w));
		çizer.setStroke(new BasicStroke(0.5F));
		çizer.fillRect((int)kutu.d.k.x, (int)kutu.d.k.y, (int)kutu.d.ö.x, (int)kutu.d.ö.y);
		çizer.setColor(Color.black);
		çizer.drawRect((int)kutu.d.k.x, (int)kutu.d.k.y, (int)kutu.d.ö.x, (int)kutu.d.ö.y);
	}
}
