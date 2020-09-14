/**
 * başaşağıderebeyi.arayüz.Levha.java
 * 0.16 / 14 Eyl 2020 / 16:51:55
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.motor.*;

import java.util.*;

public class Levha extends Öğe {
	public final List<Öğe> içerik;
	
	public Levha(Levha levha) {
		super(levha);
		içerik = new ArrayList<>();
	}
	
	@Override
	public void hizala() {
		super.hizala();
		for (Öğe öğe : içerik)
			öğe.hizala();
	}

	@Override
	public void odaktanÇık() {
		super.odaktanÇık();
		for (Öğe öğe : içerik)
			öğe.odaktanÇık();
	}
	
	@Override
	public void üzerindeDeğil() {
		super.üzerindeDeğil();
		for (Öğe öğe : içerik)
			öğe.üzerindeDeğil();
	}
	
	@Override
	public boolean girdi(Girdi girdi) {
		boolean sonuç = super.girdi(girdi);
		for (int i = içerik.size() - 1; i > -1; i--)
			if (içerik.get(i).girdi(girdi)) {
				for (int j = 0; j < içerik.size(); j++)
					if (i != j)
						içerik.get(j).üzerindeDeğil();
				return true;
			}
		return sonuç;
	}
	
	@Override
	public String toString() {
		return "Levha: " + içerik;
	}
}
