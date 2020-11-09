/**
 * başaşağıderebeyi.arayüz.öğe.KayanLevha.java
 * 0.17 / 15 Eyl 2020 / 17:03:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.öğe;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.matematik.hiza.*;

public class KayanLevha extends Levha {
	public final float asılGenişlik;
	public final float asılYükseklik;
	public final KaydırmaÇubuğu yatayÇubuk;
	public final KaydırmaÇubuğu dikeyÇubuk;
	
	public float yatayKaydırma;
	public float dikeyKaydırma;
	
	public KayanLevha(Levha levha, float asılGenişlik, float asılYükseklik) {
		super(new Levha(new Levha(levha, levha.pencere, levha.ekran), levha.pencere, levha.ekran), levha.pencere, levha.ekran);
		this.asılGenişlik = asılGenişlik;
		this.asılYükseklik = asılYükseklik;
		yatayÇubuk = new KaydırmaÇubuğu(this, false);
		dikeyÇubuk = new KaydırmaÇubuğu(this, true);
		this.levha.hizalıDikdörtgen.hepsiniAyarla(
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new TersSabitHiza(DikdörtgenVerisi.BÜYÜK).yaz(KaydırmaÇubuğu.KALINLIK),
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new TersSabitHiza(DikdörtgenVerisi.BÜYÜK).yaz(KaydırmaÇubuğu.KALINLIK));
		hizalıDikdörtgen.hepsiniAyarla(
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new SerbestBoyutHiza(asılGenişlik),
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK),
				new SerbestBoyutHiza(asılYükseklik));
	}
	
	@Override
	public void hizala() {
		((SabitHiza)hizalıDikdörtgen.hizalar[0]).yaz((levha.hizalıDikdörtgen.hedef.ö.x - asılGenişlik) * yatayKaydırma);
		((SabitHiza)hizalıDikdörtgen.hizalar[2]).yaz((levha.hizalıDikdörtgen.hedef.ö.y - asılYükseklik) * dikeyKaydırma);
		super.hizala();
	}
	
	@Override
	public String toString() {
		return "Kayan " + super.toString();
	}
}
