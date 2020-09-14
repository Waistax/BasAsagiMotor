/**
 * başaşağıderebeyi.arayüz.Etiket.java
 * 0.16 / 13 Eyl 2020 / 22:06:18
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

public class Etiket extends Öğe {
	public String yazı;
	
	public Etiket(Levha levha) {
		super(levha);
	}
	
	@Override
	public String toString() {
		return levha + " Etiketi: " + yazı;
	}
}
