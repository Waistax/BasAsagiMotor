/**
 * başaşağıderebeyi.matematik.hiza.SerbestBoyutHiza.java
 * 0.16 / 13 Eyl 2020 / 18:54:00
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public class SerbestBoyutHiza extends Hiza {
	public float boyut;
	
	public SerbestBoyutHiza() {
		super(DikdörtgenVerisi.ÖLÇÜ, false, false);
	}
	
	public SerbestBoyutHiza(float boyut) {
		this();
		yaz(boyut);
	}
	
	public SerbestBoyutHiza yaz(float boyut) {
		this.boyut = boyut;
		return this;
	}

	@Override
	public void hesapla() {
		yön.yaz(hedef, boyut);
	}
}
