
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OgrenciTalepEt extends javax.swing.JFrame {

    public static String kullaniciAd;

    Connection connection = null;

    public OgrenciTalepEt(String kullaniciAd) throws SQLException {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.kullaniciAd = kullaniciAd;
        OgrenciTalep();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        myJTable = new javax.swing.JTable();
        BtnGeri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ComboDersler = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ComboOgrenciler = new javax.swing.JComboBox<>();
        BtnOgrTalepEt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));

        myJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Öğrenci No", "Öğrenci Ad Soyad", "İlgi Alanları"
            }
        ));
        jScrollPane2.setViewportView(myJTable);

        BtnGeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        BtnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeriActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Derslerim:");

        ComboDersler.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Öğrenci Seç:");

        ComboOgrenciler.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        BtnOgrTalepEt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnOgrTalepEt.setText("Talep Et");
        BtnOgrTalepEt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOgrTalepEtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboDersler, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboOgrenciler, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnOgrTalepEt)
                        .addGap(216, 216, 216))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboDersler, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboOgrenciler, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnOgrTalepEt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    private void BtnOgrTalepEtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOgrTalepEtActionPerformed
        connection = DatabaseConnection.getConnection();
        String ogrenciAdSoyad = ComboOgrenciler.getSelectedItem().toString();
        String selectedDers = ComboDersler.getSelectedItem().toString();
        String hocaAdSoyad = null;

        try {
            String selectSQL = "SELECT adsoyad from hoca where kullaniciad = ?";
            PreparedStatement ps = connection.prepareStatement(selectSQL);
            ps.setString(1, kullaniciAd);
            ResultSet resultSet = ps.executeQuery();
            
            if (resultSet.next()) {
                hocaAdSoyad = resultSet.getString("adsoyad");
            } else {
                // Belirtilen kullanıcı adına sahip öğrenci bulunamadı.
                // İsterseniz burada bir hata mesajı oluşturabilirsiniz.
            }
        } catch (SQLException ex) {
        }

        int kontenjan = 0;
        try {
            String selectK = "SELECT kontenjan from hoca where adsoyad = ?";
            PreparedStatement prepare = connection.prepareStatement(selectK);
            prepare.setString(1, hocaAdSoyad);
            ResultSet resultS = prepare.executeQuery();
            if (resultS.next()) {
                kontenjan = resultS.getInt("kontenjan");
            } else {
            }
        } catch (SQLException ex) {
        }
        if (kontenjan == 0) {
            JOptionPane.showMessageDialog(this, "Kontenjan dolu.");
        } else {
            try {
                //Hocanın talep ettiği öğrenci hocanın tabloya dersle birlikte eklenir
                String updateSQLO = "UPDATE hoca "
                        + "SET talepogrenci = array_append(talepogrenci, ?), talepogrenciders = array_append(talepogrenciders, ?), "
                        + "WHERE kullaniciad = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateSQLO);
                preparedStatement.setString(1, ogrenciAdSoyad);
                preparedStatement.setString(2, selectedDers);
                preparedStatement.setString(3, kullaniciAd);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (SQLException ex) {
            }
               
            try {
                //Öğrenci tablosuna hocayı ve dersi ekler
                String updateSQLO = "UPDATE ogrenci "
                        + "SET gelentalepad = array_append(gelentalepad, ?), gelentalepders = array_append(gelentalepders, ?), anlasmadurumu = 3 "
                        + "WHERE adsoyad = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateSQLO);
                preparedStatement.setString(1, hocaAdSoyad);
                preparedStatement.setString(2, selectedDers);
                preparedStatement.setString(3, ogrenciAdSoyad);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_BtnOgrTalepEtActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new OgrenciTalepEt(kullaniciAd).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(OgrenciTalepEt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void OgrenciTalep() throws SQLException {

        connection = DatabaseConnection.getConnection();

        try {
            String sorgu = "SELECT adsoyad FROM ogrenci WHERE anlasmadurumu IN (0, 2, 3)";
            PreparedStatement psmt = connection.prepareStatement(sorgu);
            ResultSet rslt = psmt.executeQuery();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Öğrenci No");
            tableModel.addColumn("Öğrenci Ad Soyad");
            tableModel.addColumn("Öğrenci İlgi Alanı");

            int no = 1;
            while (rslt.next()) {
                String ad = rslt.getString("adsoyad");
                String sql2 = "SELECT unnest(ilgialani) as ilgi FROM ogrenci WHERE adsoyad = ?";
                PreparedStatement psmt2 = connection.prepareStatement(sql2);
                psmt2.setString(1, ad);
                ResultSet rslt2 = psmt2.executeQuery();
                String ilgi = "";
                while (rslt2.next()) {
                    ilgi += rslt2.getString("ilgi") + ",";
                }
                Object[] row = {Integer.toString(no), ad, ilgi};
                tableModel.addRow(row);
                ComboOgrenciler.addItem(ad);
                no++;
            }
            myJTable.setModel(tableModel);
        } catch (SQLException ex) {
        }
        try {

            String sorgu2 = "SELECT unnest(verecegidersler) as ders "
                    + "FROM hoca WHERE kullaniciad = ?";
            PreparedStatement ps = connection.prepareStatement(sorgu2);
            ps.setString(1, kullaniciAd);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String ders = rs.getString("ders");
                ComboDersler.addItem(ders);
            }
        } catch (SQLException ex) {
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGeri;
    private javax.swing.JButton BtnOgrTalepEt;
    private javax.swing.JComboBox<String> ComboDersler;
    private javax.swing.JComboBox<String> ComboOgrenciler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myJTable;
    // End of variables declaration//GEN-END:variables
}
