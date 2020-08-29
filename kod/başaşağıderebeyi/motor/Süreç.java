/**
 * başaşağıderebeyi.motor.SüreHesaplayıcı.java
 * 0.7 / 29 Ağu 2020 / 19:23:14
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

/** Her kare gerçekleşen süreçlerin ortalama süreçlerini hesaplar */
public class Süreç {
	/** Son hesaplamadan beri yapılan işlemlerin toplam süresi */
	private float süre;
	/** Son başlangıç zamanı */
	private float başlangıç;
	/** Son hesaplamadan beri yapılan işlem sayısı */
	private int sayaç;
	/** Son hesaplanan ortalama süre */
	private float ortalama;

	/** Sürecin başlangıcını işaretle */
	public void başla() {
		// İşlemin başladığı zamanı kaydet
		başlangıç = Motor.zaman();
	}

	/** Sürecin sonunu işaretle */
	public void dur() {
		// Geçen süreyi hesapla ve toplama ekle
		süre += Motor.zaman() - başlangıç;
		// Sayacı bir arttır
		sayaç++;
	}

	/** Yapılan işlemlerin ortalama süresini hesapla */
	public void hesapla() {
		// Toplam zamanı milisaniyeye çevir ve işlem sayısına böl
		ortalama = süre / 1000000.0F / sayaç;
		// Süreyi ve sayacı sıfırla
		süre = 0.0F;
		sayaç = 0;
	}

	/** Son hesaplanan ortalamayı dönder */
	public float ortalamayıAl() {
		return ortalama;
	}
}
