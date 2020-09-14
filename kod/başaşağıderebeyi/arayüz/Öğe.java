/**
 * başaşağıderebeyi.arayüz.Öğe.java
 * 0.16 / 13 Eyl 2020 / 17:43:42
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;
import başaşağıderebeyi.motor.*;

public class Öğe {
	public final Levha levha;
	public final Hizalama hizalama;
	
	public boolean açık;
	public boolean üzerinde;
	public boolean odaklı;
	
	public Öğe(Levha levha) {
		this.levha = levha;
		hizalama = new Hizalama();
		açık = true;
		ekle();
	}
	
	public void ekle() {
		levha.içerik.add(this);
	}
	
	public void hizala() {
		hizalama.hesapla(levha.hizalama.alan);
	}
	
	public boolean açıkMı() {
		return levha.açıkMı() && açık;
	}
	
	public void odağaGir() {
		odaklı = true;
		levha.odağaGir();
	}
	
	public void odaktanÇık() {
		odaklı = false;
	}
	
	public void odağıAl() {
		levha.odaktanÇık();
		odağaGir();
	}
	
	public boolean tıklandığında(int düğme) {
		odağıAl();
		return true;
	}
	
	public void üzerindeDeğil() {
		üzerinde = false;
	}
	
	public boolean girdi(Girdi girdi) {
		if (hizalama.alan.içinde(girdi.imleç)) {
			üzerinde = true;
			for (int i = 0; i < girdi.düğmeler; i++)
				if (girdi.düğmeBasıldı[i])
					if (tıklandığında(i))
						return true;
		} else {
			üzerindeDeğil();
		}
		return false;
	}
}
