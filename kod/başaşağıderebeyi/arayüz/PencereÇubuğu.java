/**
 * başaşağıderebeyi.arayüz.PencereÇubuğu.java
 * 0.16 / 13 Eyl 2020 / 21:58:50
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;

public class PencereÇubuğu extends Öğe {
	public final String başlık;
	
	public PencereÇubuğu(Pencere pencere, String başlık) {
		super(pencere);
		hizalama
		.kx(new SabitHiza(0.0F))
		.g(new TersSabitHiza(Pencere.ÇARPI_GENİŞLİĞİ))
		.ky(new SabitHiza(0.0F))
		.y(new SabitBoyutHiza(Pencere.ÇUBUK_YÜKSEKLİĞİ));
		this.başlık = başlık;
	}
	
	@Override
	public String toString() {
		return "Pencere Çubuğu: " + başlık;
	}
}
