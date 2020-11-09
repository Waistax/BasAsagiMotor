/**
 * başaşağıderebeyi.matematik.hiza.SabitHiza.java
 * 0.16 / 13 Eyl 2020 / 18:48:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public class SabitHiza extends Hiza {
	public float mesafe;

	public SabitHiza(DikdörtgenVerisi veri) {
		super(veri, false, false);
	}

	public SabitHiza yaz(float mesafe) {
		this.mesafe = mesafe;
		return this;
	}
	
	public SabitHiza taşı(float o) {
		return yaz(mesafe + o);
	}
	
	@Override
	public void hesapla() {
		yön.yaz(hedef, yön.küçük().al(ana) + mesafe);
	}
}
