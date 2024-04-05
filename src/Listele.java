
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.management.Query.value;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Listele extends javax.swing.JFrame {

    Connection connection = null;

    public Listele() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        try {
            connection = DatabaseConnection.getConnection();
            Listeleme();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        myJTable = new javax.swing.JTable();
        BtnKapat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 50));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        myJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Ad Soyad", "Geçmiş Dersler", "Geçmiş Dersler Notları", "Agno", "Alacağı Dersler", "Alacağı Dersler Hocaları"
            }
        ));
        jScrollPane2.setViewportView(myJTable);

        BtnKapat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        BtnKapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKapatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnKapat)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnKapat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKapatActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKapatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listele().setVisible(true);
            }
        });
    }

    public void Listeleme() throws SQLException {

        connection = DatabaseConnection.getConnection();

        String sorgu = "SELECT adsoyad FROM ogrenci";
        PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
        ResultSet resultSet = preparedStatement.executeQuery();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        while (resultSet.next()) {
            String ogrAd = resultSet.getString("adsoyad");
            listModel.addElement(ogrAd);
        }
        resultSet.close();
        preparedStatement.close();
        jList1.setModel(listModel);
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            @SuppressWarnings("empty-statement")
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedOgrAd = jList1.getSelectedValue();

                    try {
                        DefaultTableModel tableModel = new DefaultTableModel();
                        tableModel.addColumn("Öğrenci No");
                        tableModel.addColumn("Ad Soyad");
                        tableModel.addColumn("Geçmiş Dersler");
                        tableModel.addColumn("Geçmiş Dersler Notları");
                        tableModel.addColumn("AGNO");
                        tableModel.addColumn("Alacağı Dersler");
                        tableModel.addColumn("Alacağı Dersi Veren Hoca");

                        String sql = "SELECT * FROM ogrenci WHERE adsoyad = ?";
                        PreparedStatement psmt = connection.prepareStatement(sql);
                        psmt.setString(1, selectedOgrAd);
                        ResultSet rslt = psmt.executeQuery();

                        int ogrNo = 0;
                        String ad = "";
                        float agno = 0;
                        List<String> gders = new ArrayList<>();
                        List<String> gdersnot = new ArrayList<>();
                        List<String> aders = new ArrayList<>();
                        List<String> ahoca = new ArrayList<>();

                        while (rslt.next()) {
                            ogrNo = rslt.getInt("no");
                            ad = rslt.getString("adsoyad");
                            agno = rslt.getFloat("agno");

                            String sql2 = "SELECT unnest(gecmisdersler) as gders, "
                                    + "unnest (gecmisderslernot) as gdersnot, "
                                    + "unnest (alacagidersad) as aders, "
                                    + "unnest (alacagidershoca) as ahoca "
                                    + "FROM ogrenci "
                                    + "WHERE adsoyad = ?";
                            PreparedStatement psmt2 = connection.prepareStatement(sql2);
                            psmt2.setString(1, jList1.getSelectedValue());
                            ResultSet rslt2 = psmt2.executeQuery();

                            while (rslt2.next()) {
                                gders.add(rslt2.getString("gders"));
                                gdersnot.add(rslt2.getString("gdersnot"));
                                aders.add(rslt2.getString("aders"));
                                ahoca.add(rslt2.getString("ahoca"));
                            }

                        }
                        Object[] row = {Integer.toString(ogrNo), ad, gders.get(0), gdersnot.get(0), Float.toString(agno), aders.get(0), ahoca.get(0)};
                        tableModel.addRow(row);
                        for (int x = 1; x < gders.size() - 1; x++) {
                            Object[] row2 = {"", "", gders.get(x), gdersnot.get(x), "", aders.get(x), ahoca.get(x)};
                            tableModel.addRow(row2);
                        }
                        myJTable.setModel(tableModel);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnKapat;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myJTable;
    // End of variables declaration//GEN-END:variables
}
