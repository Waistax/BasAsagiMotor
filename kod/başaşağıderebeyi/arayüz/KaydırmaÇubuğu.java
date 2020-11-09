/**
 * başaşağıderebeyi.arayüz.KaydırmaÇubuğu.java
 * 0.17 / 15 Eyl 2020 / 18:03:11
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.matematik.hiza.*;

public class KaydırmaÇubuğu extends Öğe {
	public static final float KALINLIK = 10.0F;
	
	public final boolean kenar;
	public final KayanLevha kayanLevha;
	
	public KaydırmaÇubuğu(KayanLevha kayanLevha, boolean kenar) {
		super(kayanLevha.levha.levha);
		this.kenar = kenar;
		this.kayanLevha = kayanLevha;
		if (kenar) {
			hizalıDikdörtgen.hepsiniAyarla(
					new TersSabitHiza(DikdörtgenVerisi.BÜYÜK),
					new SerbestBoyutHiza(KALINLIK),
					new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
					new SerbestBoyutHiza());
		} else {
			hizalıDikdörtgen.hepsiniAyarla(
					new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
					new SerbestBoyutHiza(),
					new TersSabitHiza(DikdörtgenVerisi.BÜYÜK),
					new SerbestBoyutHiza(KALINLIK));
		}
	}
	
	@Override
	public void hizala() {
		if (kenar) {
			SerbestBoyutHiza hiza = (SerbestBoyutHiza)hizalıDikdörtgen.hizalar[3];
			hiza.yaz(Hesaplayıcı.karesi(kayanLevha.levha.hizalıDikdörtgen.hedef.ö.y) / kayanLevha.asılYükseklik);
			açık = hiza.boyut < kayanLevha.levha.hizalıDikdörtgen.hedef.ö.y;
		}
		else {
			SerbestBoyutHiza hiza = (SerbestBoyutHiza)hizalıDikdörtgen.hizalar[1];
			hiza.yaz(Hesaplayıcı.karesi(kayanLevha.levha.hizalıDikdörtgen.hedef.ö.x) / kayanLevha.asılGenişlik);
			açık = hiza.boyut < kayanLevha.levha.hizalıDikdörtgen.hedef.ö.x;
		}
		super.hizala();
	}
	
	@Override
	public void güncelle() {
		if (!açıkMı())
			return;
		SabitHiza hiza = (SabitHiza)hizalıDikdörtgen.hizalar[kenar ? 2 : 0];
		if (Girdi.tekerlekUygunMu(this) && Girdi.tekerlek != 0) {
			if (kenar)
				hiza.taşı(Girdi.tekerlek * kayanLevha.levha.hizalıDikdörtgen.hedef.ö.y * 0.01F);
			else
				hiza.taşı(Girdi.tekerlek * kayanLevha.levha.hizalıDikdörtgen.hedef.ö.x * 0.01F);
			odakla();
			Girdi.tekerlekKullanıldı(this);
		}
		if (Girdi.imleçUygunMu(this) && ekran.tık.aşağı) {
			hiza.taşı(kenar ? Girdi.SÜRÜKLEME.y : Girdi.SÜRÜKLEME.x);
			odakla();
		}
		float enFazlaKayma = kenar
				? kayanLevha.levha.hizalıDikdörtgen.hedef.ö.y - alan.ö.y
				: kayanLevha.levha.hizalıDikdörtgen.hedef.ö.x - alan.ö.x;
		if (hiza.mesafe > enFazlaKayma)
			hiza.mesafe = enFazlaKayma;
		if (hiza.mesafe < 0.0F)
			hiza.mesafe = 0.0F;
		if (kenar)
			kayanLevha.dikeyKaydırma = hiza.mesafe / enFazlaKayma;
		else
			kayanLevha.yatayKaydırma = hiza.mesafe / enFazlaKayma;
		levha.hizala();
	}
	
	@Override
	public String toString() {
		return (kenar ? "Dikey" : "Yatay") + " Kaydırma Çubuğu";
	}
}
