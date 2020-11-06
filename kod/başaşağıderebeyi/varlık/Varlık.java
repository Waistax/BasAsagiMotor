/**
 * başaşağıderebeyi.varlık.Varlık.java
 * 0.22 / 4 Kas 2020 / 18:09:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.varlık;

import java.util.*;

public class Varlık {
	public final Topluluk topluluk;
	public final Map<Class<? extends Bileşen>, Bileşen> bileşenler;
	
	public Varlık(Topluluk topluluk) {
		this.topluluk = topluluk;
		bileşenler = new HashMap<>();
		topluluk.varlıklar.add(this);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Bileşen> T bileşen(Class<T> sınıf) {
		return (T)bileşenler.get(sınıf);
	}
}
