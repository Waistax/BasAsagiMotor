/**
 * başaşağıderebeyi.kumhavuzu.Kutu.java
 * 0.22 / 4 Kas 2020 / 21:00:36
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.çizer.*;

public class Kutu extends Çizim {
	public final Dikdörtgen2 d;
	public final Vektör4 renk;

	public Kutu(Dikdörtgen2 d, Vektör4 renk) {
		this.d = d;
		this.renk = renk;
	}

	public Kutu() {
		this(new Dikdörtgen2(), new Vektör4());
	}

	@Override
	public Çizim yaz(Çizim ç) {
		Kutu k = (Kutu)ç;
		d.yaz(k.d);
		renk.yaz(k.renk);
		return this;
	}

	@Override
	public Çizim araDeğer(Çizim sol, Çizim sağ, float solaUzaklık, float sağaUzaklık) {
		Kutu kSol = (Kutu)sol;
		Kutu kSağ = (Kutu)sağ;
		d.araDeğer(kSol.d, kSağ.d, solaUzaklık, sağaUzaklık);
		renk.araDeğer(kSol.renk, kSağ.renk, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	@Override
	public String toString() {
		return d.toString() + ", " + renk.toString();
	}
}
