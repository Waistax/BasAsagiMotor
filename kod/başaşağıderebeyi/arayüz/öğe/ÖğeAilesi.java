/**
 * başaşağıderebeyi.arayüz.öğe.ÖğeAilesi.java
 * 0.27 / 9 Kas 2020 / 09:39:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.öğe;

import başaşağıderebeyi.arayüz.kutu.*;
import başaşağıderebeyi.motor.*;
import başaşağıderebeyi.varlık.*;

import java.awt.*;

public class ÖğeAilesi extends Aile {
	public final Ekran ekran;
	public final KutuÇizer kutuÇizer;
	
	public boolean güncelleme;
	public float öbürküneUzaklık;
	public float öncekineUzaklık;
	
	public ÖğeAilesi(Topluluk topluluk, Ekran ekran, KutuÇizer kutuÇizer) {
		super(topluluk, ÖğeBileşeni.class, KutuBileşeni.class);
		this.ekran = ekran;
		this.kutuÇizer = kutuÇizer;
	}

	@Override
	public void güncelle() {
		güncelleme = true;
		if (ekran != null)
			ekran.güncelle();
		paralelYürüt();
	}
	
	@Override
	public void çiz() {
		güncelleme = false;
		öbürküneUzaklık = Motor.işlenmemişTıklar;
		öncekineUzaklık = 1.0F - öbürküneUzaklık;
		paralelYürüt();
		for (Varlık varlık : varlıklar) {
			KutuBileşeni kutuBileşeni = varlık.bileşen(KutuBileşeni.class);
			Kutu kutu = (Kutu)kutuBileşeni.anlık;
			kutuÇizer.çiz(kutu);
		}
	}
	
	@Override
	public void yürüt(Varlık varlık) {
		KutuBileşeni kutuBileşeni = varlık.bileşen(KutuBileşeni.class);
		if (güncelleme) {
			Kutu önceki = (Kutu)kutuBileşeni.önceki;
			Kutu öbürkü = (Kutu)kutuBileşeni.öbürkü;
			öbürkü.yaz(önceki);
			Öğe öğe = varlık.bileşen(ÖğeBileşeni.class).öğe;
			önceki.alan.yaz(öğe.alan);
			önceki.renk.yaz(öğe.renk);
		} else {
			Kutu kutu = (Kutu)kutuBileşeni.anlık;
			kutu
			.araDeğer(kutuBileşeni.önceki, kutuBileşeni.öbürkü, öncekineUzaklık, öbürküneUzaklık)
			.hazırla();
		}
	}
}
