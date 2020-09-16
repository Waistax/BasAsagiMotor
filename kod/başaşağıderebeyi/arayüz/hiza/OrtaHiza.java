/**
 * başaşağıderebeyi.arayüz.hiza.OrtaHiza.java
 * 0.16 / 13 Eyl 2020 / 19:43:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class OrtaHiza extends Hiza {
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, (yön.kenarToplam(levha) - yön.karşı().al(hizalama.alan)));
	}
}
