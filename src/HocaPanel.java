
import java.awt.Color;
import java.awt.PopupMenu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HocaPanel extends javax.swing.JFrame {

    public static String kullaniciAd;

    public HocaPanel(String kullaniciAd) {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.kullaniciAd = kullaniciAd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGeri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnOgrListele = new javax.swing.JButton();
        BtnIlgiAlaniSec = new javax.swing.JButton();
        BtnGelenTalepler = new javax.swing.JButton();
        BtnOgrenciTalepEt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));
        setSize(new java.awt.Dimension(1000, 700));

        BtnGeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        BtnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeriActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOŞGELDİNİZ");

        BtnOgrListele.setText("Öğrenci Listele");
        BtnOgrListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOgrListeleActionPerformed(evt);
            }
        });

        BtnIlgiAlaniSec.setText("İlgi alanı seç");
        BtnIlgiAlaniSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIlgiAlaniSecActionPerformed(evt);
            }
        });

        BtnGelenTalepler.setText("Gelen Talepler");
        BtnGelenTalepler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGelenTaleplerActionPerformed(evt);
            }
        });

        BtnOgrenciTalepEt.setText("Öğrenci Talep Et");
        BtnOgrenciTalepEt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOgrenciTalepEtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnOgrListele, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(BtnOgrenciTalepEt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnGelenTalepler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnIlgiAlaniSec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(BtnOgrenciTalepEt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnGelenTalepler, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnIlgiAlaniSec, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnOgrListele, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        mainFrame panel = new mainFrame();
        panel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    private void BtnOgrListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOgrListeleActionPerformed
        Listele panel = new Listele();
        panel.setVisible(true);
    }//GEN-LAST:event_BtnOgrListeleActionPerformed

    private void BtnIlgiAlaniSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIlgiAlaniSecActionPerformed
        IlgıAlaniSecHoca panel = new IlgıAlaniSecHoca(kullaniciAd);
        panel.setVisible(true);
    }//GEN-LAST:event_BtnIlgiAlaniSecActionPerformed

    private void BtnGelenTaleplerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGelenTaleplerActionPerformed
        try {
            new HocaTaleplerim(kullaniciAd).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HocaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnGelenTaleplerActionPerformed

    private void BtnOgrenciTalepEtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOgrenciTalepEtActionPerformed
        try {
            new OgrenciTalepEt(kullaniciAd).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(HocaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnOgrenciTalepEtActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HocaPanel(kullaniciAd).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGelenTalepler;
    private javax.swing.JButton BtnGeri;
    private javax.swing.JButton BtnIlgiAlaniSec;
    private javax.swing.JButton BtnOgrListele;
    private javax.swing.JButton BtnOgrenciTalepEt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
