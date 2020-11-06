/**
 * başaşağıderebeyi.varlık.Bileşen.java
 * 0.22 / 4 Kas 2020 / 18:10:59
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.varlık;

public abstract class Bileşen {
	public final Varlık varlık;
	
	@SuppressWarnings("unchecked")
	public Bileşen(Varlık varlık) {
		this.varlık = varlık;
		Class<? extends Bileşen> sınıf = this.getClass();
		do {
			varlık.bileşenler.put(sınıf, this);
			sınıf = (Class<? extends Bileşen>)sınıf.getSuperclass();
		}
		while (sınıf != Bileşen.class);
		for (Aile aile : varlık.topluluk.aileler)
			aile.ekle(varlık);
	}
}
