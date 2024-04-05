
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

public class HocaDersEsle extends javax.swing.JFrame {

    Connection connection = DatabaseConnection.getConnection();

    public HocaDersEsle() throws SQLException {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        DerslerCombo();
        HocalarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGeri = new javax.swing.JButton();
        ComboHocalar = new javax.swing.JComboBox<>();
        BtnEkle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboDersler = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));
        setSize(new java.awt.Dimension(500, 500));

        BtnGeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        BtnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeriActionPerformed(evt);
            }
        });

        ComboHocalar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        BtnEkle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEkle.setText("Dersi Hocaya Ekle");
        BtnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEkleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Hocalar:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dersler:");

        ComboDersler.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(BtnEkle))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboDersler, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboHocalar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboHocalar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboDersler, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(BtnEkle)
                .addGap(9, 9, 9)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    private void BtnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEkleActionPerformed
        String hocaAdSoyad = ComboHocalar.getSelectedItem().toString();
        String dersAd = ComboDersler.getSelectedItem().toString();
        try {
            String updateSQL = "UPDATE verilecekdersler SET verenhoca = array_append(verenhoca, ?) WHERE ad = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, hocaAdSoyad);
            preparedStatement.setString(2, dersAd);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException ex) {
        }
        try {
            String updateSQL2 = "UPDATE hoca SET verecegidersler = array_append(verecegidersler, ?) WHERE adsoyad = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(updateSQL2);
            preparedStatement2.setString(1, dersAd);
            preparedStatement2.setString(2, hocaAdSoyad);
            preparedStatement2.executeUpdate();
            preparedStatement2.close();
            
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_BtnEkleActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HocaDersEsle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HocaDersEsle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void DerslerCombo() throws SQLException {
        String sql = "SELECT ad FROM verilecekdersler";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rslt = psmt.executeQuery();
        List<String> dersler = new ArrayList<>();

        while (rslt.next()) {
            String ders = rslt.getString("ad");
            dersler.add(ders);
        }

        for (String ders : dersler) {
            ComboDersler.addItem(ders);
        }
        psmt.close();
        rslt.close();
    }

    public void HocalarCombo() throws SQLException {
        String sql = "SELECT adsoyad FROM hoca";
        PreparedStatement psmt2 = connection.prepareStatement(sql);
        ResultSet rslt2 = psmt2.executeQuery();
        List<String> hocalar = new ArrayList<>();

        while (rslt2.next()) {
            String hoca = rslt2.getString("adsoyad");
            hocalar.add(hoca);
        }

        for (String hoca : hocalar) {
            ComboHocalar.addItem(hoca);
        }
        psmt2.close();
        rslt2.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEkle;
    private javax.swing.JButton BtnGeri;
    private javax.swing.JComboBox<String> ComboDersler;
    private javax.swing.JComboBox<String> ComboHocalar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
