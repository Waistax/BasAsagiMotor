/**
 * başaşağıderebeyi.varlık.AileYürütücü.java
 * 0.23 / 6 Kas 2020 / 09:37:37
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.varlık;

import java.util.*;

public class AileYürütücü implements Runnable {
	public final Aile aile;
	public final Set<Varlık> varlıklar;
	
	public boolean bitti;
	
	public AileYürütücü(Aile aile) {
		this.aile = aile;
		this.varlıklar = new HashSet<>();
	}
	
	@Override
	public void run() {
		bitti = false;
		for (Varlık varlık : varlıklar)
			aile.yürüt(varlık);
		bitti = true;
	}
}
