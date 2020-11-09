/**
 * başaşağıderebeyi.çizer.Çizer.java
 * 0.22 / 4 Kas 2020 / 19:51:27
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.çizer;

import başaşağıderebeyi.motor.*;
import başaşağıderebeyi.varlık.*;

public abstract class Çizer extends Aile {
	public boolean güncelleme;
	public float öbürküneUzaklık;
	public float öncekineUzaklık;
	
	public Çizer(Topluluk topluluk) {
		super(topluluk, Çizilebilir.class);
	}
	
	@Override
	public void güncelle() {
		güncelleme = true;
		paralelYürüt();
	}
	
	@Override
	public void çiz() {
		güncelleme = false;
		öbürküneUzaklık = Motor.işlenmemişTıklar;
		öncekineUzaklık = 1.0F - öbürküneUzaklık;
		paralelYürüt();
		for (Varlık varlık : varlıklar)
			çiz(varlık.bileşen(Çizilebilir.class).anlık);
	}
	
	@Override
	public void yürüt(Varlık varlık) {
		Çizilebilir çizilebilir = varlık.bileşen(Çizilebilir.class);
		if (güncelleme) {
			çizilebilir.öbürkü.yaz(çizilebilir.önceki);
			çizilebilir.önceki.yaz(çizilebilir.güncel);
		} else
			çizilebilir.anlık
			.araDeğer(çizilebilir.önceki, çizilebilir.öbürkü, öncekineUzaklık, öbürküneUzaklık)
			.hazırla();
	}
	
	public abstract void çiz(Çizim çizim);
}
