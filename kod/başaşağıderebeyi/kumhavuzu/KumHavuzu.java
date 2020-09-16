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

public class KumHavuzu implements Uygulama {
	public static final KumHavuzu KUM_HAVUZU = new KumHavuzu();
	
	public static void main(String[] args) {
		Motor.görselleştirici = KUM_HAVUZU.görselleştirici;
		Motor.uygulama = KUM_HAVUZU;
		Motor.başla();
	}
	
	private AWTGörselleştirici görselleştirici;
	private AWTGirdi girdi;
	private int sayaç;
	private int xkon;
	private Süreç yazmaSüreci;
	private Color renk;
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
		girdi = görselleştirici.girdi;
		sayaç = 0;
		xkon = 10;
		yazmaSüreci = new Süreç();
		ekran = new Ekran(görselleştirici.boyut.x, görselleştirici.boyut.y, MouseEvent.BUTTON1);
		pencere = ekran.pencereAç("Pencere", 500.0F, 500.0F);
		kayanLevha = new KayanLevha(pencere, 1000.0F, 1000.0F, MouseEvent.BUTTON1);
		kayanLevha.levha.hizalama
		.kx(new SabitHiza(10.0F))
		.bx(new OrtaHiza())
		.ky(new SabitHiza(10.0F + Pencere.ÇUBUK_YÜKSEKLİĞİ))
		.by(new TersSabitHiza(110.0F));
		Düğme düğme = new Düğme(kayanLevha, "Bas Bana", () -> System.out.println("Bastın"), pencere.solDüğme);
		düğme.hizalama
		.kx(new SabitHiza(150.0F))
		.bx(new OrtaHiza())
		.ky(new SabitHiza(400.0F + Pencere.ÇUBUK_YÜKSEKLİĞİ))
		.by(new SabitBoyutHiza(90.0F));
		renk = new Color(0.4F, 0.4F, 0.4F, 1.0F);
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
//		if (girdi.tuşBasıldı[KeyEvent.VK_F])
//			sayaç++;
//		xkon += girdi.kaydırma * 10;
//		yazmaSüreci.başla();
		görselleştirici.çizer.setColor(Color.white);
		görselleştirici.çizer.drawString("SBK: " + Motor.kareOranı, xkon, 30);
		görselleştirici.çizer.drawString("Uyg: " + Motor.UYGULAMA_SÜRECİ.ortalamayıAl(), xkon, 50);
		görselleştirici.çizer.drawString("Gir: " + Motor.GİRDİ_SÜRECİ.ortalamayıAl(), xkon, 70);
		görselleştirici.çizer.drawString("Gös: " + Motor.GÖSTERME_SÜRECİ.ortalamayıAl(), xkon, 90);
		görselleştirici.çizer.drawString("Gör: " + kayanLevha.görünürHizalama.alan, xkon, 110);
		görselleştirici.çizer.drawString("Hiz: " + kayanLevha.hizalama.alan, xkon, 130);
		görselleştirici.çizer.drawString("Kay: " + kayanLevha.dikeyKaydırma, xkon, 150);
//		çizer.drawString("İmleç: " + girdi.imleç + " Değişim: " + girdi.imleçDeğişimi, xkon, 50);
//		çizer.drawString("F tuşu " + sayaç + " kere basıldı.", xkon, 70);
//		if (girdi.tuşAşağı[KeyEvent.VK_SPACE])
//			çizer.drawString("BOŞLUK TUŞU AŞAĞIDA!", xkon, 90);
//		yazmaSüreci.dur();
		ekran.girdi(girdi);
		öğeÇiz(ekran);
		if (girdi.tuşAşağı[KeyEvent.VK_ESCAPE])
			Motor.dur();
	}
	
	@Override
	public void saniye() {
//		yazmaSüreci.hesapla();
//		System.out.println("Yazma: " + yazmaSüreci.ortalamayıAl() + "ms");
	}
	
	private void rengiDeğiştir() {
		Color renk = görselleştirici.çizer.getColor();
		if (renk.equals(Color.WHITE)) {
			görselleştirici.çizer.setColor(new Color(0.6F, 0.6F, 0.6F, 1.0F));
		} else {
			görselleştirici.çizer.setColor(renk.brighter());
		}
	}
	
	private void dörtgenÇiz(Dikdörtgen2 d) {
		görselleştirici.çizer.fillRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		Color renk = görselleştirici.çizer.getColor();
		görselleştirici.çizer.setColor(Color.black);
		görselleştirici.çizer.drawRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		görselleştirici.çizer.setColor(renk);
	}
	
	private void kutuÇiz(Öğe öğe) {
		if (öğe.levha != null) {
			if (öğe.levha == ekran)
				görselleştirici.çizer.setColor(renk);
			else
				rengiDeğiştir();
			Color renk = görselleştirici.çizer.getColor();
			if (öğe instanceof Düğme && öğe.üzerinde)
				görselleştirici.çizer.setColor(Color.red);
			if (öğe.odaklı)
				görselleştirici.çizer.setStroke(new BasicStroke(2.0F));
			else
				görselleştirici.çizer.setStroke(new BasicStroke(0.5F));
			dörtgenÇiz(öğe instanceof KayanLevha ? ((KayanLevha)öğe).görünürHizalama.alan : öğe.hizalama.alan);
			görselleştirici.çizer.setColor(renk);
		}
	}
	
	private void öğeÇiz(Öğe öğe) {
		if (öğe instanceof Levha) {
			kutuÇiz(öğe);
			if (öğe instanceof KayanLevha) {
				Dikdörtgen2 d = ((KayanLevha)öğe).görünürHizalama.alan;
				görselleştirici.çizer.setClip((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
			}
			for (Öğe altÖğe : ((Levha)öğe).içerik)
				öğeÇiz(altÖğe);
			if (öğe instanceof KayanLevha)
				görselleştirici.çizer.setClip(null);
		} else if (öğe instanceof Düğme) {
			kutuÇiz(öğe);
			Color renk = görselleştirici.çizer.getColor();
			görselleştirici.çizer.setColor(öğe.üzerinde ? Color.white : Color.black);
			FontMetrics ölçü = görselleştirici.çizer.getFontMetrics();
			String yazı = ((Düğme)öğe).yazı;
			görselleştirici.çizer.drawString(yazı,
					(öğe.hizalama.alan.b.x + öğe.hizalama.alan.k.x - ölçü.stringWidth(yazı)) / 2.0F,
					(öğe.hizalama.alan.b.y + öğe.hizalama.alan.k.y + ölçü.getLeading() + ölçü.getAscent()) / 2.0F);
			görselleştirici.çizer.setColor(renk);
		} else if (öğe instanceof Etiket) {
			Color renk = görselleştirici.çizer.getColor();
			görselleştirici.çizer.setColor(Color.black);
			FontMetrics ölçü = görselleştirici.çizer.getFontMetrics();
			String yazı = ((Etiket)öğe).yazı;
			görselleştirici.çizer.drawString(yazı,
					öğe.hizalama.alan.k.x,
					(öğe.hizalama.alan.b.y + öğe.hizalama.alan.k.y + ölçü.getLeading() + ölçü.getAscent()) / 2.0F);
			görselleştirici.çizer.setColor(renk);
		} else if (öğe instanceof PencereÇubuğu) {
			kutuÇiz(öğe);
			Color renk = görselleştirici.çizer.getColor();
			görselleştirici.çizer.setColor(Color.black);
			FontMetrics ölçü = görselleştirici.çizer.getFontMetrics();
			String yazı = ((PencereÇubuğu)öğe).başlık;
			görselleştirici.çizer.drawString(yazı,
					öğe.hizalama.alan.k.x + ölçü.charWidth(' '),
					(öğe.hizalama.alan.b.y + öğe.hizalama.alan.k.y + ölçü.getLeading() + ölçü.getAscent()) / 2.0F);
			görselleştirici.çizer.setColor(renk);
		} else if (öğe instanceof KaydırmaÇubuğu) {
			kutuÇiz(öğe);
		}
	}
}
