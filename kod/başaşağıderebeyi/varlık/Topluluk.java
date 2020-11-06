/**
 * başaşağıderebeyi.varlık.Topluluk.java
 * 0.22 / 4 Kas 2020 / 18:47:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.varlık;

import java.util.*;

public class Topluluk {
	public final Set<Varlık> varlıklar;
	public final Set<Aile> aileler;
	
	public Topluluk() {
		varlıklar = new HashSet<>();
		aileler = new HashSet<>();
	}

	public void güncelle() {
		for (Aile aile : aileler)
			aile.güncelle();
	}
	
	public void çiz() {
		for (Aile aile : aileler)
			aile.çiz();
	}
	
	public void çıkar(Varlık varlık) {
		if (varlıklar.remove(varlık))
			for (Aile aile : aileler)
				aile.çıkar(varlık);
	}
}
