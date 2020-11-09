/**
 * başaşağıderebeyi.matematik.hiza.TersSabitHiza.java
 * 0.16 / 13 Eyl 2020 / 18:52:31
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public class TersSabitHiza extends Hiza {
	public float mesafe;
	
	public TersSabitHiza(DikdörtgenVerisi veri) {
		super(veri, false, false);
	}
	
	public TersSabitHiza yaz(float mesafe) {
		this.mesafe = mesafe;
		return this;
	}
	
	public TersSabitHiza taşı(float o) {
		return yaz(mesafe + o);
	}
	
	@Override
	public void hesapla() {
		yön.yaz(hedef, yön.büyük().al(ana) - mesafe);
	}
}
