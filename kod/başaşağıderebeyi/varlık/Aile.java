/**
 * başaşağıderebeyi.varlık.Aile.java
 * 0.22 / 4 Kas 2020 / 19:00:40
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.varlık;

import java.util.*;

public abstract class Aile {
	public final Topluluk topluluk;
	public final Set<Varlık> varlıklar;
	public final Class<? extends Bileşen>[] gerekliSınıflar;
	
	@SuppressWarnings("unchecked")
	public Aile(Topluluk topluluk, Class<?>... gerekliSınıflar) {
		this.topluluk = topluluk;
		varlıklar = new HashSet<>();
		this.gerekliSınıflar = (Class<? extends Bileşen>[])gerekliSınıflar;
		topluluk.aileler.add(this);
		for (Varlık varlık : topluluk.varlıklar)
			ekle(varlık);
	}
	
	public void güncelle() {
	}
	
	public void çiz() {
	}
	
	public boolean karşılıyorMu(Varlık varlık) {
		for (Class<? extends Bileşen> sınıf : gerekliSınıflar)
			if (varlık.bileşen(sınıf) == null)
				return false;
		return true;
	}
	
	public void ekle(Varlık varlık) {
		if (karşılıyorMu(varlık))
			varlıklar.add(varlık);
	}
}
