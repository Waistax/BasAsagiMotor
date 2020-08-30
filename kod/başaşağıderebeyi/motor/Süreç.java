/**
 * başaşağıderebeyi.motor.SüreHesaplayıcı.java
 * 0.7 / 29 Ağu 2020 / 19:23:14
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

public class Süreç {
	private float süre;
	private float başlangıç;
	private int sayaç;
	private float ortalama;

	public void başla() {
		başlangıç = Motor.zaman();
	}

	public void dur() {
		süre += Motor.zaman() - başlangıç;
		sayaç++;
	}

	public void hesapla() {
		ortalama = süre / 1000000.0F / sayaç;
		süre = 0.0F;
		sayaç = 0;
	}

	public float ortalamayıAl() {
		return ortalama;
	}
}
