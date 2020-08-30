/**
 * başaşağıderebeyi.matematik.Dikdörtgen2t.java
 * 0.9 / 30 Ağu 2020 / 13:25:08
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.matematik;

public class Dikdörtgen2t {
	public final Vektör2t k;
	public final Vektör2t b;
	
	public Dikdörtgen2t() {
		k = new Vektör2t();
		b = new Vektör2t();
	}
	
	public Dikdörtgen2t(int kx, int ky, int bx, int by) {
		this();
		yaz(kx, ky, bx, by);
	}
	
	public Dikdörtgen2t(Vektör2t k, Vektör2t b) {
		this();
		yaz(k, b);
	}
	
	public Dikdörtgen2t(Dikdörtgen2t d) {
		this();
		yaz(d);
	}
	
	public Dikdörtgen2t yaz(int kx, int ky, int bx, int by) {
		k.yaz(kx, ky);
		b.yaz(bx, by);
		return this;
	}
	
	public Dikdörtgen2t yaz(Vektör2t k, Vektör2t b) {
		return yaz(k.x, k.y, b.x, b.y);
	}
	
	public Dikdörtgen2t yaz(Dikdörtgen2t d) {
		return yaz(d.k, d.b);
	}
	
	public boolean eşittir(int kx, int ky, int bx, int by) {
		return k.eşittir(kx, ky) && b.eşittir(bx, by);
	}
	
	public boolean eşittir(Vektör2t k, Vektör2t b) {
		return eşittir(k.x, k.y, b.x, b.y);
	}
	
	public boolean eşittir(Dikdörtgen2t d) {
		return eşittir(d.k, d.b);
	}
	
	@Override
	public boolean equals(Object obj) {
		return eşittir((Dikdörtgen2t)obj);
	}
	
	@Override
	public String toString() {
		return "[" + k + ", " + b + "]";
	}
}
