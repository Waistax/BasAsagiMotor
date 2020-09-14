/**
 * başaşağıderebeyi.arayüz.Pencere.java
 * 0.16 / 13 Eyl 2020 / 21:51:31
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;
import başaşağıderebeyi.motor.*;

public class Pencere extends Levha {
	public static final float ÇUBUK_YÜKSEKLİĞİ = 30.0F;
	public static final float ÇARPI_GENİŞLİĞİ = 50.0F;
	
	public final float genişlik;
	public final float yükseklik;
	public final PencereÇubuğu çubuk;
	public final Düğme çarpı;
	public final int solDüğme;
	
	public Pencere(Ekran ekran, String başlık, float genişlik, float yükseklik, int solDüğme) {
		super(ekran);
		this.genişlik = genişlik;
		this.yükseklik = yükseklik;
		hizalama
		.kx(new SerbestHiza().ortala(ekran.hizalama.alan.b.x, genişlik))
		.bx(new SabitBoyutHiza(genişlik))
		.by(new SerbestHiza().ortala(ekran.hizalama.alan.b.y, -yükseklik))
		.ky(new SabitBoyutHiza(yükseklik + ÇUBUK_YÜKSEKLİĞİ));
		çubuk = new PencereÇubuğu(this, başlık);
		çarpı = new Düğme(this, "X", new Runnable() {
			@Override
			public void run() {
				ekran.içerik.remove(çarpı.levha);
			}
		}, solDüğme);
		çarpı.hizalama
		.kx(new TersSabitHiza(ÇARPI_GENİŞLİĞİ))
		.bx(new TersSabitHiza(0.0F))
		.ky(new SabitHiza(0.0F))
		.by(new SabitBoyutHiza(ÇUBUK_YÜKSEKLİĞİ));
		this.solDüğme = solDüğme;
	}

	@Override
	public void odağıAl() {
		((Ekran)levha).odakla(this);
	}
	
	@Override
	public boolean girdi(Girdi girdi) {
		if (çubuk.odaklı && girdi.düğmeAşağı[solDüğme]) {
			((SerbestHiza)hizalama.hizalar.get(0)).taşı(girdi.imleçDeğişimi.x);
			((SerbestHiza)hizalama.hizalar.get(2)).taşı(girdi.imleçDeğişimi.y);
			hizala();
		}
		return super.girdi(girdi) || üzerinde;
	}
	
	@Override
	public String toString() {
		return "Pencere: " + çubuk.başlık;
	}
}
