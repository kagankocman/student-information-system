
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class OgrenciPanel extends javax.swing.JFrame {

    public static String ocrCikti;
    public static List<Ders> gecmisDersler;
    public static String kullaniciAd;

    public OgrenciPanel(String kullaniciAd) {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.kullaniciAd = kullaniciAd;
    }

    public String getOcrCikti() {
        //System.out.println(ocrCikti);
        return ocrCikti;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dosyaYukleButonu = new javax.swing.JButton();
        BtnGeri = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnIlgıAlaniSec = new javax.swing.JButton();
        BtnDersTalep = new javax.swing.JButton();
        BtnGelenTalep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setSize(new java.awt.Dimension(800, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Transkript yükle:");

        dosyaYukleButonu.setBackground(new java.awt.Color(242, 242, 242));
        dosyaYukleButonu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dosyaYukleButonu.setForeground(new java.awt.Color(51, 0, 51));
        dosyaYukleButonu.setText("Dosya Yükle");
        dosyaYukleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaYukleButonuActionPerformed(evt);
            }
        });

        BtnGeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        BtnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeriActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HOŞGELDİNİZ");

        BtnIlgıAlaniSec.setText("İlgi Alanı Seç");
        BtnIlgıAlaniSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIlgıAlaniSecActionPerformed(evt);
            }
        });

        BtnDersTalep.setText("Ders Talebi Olustur");
        BtnDersTalep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDersTalepActionPerformed(evt);
            }
        });

        BtnGelenTalep.setText("Gelen talep");
        BtnGelenTalep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGelenTalepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnGelenTalep, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dosyaYukleButonu, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(BtnDersTalep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnIlgıAlaniSec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 214, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dosyaYukleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnDersTalep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnGelenTalep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnIlgıAlaniSec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyaYukleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaYukleButonuActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String dosyaYolu = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                Tesseract instance = new Tesseract();
                instance.setDatapath("C:\\Users\\aslid\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
                instance.setLanguage("tur");
                String resultText = instance.doOCR(new File(dosyaYolu));
                ocrCikti = resultText;
                StringBuilder dersAdlari = new StringBuilder();
                String regex = "\\b([A-Z]+[0-9]+[A-Z]*\\d*)\\s(.+?)\\s\\(";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(resultText);

                while (matcher.find()) {
                    dersAdlari.append(matcher.group()).append("\n");
                }
            } catch (TesseractException ex) {
            }
        }
        try {
            gecmisDersler = DBProcess.dersAdlariEkle(kullaniciAd);

        } catch (SQLException ex) {
            Logger.getLogger(OgrenciPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dosyaYukleButonuActionPerformed

    //Herhangi bir yerden gecmis dersler tablosuna erişilebilir

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        mainFrame panel = new mainFrame();
        panel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    private void BtnIlgıAlaniSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIlgıAlaniSecActionPerformed
        IlgıAlaniSecOgrenci panel = new IlgıAlaniSecOgrenci(kullaniciAd);
        panel.setVisible(true);
    }//GEN-LAST:event_BtnIlgıAlaniSecActionPerformed

    private void BtnDersTalepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDersTalepActionPerformed
        try {
            new DersTalepEt(kullaniciAd).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BtnDersTalepActionPerformed

    private void BtnGelenTalepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGelenTalepActionPerformed
        try {
            new OgrenciTaleplerim(kullaniciAd).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(OgrenciPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnGelenTalepActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel()); // Windows görünümünü ayarlıyoruz
        } catch (UnsupportedLookAndFeelException e) {
            // Look and feel ayarı yapılırken bir hata oluşursa burada işlenebilir.
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OgrenciPanel(kullaniciAd).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDersTalep;
    private javax.swing.JButton BtnGelenTalep;
    private javax.swing.JButton BtnGeri;
    private javax.swing.JButton BtnIlgıAlaniSec;
    private javax.swing.JButton dosyaYukleButonu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
