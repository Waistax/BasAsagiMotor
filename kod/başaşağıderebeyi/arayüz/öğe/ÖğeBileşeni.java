/**
 * başaşağıderebeyi.arayüz.öğe.ÖğeBileşeni.java
 * 0.27 / 9 Kas 2020 / 09:34:41
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.öğe;

import başaşağıderebeyi.varlık.*;

public class ÖğeBileşeni extends Bileşen {
	public final Öğe öğe;
	
	public ÖğeBileşeni(Varlık varlık, Öğe öğe) {
		super(varlık);
		this.öğe = öğe;
	}
}
