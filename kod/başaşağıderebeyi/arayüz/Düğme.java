/**
 * başaşağıderebeyi.arayüz.Düğme.java
 * 0.16 / 14 Eyl 2020 / 00:35:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

public class Düğme extends Öğe {
	public final String yazı;
	public final Runnable çalıştırılabilir;
	
	public boolean basıldı;
	
	public Düğme(Levha levha, String yazı, Runnable çalıştırılabilir) {
		super(levha);
		this.yazı = yazı;
		this.çalıştırılabilir = çalıştırılabilir;
	}
	
	@Override
	public void güncelle() {
		if (!açıkMı())
			return;
		if (Girdi.imleçUygunMu(this)) {
			if (ekran.tık.basma) {
				odakla();
				basıldı = true;
			}
			if (basıldı && ekran.tık.salma) {
				odakla();
				çalıştırılabilir.run();
				basıldı = false;
			}
		} else
			basıldı = false;
	}
	
	@Override
	public String toString() {
		return "Düğme: " + yazı;
	}
}
