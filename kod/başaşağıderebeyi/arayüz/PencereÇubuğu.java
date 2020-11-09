/**
 * başaşağıderebeyi.arayüz.PencereÇubuğu.java
 * 0.16 / 13 Eyl 2020 / 21:58:50
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.matematik.hiza.*;

public class PencereÇubuğu extends Öğe {
	public final String başlık;
	
	public PencereÇubuğu(Pencere pencere, String başlık) {
		super(pencere);
		hizalıDikdörtgen.hepsiniAyarla(
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new TersSabitHiza(DikdörtgenVerisi.BÜYÜK).yaz(Pencere.ÇARPI_GENİŞLİĞİ),
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new SerbestBoyutHiza(Pencere.ÇUBUK_KALINLIĞI));
		this.başlık = başlık;
	}
	
	@Override
	public void güncelle() {
		if (Girdi.imleçUygunMu(this) && ekran.tık.aşağı) {
			odakla();
			((SerbestHiza)levha.hizalıDikdörtgen.hizalar[0]).taşı(Girdi.SÜRÜKLEME.x);
			((SerbestHiza)levha.hizalıDikdörtgen.hizalar[2]).taşı(Girdi.SÜRÜKLEME.y);
			levha.hizala();
		}
	}
	
	@Override
	public String toString() {
		return "Pencere Çubuğu: " + başlık;
	}
}
