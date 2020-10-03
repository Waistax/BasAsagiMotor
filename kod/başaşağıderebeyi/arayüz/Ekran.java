/**
 * başaşağıderebeyi.arayüz.Ekran.java
 * 0.16 / 14 Eyl 2020 / 13:29:10
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.arayüz.hiza.*;
import başaşağıderebeyi.motor.*;

public class Ekran extends Levha {
	public final float genişlik;
	public final float yükseklik;
	public final int solDüğme;
	
	public Ekran(float genişlik, float yükseklik, int solDüğme) {
		super(null);
		hizalama
		.kx(new SerbestHiza())
		.ky(new SerbestHiza())
		.g(new SerbestHiza().yaz(genişlik))
		.y(new SerbestHiza().yaz(yükseklik));
		hizala();
		this.genişlik = genişlik;
		this.yükseklik = yükseklik;
		this.solDüğme = solDüğme;
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
	public boolean açıkMı() {
		return açık;
	}
	
	@Override
	public void odağaGir() {
		odaklı = true;
	}
	
	@Override
	public void odağıAl() {
		odaktanÇık();
		odağaGir();
	}
	
	@Override
	public boolean tıklandığında(int düğme) {
		odağıAl();
		return false;
	}
	
	@Override
	public boolean girdi(Girdi girdi) {
		üzerinde = true;
		for (int i = 0; i < girdi.düğmeler; i++)
			if (girdi.düğmeBasıldı[i])
				tıklandığında(i);
		for (int i = içerik.size() - 1; i > -1; i--)
			if (içerik.get(i).girdi(girdi)) {
				for (int j = 0; j < içerik.size(); j++)
					if (i != j)
						içerik.get(j).üzerindeDeğil();
				return true;
			}
		odaklı = false;
		return false;
	}
	
	public Pencere pencereAç(String başlık, float genişlik, float yükseklik) {
		return new Pencere(this, başlık, genişlik, yükseklik, solDüğme);
	}
	
	public void odakla(Pencere pencere) {
		içerik.remove(pencere);
		içerik.add(pencere);
		odaktanÇık();
		pencere.odağaGir();
	}
	
	@Override
	public String toString() {
		return "Ekran";
	}
}
