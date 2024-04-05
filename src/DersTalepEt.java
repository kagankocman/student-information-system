
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

public final class DersTalepEt extends javax.swing.JFrame {

    public static String kullaniciAd;
    Connection connection = null;

    public DersTalepEt(String kullaniciAd) throws SQLException {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.kullaniciAd = kullaniciAd;
        DersTalep();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        myJTable = new javax.swing.JTable();
        BtnGeri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnTalep = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));

        jScrollPane1.setViewportView(jList1);

        myJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Hoca Ad Soyad", "Hoca İlgi Alanı"
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
        jLabel1.setText("NO:");

        BtnTalep.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        BtnTalep.setText("Talep");
        BtnTalep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTalepActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chat.png"))); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnTalep, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnTalep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(BtnGeri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeriActionPerformed
        dispose();
    }//GEN-LAST:event_BtnGeriActionPerformed

    private void BtnTalepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTalepActionPerformed
        int selectedRow = Integer.parseInt(jComboBox1.getSelectedItem().toString()) - 1;
        int selectedColumn = 1;
        Object hocaAdSoyad = myJTable.getValueAt(selectedRow, selectedColumn);
        connection = DatabaseConnection.getConnection();
        String talepDersAd = jList1.getSelectedValue();
        String talepDersHoca = hocaAdSoyad.toString();

        int kontenjan = 0;

        try {
            String selectK = "SELECT kontenjan from hoca where adsoyad = ?";
            PreparedStatement prepare = connection.prepareStatement(selectK);
            prepare.setString(1, talepDersHoca);

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
                String updateSQLO = "UPDATE ogrenci "
                        + "SET talepdersad = array_append(talepdersad, ?), talepdershoca = array_append(talepdershoca, ?), anlasmadurumu = 3 "
                        + "WHERE kullaniciad = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateSQLO);
                preparedStatement.setString(1, talepDersAd);
                preparedStatement.setString(2, talepDersHoca);
                preparedStatement.setString(3, kullaniciAd);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (SQLException ex) {
            }

            String ogrenciAd = "";
            try {
                String selectSQL = "SELECT adsoyad from ogrenci where kullaniciad = ?";
                PreparedStatement ps = connection.prepareStatement(selectSQL);
                ps.setString(1, kullaniciAd);

                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    ogrenciAd = resultSet.getString("adsoyad");
                } else {
                    // Belirtilen kullanıcı adına sahip öğrenci bulunamadı.
                    // İsterseniz burada bir hata mesajı oluşturabilirsiniz.
                }
            } catch (SQLException ex) {
            }

            try {
                String updateSQLH = "UPDATE hoca "
                        + "SET gelentalepad = array_append(gelentalepad, ?), gelentalepders = array_append(gelentalepders, ?) "
                        + "WHERE adsoyad = ?";
                PreparedStatement preparedStatement2 = connection.prepareStatement(updateSQLH);
                preparedStatement2.setString(1, ogrenciAd);
                preparedStatement2.setString(2, talepDersAd);
                preparedStatement2.setString(3, talepDersHoca);
                preparedStatement2.executeUpdate();
                preparedStatement2.close();

            } catch (SQLException ex) {
            }
        }


    }//GEN-LAST:event_BtnTalepActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DersTalepEt(kullaniciAd).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DersTalepEt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void DersTalep() throws SQLException {

        connection = DatabaseConnection.getConnection();

        String sorgu = "SELECT ad FROM verilecekdersler";
        PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
        ResultSet resultSet = preparedStatement.executeQuery();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        while (resultSet.next()) {
            String dersAd = resultSet.getString("ad");
            listModel.addElement(dersAd);
        }
        resultSet.close();
        preparedStatement.close();
        jList1.setModel(listModel);
        jList1.addListSelectionListener(e -> {
            jComboBox1.removeAllItems();
            if (!e.getValueIsAdjusting()) {
                String selectedDersAd = jList1.getSelectedValue();
                try {
                    String sql = "SELECT unnest(verenhoca) as hocaad FROM verilecekdersler WHERE ad = ?";
                    PreparedStatement psmt = connection.prepareStatement(sql);
                    psmt.setString(1, selectedDersAd);
                    ResultSet rslt = psmt.executeQuery();

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("NO");
                    tableModel.addColumn("Hoca Ad Soyad");
                    tableModel.addColumn("Hoca İlgi Alanı");

                    int no = 1;
                    while (rslt.next()) {
                        String ad = rslt.getString("hocaad");

                        String sql2 = "SELECT unnest(ilgialani) as ilgi FROM hoca WHERE adsoyad = ?";
                        PreparedStatement psmt2 = connection.prepareStatement(sql2);
                        psmt2.setString(1, ad);
                        ResultSet rslt2 = psmt2.executeQuery();
                        String ilgi = "";
                        while (rslt2.next()) {
                            ilgi += rslt2.getString("ilgi") + ",";
                        }
                        Object[] row = {Integer.toString(no), ad, ilgi};
                        tableModel.addRow(row);
                        jComboBox1.addItem(Integer.toString(no));
                        no++;
                    }
                    myJTable.setModel(tableModel);
                } catch (SQLException ex) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGeri;
    private javax.swing.JButton BtnTalep;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myJTable;
    // End of variables declaration//GEN-END:variables
}
