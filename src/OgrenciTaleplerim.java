
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class OgrenciTaleplerim extends javax.swing.JFrame {

    public static String kullaniciAd;
    Connection connection = null;

    public OgrenciTaleplerim(String kullaniciAd) throws SQLException {
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
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BtnOnay = new javax.swing.JButton();
        BtnGeri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));

        myJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Talep No", "Hoca Ad Soyad", "Ders Adı"
            }
        ));
        jScrollPane1.setViewportView(myJTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Talep Seç:");

        BtnOnay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        BtnOnay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOnayActionPerformed(evt);
            }
        });

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
                .addGap(479, 531, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(BtnOnay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(BtnOnay, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOnayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOnayActionPerformed
        connection = DatabaseConnection.getConnection();

        int secim = Integer.parseInt(jComboBox1.getSelectedItem().toString()) - 1;
        String ogrenciAdSoyad = "";
        String hocaAdi= myJTable.getValueAt(secim, 1).toString();
        String selectedDers = myJTable.getValueAt(secim, 2).toString();

        try {
            //Öğrenci adsoyadı veritabanından çeker
            String selectAd = "SELECT adsoyad FROM ogrenci WHERE kullaniciad = ?";
            PreparedStatement pstm = connection.prepareStatement(selectAd);
            pstm.setString(1, kullaniciAd);
            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                ogrenciAdSoyad = resultSet.getString("adsoyad");
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
            ps.setString(1, selectedDers);
            ps.setString(2, hocaAdi);
            ps.setString(3, ogrenciAdSoyad);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }

        try {
            //öğrencinin gelentalep derslerden ilgili ders silinir
            String deleteO = "UPDATE ogrenci "
                    + "SET gelentalepders = array_remove(gelentalepders, ?) "
                    + "WHERE ? = ANY(gelentalepders)";
            PreparedStatement ps2 = connection.prepareStatement(deleteO);
            ps2.setString(1, selectedDers);
            ps2.setString(2, selectedDers);
            ps2.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Öğrencinin gelen talep derslerden ilgili hocanın adı silinir
            String deleteH = "UPDATE ogrenci "
                    + "SET gelentalepad = array_remove(gelentalepad, ?) "
                    + "WHERE ? = ANY(gelentalepad)";
            PreparedStatement ps3 = connection.prepareStatement(deleteH);
            ps3.setString(1, hocaAdi);
            ps3.setString(2, hocaAdi);
            ps3.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Hocanın talep edilenlerden ilgili ders silinir
            String deleteO = "UPDATE hoca "
                    + "SET talepogrenciders = array_remove(talepogrenciders, ?) "
                    + "WHERE ? = ANY(talepogrenciders)";
            PreparedStatement ps2 = connection.prepareStatement(deleteO);
            ps2.setString(1, selectedDers);
            ps2.setString(2, selectedDers);
            ps2.executeUpdate();

        } catch (SQLException ex) {
        }

        try {
            //Hocanın talep edilenlerden ilgili öğrenci silinir
            String deleteH = "UPDATE hoca "
                    + "SET talepogrenci = array_remove(talepogrenci, ?) "
                    + "WHERE ? = ANY(talepogrenci)";
            PreparedStatement ps3 = connection.prepareStatement(deleteH);
            ps3.setString(1, ogrenciAdSoyad);
            ps3.setString(2, ogrenciAdSoyad);
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
            String updateSQL = "UPDATE hoca SET kontenjan = kontenjan -1 WHERE adsoyad = ?";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setString(1, hocaAdi);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_BtnOnayActionPerformed

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new OgrenciTaleplerim(kullaniciAd).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(OgrenciTaleplerim.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }

    public void Taleplerim() throws SQLException {
        
        connection = DatabaseConnection.getConnection();

        String sorgu = "SELECT unnest(gelentalepad) as hocaad, "
                + "unnest(gelentalepders) as ders "
                + "FROM ogrenci "
                + "WHERE kullaniciad = ?";
        PreparedStatement ps = connection.prepareStatement(sorgu);
        ps.setString(1, kullaniciAd);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Talep No");
        tableModel.addColumn("Hoca Ad Soyad");
        tableModel.addColumn("Ders Adı");

        int no = 1;
        while (rs.next()) {
            String ad = rs.getString("hocaad");
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myJTable;
    // End of variables declaration//GEN-END:variables
}
