/**
 * başaşağıderebeyi.kumhavuzu.KutuÇizer.java
 * 0.22 / 4 Kas 2020 / 21:07:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.varlık.*;
import başaşağıderebeyi.çizer.*;

import java.awt.*;

public class KutuÇizer extends Çizer {
	public final Graphics2D çizer;
	public final Dikdörtgen2 d;
	
	public KutuÇizer(Topluluk topluluk, Graphics2D çizer) {
		super(topluluk);
		this.çizer = çizer;
		d = new Dikdörtgen2();
	}

	@Override
	public void çiz(Çizim çizim) {
		Kutu kutu = (Kutu)çizim;
		d.yuvarla(kutu.d);
		çizer.setColor(new Color(kutu.renk.x, kutu.renk.y, kutu.renk.z, kutu.renk.w));
		çizer.setStroke(new BasicStroke(0.5F));
		çizer.fillRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		çizer.setColor(Color.black);
		çizer.drawRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
	}
}
