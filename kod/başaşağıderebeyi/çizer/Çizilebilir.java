/**
 * başaşağıderebeyi.çizer.Çizilebilir.java
 * 0.22 / 4 Kas 2020 / 19:33:09
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.çizer;

import başaşağıderebeyi.varlık.*;

public class Çizilebilir extends Bileşen {
	public final Çizim güncel;
	public final Çizim anlık;
	public final Çizim önceki;
	public final Çizim öbürkü;

	public Çizilebilir(Varlık varlık, Çizim güncel, Çizim anlık, Çizim önceki, Çizim öbürkü) {
		super(varlık);
		this.güncel = güncel;
		this.anlık = anlık;
		this.önceki = önceki;
		this.öbürkü = öbürkü;
	}
}
