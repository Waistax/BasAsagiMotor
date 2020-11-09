/**
 * başaşağıderebeyi.matematik.Vektör4.java
 * 0.22 / 4 Kas 2020 / 21:30:15
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Vektör4 {
	public float x;
	public float y;
	public float z;
	public float w;
	
	public Vektör4() {
	}
	
	public Vektör4(float x, float y, float z, float w) {
		yaz(
				x,
				y,
				z,
				w);
	}
	
	public Vektör4(Vektör4 v) {
		yaz(v);
	}
	
	public Vektör4 yazX(float x) {
		this.x = x;
		return this;
	}
	
	public Vektör4 yazY(float y) {
		this.y = y;
		return this;
	}
	
	public Vektör4 yazZ(float z) {
		this.z = z;
		return this;
	}
	
	public Vektör4 yazW(float w) {
		this.w = w;
		return this;
	}
	
	public Vektör4 yaz(float x, float y, float z, float w) {
		return
				yazX(x).
				yazY(y).
				yazZ(z).
				yazW(w);
	}
	
	public Vektör4 yaz(Vektör4 v) {
		return yaz(
				v.x,
				v.y,
				v.z,
				v.w);
	}
	
	public Vektör4 topla(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				sol.x + sağ.x,
				sol.y + sağ.y,
				sol.z + sağ.z,
				sol.w + sağ.w);
	}
	
	public Vektör4 topla(Vektör4 v) {
		return topla(this, v);
	}
	
	public Vektör4 çıkar(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				sol.x - sağ.x,
				sol.y - sağ.y,
				sol.z - sağ.z,
				sol.w - sağ.w);
	}
	
	public Vektör4 çıkar(Vektör4 v) {
		return çıkar(this, v);
	}
	
	public Vektör4 çarp(Vektör4 sol, float sağ) {
		return yaz(
				sol.x * sağ,
				sol.y * sağ,
				sol.z * sağ,
				sol.w * sağ);
	}
	
	public Vektör4 çarp(float o) {
		return çarp(this, o);
	}
	
	public Vektör4 böl(Vektör4 sol, float sağ) {
		return yaz(
				sol.x / sağ,
				sol.y / sağ,
				sol.z / sağ,
				sol.w / sağ);
	}
	
	public Vektör4 böl(float o) {
		return böl(this, o);
	}
	
	public Vektör4 küçüktür(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				Hesaplayıcı.küçüktür(sol.x, sağ.x),
				Hesaplayıcı.küçüktür(sol.y, sağ.y),
				Hesaplayıcı.küçüktür(sol.z, sağ.z),
				Hesaplayıcı.küçüktür(sol.w, sağ.w));
	}
	
	public Vektör4 küçüktür(Vektör4 v) {
		return küçüktür(this, v);
	}
	
	public Vektör4 büyüktür(Vektör4 sol, Vektör4 sağ) {
		return yaz(
				Hesaplayıcı.büyüktür(sol.x, sağ.x),
				Hesaplayıcı.büyüktür(sol.y, sağ.y),
				Hesaplayıcı.büyüktür(sol.z, sağ.z),
				Hesaplayıcı.büyüktür(sol.w, sağ.w));
	}
	
	public Vektör4 büyüktür(Vektör4 v) {
		return büyüktür(this, v);
	}
	
	public Vektör4 sıkıştır(Vektör4 v, Vektör4 alt, Vektör4 üst) {
		return yaz(
				Hesaplayıcı.sıkıştır(v.x, alt.x, üst.x),
				Hesaplayıcı.sıkıştır(v.y, alt.y, üst.y),
				Hesaplayıcı.sıkıştır(v.z, alt.z, üst.z),
				Hesaplayıcı.sıkıştır(v.w, alt.w, üst.w));
	}
	
	public Vektör4 sıkıştır(Vektör4 alt, Vektör4 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	public Vektör4 yuvarla(Vektör4 v) {
		return yaz(
				Hesaplayıcı.yuvarla(v.x),
				Hesaplayıcı.yuvarla(v.y),
				Hesaplayıcı.yuvarla(v.z),
				Hesaplayıcı.yuvarla(v.w));
	}
	
	public Vektör4 yuvarla() {
		return yuvarla(this);
	}
	
	public Vektör4 tavan(Vektör4 v) {
		return yaz(
				Hesaplayıcı.tavan(v.x),
				Hesaplayıcı.tavan(v.y),
				Hesaplayıcı.tavan(v.z),
				Hesaplayıcı.tavan(v.w));
	}
	
	public Vektör4 tavan() {
		return tavan(this);
	}
	
	public Vektör4 taban(Vektör4 v) {
		return yaz(
				Hesaplayıcı.taban(v.x),
				Hesaplayıcı.taban(v.y),
				Hesaplayıcı.taban(v.z),
				Hesaplayıcı.taban(v.w));
	}
	
	public Vektör4 taban() {
		return taban(this);
	}
	
	public Vektör4 araDeğer(Vektör4 sol, Vektör4 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(
				Hesaplayıcı.araDeğer(sol.x, sağ.x, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.araDeğer(sol.y, sağ.y, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.araDeğer(sol.z, sağ.z, solaUzaklık, sağaUzaklık),
				Hesaplayıcı.araDeğer(sol.w, sağ.w, solaUzaklık, sağaUzaklık));
	}
	
	public Vektör4 araDeğer(Vektör4 v, float uzaklık, float yakınlık) {
		return araDeğer(this, v, uzaklık, yakınlık);
	}
	
	public float nokta(Vektör4 v) {
		return
				x * v.x +
				y * v.y +
				z * v.z +
				w * v.w;
	}
	
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	public float uzunluk() {
		return Hesaplayıcı.kökü(uzunluğunKaresi());
	}
	
	public Vektör4 birim(Vektör4 v) {
		return böl(v, v.uzunluk());
	}
	
	public Vektör4 birim() {
		return böl(uzunluk());
	}
	
	public boolean eşittir(float x, float y, float z, float w) {
		return
				this.x == x &&
				this.y == y &&
				this.z == z &&
				this.w == w;
	}
	
	public boolean eşittir(Vektör4 v) {
		return eşittir(
				v.x,
				v.y,
				v.z,
				v.w);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör4)obj);
	}
	
	@Override
	public String toString() {
		return "(" +
				x + ", " +
				y + ", " +
				z + ", " +
				w + ")";
	}
}
