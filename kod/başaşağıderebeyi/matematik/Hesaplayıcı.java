/**
 * başaşağıderebeyi.matematik.Hesaplayıcı.java
 * 0.24 / 6 Kas 2020 / 11:15:43
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Hesaplayıcı {
	public static float küçüktür(float sol, float sağ) {
		return sol < sağ ? sol : sağ;
	}
	
	public static float büyüktür(float sol, float sağ) {
		return sol > sağ ? sol : sağ;
	}
	
	public static float sıkıştır(float o, float alt, float üst) {
		return küçüktür(büyüktür(0, alt), üst);
	}
	
	public static float yuvarla(float o) {
		return (float)Math.round(o);
	}
	
	public static float tavan(float o) {
		return (float)Math.ceil(o);
	}
	
	public static float taban(float o) {
		return (float)Math.floor(o);
	}
	
	public static float araDeğer(float sol, float sağ, float solaUzaklık, float sağaUzaklık) {
		return sol * sağaUzaklık + sağ * solaUzaklık;
	}
	
	public static int araDeğer(int sol, int sağ, float solaUzaklık, float sağaUzaklık) {
		return (int)yuvarla(araDeğer(sol, sağ, solaUzaklık, sağaUzaklık));
	}
	
	public static <T> T araDeğer(T sol, T sağ, float solaUzaklık, float sağaUzaklık) {
		if (solaUzaklık < sağaUzaklık)
			return sol;
		else
			return sağ;
	}
	
	public static float karesi(float o) {
		return o * o;
	}
	
	public static float kökü(float o) {
		return (float)Math.sqrt(o);
	}
	
	private Hesaplayıcı() {
	}
}
