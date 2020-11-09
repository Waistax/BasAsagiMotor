/**
 * başaşağıderebeyi.matematik.Vektör2.java
 * 0.13 / 8 Eyl 2020 / 09:16:17
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Vektör2 {
	public float x;
	public float y;
	
	public Vektör2() {
	}
	
	public Vektör2(float x, float y) {
		yaz(
				x,
				y);
	}
	
	public Vektör2(Vektör2 v) {
		yaz(v);
	}
	
	public Vektör2 yazX(float x) {
		this.x = x;
		return this;
	}
	
	public Vektör2 yazY(float y) {
		this.y = y;
		return this;
	}
	
	public Vektör2 yaz(float x, float y) {
		return
				yazX(x).
				yazY(y);
	}
	
	public Vektör2 yaz(Vektör2 v) {
		return yaz(
				v.x,
				v.y);
	}
	
	public Vektör2 topla(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				sol.x + sağ.x,
				sol.y + sağ.y);
	}
	
	public Vektör2 topla(Vektör2 v) {
		return topla(this, v);
	}
	
	public Vektör2 çıkar(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				sol.x - sağ.x,
				sol.y - sağ.y);
	}
	
	public Vektör2 çıkar(Vektör2 v) {
		return çıkar(this, v);
	}
	
	public Vektör2 çarp(Vektör2 sol, float sağ) {
		return yaz(
				sol.x * sağ,
				sol.y * sağ);
	}
	
	public Vektör2 çarp(float o) {
		return çarp(this, o);
	}
	
	public Vektör2 böl(Vektör2 sol, float sağ) {
		return yaz(
				sol.x / sağ,
				sol.y / sağ);
	}
	
	public Vektör2 böl(float o) {
		return böl(this, o);
	}
	
	public Vektör2 küçüktür(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				Hesaplayıcı.küçüktür(sol.x, sağ.x),
				Hesaplayıcı.küçüktür(sol.y, sağ.y));
	}
	
	public Vektör2 küçüktür(Vektör2 v) {
		return küçüktür(this, v);
	}
	
	public Vektör2 büyüktür(Vektör2 sol, Vektör2 sağ) {
		return yaz(
				Hesaplayıcı.büyüktür(sol.x, sağ.x),
				Hesaplayıcı.büyüktür(sol.y, sağ.y));
	}
	
	public Vektör2 büyüktür(Vektör2 v) {
		return büyüktür(this, v);
	}
	
	public Vektör2 sıkıştır(Vektör2 v, Vektör2 alt, Vektör2 üst) {
		return yaz(
				Hesaplayıcı.sıkıştır(v.x, alt.x, üst.x),
				Hesaplayıcı.sıkıştır(v.y, alt.y, üst.y));
	}
	
	public Vektör2 sıkıştır(Vektör2 alt, Vektör2 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	public Vektör2 yuvarla(Vektör2 v) {
		return yaz(
				Hesaplayıcı.yuvarla(v.x),
				Hesaplayıcı.yuvarla(v.y));
	}
	
	public Vektör2 yuvarla() {
		return yuvarla(this);
	}
	
	public Vektör2 tavan(Vektör2 v) {
		return yaz(
				Hesaplayıcı.tavan(v.x),
				Hesaplayıcı.tavan(v.x));
	}
	
	public Vektör2 tavan() {
		return tavan(this);
	}
	
	public Vektör2 taban(Vektör2 v) {
		return yaz(
				Hesaplayıcı.taban(v.x),
				Hesaplayıcı.taban(v.x));
	}
	
	public Vektör2 taban() {
		return taban(this);
	}
	
	public Vektör2 araDeğer(Vektör2 sol, Vektör2 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(
				Hesaplayıcı.araDeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.araDeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık));
	}
	
	public Vektör2 araDeğer(Vektör2 v, float uzaklık, float yakınlık) {
		return araDeğer(this, v, uzaklık, yakınlık);
	}
	
	public float nokta(Vektör2 v) {
		return
				x * v.x +
				y * v.y;
	}
	
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	public float uzunluk() {
		return Hesaplayıcı.kökü(uzunluğunKaresi());
	}
	
	public Vektör2 birim(Vektör2 v) {
		return böl(v, v.uzunluk());
	}
	
	public Vektör2 birim() {
		return böl(uzunluk());
	}
	
	public boolean eşittir(float x, float y) {
		return
				this.x == x &&
				this.y == y;
	}
	
	public boolean eşittir(Vektör2 v) {
		return eşittir(
				v.x,
				v.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2)obj);
	}
	
	@Override
	public String toString() {
		return "(" +
				x + ", " +
				y + ")";
	}
}
