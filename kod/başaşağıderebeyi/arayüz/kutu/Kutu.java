/**
 * başaşağıderebeyi.arayüz.kutu.Kutu.java
 * 0.22 / 4 Kas 2020 / 21:00:36
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.kutu;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.çizer.*;

public class Kutu extends Çizim {
	public final Dikdörtgen alan;
	public final Vektör4 renk;

	public Kutu(Dikdörtgen alan, Vektör4 renk) {
		this.alan = alan;
		this.renk = renk;
	}

	public Kutu() {
		this(new Dikdörtgen(), new Vektör4());
	}

	@Override
	public Çizim yaz(Çizim ç) {
		Kutu k = (Kutu)ç;
		alan.yaz(k.alan);
		renk.yaz(k.renk);
		return this;
	}

	@Override
	public Çizim araDeğer(Çizim sol, Çizim sağ, float solaUzaklık, float sağaUzaklık) {
		Kutu kSol = (Kutu)sol;
		Kutu kSağ = (Kutu)sağ;
		alan.araDeğer(kSol.alan, kSağ.alan, solaUzaklık, sağaUzaklık);
		renk.araDeğer(kSol.renk, kSağ.renk, solaUzaklık, sağaUzaklık);
		return this;
	}
	
	@Override
	public Çizim hazırla() {
		alan.yuvarla();
		return this;
	}
	
	@Override
	public String toString() {
		return alan.toString() + ", " + renk.toString();
	}
}
