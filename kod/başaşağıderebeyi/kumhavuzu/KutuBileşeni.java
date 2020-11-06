/**
 * başaşağıderebeyi.kumhavuzu.KutuBileşeni.java
 * 0.22 / 5 Kas 2020 / 13:18:16
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.varlık.*;
import başaşağıderebeyi.çizer.*;

public class KutuBileşeni extends Çizilebilir {
	public KutuBileşeni(Varlık varlık) {
		super(varlık, new Kutu(), new Kutu(), new Kutu(), new Kutu());
	}
	
	@Override
	public String toString() {
		return "Güncel: " + güncel.toString() + " Anlık: " + anlık.toString();
	}
}
