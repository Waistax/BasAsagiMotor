/**
 * başaşağıderebeyi.kütük.AdAlanı.java
 * 0.8 / 29 Ağu 2020 / 23:57:56
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütük;

import java.util.*;

public class Kapsam {
	public final String ad;
	public final List<Tanımlayıcı> tanımlayıcılar;
	
	public Kapsam(String ad) {
		this.ad = ad;
		tanımlayıcılar = new ArrayList<>();
	}
	
	public Tanımlayıcı tanımlayıcıOluştur(String ad) {
		for (Tanımlayıcı tanımlayıcı : tanımlayıcılar)
			if (tanımlayıcı.ad.equals(ad))
				return null;
		Tanımlayıcı tanımlayıcı = new Tanımlayıcı(this, ad);
		tanımlayıcılar.add(tanımlayıcı);
		return tanımlayıcı;
	}
	
	public Tanımlayıcı tanımlayıcıAl(String ad) {
		for (Tanımlayıcı tanımlayıcı : tanımlayıcılar)
			if (tanımlayıcı.ad.equals(ad))
				return tanımlayıcı;
		return null;
	}
	
	@Override
	public String toString() {
		return ad;
	}
}
