/**
 * başaşağıderebeyi.arayüz.öğe.Öğe.java
 * 0.16 / 13 Eyl 2020 / 17:43:42
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.öğe;

import başaşağıderebeyi.girdi.*;
import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.matematik.hiza.*;

public class Öğe {
	public final Levha levha;
	public final Pencere pencere;
	public final Ekran ekran;
	public final Dikdörtgen alan;
	public final HizalıDikdörtgen hizalıDikdörtgen;
	public final Vektör4 renk;
	
	public boolean açık;
	public boolean üzerinde;
	public boolean imleçte;
	
	public Öğe(Levha levha, Pencere pencere, Ekran ekran) {
		this.levha = levha;
		this.pencere = pencere;
		this.ekran = ekran;
		alan = new Dikdörtgen();
		hizalıDikdörtgen = new HizalıDikdörtgen(levha != null ? levha.alan : null, alan);
		renk = new Vektör4();
		açık = true;
		ekle();
	}
	
	public Öğe(Levha levha) {
		this(levha, levha.pencere, levha.ekran);
	}

	public void ekle() {
		levha.içerik.add(this);
	}
	
	public void hizala() {
		hizalıDikdörtgen.hizala();
	}
	
	public void odakla() {
		levha.odakla();
	}
	
	public boolean açıkMı() {
		return levha.açıkMı() && açık;
	}
	
	public void üzerindeyiHesapla() {
		üzerinde = levha.üzerinde && alan.içinde(Girdi.İMLEÇ);
	}
	
	public void imleciHesapla() {
		if (imleçte = üzerinde && Girdi.imleçUygunMu(this))
			Girdi.imleçKullanıldı(this);
	}
	
	public void güncelle() {
	}
}
