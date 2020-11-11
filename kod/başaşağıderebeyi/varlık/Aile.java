/**
 * başaşağıderebeyi.varlık.Aile.java
 * 0.22 / 4 Kas 2020 / 19:00:40
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.varlık;

import başaşağıderebeyi.motor.*;

import java.util.*;

public abstract class Aile {
	public final Topluluk topluluk;
	public final Set<Varlık> varlıklar;
	public final Class<? extends Bileşen>[] gerekliSınıflar;
	public final Set<AileYürütücü> yürütücüler;
	
	@SuppressWarnings("unchecked")
	public Aile(Topluluk topluluk, Class<?>... gerekliSınıflar) {
		this.topluluk = topluluk;
		varlıklar = new HashSet<>();
		this.gerekliSınıflar = (Class<? extends Bileşen>[])gerekliSınıflar;
		yürütücüler = new HashSet<>(Motor.yürütücüİşlemSayısı);
		for (int i = 0; i < Motor.yürütücüİşlemSayısı; i++)
			yürütücüler.add(new AileYürütücü(this));
		topluluk.aileler.add(this);
		for (Varlık varlık : topluluk.varlıklar)
			ekle(varlık);
	}
	
	public boolean karşılıyorMu(Varlık varlık) {
		for (Class<? extends Bileşen> sınıf : gerekliSınıflar)
			if (varlık.bileşen(sınıf) == null)
				return false;
		return true;
	}
	
	public void ekle(Varlık varlık) {
		if (karşılıyorMu(varlık) && varlıklar.add(varlık))
			eklendi(varlık);
	}

	public void eklendi(Varlık varlık) {
		int elemanSayısı = varlıklar.size() / Motor.yürütücüİşlemSayısı;
		for (AileYürütücü yürütücü : yürütücüler)
			if (yürütücü.varlıklar.size() <= elemanSayısı) {
				yürütücü.varlıklar.add(varlık);
				return;
			}
	}
	
	public void çıkar(Varlık varlık) {
		if (varlıklar.remove(varlık))
			çıkarıldı(varlık);
	}
	
	public void çıkarıldı(Varlık varlık) {
		for (AileYürütücü yürütücü : yürütücüler)
			if (yürütücü.varlıklar.remove(varlık))
				return;
	}
	
	public void paralelYürüt() {
//		int elemanSayısı = varlıklar.size() / Motor.yürütücüİşlemSayısı;
//		int fazladanElemanlar = varlıklar.size() % Motor.yürütücüİşlemSayısı;
//		Iterator<AileYürütücü> yürütücüDöngüsü = yürütücüler.iterator();
//		Iterator<Varlık> varlıkDöngüsü = varlıklar.iterator();
//		while (yürütücüDöngüsü.hasNext()) {
//			AileYürütücü yürütücü = yürütücüDöngüsü.next();
//			yürütücü.temizle();
//			while (varlıkDöngüsü.hasNext()) {
//				yürütücü.varlıklar.add(varlıkDöngüsü.next());
//				int doluluk = yürütücü.varlıklar.size() - elemanSayısı;
//				if (doluluk == 0 && fazladanElemanlar > 0)
//					fazladanElemanlar--;
//				else if (doluluk >= 0)
//					break;
//			}
//			Motor.yürütücü.execute(yürütücü);
//		}
		for (AileYürütücü yürütücü : yürütücüler)
			Motor.yürütücü.execute(yürütücü);
		boolean bitmemişYürütücüVar;
		do {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			bitmemişYürütücüVar = false;
			for (AileYürütücü yürütücü : yürütücüler)
				if (!yürütücü.bitti) {
					bitmemişYürütücüVar = true;
					break;
				}
		} while (bitmemişYürütücüVar);
	}
	
	public void güncelle() {
	}
	
	public void çiz() {
	}
	
	public void yürüt(Varlık varlık) {
	}
}
