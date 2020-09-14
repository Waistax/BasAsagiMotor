/**
 * başaşağıderebeyi.arayüz.Düğme.java
 * 0.16 / 14 Eyl 2020 / 00:35:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

public class Düğme extends Öğe {
	public final String yazı;
	public final Runnable çalıştırılabilir;
	public final int solDüğme;
	
	public Düğme(Levha levha, String yazı, Runnable çalıştırılabilir, int solDüğme) {
		super(levha);
		this.yazı = yazı;
		this.çalıştırılabilir = çalıştırılabilir;
		this.solDüğme = solDüğme;
	}
	
	@Override
	public boolean tıklandığında(int düğme) {
		if (!açıkMı())
			return false;
		if (düğme == solDüğme) {
			odağıAl();
			çalıştırılabilir.run();
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return levha + " Düğmesi: " + yazı;
	}
}
