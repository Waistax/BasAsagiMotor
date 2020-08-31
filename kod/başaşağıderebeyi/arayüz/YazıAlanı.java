/**
 * başaşağıderebeyi.arayüz.YazıAlanı.java
 * 0.11 / 30 Ağu 2020 / 17:31:32
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz;

import başaşağıderebeyi.motor.*;

public class YazıAlanı {
	public final StringBuilder alan;
	
	public int yazımKonumu;
	public float sonYazımZamanı;
	public boolean üzerineYaz;

	public int girişTuşu = -1;
	public int geriAlmaTuşu = -1;
	public int silmeTuşu = -1;
	public int solOkTuşu = -1;
	public int sağOkTuşu = -1;
	public int yerleştirTuşu = -1;
	
	public YazıAlanı() {
		alan = new StringBuilder();
	}
	
	public YazıAlanı(int girişTuşu, int geriAlmaTuşu, int silmeTuşu, int solOkTuşu, int sağOkTuşu, int yerleştirTuşu) {
		this();
		this.girişTuşu = girişTuşu;
		this.geriAlmaTuşu = geriAlmaTuşu;
		this.silmeTuşu = silmeTuşu;
		this.solOkTuşu = solOkTuşu;
		this.sağOkTuşu = sağOkTuşu;
		this.yerleştirTuşu = yerleştirTuşu;
	}

	public void giriş() {
		alan.insert(yazımKonumu, System.lineSeparator());
		yazımKonumu += System.lineSeparator().length();
	}
	
	public boolean uygunSes(char ses) {
		return Character.isAlphabetic(ses) || Character.isDigit(ses)
				|| ses == ':'
				|| ses == '_'
				|| ses == '-'
				|| ses == '+'
				|| ses == '₺'
				|| ses == '"'
				|| ses == '\''
				|| ses == ','
				|| ses == '.'
				|| ses == '('
				|| ses == ')'
				|| ses == ' ';
	}
	
	public synchronized void yaz(int tuş, char ses) {
		if (tuş == girişTuşu) {
			giriş();
		} else if (tuş == geriAlmaTuşu) {
			if (yazımKonumu > 0)
				alan.deleteCharAt(--yazımKonumu);
		} else if (tuş == silmeTuşu) {
			if (yazımKonumu < alan.length())
				alan.deleteCharAt(yazımKonumu);
		} else if (tuş == solOkTuşu) {
			if (yazımKonumu > 0)
				yazımKonumu--;
		} else if (tuş == sağOkTuşu) {
			if (yazımKonumu < alan.length())
				yazımKonumu++;
		} else if (tuş == yerleştirTuşu) {
			üzerineYaz = !üzerineYaz;
		} else if (uygunSes(ses)) {
			if (üzerineYaz && yazımKonumu < alan.length())
				alan.deleteCharAt(yazımKonumu);
			alan.insert(yazımKonumu++, ses);
		}
		yazımZamanınıGüncelle();
	}
	
	public void yazımZamanınıGüncelle() {
		sonYazımZamanı = Motor.zaman();
	}
	
	public boolean imleçÇizilmeliMi() {
		float şuan = Motor.zaman();
		return (şuan - sonYazımZamanı) / 1000000000.0F < 0.5F || (int)Math.floor(şuan / 1000000000.0F * 3.0F) % 2 == 0;
	}
	
	public void temizle() {
		alan.setLength(0);
		yazımKonumu = 0;
	}
}
