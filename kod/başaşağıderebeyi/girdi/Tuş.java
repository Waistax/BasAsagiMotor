/**
 * başaşağıderebeyi.girdi.Tuş.java
 * 0.20 / 1 Kas 2020 / 16:42:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.girdi;

public class Tuş {
	public final int kod;
	
	public boolean aşağı;
	public boolean basma;
	public boolean salma;
	public boolean girdi;
	public Object hedef;
	
	public Tuş(int kod) {
		this.kod = kod;
	}
	
	public void güncelle() {
		basma = !aşağı && girdi;
		salma = aşağı && !girdi;
		aşağı = girdi;
		boşta();
	}
	
	public boolean boştaMı() {
		return hedef == null;
	}
	
	public boolean uygunMu(Object hedef) {
		return boştaMı() || this.hedef == hedef;
	}
	
	public void kullanıldı(Object hedef) {
		this.hedef = hedef;
	}
	
	public void boşta() {
		kullanıldı(null);
	}
}
