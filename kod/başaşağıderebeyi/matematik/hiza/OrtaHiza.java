/**
 * başaşağıderebeyi.matematik.hiza.OrtaHiza.java
 * 0.16 / 13 Eyl 2020 / 19:43:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public class OrtaHiza extends Hiza {
	public OrtaHiza() {
		super(DikdörtgenVerisi.ORTA, false, false);
	}

	@Override
	public void hesapla() {
		yön.yaz(hedef, yön.al(ana));
	}
}
