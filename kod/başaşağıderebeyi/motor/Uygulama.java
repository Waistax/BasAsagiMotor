/**
 * başaşağıderebeyi.motor.Uygulama.java
 * 0.2 / 28 Ağu 2020 / 23:57:20
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

/** Uygulamaları motora sağlayan arayüz */
public interface Uygulama {
	/** Uygulamayı yükler */
	void yükle();

	/** Uygulamayı kaydeder */
	void kaydet();

	/** Uygulamayı günceller ve çizer */
	void kare();
}
