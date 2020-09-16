/**
 * başaşağıderebeyi.arayüz.hiza.SabitHiza.java
 * 0.16 / 13 Eyl 2020 / 18:48:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class SabitHiza extends Hiza {
	public float mesafe;
	
	public SabitHiza() {
	}
	
	public SabitHiza(float mesafe) {
		yaz(mesafe);
	}
	
	public SabitHiza yaz(float mesafe) {
		this.mesafe = mesafe;
		return this;
	}
	
	public SabitHiza taşı(float o) {
		return yaz(mesafe + o);
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, yön.al(levha.k) + mesafe);
	}
}
