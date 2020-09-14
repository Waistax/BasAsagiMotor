/**
 * başaşağıderebeyi.arayüz.hiza.TersSabitHiza.java
 * 0.16 / 13 Eyl 2020 / 18:52:31
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class TersSabitHiza extends Hiza {
	public final float mesafe;
	
	public TersSabitHiza(float mesafe) {
		this.mesafe = mesafe;
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, yön.al(levha.b) - mesafe);
	}
}
