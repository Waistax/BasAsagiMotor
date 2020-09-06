/**
 * başaşağıderebeyi.matematik.Vektör2o.java
 * 0.3 / 29 Ağu 2020 / 00:12:11
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Vektör2o {
	public float x;
	public float y;
	
	public Vektör2o() {
	}
	
	public Vektör2o(float x, float y) {
		yaz(x, y);
	}
	
	public Vektör2o(Vektör2o v) {
		yaz(v);
	}
	
	public Vektör2o(Vektör2t v) {
		yaz(v);
	}
	
	public Vektör2o yaz(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vektör2o yaz(Vektör2o v) {
		return yaz(v.x, v.y);
	}
	
	public Vektör2o yaz(Vektör2t v) {
		return yaz(v.x, v.y);
	}
	
	public Vektör2o topla(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x + sağ.x, sol.y + sağ.y);
	}
	
	public Vektör2o topla(Vektör2o v) {
		return topla(this, v);
	}
	
	public Vektör2o çıkar(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x - sağ.x, sol.y - sağ.y);
	}
	
	public Vektör2o çıkar(Vektör2o v) {
		return çıkar(this, v);
	}
	
	public Vektör2o çarp(Vektör2o sol, float sağ) {
		return yaz(sol.x * sağ, sol.y * sağ);
	}
	
	public Vektör2o çarp(float o) {
		return çarp(this, o);
	}
	
	public Vektör2o böl(Vektör2o sol, float sağ) {
		return yaz(sol.x / sağ, sol.y / sağ);
	}
	
	public Vektör2o böl(float o) {
		return böl(this, o);
	}
	
	public Vektör2o küçüktür(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x < sağ.x ? sol.x : sağ.x, sol.y < sağ.y ? sol.y : sağ.y);
	}
	
	public Vektör2o küçüktür(Vektör2o v) {
		return küçüktür(this, v);
	}
	
	public Vektör2o büyüktür(Vektör2o sol, Vektör2o sağ) {
		return yaz(sol.x > sağ.x ? sol.x : sağ.x, sol.y > sağ.y ? sol.y : sağ.y);
	}
	
	public Vektör2o büyüktür(Vektör2o v) {
		return büyüktür(this, v);
	}
	
	public Vektör2o sıkıştır(Vektör2o v, Vektör2o alt, Vektör2o üst) {
		return küçüktür(büyüktür(v, alt), üst);
	}
	
	public Vektör2o sıkıştır(Vektör2o alt, Vektör2o üst) {
		return sıkıştır(this, alt, üst);
	}
	
	public float nokta(Vektör2o v) {
		return x * v.x + y * v.y;
	}
	
	public float uzunluğunKaresi() {
		return nokta(this);
	}
	
	public float uzunluk() {
		return (float)Math.sqrt(uzunluğunKaresi());
	}
	
	public Vektör2o birim(Vektör2o v) {
		return böl(v, v.uzunluk());
	}
	
	public Vektör2o birim() {
		return böl(uzunluk());
	}
	
	public boolean eşittir(float x, float y) {
		return this.x == x && this.y == y;
	}
	
	public boolean eşittir(Vektör2o v) {
		return eşittir(v.x, v.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2o)obj);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
