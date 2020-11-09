/**
 * başaşağıderebeyi.matematik.hiza.OranBoyutHiza.java
 * 0.16 / 13 Eyl 2020 / 18:55:02
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public class OranBoyutHiza extends Hiza {
	public float oran;
	
	public OranBoyutHiza() {
		super(DikdörtgenVerisi.ÖLÇÜ, false, true);
	}
	
	public OranBoyutHiza yaz(float o) {
		oran = o;
		return this;
	}
	
	public OranBoyutHiza taşı(float o) {
		return yaz(oran + o);
	}
	
	@Override
	public void hesapla() {
		yön.yaz(hedef, yön.komşu().ölçü().al(hedef) * oran);
	}
}
