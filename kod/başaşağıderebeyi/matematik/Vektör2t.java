/**
 * başaşağıderebeyi.matematik.Vektör2t.java
 * 0.3 / 29 Ağu 2020 / 00:09:14
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Vektör2t {
	public int x;
	public int y;
	
	public Vektör2t() {
	}
	
	public Vektör2t(int x, int y) {
		yaz(x, y);
	}
	
	public Vektör2t(Vektör2t v) {
		yaz(v);
	}
	
	public Vektör2t(Vektör2o v) {
		yaz(v);
	}
	
	public Vektör2t yaz(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vektör2t yaz(Vektör2t v) {
		return yaz(v.x, v.y);
	}
	
	public Vektör2t yaz(Vektör2o v) {
		return yuvarla(v);
	}
	
	public Vektör2t topla(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x + sağ.x, sol.y + sağ.y);
	}
	
	public Vektör2t topla(Vektör2t v) {
		return topla(this, v);
	}
	
	public Vektör2t çıkar(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x - sağ.x, sol.y - sağ.y);
	}
	
	public Vektör2t çıkar(Vektör2t v) {
		return çıkar(this, v);
	}
	
	public Vektör2t çarp(Vektör2t sol, int sağ) {
		return yaz(sol.x * sağ, sol.y * sağ);
	}
	
	public Vektör2t çarp(int t) {
		return çarp(this, t);
	}
	
	public Vektör2t böl(Vektör2t sol, int sağ) {
		return yaz(sol.x / sağ, sol.y / sağ);
	}
	
	public Vektör2t böl(int t) {
		return böl(this, t);
	}
	
	public Vektör2t küçüktür(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x < sağ.x ? sol.x : sağ.x, sol.y < sağ.y ? sol.y : sağ.y);
	}
	
	public Vektör2t küçüktür(Vektör2t v) {
		return küçüktür(this, v);
	}
	
	public Vektör2t büyüktür(Vektör2t sol, Vektör2t sağ) {
		return yaz(sol.x > sağ.x ? sol.x : sağ.x, sol.y > sağ.y ? sol.y : sağ.y);
	}
	
	public Vektör2t büyüktür(Vektör2t v) {
		return büyüktür(this, v);
	}
	
	public Vektör2t sıkıştır(Vektör2t v, Vektör2t alt, Vektör2t üst) {
		return küçüktür(büyüktür(v, alt), üst);
	}
	
	public Vektör2t sıkıştır(Vektör2t alt, Vektör2t üst) {
		return sıkıştır(this, alt, üst);
	}
	
	public Vektör2t yuvarla(Vektör2o v) {
		return yaz(Math.round(v.x), Math.round(v.y));
	}
	
	public Vektör2t tavan(Vektör2o v) {
		return yaz((int)Math.ceil(v.x), (int)Math.ceil(v.y));
	}
	
	public Vektör2t taban(Vektör2o v) {
		return yaz((int)Math.floor(v.x), (int)Math.floor(v.y));
	}
	
	public boolean eşittir(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	public boolean eşittir(Vektör2t v) {
		return eşittir(v.x, v.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Vektör2t)obj);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
