/**
 * başaşağıderebeyi.arayüz.hiza.OranBoyutHiza.java
 * 0.16 / 13 Eyl 2020 / 18:55:02
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class OranBoyutHiza extends Hiza {
	public final float oran;
	
	public OranBoyutHiza(float oran) {
		this.oran = oran;
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, yön.karşı().al(hizalama.alan) + oran * yön.ters().boyut(hizalama.alan));
	}
}
