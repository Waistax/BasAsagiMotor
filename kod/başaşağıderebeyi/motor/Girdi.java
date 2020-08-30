/**
 * başaşağıderebeyi.motor.Girdi.java
 * 0.4 / 29 Ağu 2020 / 00:26:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.motor;

import başaşağıderebeyi.matematik.*;

public class Girdi {
	public final int tuşlar;
	public final int düğmeler;
	public final boolean[] tuşAşağı;
	public final boolean[] tuşBasıldı;
	public final boolean[] tuşGirdisi;
	public final boolean[] düğmeAşağı;
	public final boolean[] düğmeBasıldı;
	public final boolean[] düğmeGirdisi;
	public final Vektör2t imleç;
	public final Vektör2t imleçDeğişimi;
	public final Vektör2t imleçGirdisi;
	
	public int kaydırma;
	public int kaydırmaGirdisi;

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

	public void kare() {
		for (int i = 0; i < tuşlar; i++) {
			tuşBasıldı[i] = !tuşAşağı[i] && tuşGirdisi[i];
			tuşAşağı[i] = tuşGirdisi[i];
		}
		for (int i = 0; i < düğmeler; i++) {
			düğmeBasıldı[i] = !düğmeAşağı[i] && düğmeGirdisi[i];
			düğmeAşağı[i] = düğmeGirdisi[i];
		}
		kaydırma = kaydırmaGirdisi;
		kaydırmaGirdisi = 0;
		imleçDeğişimi.çıkar(imleçGirdisi, imleç);
		imleç.yaz(imleçGirdisi);
	}
}
