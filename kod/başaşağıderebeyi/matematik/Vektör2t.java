/**
 * başaşağıderebeyi.matematik.Vektör2t.java
 * 0.3 / 29 Ağu 2020 / 00:09:14
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

/** İki tane tam sayı bileşeni olan vektör */
public class Vektör2t {
	/** Yatay bileşen */
	public int x;
	/** Dikey bileşen */
	public int y;

	/** İki sayıyla tanımlar */
	public Vektör2t(int x, int y) {
		yaz(x, y);
	}

	/** Kopyalar */
	public Vektör2t(Vektör2t v) {
		yaz(v);
	}

	/** Sıfır tanımlar */
	public Vektör2t() {
	}

	/** Bileşenlere yazar */
	public Vektör2t yaz(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	/** Bileşenlere yazar */
	public Vektör2t yaz(Vektör2t v) {
		return yaz(v.x, v.y);
	}

	/** Bileşenler eşit mi diye kontrol eder */
	public boolean eşittir(int x, int y) {
		return this.x == x && this.y == y;
	}

	/** Bileşenler eşit mi diye kontrol eder */
	public boolean eşittir(Vektör2t v) {
		return eşittir(v.x, v.y);
	}

	/** Vektörleri topla ve buna yaz */
	public Vektör2t topla(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x + sağ.x, sol.y + sağ.y);
	}

	/** Vektörleri çıkar ve buna yaz */
	public Vektör2t çıkar(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x - sağ.x, sol.y - sağ.y);
	}

	/** Vektörü skalerle çarp ve buna yaz */
	public Vektör2t çarp(Vektör2t sol, int sağ) {
		return yaz(sol.x * sağ, sol.y * sağ);
	}

	/** Vektörü skalerle böl ve buna yaz */
	public Vektör2t böl(Vektör2t sol, int sağ) {
		return yaz(sol.x / sağ, sol.y / sağ);
	}

	/** Vektörlerin küçük olan bileşenlerini yaz */
	public Vektör2t küçüktür(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x < sağ.x ? sol.x : sağ.x, sol.y < sağ.y ? sol.y : sağ.y);
	}

	/** Vektörlerin büyük olan bileşenlerini yaz */
	public Vektör2t büyüktür(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x > sağ.x ? sol.x : sağ.x, sol.y > sağ.y ? sol.y : sağ.y);
	}

	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2t)obj);
	}

	@Override
	public String toString() {
		// (x, y)
		return "(" + x + ", " + y + ")";
	}
}
