/**
 * başaşağıderebeyi.arayüz.öğe.Levha.java
 * 0.16 / 14 Eyl 2020 / 16:51:55
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.öğe;

import java.util.*;

public class Levha extends Öğe {
	public final List<Öğe> içerik;
	
	public Levha(Levha levha, Pencere pencere, Ekran ekran) {
		super(levha, pencere, ekran);
		içerik = new ArrayList<>();
	}
	
	@Override
	public void hizala() {
		super.hizala();
		for (Öğe öğe : içerik)
			öğe.hizala();
	}
	
	@Override
	public void üzerindeyiHesapla() {
		super.üzerindeyiHesapla();
		for (Öğe öğe : içerik)
			öğe.üzerindeyiHesapla();
	}
	
	@Override
	public void imleciHesapla() {
		for (int i = içerik.size() - 1; i > -1; i--) {
			Öğe öğe = içerik.get(i);
			öğe.imleciHesapla();
		}
		super.imleciHesapla();
	}
	
	@Override
	public void güncelle() {
		for (int i = içerik.size() - 1; i > -1; i--) {
			Öğe öğe = içerik.get(i);
			öğe.güncelle();
		}
	}

	@Override
	public String toString() {
		return "Levha: " + içerik;
	}
}
