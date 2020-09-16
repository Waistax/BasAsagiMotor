/**
 * başaşağıderebeyi.arayüz.KaydırmaÇubuğu.java
 * 0.17 / 15 Eyl 2020 / 18:03:11
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;
import başaşağıderebeyi.motor.*;

public class KaydırmaÇubuğu extends Öğe {
	public static final float KALINLIK = 10.0F;
	
	public final boolean kenar;
	public final KayanLevha kayanLevha;
	
	public KaydırmaÇubuğu(KayanLevha kayanLevha, boolean kenar) {
		super(kayanLevha.levha);
		this.kenar = kenar;
		this.kayanLevha = kayanLevha;
		if (kenar) {
			hizalama
			.kx(new TersSabitHiza(KALINLIK))
			.bx(new TersSabitHiza(0.0F))
			.ky(new SabitHiza())
			.by(new SabitBoyutHiza((float)Math.pow(kayanLevha.görünürHizalama.alan.yükseklik(), 2.0F) / kayanLevha.asılYükseklik));
		} else {
			hizalama
			.ky(new TersSabitHiza(KALINLIK))
			.by(new TersSabitHiza(0.0F))
			.kx(new SabitHiza())
			.bx(new SabitBoyutHiza((float)Math.pow(kayanLevha.görünürHizalama.alan.genişlik(), 2.0F) / kayanLevha.asılGenişlik));
		}
	}
	
	@Override
	public void hizala() {
		((SabitBoyutHiza)hizalama.hizalar.get(3))
		.yaz((float)Math.pow((kenar
				? kayanLevha.görünürHizalama.alan.yükseklik()
				: kayanLevha.görünürHizalama.alan.genişlik())
				, 2.0F) / (kenar
				? kayanLevha.asılYükseklik
				: kayanLevha.asılGenişlik));
		super.hizala();
	}
	
	@Override
	public boolean girdi(Girdi girdi) {
		SabitHiza hiza = (SabitHiza)hizalama.hizalar.get(2);
		if (kenar)
			hiza.taşı(girdi.kaydırma * kayanLevha.asılYükseklik * 0.01F);
		if (odaklı && girdi.düğmeAşağı[1]) {
			hiza.taşı(kenar ? girdi.imleçDeğişimi.y : girdi.imleçDeğişimi.x);
		}
		if (hiza.mesafe < 0.0F)
			hiza.mesafe = 0.0F;
		float enFazlaKayma = kenar
				? kayanLevha.görünürHizalama.alan.yükseklik() - hizalama.alan.yükseklik()
				: kayanLevha.görünürHizalama.alan.genişlik() - hizalama.alan.genişlik();
		if (hiza.mesafe > enFazlaKayma)
			hiza.mesafe = enFazlaKayma;
		if (kenar)
			kayanLevha.dikeyKaydırma = hiza.mesafe / enFazlaKayma;
		else
			kayanLevha.yatayKaydırma = hiza.mesafe / enFazlaKayma;
		levha.hizala();
		return super.girdi(girdi) || üzerinde;
	}
}
