/**
 * başaşağıderebeyi.arayüz.hiza.TersSabitHiza.java
 * 0.16 / 13 Eyl 2020 / 18:52:31
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class TersSabitHiza extends Hiza {
	public float mesafe;
	
	public TersSabitHiza() {
	}
	
	public TersSabitHiza(float mesafe) {
		yaz(mesafe);
	}
	
	public TersSabitHiza yaz(float mesafe) {
		this.mesafe = mesafe;
		return this;
	}
	
	public TersSabitHiza taşı(float o) {
		return yaz(mesafe + o);
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, yön.al(levha.b) - mesafe);
	}
}
