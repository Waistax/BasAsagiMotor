/**
 * başaşağıderebeyi.arayüz.hiza.SabitBoyutHiza.java
 * 0.16 / 13 Eyl 2020 / 18:54:00
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class SabitBoyutHiza extends Hiza {
	public final float boyut;
	
	public SabitBoyutHiza(float boyut) {
		this.boyut = boyut;
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.boyutYaz(hizalama.alan, boyut);
	}
}
