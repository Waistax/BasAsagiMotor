/**
 * başaşağıderebeyi.kumhavuzu.KumHavuzu.java
 * 0.6 / 29 Ağu 2020 / 13:17:03
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.arayüz.*;
import başaşağıderebeyi.arayüz.hiza.*;
import başaşağıderebeyi.awtkütüphanesi.*;
import başaşağıderebeyi.matematik.*;
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
	private int xkon;
	private Ekran ekran;
	private Pencere pencere;
	private KayanLevha kayanLevha;
	
	public KumHavuzu() {
		görselleştirici = new AWTGörselleştirici();
		float boyut = 80;
		görselleştirici.boyut.yaz(16 * boyut, 9 * boyut);
		görselleştirici.tamEkran = false;
	}
	
	@Override
	public void yükle() {
		Girdi.fareTuşuOluştur(MouseEvent.BUTTON1);
		Girdi.tuşOluştur(KeyEvent.VK_ESCAPE);
		xkon = 10;
		ekran = new Ekran(görselleştirici.boyut.x, görselleştirici.boyut.y, Girdi.fareTuşuAl(MouseEvent.BUTTON1));
		pencere = ekran.pencereAç("Deneme", 500.0F, 500.0F);
		Random rastgele = new Random();
		for (int i = 0; i < rastgele.nextInt(20) + 1; i++) {
			ekran.pencereAç("Rastgele " + (i + 1), (rastgele.nextInt(6) + 2) * 100, (rastgele.nextInt(6) + 2) * 100);
		}
		kayanLevha = new KayanLevha(pencere, 1000.0F, 1000.0F);
		kayanLevha.levha.hizalama
		.kx(new SabitHiza(10.0F))
		.bx(new OrtaHiza())
		.ky(new SabitHiza(10.0F + Pencere.ÇUBUK_YÜKSEKLİĞİ))
		.by(new TersSabitHiza(110.0F));
		Düğme düğme = new Düğme(kayanLevha, "Bas Bana", () -> System.out.println("Bastın"));
		düğme.hizalama
		.kx(new SabitHiza(150.0F))
		.bx(new OrtaHiza())
		.ky(new SabitHiza(400.0F + Pencere.ÇUBUK_YÜKSEKLİĞİ))
		.by(new SabitBoyutHiza(90.0F));
		görselleştirici.çizer.setFont(new Font("Consolas", Font.PLAIN, 17));
		ekran.hizala();
	}
	
	@Override
	public void kaydet() {
	}
	
	@Override
	public void kare() {
//		try {
//			Thread.sleep(5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		ekran.güncelle();
		öğeÇiz(ekran);
		if (Girdi.tuşAl(KeyEvent.VK_ESCAPE).basma)
			Motor.dur();
		görselleştirici.çizer.setColor(Color.white);
		görselleştirici.çizer.drawString("SBK: " + Motor.kareOranı, xkon, 30);
		görselleştirici.çizer.drawString("Uyg: " + Motor.UYGULAMA_SÜRECİ.ortalamayıAl(), xkon, 50);
		görselleştirici.çizer.drawString("Gir: " + Motor.GİRDİ_SÜRECİ.ortalamayıAl(), xkon, 70);
		görselleştirici.çizer.drawString("Gös: " + Motor.GÖSTERME_SÜRECİ.ortalamayıAl(), xkon, 90);
		görselleştirici.çizer.drawString("İml: " + Girdi.imleçHedefi, xkon, 110);
		görselleştirici.çizer.drawString("Tek: " + Girdi.tekerlekHedefi, xkon, 130);
	}
	
	@Override
	public void saniye() {
	}
	
	private void kutuÇiz(Dikdörtgen2 d, Color renk, boolean kalın) {
		görselleştirici.çizer.setColor(renk);
		görselleştirici.çizer.setStroke(new BasicStroke(kalın ? 2.0F : 0.5F));
		görselleştirici.çizer.fillRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		görselleştirici.çizer.setColor(Color.black);
		görselleştirici.çizer.drawRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
	}
	
	private void öğeÇiz(Öğe öğe) {
		FontMetrics ölçü = görselleştirici.çizer.getFontMetrics();
		if (öğe instanceof Levha) {
			if (öğe instanceof KayanLevha) {
				Dikdörtgen2 d = ((KayanLevha)öğe).görünürHizalama.alan;
				kutuÇiz(d, Color.WHITE, false);
				görselleştirici.çizer.setClip((int)d.k.x + 1, (int)d.k.y + 1, (int)(d.b.x - d.k.x) - 1, (int)(d.b.y - d.k.y) - 1);
			} else if (öğe instanceof Pencere) {
				kutuÇiz(öğe.hizalama.alan, Color.DARK_GRAY, ekran.içerik.indexOf(öğe) == ekran.içerik.size() - 1);
			}
			for (Öğe altÖğe : ((Levha)öğe).içerik)
				öğeÇiz(altÖğe);
			if (öğe instanceof KayanLevha)
				görselleştirici.çizer.setClip(null);
		} else if (öğe instanceof Düğme) {
			kutuÇiz(öğe.hizalama.alan, öğe.imleçte ? Color.RED : ((Düğme)öğe).basıldı ? Color.GRAY : Color.WHITE, false);
			görselleştirici.çizer.setColor(öğe.imleçte ? Color.white : Color.black);
			String yazı = ((Düğme)öğe).yazı;
			görselleştirici.çizer.drawString(yazı,
					(öğe.hizalama.alan.b.x + öğe.hizalama.alan.k.x - ölçü.stringWidth(yazı)) / 2.0F,
					(öğe.hizalama.alan.b.y + öğe.hizalama.alan.k.y + ölçü.getLeading() + ölçü.getAscent()) / 2.0F);
		} else if (öğe instanceof Etiket) {
			görselleştirici.çizer.setColor(Color.black);
			String yazı = ((Etiket)öğe).yazı;
			görselleştirici.çizer.drawString(yazı,
					öğe.hizalama.alan.k.x,
					(öğe.hizalama.alan.b.y + öğe.hizalama.alan.k.y + ölçü.getLeading() + ölçü.getAscent()) / 2.0F);
		} else if (öğe instanceof PencereÇubuğu) {
			kutuÇiz(öğe.hizalama.alan, Color.WHITE, false);
			görselleştirici.çizer.setColor(Color.black);
			String yazı = ((PencereÇubuğu)öğe).başlık;
			görselleştirici.çizer.drawString(yazı,
					öğe.hizalama.alan.k.x + ölçü.charWidth(' '),
					(öğe.hizalama.alan.b.y + öğe.hizalama.alan.k.y + ölçü.getLeading() + ölçü.getAscent()) / 2.0F);
		} else if (öğe instanceof KaydırmaÇubuğu) {
			kutuÇiz(öğe.hizalama.alan, Color.LIGHT_GRAY, false);
		}
	}
}
