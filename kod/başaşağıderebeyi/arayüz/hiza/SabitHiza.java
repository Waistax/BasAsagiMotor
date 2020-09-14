/**
 * başaşağıderebeyi.arayüz.hiza.SabitHiza.java
 * 0.16 / 13 Eyl 2020 / 18:48:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class SabitHiza extends Hiza {
	public final float mesafe;
	
	public SabitHiza(float mesafe) {
		this.mesafe = mesafe;
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, yön.al(levha.k) + mesafe);
	}
}
