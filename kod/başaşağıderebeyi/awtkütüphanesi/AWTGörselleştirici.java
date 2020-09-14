/**
 * başaşağıderebeyi.awtkütüphanesi.AWTGörselleştirici.java
 * 0.5 / 29 Ağu 2020 / 12:25:23
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.awtkütüphanesi;

import static java.awt.RenderingHints.*;

import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.motor.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

public class AWTGörselleştirici implements Görselleştirici {
	public String başlık = "Baş Aşağı Motor srm. " + Motor.SÜRÜM;
	public Vektör2 boyut = new Vektör2(16.0F * 50.0F, 9.0F * 50.0F);
	public int tamponSayısı = 3;
	public boolean kenarYumuşatma = true;
	public boolean tamEkran = false;
	public Color arkaplanRengi = new Color(0.2F, 0.2F, 0.2F, 1.0F);
	public AWTGirdi girdi = new AWTGirdi();
	public Image ikon;
	public Cursor imleç;
	public JFrame çerçeve;
	public Canvas tuval;
	public BufferStrategy çizimTamponu;
	public Graphics2D çizer;
	
	@Override
	public void oluştur() {
		if (çerçeve != null)
			return;
		çerçeve = new JFrame(başlık);
		tuval = new Canvas();
		if (tamEkran) {
			çerçeve.setUndecorated(true);
			GraphicsDevice d = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			d.setFullScreenWindow(çerçeve);
			boyut.yaz(d.getDisplayMode().getWidth(), d.getDisplayMode().getHeight());
		} else {
			boyut.yuvarla();
		}
		Dimension boyut = new Dimension((int)this.boyut.x, (int)this.boyut.y);
		tuval.setMaximumSize(boyut);
		tuval.setMinimumSize(boyut);
		tuval.setPreferredSize(boyut);
		çerçeve.add(tuval);
		çerçeve.pack();
		çerçeve.setResizable(false);
		if (ikon != null)
			ikonuAyarla();
		if (imleç != null)
			imleciAyarla();
		çerçeve.setLocationRelativeTo(null);
		çerçeve.setVisible(true);
		çerçeve.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Motor.dur();
			}
		});
		girdiyiEkle();
		çerçeve.requestFocus();
		tuval.requestFocus();
		arkaplanRenginiAyarla();
		tuval.createBufferStrategy(tamponSayısı);
		çizimTamponu = tuval.getBufferStrategy();
		çizer = (Graphics2D)çizimTamponu.getDrawGraphics();
		kenarYumuşatmayıAyarla();
	}
	
	@Override
	public void yokEt() {
		if (çerçeve == null)
			return;
		çerçeve.setVisible(false);
		çizer = null;
		çizimTamponu = null;
		tuval = null;
		çerçeve = null;
	}
	
	@Override
	public void göster() {
		çizimTamponu.show();
		Toolkit.getDefaultToolkit().sync();
		çizer.clearRect(0, 0, (int)boyut.x, (int)boyut.y);
	}
	
	@Override
	public Girdi girdiyiAl() {
		return girdi;
	}
	
	private void kenarYumuşatmayıAyarla() {
		çizer.setRenderingHint(KEY_ANTIALIASING, kenarYumuşatma ? VALUE_ANTIALIAS_ON : VALUE_ANTIALIAS_OFF);
		çizer.setRenderingHint(KEY_TEXT_ANTIALIASING, kenarYumuşatma ? VALUE_TEXT_ANTIALIAS_ON : VALUE_TEXT_ANTIALIAS_OFF);
	}
	
	private void arkaplanRenginiAyarla() {
		tuval.setBackground(arkaplanRengi);
	}
	
	private void girdiyiEkle() {
		tuval.addKeyListener(girdi);
		tuval.addMouseListener(girdi);
		tuval.addMouseWheelListener(girdi);
		tuval.addMouseMotionListener(girdi);
	}
	
	private void ikonuAyarla() {
		çerçeve.setIconImage(ikon);
	}
	
	private void imleciAyarla() {
		çerçeve.setCursor(imleç);
	}
	
	public void kenarYumuşatmayıAyarla(boolean kenarYumuşatma) {
		this.kenarYumuşatma = kenarYumuşatma;
		if (çerçeve != null)
			kenarYumuşatmayıAyarla();
	}
	
	public void arkaplanRenginiAyarla(Color arkaplanRengi) {
		this.arkaplanRengi = arkaplanRengi;
		if (çerçeve != null)
			arkaplanRenginiAyarla();
	}
	
	public void girdiyiAyarla(AWTGirdi girdi) {
		this.girdi = girdi;
		if (çerçeve != null)
			girdiyiEkle();
	}
	
	public void ikonuAyarla(Image ikon) {
		this.ikon = ikon;
		if (çerçeve != null)
			ikonuAyarla();
	}
	
	public void imleciAyarla(Cursor imleç) {
		this.imleç = imleç;
		if (çerçeve != null)
			imleciAyarla();
	}
}
