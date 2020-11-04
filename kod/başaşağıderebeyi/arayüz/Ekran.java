/**
 * başaşağıderebeyi.arayüz.Ekran.java
 * 0.16 / 14 Eyl 2020 / 13:29:10
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;

public class Ekran extends Levha {
	public final float genişlik;
	public final float yükseklik;
	public final Tuş tık;
	
	public Ekran(float genişlik, float yükseklik, Tuş tık) {
		super(null, null, null);
		hizalama
		.kx(new SerbestHiza())
		.ky(new SerbestHiza())
		.g(new SerbestHiza().yaz(genişlik))
		.y(new SerbestHiza().yaz(yükseklik));
		hizala();
		this.genişlik = genişlik;
		this.yükseklik = yükseklik;
		this.tık = tık;
	}
	
	@Override
	public void ekle() {
	}
	
	@Override
	public void hizala() {
		hizalama.hesapla(null);
		for (Öğe öğe : içerik)
			öğe.hizala();
	}
	
	@Override
	public void odakla() {
	}
	
	@Override
	public boolean açıkMı() {
		return açık;
	}
	
	@Override
	public void üzerindeyiHesapla() {
		üzerinde = true;
		for (Öğe öğe : içerik)
			öğe.üzerindeyiHesapla();
	}
	
	@Override
	public void güncelle() {
		üzerindeyiHesapla();
		if (!tık.aşağı)
			Girdi.imleçBoşta();
		Girdi.tekerlekBoşta();
		imleciHesapla();
		super.güncelle();
	}
	
	public Pencere pencereAç(String başlık, float genişlik, float yükseklik) {
		return new Pencere(this, başlık, genişlik, yükseklik);
	}
	
	public void odakla(Pencere pencere) {
		içerik.remove(pencere);
		içerik.add(pencere);
	}
	
	@Override
	public String toString() {
		return "Ekran";
	}
}
