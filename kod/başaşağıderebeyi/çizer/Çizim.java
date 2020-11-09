/**
 * başaşağıderebeyi.çizer.Çizim.java
 * 0.22 / 4 Kas 2020 / 19:39:49
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.çizer;

public abstract class Çizim {
	public abstract Çizim yaz(Çizim ç);
	
	public abstract Çizim araDeğer(Çizim sol, Çizim sağ, float solaUzaklık, float sağaUzaklık);
	
	public abstract Çizim hazırla();
}
