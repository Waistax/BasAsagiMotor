/**
 * başaşağıderebeyi.kumhavuzu.KutuHareket.java
 * 0.22 / 5 Kas 2020 / 15:29:26
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.arayüz.kutu.*;
import başaşağıderebeyi.varlık.*;

public class KutuHareket extends Aile {
	public int sayaç;
	
	public KutuHareket(Topluluk topluluk) {
		super(topluluk, KutuBileşeni.class);
	}
	
	@Override
	public void güncelle() {
		if (++sayaç >= 20) {
			sayaç = -20;
		}
		paralelYürüt();
	}
	
	@Override
	public void yürüt(Varlık varlık) {
		Kutu kutu = (Kutu)varlık.bileşen(KutuBileşeni.class).güncel;
		kutu.alan.k.x = ((float)Math.cos(sayaç / 10.0 * kutu.renk.x) + kutu.renk.z) * 100;
		kutu.alan.k.y = ((float)Math.cos(sayaç / 10.0 * kutu.renk.y) + kutu.renk.z) * 100;
		kutu.alan.b.x = kutu.alan.k.x * 4;
		kutu.alan.b.y = kutu.alan.k.y * 4;
	}
}
