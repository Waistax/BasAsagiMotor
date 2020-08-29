/**
 * başaşağıderebeyi.motor.Görselleştirici.java
 * 0.4 / 29 Ağu 2020 / 00:29:34
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

/** Bir çizim kütüphanesini motora sağlayan arayüz */
public interface Görselleştirici {
	/** Pencereyi ve girdiyi oluştur
	 * Uygulama yüklenmeden önce çağırılır. */
	void oluştur();
	
	/** Pencereyi ve girdiyi yok et
	 * Uygulama kaydettikten sonra çağırılır. */
	void yokEt();
	
	/** Çizilen veriyi görselleştir
	 * Uygulama karesi çizildikten sonra çağırılır. */
	void göster();
	
	/** Kütüphanenin girdisini dönder
	 * Bu girdideki tuş ve düğme sayısı pencere kütüphanesine bağlı olur. */
	Girdi girdiyiAl();
}
