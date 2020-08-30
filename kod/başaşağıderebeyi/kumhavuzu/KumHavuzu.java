/**
 * başaşağıderebeyi.kumhavuzu.KumHavuzu.java
 * 0.6 / 29 Ağu 2020 / 13:17:03
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.awtkütüphanesi.*;
import başaşağıderebeyi.kütük.*;
import başaşağıderebeyi.motor.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KumHavuzu implements Uygulama {
	public static final KumHavuzu KUM_HAVUZU = new KumHavuzu();
	
	public static void main(String[] args) {
		Motor.görselleştirici = KUM_HAVUZU.görselleştirici;
		Motor.uygulama = KUM_HAVUZU;
		Motor.başla();
	}
	
	private AWTGörselleştirici görselleştirici;
	private AWTGirdi girdi;
	private Graphics2D çizer;
	private int sayaç;
	private int xkon;
	private Süreç yazmaSüreci;
	private Kütük kütük;
	
	public KumHavuzu() {
		görselleştirici = new AWTGörselleştirici();
	}
	
	@Override
	public void yükle() {
		girdi = görselleştirici.girdi;
		çizer = görselleştirici.çizer;
		sayaç = 0;
		xkon = 10;
		yazmaSüreci = new Süreç();
		kütük = new Kütük();
		çizer.setFont(new Font("Verdena", Font.ITALIC, 20));
		çizer.setColor(new Color(1.0F, 1.0F, 0.6F, 1.0F));
		kütük.bağla("kh:0", 10, Object.class);
		kütük.bağla("kh:1", "Selam", Object.class);
		kütük.bağla("kh:2", 'C', Object.class);
		kütük.bağla("kh:3", 45.7, Object.class);
		kütük.bağla("kh:4", 42);
		kütük.sal("kh:2");
		Map<Tanımlayıcı, Object> nesneKütüğü = kütük.haritaAl(Object.class);
		Map<Tanımlayıcı, Integer> sayıKütüğü = kütük.haritaAl(Integer.class);
		for (Tanımlayıcı tanımlayıcı : nesneKütüğü.keySet())
			System.out.println("Nesne " + tanımlayıcı + " " + nesneKütüğü.get(tanımlayıcı));
		kütük.yenidenBağla("kh:3", 46);
		for (Tanımlayıcı tanımlayıcı : sayıKütüğü.keySet())
			System.out.println("Sayı " + tanımlayıcı + " " + sayıKütüğü.get(tanımlayıcı));
	}
	
	@Override
	public void kaydet() {
	}
	
	@Override
	public void kare() {
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (girdi.tuşBasıldı[KeyEvent.VK_F])
			sayaç++;
		xkon += girdi.kaydırma * 10;
		yazmaSüreci.başla();
		çizer.drawString("SBK: " + Motor.kareOranı, xkon, 30);
		çizer.drawString("İmleç: " + girdi.imleç + " Değişim: " + girdi.imleçDeğişimi, xkon, 50);
		çizer.drawString("F tuşu " + sayaç + " kere basıldı.", xkon, 70);
		if (girdi.tuşAşağı[KeyEvent.VK_SPACE])
			çizer.drawString("BOŞLUK TUŞU AŞAĞIDA!", xkon, 90);
		yazmaSüreci.dur();
	}
	
	@Override
	public void saniye() {
		yazmaSüreci.hesapla();
		System.out.println("Yazma: " + yazmaSüreci.ortalamayıAl() + "ms");
	}
}
