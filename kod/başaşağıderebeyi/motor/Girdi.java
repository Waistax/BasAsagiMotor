/**
 * başaşağıderebeyi.motor.Girdi.java
 * 0.4 / 29 Ağu 2020 / 00:26:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

import başaşağıderebeyi.matematik.*;

/** Motorun girdisini saklar ve karelere böler */
public class Girdi {
	/** Klavye tuşu sayısı */
	public final int tuşlar;
	/** Fare düğmesi sayısı */
	public final int düğmeler;
	/** Tuşların bu karede aşağı basılı olup olmadığını saklar */
	public final boolean[] tuşAşağı;
	/** Tuşların bu karede ilk defa basılıp basılmadığını saklar */
	public final boolean[] tuşBasıldı;
	/** Tuşların işlenmemiş girdi verisini saklar */
	public final boolean[] tuşGirdisi;
	/** Düğmelerin bu karede aşağı basılı olup olmadığını saklar */
	public final boolean[] düğmeAşağı;
	/** Düğmelerin bu karede ilk defa basılıp basılmadığını saklar */
	public final boolean[] düğmeBasıldı;
	/** Düğmelerin işlenmemiş girdi verisini saklar */
	public final boolean[] düğmeGirdisi;
	/** İmlecin bu karedeki konumu */
	public final Vektör2t imleç;
	/** İmlecin konumunun bu karedeki değişimi */
	public final Vektör2t imleçDeğişimi;
	/** İmlecin konumunun işlenmemiş girdi verisi */
	public final Vektör2t imleçGirdisi;
	/** Bu karede yapılmış toplam fare tekerleği ya da dokunmatik kaydırma */
	public int kaydırma;
	/** Kaydırmanın işlenmemiş girdi verisi */
	public int kaydırmaGirdisi;

	/** Tuş ve düğme sayısıyla tanımlar */
	public Girdi(int tuşlar, int düğmeler) {
		this.tuşlar = tuşlar;
		this.düğmeler = düğmeler;
		tuşAşağı = new boolean[tuşlar];
		tuşBasıldı = new boolean[tuşlar];
		tuşGirdisi = new boolean[tuşlar];
		düğmeAşağı = new boolean[düğmeler];
		düğmeBasıldı = new boolean[düğmeler];
		düğmeGirdisi = new boolean[düğmeler];
		imleç = new Vektör2t();
		imleçDeğişimi = new Vektör2t();
		imleçGirdisi = new Vektör2t();
	}

	/** Bu karedeki girdi verisini işler */
	public void kare() {
		// Bütün tuş girdilerini güncelle
		for (int i = 0; i < tuşlar; i++) {
			// Eğer önceki kare tuş aşağı değilse ama
			// bu kare aşağıdaysa basıldı diye işaretle
			tuşBasıldı[i] = !tuşAşağı[i] && tuşGirdisi[i];
			tuşAşağı[i] = tuşGirdisi[i];
		}
		// Bütün düğme girdilerini güncelle
		for (int i = 0; i < düğmeler; i++) {
			// Eğer önceki kare düğme aşağı değilse ama
			// bu kare aşağıdaysa basıldı diye işaretle
			düğmeBasıldı[i] = !düğmeAşağı[i] && düğmeGirdisi[i];
			düğmeAşağı[i] = düğmeGirdisi[i];
		}
		// Önceki karede toplam kaydırma girdisini yaz
		kaydırma = kaydırmaGirdisi;
		// Toplamı sıfırla
		kaydırmaGirdisi = 0;
		// İmleç konumundaki değişimi hesapla
		imleçDeğişimi.çıkar(imleçGirdisi, imleç);
		// İmleç konumunu güncelle
		imleç.yaz(imleçGirdisi);
	}
}
