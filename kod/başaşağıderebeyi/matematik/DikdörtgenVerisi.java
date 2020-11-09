/**
 * başaşağıderebeyi.matematik.DikdörtgenVerisi.java
 * 0.24 / 7 Kas 2020 / 11:15:24
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public enum DikdörtgenVerisi {
	KÜÇÜK,
	BÜYÜK,
	ORTA,
	ÖLÇÜ;
	
	public static final DikdörtgenVerisi[] DEĞERLER = values();
	
	public final int sıra;

	private DikdörtgenVerisi() {
		this.sıra = ordinal();
	}
}
