/**
 * başaşağıderebeyi.çizer.Çizer.java
 * 0.22 / 4 Kas 2020 / 19:51:27
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.çizer;

import başaşağıderebeyi.motor.*;
import başaşağıderebeyi.varlık.*;

public abstract class Çizer extends Aile {
	public Çizer(Topluluk topluluk) {
		super(topluluk, Çizilebilir.class);
	}
	
	@Override
	public void güncelle() {
		for (Varlık varlık : varlıklar) {
			Çizilebilir çizilebilir = varlık.bileşen(Çizilebilir.class);
			çizilebilir.öbürkü.yaz(çizilebilir.önceki);
			çizilebilir.önceki.yaz(çizilebilir.güncel);
		}
	}
	
	@Override
	public void çiz() {
		float öbürküneUzaklık = Motor.işlenmemişTıklar;
		float öncekineUzaklık = 1.0F - öbürküneUzaklık;
		for (Varlık varlık : varlıklar) {
			Çizilebilir çizilebilir = varlık.bileşen(Çizilebilir.class);
			çiz(çizilebilir.anlık.araDeğer(çizilebilir.önceki, çizilebilir.öbürkü, öncekineUzaklık, öbürküneUzaklık));
		}
	}
	
	public abstract void çiz(Çizim çizim);
}
