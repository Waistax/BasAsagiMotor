/**
 * başaşağıderebeyi.arayüz.hiza.SerbestHiza.java
 * 0.16 / 13 Eyl 2020 / 17:48:47
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.hiza;

import başaşağıderebeyi.matematik.*;

public class SerbestHiza extends Hiza {
	public float konum;
	
	public SerbestHiza yaz(float o) {
		konum = o;
		return this;
	}
	
	public SerbestHiza taşı(float o) {
		return yaz(konum + o);
	}
	
	public SerbestHiza ortala(float anaBoyut, float boyut) {
		return yaz((anaBoyut - boyut) / 2.0F);
	}
	
	@Override
	public void hesapla(Dikdörtgen2 levha) {
		yön.yaz(hizalama.alan, konum);
	}
}
