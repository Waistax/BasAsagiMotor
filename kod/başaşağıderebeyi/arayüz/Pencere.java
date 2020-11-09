/**
 * başaşağıderebeyi.arayüz.Pencere.java
 * 0.16 / 13 Eyl 2020 / 21:51:31
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.matematik.hiza.*;

public class Pencere extends Levha {
	public static final float ÇUBUK_KALINLIĞI = 30.0F;
	public static final float ÇARPI_GENİŞLİĞİ = 50.0F;
	
	public final float genişlik;
	public final float yükseklik;
	public final PencereÇubuğu çubuk;
	public final Düğme çarpı;
	
	public Pencere(Ekran ekran, String başlık, float genişlik, float yükseklik) {
		super(ekran, null, ekran);
		this.genişlik = genişlik;
		this.yükseklik = yükseklik;
		hizalıDikdörtgen.hepsiniAyarla(
				new SerbestHiza(DikdörtgenVerisi.ORTA).yaz(ekran.alan.o.x),
				new SerbestBoyutHiza(genişlik),
				new SerbestHiza(DikdörtgenVerisi.ORTA).yaz(ekran.alan.o.y),
				new SerbestBoyutHiza(yükseklik));
		çubuk = new PencereÇubuğu(this, başlık);
		çarpı = new Düğme(this, "X", new Runnable() {
			@Override
			public void run() {
				ekran.içerik.remove(çarpı.levha);
			}
		});
		çarpı.hizalıDikdörtgen.hepsiniAyarla(
				new TersSabitHiza(DikdörtgenVerisi.BÜYÜK),
				new SerbestBoyutHiza(ÇARPI_GENİŞLİĞİ),
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new SerbestBoyutHiza(ÇUBUK_KALINLIĞI));
	}
	
	@Override
	public void odakla() {
		ekran.odakla(this);
	}
	
	@Override
	public String toString() {
		return "Pencere: " + çubuk.başlık;
	}
}
