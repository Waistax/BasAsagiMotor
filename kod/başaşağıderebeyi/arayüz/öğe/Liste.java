/**
 * başaşağıderebeyi.arayüz.öğe.Liste.java
 * 0.19 / 20 Eyl 2020 / 16:02:04
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.arayüz.öğe;

import java.util.*;

public class Liste extends Öğe {
	public final List<String> yazılar;
	
	public Liste(Levha levha) {
		super(levha);
		yazılar = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Liste: " + yazılar;
	}
}
