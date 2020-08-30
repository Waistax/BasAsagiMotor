/**
 * başaşağıderebeyi.kütük.Tanımlayıcı.java
 * 0.8 / 29 Ağu 2020 / 23:06:45
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kütük;

public class Tanımlayıcı {
	public final Kapsam kapsam;
	public final String ad;
	public final String metinHali;
	public final int kodu;
	
	public Tanımlayıcı(Kapsam kapsam, String ad) {
		this.kapsam = kapsam;
		this.ad = ad;
		metinHali = kapsam + ":" + ad;
		kodu = metinHali.hashCode();
	}
	
	@Override
	public String toString() {
		return metinHali;
	}
	
	@Override
	public int hashCode() {
		return kodu;
	}
}
