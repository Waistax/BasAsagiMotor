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

/** Java AWT kütüphanesi ile çizer ve görselleştirir */
public class AWTGörselleştirici implements Görselleştirici {
	/** Pencerenin başlığı */
	public String başlık = "Baş Aşağı Motor srm. " + Motor.SÜRÜM;
	/** Pencerenin boyutu */
	public Vektör2t boyut = new Vektör2t(16 * 50, 9 * 50);
	/** Tuvalin ekran tamponu sayısı */
	public int tamponSayısı = 3;
	/** Pikselleri bölerek kenarları yumuşatma */
	public boolean kenarYumuşatma = true;
	/** Tuvalin arkaplanının rengi */
	public Color arkaplanRengi = new Color(0.2F, 0.2F, 0.2F, 1.0F);
	/** Girdi dinleyicisi */
	public AWTGirdi girdi = new AWTGirdi();
	/** Pencerenin ikonu */
	public Image ikon;
	/** Pencerenin imleci */
	public Cursor imleç;
	/** Pencerenin çerçevesi */
	public JFrame çerçeve;
	/** Tuval */
	public Canvas tuval;
	/** Tuvalin tamponu */
	public BufferStrategy çizimTamponu;
	/** Çizim aracı */
	public Graphics2D çizer;

	@Override
	public void oluştur() {
		// Eğer bir çerçeve zaten varsa
		if (çerçeve != null)
			// Görselleştiriciyi tekrar oluşturma
			return;
		// Çerçeveyi oluştur
		çerçeve = new JFrame(başlık);
		tuval = new Canvas();
		// Tuvalin boyutlarını ayarla
		Dimension boyut = new Dimension(this.boyut.x, this.boyut.y);
		tuval.setMaximumSize(boyut);
		tuval.setMinimumSize(boyut);
		tuval.setPreferredSize(boyut);
		// Tuvali çerçevenin içine koy ve onu sar
		çerçeve.add(tuval);
		çerçeve.pack();
		// Çerçevenin boyutunun değiştirilmesini engelle
		çerçeve.setResizable(false);
		// Eğer verilmiş bir ikon varsa
		if (ikon != null)
			ikonuAyarla();
		// Eğer verilmiş bir imleç varsa
		if (imleç != null)
			imleciAyarla();
		// Çerçeveyi ekranın ortasına koy ve görünür yap
		çerçeve.setLocationRelativeTo(null);
		çerçeve.setVisible(true);
		// Pencere kapatıldığında motoru da durduracak bir dinleyici ekle
		çerçeve.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Motor.dur();
			}
		});
		girdiyiEkle();
		// Çerçeveyi ve tuvali odakla böylece girdiler tuvale gelecek
		çerçeve.requestFocus();
		tuval.requestFocus();
		// Çizim tamponunu ve çizim aracını
		arkaplanRenginiAyarla();
		tuval.createBufferStrategy(tamponSayısı);
		çizimTamponu = tuval.getBufferStrategy();
		çizer = (Graphics2D)çizimTamponu.getDrawGraphics();
		kenarYumuşatmayıAyarla();
	}

	@Override
	public void yokEt() {
		// Eğer bir çerçeve zaten yoksa
		if (çerçeve == null)
			// Görselleştiriciyi tekrar yok etme
			return;
		// Pencereyi görünmez yap ve temizliğe bırak
		çerçeve.setVisible(false);
		çizer = null;
		çizimTamponu = null;
		tuval = null;
		çerçeve = null;
	}

	@Override
	public void göster() {
		// Tampona çizileni ekrana getir ve sonra temizle
		çizimTamponu.show();
		çizer.clearRect(0, 0, boyut.x, boyut.y);
	}

	@Override
	public Girdi girdiyiAl() {
		return girdi;
	}
	
	/** Çizerin kenar yumuşatmasını ayarla */
	private void kenarYumuşatmayıAyarla() {
		çizer.setRenderingHint(KEY_ANTIALIASING, kenarYumuşatma ? VALUE_ANTIALIAS_ON : VALUE_ANTIALIAS_OFF);
		çizer.setRenderingHint(KEY_TEXT_ANTIALIASING, kenarYumuşatma ? VALUE_TEXT_ANTIALIAS_ON : VALUE_TEXT_ANTIALIAS_OFF);
	}
	
	/** Tuvalin arkaplan rengini ayarla */
	private void arkaplanRenginiAyarla() {
		tuval.setBackground(arkaplanRengi);
	}
	
	/** Tuvale girdiyi ekle */
	private void girdiyiEkle() {
		tuval.addKeyListener(girdi);
		tuval.addMouseListener(girdi);
		tuval.addMouseWheelListener(girdi);
		tuval.addMouseMotionListener(girdi);
	}
	
	/** Çerçevenin ikonunu ayarla */
	private void ikonuAyarla() {
		çerçeve.setIconImage(ikon);
	}
	
	/** Çerçevenin imlecini ayarla */
	private void imleciAyarla() {
		çerçeve.setCursor(imleç);
	}
	
	/** Kenar yumuşatmayı ayarla */
	public void kenarYumuşatmayıAyarla(boolean kenarYumuşatma) {
		this.kenarYumuşatma = kenarYumuşatma;
		// Pencere çoktan oluşturulmuşsa
		if (çerçeve != null)
			kenarYumuşatmayıAyarla();
	}
	
	/** Arkaplan rengini ayarla */
	public void arkaplanRenginiAyarla(Color arkaplanRengi) {
		this.arkaplanRengi = arkaplanRengi;
		// Pencere çoktan oluşturulmuşsa
		if (çerçeve != null)
			arkaplanRenginiAyarla();
	}
	
	/** Girdiyi ayarla */
	public void girdiyiAyarla(AWTGirdi girdi) {
		this.girdi = girdi;
		// Pencere çoktan oluşturulmuşsa
		if (çerçeve != null)
			girdiyiEkle();
	}
	
	/** İkonu ayarla */
	public void ikonuAyarla(Image ikon) {
		this.ikon = ikon;
		// Pencere çoktan oluşturulmuşsa
		if (çerçeve != null)
			ikonuAyarla();
	}
	
	/** İmleci ayarla */
	public void imleciAyarla(Cursor imleç) {
		this.imleç = imleç;
		// Pencere çoktan oluşturulmuşsa
		if (çerçeve != null)
			imleciAyarla();
	}
}
