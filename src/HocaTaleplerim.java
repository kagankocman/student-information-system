
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class HocaTaleplerim extends javax.swing.JFrame {

    public static String kullaniciAd;
    Connection connection = null;

    public HocaTaleplerim(String kullaniciAd) throws SQLException {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.kullaniciAd = kullaniciAd;
        Taleplerim();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myJTable = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        BtnOnay = new javax.swing.JButton();
        BtnRed = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnGeri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 50));

        myJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Talep No", "Öğrenci Ad Soyad", "Ders Adı"
            }
        ));
        jScrollPane1.setViewportView(myJTable);

        BtnOnay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        BtnOnay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOnayActionPerformed(evt);
            }
        });

        BtnRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        BtnRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Talep Seç:");

        BtnGeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        BtnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(BtnOnay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnRed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(BtnOnay, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(BtnRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOnayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOnayActionPerformed
        connection = DatabaseConnection.getConnection();

        int secim = Integer.parseInt(jComboBox1.getSelectedItem().toString()) - 1;
        String hocaAdi = "";
        String ogrenciAdSoyad = myJTable.getValueAt(secim, 1).toString();
        String ogrenciDers = myJTable.getValueAt(secim, 2).toString();

        try {
            //Hocanın adsoyadı veritabanından çeker
            String selectAd = "SELECT adsoyad FROM hoca WHERE kullaniciad = ?";
            PreparedStatement pstm = connection.prepareStatement(selectAd);
            pstm.setString(1, kullaniciAd);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                hocaAdi = resultSet.getString("adsoyad");
            } else {
            }

        } catch (SQLException ex) {

        }

        try {
            //Dersi öğrenciye ekler
            String insert = "UPDATE ogrenci "
                    + "SET alacagidersad = array_append(alacagidersad, ?), alacagidershoca = array_append(alacagidershoca, ?) "
                    + "WHERE adsoyad = ?";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, ogrenciDers);
            ps.setString(2, hocaAdi);
            ps.setString(3, ogrenciAdSoyad);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }

        try {
            //Öğrencinin talep derslerden ilgili ders silinir
            String deleteO = "UPDATE ogrenci "
                    + "SET talepdersad = array_remove(talepdersad, ?) "
                    + "WHERE ? = ANY(talepdersad)";
            PreparedStatement ps2 = connection.prepareStatement(deleteO);
            ps2.setString(1, ogrenciDers);
            ps2.setString(2, ogrenciDers);
            ps2.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Öğrencinin talep derslerden ilgili hocanın adı silinir
            String deleteH = "UPDATE ogrenci "
                    + "SET talepdershoca = array_remove(talepdershoca, ?) "
                    + "WHERE ? = ANY(talepdershoca)";
            PreparedStatement ps3 = connection.prepareStatement(deleteH);
            ps3.setString(1, hocaAdi);
            ps3.setString(2, hocaAdi);
            ps3.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Hocanın talep edilenlerden ilgili ders silinir
            String deleteO = "UPDATE hoca "
                    + "SET gelentalepad = array_remove(gelentalepad, ?) "
                    + "WHERE ? = ANY(gelentalepad)";
            PreparedStatement ps2 = connection.prepareStatement(deleteO);
            ps2.setString(1, ogrenciAdSoyad);
            ps2.setString(2, ogrenciAdSoyad);
            ps2.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Hocanın talep edilenlerden ilgili öğrenci silinir
            String deleteH = "UPDATE hoca "
                    + "SET gelentalepders = array_remove(gelentalepders, ?) "
                    + "WHERE ? = ANY(gelentalepders)";
            PreparedStatement ps3 = connection.prepareStatement(deleteH);
            ps3.setString(1, ogrenciDers);
            ps3.setString(2, ogrenciDers);
            ps3.executeUpdate();

        } catch (SQLException ex) {
        }
        
        try {
            //Öğrencinin anlasma durumu setlenir
            String updateSQLO = "UPDATE ogrenci "
                    + "SET anlasmadurumu = 1 "
                    + "WHERE adsoyad = ?";
            PreparedStatement pre = connection.prepareStatement(updateSQLO);
            pre.setString(1, ogrenciAdSoyad);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }

        try {
            //Hocanın kontenjanı 1 azaltılır
            String updateSQL = "UPDATE hoca SET kontenjan = kontenjan -1 WHERE kullaniciad = ?";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setString(1, kullaniciAd);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
        }
        
    }//GEN-LAST:event_BtnOnayActionPerformed

    private void BtnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRedActionPerformed
        connection = DatabaseConnection.getConnection();

        int secim = Integer.parseInt(jComboBox1.getSelectedItem().toString()) - 1;
        String hocaAdi = "";
        String ogrenciAdSoyad = myJTable.getValueAt(secim, 1).toString();
        String ogrenciDers = myJTable.getValueAt(secim, 2).toString();

        try {
            String selectAd = "SELECT adsoyad FROM hoca WHERE kullaniciad = ?";
            PreparedStatement pstm = connection.prepareStatement(selectAd);
            pstm.setString(1, kullaniciAd);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                hocaAdi = resultSet.getString("adsoyad");
            } else {
            }

        } catch (SQLException ex) {

        }
        
        try {
            String deleteO = "UPDATE ogrenci "
                    + "SET talepdersad = array_remove(talepdersad, ?) "
                    + "WHERE ? = ANY(talepdersad)";
            PreparedStatement ps2 = connection.prepareStatement(deleteO);
            ps2.setString(1, ogrenciDers);
            ps2.setString(2, ogrenciDers);
            ps2.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Bütün ahmet hocaları siliyor, pls silmesin any değişecek
            String deleteH = "UPDATE ogrenci "
                    + "SET talepdershoca = array_remove(talepdershoca, ?) "
                    + "WHERE ? = ANY(talepdershoca)";
            PreparedStatement ps3 = connection.prepareStatement(deleteH);
            ps3.setString(1, hocaAdi);
            ps3.setString(2, hocaAdi);
            ps3.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Bütün öğrenci ismini siliyor, pls silmesin any değişecek
            String deleteO = "UPDATE hoca "
                    + "SET gelentalepad = array_remove(gelentalepad, ?) "
                    + "WHERE ? = ANY(gelentalepad)";
            PreparedStatement ps2 = connection.prepareStatement(deleteO);
            ps2.setString(1, ogrenciAdSoyad);
            ps2.setString(2, ogrenciAdSoyad);
            ps2.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            String deleteH = "UPDATE hoca "
                    + "SET gelentalepders = array_remove(gelentalepders, ?) "
                    + "WHERE ? = ANY(gelentalepders)";
            PreparedStatement ps3 = connection.prepareStatement(deleteH);
            ps3.setString(1, ogrenciDers);
            ps3.setString(2, ogrenciDers);
            ps3.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            String updateSQLO = "UPDATE ogrenci "
                    + "SET anlasmadurumu = 2 "
                    + "WHERE adsoyad = ?";
            PreparedStatement pre = connection.prepareStatement(updateSQLO);
            pre.setString(1, ogrenciAdSoyad);
            pre.executeUpdate();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_BtnRedActionPerformed

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HocaTaleplerim(kullaniciAd).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HocaTaleplerim.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void Taleplerim() throws SQLException {
        connection = DatabaseConnection.getConnection();

        String sorgu = "SELECT unnest(gelentalepad) as ograd, "
                + "unnest(gelentalepders) as ders "
                + "FROM hoca "
                + "WHERE kullaniciad = ?";
        PreparedStatement ps = connection.prepareStatement(sorgu);
        ps.setString(1, kullaniciAd);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Talep No");
        tableModel.addColumn("Öğrenci Ad Soyad");
        tableModel.addColumn("Ders Adı");

        int no = 1;
        while (rs.next()) {
            String ad = rs.getString("ograd");
            String ders = rs.getString("ders");
            Object[] row = {Integer.toString(no), ad, ders};
            tableModel.addRow(row);
            jComboBox1.addItem(Integer.toString(no));
            no++;
        }
        myJTable.setModel(tableModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGeri;
    private javax.swing.JButton BtnOnay;
    private javax.swing.JButton BtnRed;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myJTable;
    // End of variables declaration//GEN-END:variables
}
