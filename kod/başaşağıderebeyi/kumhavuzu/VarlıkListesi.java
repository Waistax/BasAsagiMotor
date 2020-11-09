/**
 * başaşağıderebeyi.kumhavuzu.VarlıkListesi.java
 * 0.22 / 5 Kas 2020 / 14:04:57
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.arayüz.öğe.*;
import başaşağıderebeyi.varlık.*;

public class VarlıkListesi extends Aile {
	public final Liste liste;
	
	public VarlıkListesi(Topluluk topluluk, Liste liste) {
		super(topluluk);
		this.liste = liste;
	}
	
	@Override
	public void güncelle() {
		liste.yazılar.clear();
		for (Varlık varlık : varlıklar) {
			liste.yazılar.add(varlık.toString());
			for (Class<? extends Bileşen> sınıf : varlık.bileşenler.keySet())
				liste.yazılar.add("- " + sınıf.getSimpleName() + ": " + varlık.bileşen(sınıf).toString());
		}
	}
}
