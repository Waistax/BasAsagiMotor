/**
 * başaşağıderebeyi.kumhavuzu.KumHavuzu.java
 * 0.6 / 29 Ağu 2020 / 13:17:03
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kumhavuzu;

import başaşağıderebeyi.arayüz.kutu.*;
import başaşağıderebeyi.arayüz.öğe.*;
import başaşağıderebeyi.awtkütüphanesi.*;
import başaşağıderebeyi.girdi.*;
import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.matematik.hiza.*;
import başaşağıderebeyi.motor.*;
import başaşağıderebeyi.varlık.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KumHavuzu implements Uygulama {
	public static final KumHavuzu KUM_HAVUZU = new KumHavuzu();
	
	public static void main(String[] args) {
		Motor.görselleştirici = KUM_HAVUZU.görselleştirici;
		Motor.uygulama = KUM_HAVUZU;
		Motor.hedefTıkOranı = 20.0F;
		Motor.başla();
	}
	
	private AWTGörselleştirici görselleştirici;
	private int xkon;
	private Ekran ekran;
	private Pencere pencere;
	private KayanLevha kayanLevha;
	private Topluluk topluluk;
	
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
//		for (int i = 0; i < rastgele.nextInt(20) + 1; i++) {
//			ekran.pencereAç("Rastgele " + (i + 1), (rastgele.nextInt(6) + 2) * 100, (rastgele.nextInt(6) + 2) * 100);
//		}
		kayanLevha = new KayanLevha(pencere, 10000.0F, 10000.0F);
		kayanLevha.levha.levha.hizalıDikdörtgen.hepsiniAyarla(
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK).yaz(10.0F),
				new OrtaHiza(),
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK).yaz(10.0F + Pencere.ÇUBUK_KALINLIĞI),
				new SerbestBoyutHiza(400.0F));
		Liste liste = new Liste(kayanLevha);
		liste.hizalıDikdörtgen.hepsiniAyarla(
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK).yaz(10.0F),
				new OrtaHiza(),
				new SabitHiza(DikdörtgenVerisi.KÜÇÜK).yaz(10.0F),
				new OrtaHiza());
		görselleştirici.çizer.setFont(new Font("Consolas", Font.PLAIN, 17));
		ekran.hizala();
		topluluk = new Topluluk();
		new KutuÇizer(topluluk, görselleştirici.çizer);
		new VarlıkListesi(topluluk, liste);
		new KutuHareket(topluluk);
		for (int i = 0; i < 30; i++) {
			Varlık varlık = new Varlık(topluluk);
			Kutu kutu = (Kutu)new KutuBileşeni(varlık).güncel;
			kutu.d.o.yaz(rastgele.nextFloat() * 300.0F, rastgele.nextFloat() * 300.0F);
			kutu.d.ö.yaz(rastgele.nextFloat() * 300.0F, rastgele.nextFloat() * 300.0F);
			kutu.renk.yaz(rastgele.nextFloat(), rastgele.nextFloat(), rastgele.nextFloat(), 1.0F);
		}
	}
	
	@Override
	public void kaydet() {
	}
	
	@Override
	public void güncelle() {
		ekran.güncelle();
		topluluk.güncelle();
		if (Girdi.tuşAl(KeyEvent.VK_ESCAPE).basma)
			Motor.dur();
	}
	
	@Override
	public void çiz() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		topluluk.çiz();
		öğeÇiz(ekran);
		görselleştirici.çizer.setColor(Color.white);
		görselleştirici.çizer.drawString("Tık: " + Motor.tıkOranı, xkon, 30);
		görselleştirici.çizer.drawString("Kar: " + Motor.kareOranı, xkon, 50);
		görselleştirici.çizer.drawString("Gün: " + Motor.GÜNCELLEME_SÜRECİ.ortalamayıAl(), xkon, 70);
		görselleştirici.çizer.drawString("Çiz: " + Motor.ÇİZME_SÜRECİ.ortalamayıAl(), xkon, 90);
		görselleştirici.çizer.drawString("İşl: " + Motor.işlenmemişTıklar, xkon, 110);
		görselleştirici.çizer.drawString("İml: " + Girdi.imleçHedefi, xkon, 130);
		görselleştirici.çizer.drawString("Tek: " + Girdi.tekerlekHedefi, xkon, 150);
	}
	
	@Override
	public void saniye() {
	}
	
	private void kutuÇiz(Dikdörtgen d, Color renk, boolean kalın) {
		görselleştirici.çizer.setColor(renk);
		görselleştirici.çizer.setStroke(new BasicStroke(kalın ? 2.0F : 0.5F));
		görselleştirici.çizer.fillRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
		görselleştirici.çizer.setColor(Color.black);
		görselleştirici.çizer.drawRect((int)d.k.x, (int)d.k.y, (int)(d.b.x - d.k.x), (int)(d.b.y - d.k.y));
	}
	
	private void öğeÇiz(Öğe öğe) {
		FontMetrics ölçü = görselleştirici.çizer.getFontMetrics();
		float yazıSonu = ölçü.getLeading() + ölçü.getAscent();
		float yükseklik = yazıSonu + ölçü.getDescent();
		if (öğe instanceof Levha) {
			if (öğe instanceof KayanLevha) {
				görselleştirici.çizer.setClip((int)öğe.levha.alan.k.x + 1, (int)öğe.levha.alan.k.y + 1, (int)öğe.levha.alan.ö.x - 1, (int)öğe.levha.alan.ö.y - 1);
				kutuÇiz(öğe.levha.alan, Color.GRAY, false);
			} else if (öğe instanceof Pencere) {
				kutuÇiz(öğe.alan, Color.DARK_GRAY, ekran.içerik.indexOf(öğe) == ekran.içerik.size() - 1);
			}
			for (Öğe altÖğe : ((Levha)öğe).içerik)
				öğeÇiz(altÖğe);
			if (öğe instanceof KayanLevha)
				görselleştirici.çizer.setClip(null);
		} else if (öğe instanceof Düğme) {
			kutuÇiz(öğe.alan, öğe.imleçte ? Color.RED : ((Düğme)öğe).basıldı ? Color.GRAY : Color.WHITE, false);
			görselleştirici.çizer.setColor(öğe.imleçte ? Color.white : Color.black);
			String yazı = ((Düğme)öğe).yazı;
			görselleştirici.çizer.drawString(yazı,
					(öğe.alan.b.x + öğe.alan.k.x - ölçü.stringWidth(yazı)) / 2.0F,
					(öğe.alan.b.y + öğe.alan.k.y + yazıSonu) / 2.0F);
		} else if (öğe instanceof Etiket) {
			görselleştirici.çizer.setColor(Color.black);
			String yazı = ((Etiket)öğe).yazı;
			görselleştirici.çizer.drawString(yazı,
					öğe.alan.k.x,
					(öğe.alan.b.y + öğe.alan.k.y + yazıSonu) / 2.0F);
		} else if (öğe instanceof PencereÇubuğu) {
			kutuÇiz(öğe.alan, Color.WHITE, false);
			görselleştirici.çizer.setColor(Color.black);
			String yazı = ((PencereÇubuğu)öğe).başlık;
			görselleştirici.çizer.drawString(yazı,
					öğe.alan.k.x + ölçü.charWidth(' '),
					(öğe.alan.b.y + öğe.alan.k.y + yazıSonu) / 2.0F);
		} else if (öğe instanceof KaydırmaÇubuğu) {
			kutuÇiz(öğe.alan, Color.LIGHT_GRAY, false);
		} else if (öğe instanceof Liste) {
			görselleştirici.çizer.setColor(Color.black);
			float y = öğe.alan.k.y;
			for (String yazı : ((Liste)öğe).yazılar)
				görselleştirici.çizer.drawString(yazı,
						öğe.alan.k.x,
						y += yükseklik);
		}
	}
}
