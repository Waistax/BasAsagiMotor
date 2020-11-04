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
		.kx(new SabitHiza())
		.g(new TersSabitHiza(Pencere.ÇARPI_GENİŞLİĞİ))
		.ky(new SabitHiza())
		.y(new SabitBoyutHiza(Pencere.ÇUBUK_YÜKSEKLİĞİ));
		this.başlık = başlık;
	}
	
	@Override
	public void güncelle() {
		if (Girdi.imleçUygunMu(this) && ekran.tık.aşağı) {
			odakla();
			((SerbestHiza)levha.hizalama.hizalar.get(0)).taşı(Girdi.SÜRÜKLEME.x);
			((SerbestHiza)levha.hizalama.hizalar.get(2)).taşı(Girdi.SÜRÜKLEME.y);
			levha.hizala();
		}
	}
	
	@Override
	public String toString() {
		return "Pencere Çubuğu: " + başlık;
	}
}
