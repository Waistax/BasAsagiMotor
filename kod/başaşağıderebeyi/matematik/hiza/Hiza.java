/**
 * başaşağıderebeyi.matematik.hiza.Hiza.java
 * 0.16 / 13 Eyl 2020 / 17:46:57
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik.hiza;

import başaşağıderebeyi.matematik.*;

public abstract class Hiza {
	public final DikdörtgenVerisi veri;
	public final boolean ikincil;
	public final boolean bağımlı;
	
	public Dikdörtgen ana;
	public Dikdörtgen hedef;
	public HizaYönü yön;
	public HizaYönü birincilYön;

	public Hiza(DikdörtgenVerisi veri, boolean ikincil, boolean bağımlı) {
		this.veri = veri;
		this.ikincil = ikincil;
		this.bağımlı = bağımlı;
	}

	public abstract void hesapla();
}
