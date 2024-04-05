import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class mainFrame extends javax.swing.JFrame {

    public mainFrame() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtKullaniciAd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtSifre = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxKullaniciTuru = new javax.swing.JComboBox<>();
        BtnGiris = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CheckBoxSifreGoster = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 150));
        setSize(new java.awt.Dimension(600, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kullanıcı Adı:");

        TxtKullaniciAd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TxtKullaniciAd.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Şifre:");

        TxtSifre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TxtSifre.setPreferredSize(new java.awt.Dimension(150, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Kullanıcı Türü:");

        ComboBoxKullaniciTuru.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        ComboBoxKullaniciTuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YONETICI", "OGRENCI", "HOCA" }));
        ComboBoxKullaniciTuru.setPreferredSize(new java.awt.Dimension(150, 40));

        BtnGiris.setBackground(new java.awt.Color(0, 51, 255));
        BtnGiris.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnGiris.setForeground(new java.awt.Color(51, 0, 51));
        BtnGiris.setText("Giriş Yap");
        BtnGiris.setPreferredSize(new java.awt.Dimension(150, 50));
        BtnGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGirisActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOGIN");
        jLabel4.setToolTipText("");

        CheckBoxSifreGoster.setText("Şifre göster");
        CheckBoxSifreGoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxSifreGosterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnGiris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtKullaniciAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtSifre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxKullaniciTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxSifreGoster, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtKullaniciAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBoxSifreGoster))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxKullaniciTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGirisActionPerformed
        String kullaniciAdi = TxtKullaniciAd.getText();
        String sifre = new String(TxtSifre.getPassword());
        String kullaniciTuru = ComboBoxKullaniciTuru.getSelectedItem().toString();
        if (kullaniciTuru.equalsIgnoreCase("YONETICI")) {
            boolean girisBasarili = DatabaseConnection.verifyPassword(kullaniciAdi, sifre, "yonetici");
            if (girisBasarili) {
                YoneticiPanel panel = new YoneticiPanel(kullaniciAdi);
                panel.setVisible(true);
                this.dispose();
            } else {
                // Giriş başarısız
                JOptionPane.showMessageDialog(this, "Hatalı giriş. Lütfen tekrar deneyin.");
                this.TxtKullaniciAd.setText("");
                this.TxtSifre.setText("");
            }
        } else if (kullaniciTuru.equalsIgnoreCase("OGRENCI")) {
            boolean girisBasarili = DatabaseConnection.verifyPassword(kullaniciAdi, sifre, "OGRENCI");
            if (girisBasarili) {
                OgrenciPanel panel = new OgrenciPanel(kullaniciAdi);
                panel.setVisible(true);
                this.dispose();
            } else {
                // Giriş başarısız
                JOptionPane.showMessageDialog(this, "Hatalı giriş. Lütfen tekrar deneyin.");
                this.TxtKullaniciAd.setText("");
                this.TxtSifre.setText("");
            }
        } else if (kullaniciTuru.equalsIgnoreCase("HOCA")) {
            boolean girisBasarili = DatabaseConnection.verifyPassword(kullaniciAdi, sifre, "HOCA");
            if (girisBasarili) {
                HocaPanel panel = new HocaPanel(kullaniciAdi);
                panel.setVisible(true);
                this.dispose();
            } else {
                // Giriş başarısız
                JOptionPane.showMessageDialog(this, "Hatalı giriş. Lütfen tekrar deneyin.");
                this.TxtKullaniciAd.setText("");
                this.TxtSifre.setText("");
            }
        }
    }//GEN-LAST:event_BtnGirisActionPerformed

    private void CheckBoxSifreGosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxSifreGosterActionPerformed
        if (this.CheckBoxSifreGoster.isSelected()) {
            this.TxtSifre.setEchoChar((char) 0);
        } else {
            this.TxtSifre.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckBoxSifreGosterActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGiris;
    private javax.swing.JCheckBox CheckBoxSifreGoster;
    private javax.swing.JComboBox<String> ComboBoxKullaniciTuru;
    private javax.swing.JTextField TxtKullaniciAd;
    private javax.swing.JPasswordField TxtSifre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
