/**
 * başaşağıderebeyi.arayüz.KayanLevha.java
 * 0.17 / 15 Eyl 2020 / 17:03:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;
import başaşağıderebeyi.motor.*;

public class KayanLevha extends Levha {
	public final Hizalama görünürHizalama;
	public final float asılGenişlik;
	public final float asılYükseklik;
	public final KaydırmaÇubuğu yatayÇubuk;
	public final KaydırmaÇubuğu dikeyÇubuk;
	
	public float yatayKaydırma;
	public float dikeyKaydırma;
	
	public KayanLevha(Levha levha, float asılGenişlik, float asılYükseklik, int solDüğme) {
		super(new Levha(levha));
		görünürHizalama = new Hizalama();
		this.asılGenişlik = asılGenişlik;
		this.asılYükseklik = asılYükseklik;
		yatayÇubuk = new KaydırmaÇubuğu(this, false, solDüğme);
		dikeyÇubuk = new KaydırmaÇubuğu(this, true, solDüğme);
		görünürHizalama
		.kx(new SabitHiza())
		.bx(new TersSabitHiza(KaydırmaÇubuğu.KALINLIK))
		.ky(new SabitHiza())
		.by(new TersSabitHiza(KaydırmaÇubuğu.KALINLIK));
		hizalama
		.kx(new SabitHiza())
		.bx(new SabitBoyutHiza(asılGenişlik))
		.ky(new SabitHiza())
		.by(new SabitBoyutHiza(asılYükseklik));
	}
	
	@Override
	public void hizala() {
		görünürHizalama.hesapla(levha.hizalama.alan);
		((SabitHiza)hizalama.hizalar.get(0)).yaz((görünürHizalama.alan.genişlik() - asılGenişlik) * yatayKaydırma);
		((SabitHiza)hizalama.hizalar.get(2)).yaz((görünürHizalama.alan.yükseklik() - asılYükseklik) * dikeyKaydırma);
		hizalama.hesapla(görünürHizalama.alan);
		for (Öğe öğe : içerik)
			öğe.hizala();
	}
	
	@Override
	public boolean girdi(Girdi girdi) {
		boolean sonuç = false;
		if (görünürHizalama.alan.içinde(girdi.imleç)) {
			üzerinde = true;
			for (int i = 0; i < girdi.düğmeler; i++)
				if (girdi.düğmeBasıldı[i])
					if (tıklandığında(i)) {
						sonuç = true;
						break;
					}
			for (int i = içerik.size() - 1; i > -1; i--)
				if (içerik.get(i).girdi(girdi)) {
					for (int j = 0; j < içerik.size(); j++)
						if (i != j)
							içerik.get(j).üzerindeDeğil();
					sonuç = true;
					break;
				}
		} else {
			üzerindeDeğil();
		}
		return sonuç;
	}
}
