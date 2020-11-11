/**
 * başaşağıderebeyi.awtkütüphanesi.AWTKutuÇizer.java
 * 0.27 / 9 Kas 2020 / 15:18:52
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.awtkütüphanesi;

import başaşağıderebeyi.arayüz.kutu.*;

import java.awt.*;

public class AWTKutuÇizer implements KutuÇizer {
	public final Graphics2D çizer;
	
	public Stroke çerçeveŞekli;
	public Color çerçeveRengi;
	
	public AWTKutuÇizer(Graphics2D çizer) {
		this.çizer = çizer;
		çerçeveŞekli = new BasicStroke(0.5F);
		çerçeveRengi = new Color(0.0F, 0.0F, 0.0F, 1.0F);
	}

	@Override
	public void çiz(Kutu kutu) {
		çizer.setColor(new Color(kutu.renk.x, kutu.renk.y, kutu.renk.z, kutu.renk.w));
		çizer.fillRect((int)kutu.alan.k.x, (int)kutu.alan.k.y, (int)kutu.alan.ö.x, (int)kutu.alan.ö.y);
		çizer.setStroke(çerçeveŞekli);
		çizer.setColor(çerçeveRengi);
		çizer.drawRect((int)kutu.alan.k.x, (int)kutu.alan.k.y, (int)kutu.alan.ö.x, (int)kutu.alan.ö.y);
	}
}
