/**
 * başaşağıderebeyi.kumhavuzu.KutuHareket.java
 * 0.22 / 5 Kas 2020 / 15:29:26
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.varlık.*;

public class KutuHareket extends Aile {
	public KutuHareket(Topluluk topluluk) {
		super(topluluk, KutuBileşeni.class);
	}
	
	@Override
	public void güncelle() {
		for (Varlık varlık : varlıklar) {
			Kutu kutu = (Kutu)varlık.bileşen(KutuBileşeni.class).güncel;
			kutu.d.k.x += 5F;
			kutu.d.k.y += 5F;
			kutu.d.b.x += 5F;
			kutu.d.b.y += 5F;
//			kutu.renk.x = (kutu.renk.x + 0.1F) % 1.0F;
		}
	}
}
