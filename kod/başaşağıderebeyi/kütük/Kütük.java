/**
 * başaşağıderebeyi.kütük.Kütük.java
 * 0.8 / 30 Ağu 2020 / 11:09:24
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütük;

import java.util.*;

@SuppressWarnings("unchecked")
public class Kütük {
	public final List<Kapsam> kapsamlar;
	public final Map<Class<?>, Map<Tanımlayıcı, ?>> haritalar;
	
	public Kütük() {
		kapsamlar = new ArrayList<>();
		haritalar = new HashMap<>();
	}
	
	public Kapsam kapsamOluştur(String ad) {
		for (Kapsam kapsam : kapsamlar)
			if (kapsam.ad.equals(ad))
				return null;
		Kapsam kapsam = new Kapsam(ad);
		kapsamlar.add(kapsam);
		return kapsam;
	}
	
	public Kapsam kapsamAl(String ad) {
		for (Kapsam kapsam : kapsamlar)
			if (kapsam.ad.equals(ad))
				return kapsam;
		return null;
	}
	
	public Tanımlayıcı tanımlayıcıOluştur(String kimlik) {
		int ayırıcıKonumu = kimlik.indexOf(':');
		if (ayırıcıKonumu < 1 || ayırıcıKonumu >= kimlik.length() - 1)
			return null;
		String kapsamAdı = kimlik.substring(0, ayırıcıKonumu);
		Kapsam kapsam = kapsamAl(kapsamAdı);
		if (kapsam == null)
			kapsam = kapsamOluştur(kapsamAdı);
		String ad = kimlik.substring(ayırıcıKonumu + 1);
		return kapsam.tanımlayıcıOluştur(ad);
	}
	
	public Tanımlayıcı tanımlayıcıAl(String kimlik) {
		int ayırıcıKonumu = kimlik.indexOf(':');
		if (ayırıcıKonumu < 1 || ayırıcıKonumu >= kimlik.length() - 1)
			return null;
		Kapsam kapsam = kapsamAl(kimlik.substring(0, ayırıcıKonumu));
		if (kapsam == null)
			return null;
		return kapsam.tanımlayıcıAl(kimlik.substring(ayırıcıKonumu + 1));
	}
	
	public <T> Map<Tanımlayıcı, T> haritaOluştur(Class<T> değerTürü) {
		Map<Tanımlayıcı, ?> vahşiHarita = haritalar.get(değerTürü);
		if (vahşiHarita == null) {
			vahşiHarita = new HashMap<Tanımlayıcı, T>();
			haritalar.put(değerTürü, vahşiHarita);
		}
		return (Map<Tanımlayıcı, T>)vahşiHarita;
	}
	
	public <T> Map<Tanımlayıcı, T> haritaAl(Class<T> değerTürü) {
		Map<Tanımlayıcı, ?> vahşiHarita = haritalar.get(değerTürü);
		if (vahşiHarita == null)
			return null;
		return (Map<Tanımlayıcı, T>)vahşiHarita;
	}
	
	public <T> boolean bağla(Tanımlayıcı tanımlayıcı, T t) {
		haritaOluştur((Class<T>)t.getClass()).put(tanımlayıcı, t);
		return true;
	}
	
	public <T> boolean bağla(String kimlik, T t) {
		Tanımlayıcı tanımlayıcı = tanımlayıcıOluştur(kimlik);
		if (tanımlayıcı == null)
			return false;
		return bağla(tanımlayıcı, t);
	}
	
	public <T> boolean yenidenBağla(String kimlik, T t) {
		Tanımlayıcı tanımlayıcı = tanımlayıcıAl(kimlik);
		if (tanımlayıcı == null)
			return false;
		if (!sal(tanımlayıcı))
			return false;
		return bağla(tanımlayıcı, t);
	}
	
	public <T> boolean bağla(Tanımlayıcı tanımlayıcı, T t, Class<T> değerTürü) {
		haritaOluştur(değerTürü).put(tanımlayıcı, t);
		return true;
	}
	
	public <T> boolean bağla(String kimlik, T t, Class<T> değerTürü) {
		Tanımlayıcı tanımlayıcı = tanımlayıcıOluştur(kimlik);
		if (tanımlayıcı == null)
			return false;
		return bağla(tanımlayıcı, t, değerTürü);
	}
	
	public <T> boolean yenidenBağla(String kimlik, T t, Class<T> değerTürü) {
		Tanımlayıcı tanımlayıcı = tanımlayıcıAl(kimlik);
		if (tanımlayıcı == null)
			return false;
		if (!sal(tanımlayıcı))
			return false;
		return bağla(tanımlayıcı, t, değerTürü);
	}
	
	public boolean sal(Tanımlayıcı tanımlayıcı) {
		for (Class<?> girdiTürü : haritalar.keySet())
			if (haritalar.get(girdiTürü).remove(tanımlayıcı) != null)
				return true;
		return false;
	}
	
	public boolean sal(String kimlik) {
		Tanımlayıcı tanımlayıcı = tanımlayıcıAl(kimlik);
		if (tanımlayıcı != null)
			return sal(tanımlayıcı);
		return false;
	}
	
	public <T> T ara(String kimlik, Class<T> değerTürü) {
		Tanımlayıcı tanımlayıcı = tanımlayıcıAl(kimlik);
		if (tanımlayıcı == null)
			return null;
		Map<Tanımlayıcı, T> harita = haritaAl(değerTürü);
		if (harita == null)
			return null;
		return harita.get(tanımlayıcı);
	}
}
