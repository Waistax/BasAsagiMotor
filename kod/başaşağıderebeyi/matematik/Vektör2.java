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
		yaz(x, y);
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
		return yazX(x).yazY(y);
	}
	
	public Vektör2 yaz(Vektör2 v) {
		return yaz(v.x, v.y);
	}
	
	public Vektör2 topla(Vektör2 sol, Vektör2 sağ) {
		return yaz(sol.x + sağ.x, sol.y + sağ.y);
	}
	
	public Vektör2 topla(Vektör2 v) {
		return topla(this, v);
	}
	
	public Vektör2 çıkar(Vektör2 sol, Vektör2 sağ) {
		return yaz(sol.x - sağ.x, sol.y - sağ.y);
	}
	
	public Vektör2 çıkar(Vektör2 v) {
		return çıkar(this, v);
	}
	
	public Vektör2 çarp(Vektör2 sol, float sağ) {
		return yaz(sol.x * sağ, sol.y * sağ);
	}
	
	public Vektör2 çarp(float o) {
		return çarp(this, o);
	}
	
	public Vektör2 böl(Vektör2 sol, float sağ) {
		return yaz(sol.x / sağ, sol.y / sağ);
	}
	
	public Vektör2 böl(float o) {
		return böl(this, o);
	}
	
	public Vektör2 küçüktür(Vektör2 sol, Vektör2 sağ) {
		return yaz(sol.x < sağ.x ? sol.x : sağ.x, sol.y < sağ.y ? sol.y : sağ.y);
	}
	
	public Vektör2 küçüktür(Vektör2 v) {
		return küçüktür(this, v);
	}
	
	public Vektör2 büyüktür(Vektör2 sol, Vektör2 sağ) {
		return yaz(sol.x > sağ.x ? sol.x : sağ.x, sol.y > sağ.y ? sol.y : sağ.y);
	}
	
	public Vektör2 büyüktür(Vektör2 v) {
		return büyüktür(this, v);
	}
	
	public Vektör2 sıkıştır(Vektör2 v, Vektör2 alt, Vektör2 üst) {
		return küçüktür(büyüktür(v, alt), üst);
	}
	
	public Vektör2 sıkıştır(Vektör2 alt, Vektör2 üst) {
		return sıkıştır(this, alt, üst);
	}
	
	public Vektör2 yuvarla(Vektör2 v) {
		return yaz((float)Math.round(v.x), (float)Math.round(v.y));
	}
	
	public Vektör2 yuvarla() {
		return yuvarla(this);
	}
	
	public Vektör2 tavan(Vektör2 v) {
		return yaz((float)Math.ceil(v.x), (float)Math.ceil(v.y));
	}
	
	public Vektör2 tavan() {
		return tavan(this);
	}
	
	public Vektör2 taban(Vektör2 v) {
		return yaz((float)Math.floor(v.x), (float)Math.floor(v.y));
	}
	
	public Vektör2 taban() {
		return taban(this);
	}
	
	public Vektör2 araDeğer(Vektör2 sol, Vektör2 sağ, float solaUzaklık, float sağaUzaklık) {
		return yaz(sol.x * sağaUzaklık + sağ.x * solaUzaklık, sol.y * sağaUzaklık + sağ.y * solaUzaklık);
	}
	
	public Vektör2 araDeğer(Vektör2 v, float uzaklık, float yakınlık) {
		return araDeğer(this, v, uzaklık, yakınlık);
	}
	
	public float nokta(Vektör2 v) {
		return x * v.x + y * v.y;
	}
	
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	public float uzunluk() {
		return (float)Math.sqrt(uzunluğunKaresi());
	}
	
	public Vektör2 birim(Vektör2 v) {
		return böl(v, v.uzunluk());
	}
	
	public Vektör2 birim() {
		return böl(uzunluk());
	}
	
	public boolean eşittir(float x, float y) {
		return this.x == x && this.y == y;
	}
	
	public boolean eşittir(Vektör2 v) {
		return eşittir(v.x, v.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2)obj);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
