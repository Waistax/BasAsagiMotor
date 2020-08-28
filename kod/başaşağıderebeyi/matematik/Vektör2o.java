/**
 * başaşağıderebeyi.matematik.Vektör2o.java
 * 0.3 / 29 Ağu 2020 / 00:12:11
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

/** İki tane ondalıklı sayı bileşeni olan vektör */
public class Vektör2o {
	/** Yatay bileşen */
	public float x;
	/** Dikey bileşen */
	public float y;

	/** İki sayıyla tanımlar */
	public Vektör2o(float x, float y) {
		yaz(x, y);
	}

	/** Kopyalar */
	public Vektör2o(Vektör2o v) {
		yaz(v);
	}

	/** Sıfır tanımlar */
	public Vektör2o() {
	}

	/** Bileşenlere yazar */
	public Vektör2o yaz(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	/** Bileşenlere yazar */
	public Vektör2o yaz(Vektör2o v) {
		return yaz(v.x, v.y);
	}

	/** Bileşenler eşit mi diye kontrol eder */
	public boolean eşittir(float x, float y) {
		return this.x == x && this.y == y;
	}

	/** Bileşenler eşit mi diye kontrol eder */
	public boolean eşittir(Vektör2o v) {
		return eşittir(v.x, v.y);
	}

	/** Vektörleri topla ve buna yaz */
	public Vektör2o topla(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x + sağ.x, sol.y + sağ.y);
	}

	/** Vektörleri çıkar ve buna yaz */
	public Vektör2o çıkar(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x - sağ.x, sol.y - sağ.y);
	}

	/** Vektörü skalerle çarp ve buna yaz */
	public Vektör2o çarp(Vektör2o sol, float sağ) {
		return yaz(sol.x * sağ, sol.y * sağ);
	}

	/** Vektörü skalerle böl ve buna yaz */
	public Vektör2o böl(Vektör2o sol, float sağ) {
		return yaz(sol.x / sağ, sol.y / sağ);
	}

	/** Vektörlerin küçük olan bileşenlerini yaz */
	public Vektör2o küçüktür(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x < sağ.x ? sol.x : sağ.x, sol.y < sağ.y ? sol.y : sağ.y);
	}

	/** Vektörlerin büyük olan bileşenlerini yaz */
	public Vektör2o büyüktür(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x > sağ.x ? sol.x : sağ.x, sol.y > sağ.y ? sol.y : sağ.y);
	}

	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2o)obj);
	}

	@Override
	public String toString() {
		// (x, y)
		return "(" + x + ", " + y + ")";
	}
}
