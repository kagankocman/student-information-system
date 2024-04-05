
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class IlgıAlaniSecHoca extends javax.swing.JFrame {

    public static String kullaniciAd;
    Connection connection = null;
    private List<JCheckBox> ilgiAlanCheckBoxes = new ArrayList<>();
    private JButton kaydetButton = new JButton("Kaydet");
    private JPanel contentPanel = new JPanel();

    public IlgıAlaniSecHoca(String kullaniciAd) {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.kullaniciAd = kullaniciAd;

        connection = DatabaseConnection.getConnection();

        try {
            DbdenCekYaz();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        int y = 20;
        for (JCheckBox checkBox : ilgiAlanCheckBoxes) {
            checkBox.setBounds(20, y, 150, 25);
            contentPanel.add(checkBox);
            y += 30;
        }
        kaydetButton.setBounds(20, y, 150, 30);
        contentPanel.add(kaydetButton);
        contentPanel.setPreferredSize(new java.awt.Dimension(200, y + 70));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(20, 20, 200, 200);
        getContentPane().add(scrollPane);

        kaydetButton.addActionListener(e -> {
            try {
                List<String> secilenIlgiAlanlari = new ArrayList<>();
                for (JCheckBox checkBox : ilgiAlanCheckBoxes) {
                    if (checkBox.isSelected()) {
                        String ilgiAlani = checkBox.getText();
                        secilenIlgiAlanlari.add(ilgiAlani);
                    }
                }
                if (!secilenIlgiAlanlari.isEmpty()) {
                    for (String ilgiAlani : secilenIlgiAlanlari) {
                        String updateSQL = "UPDATE hoca SET ilgialani = array_append(ilgialani, ?) WHERE kullaniciad = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
                        preparedStatement.setString(1, ilgiAlani);
                        preparedStatement.setString(2, kullaniciAd);
                        preparedStatement.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(this, "Seçilen ilgi alanları kaydedildi.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "ilgi alanlari kaydedilemedi.", "hata", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void DbdenCekYaz() throws SQLException {
        String sql = "SELECT ad FROM ilgialani";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rslt = psmt.executeQuery();

        List<String> ilgiAlanlari = new ArrayList<>();

        while (rslt.next()) {
            String ilgiAlani = rslt.getString("ad");
            ilgiAlanlari.add(ilgiAlani);
        }

        for (String ilgiAlani : ilgiAlanlari) {
            JCheckBox checkBox = new JCheckBox(ilgiAlani);
            ilgiAlanCheckBoxes.add(checkBox);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnKapat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));
        setSize(new java.awt.Dimension(700, 500));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(BtnKapat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addComponent(BtnKapat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                new IlgıAlaniSecHoca(kullaniciAd).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnKapat;
    // End of variables declaration//GEN-END:variables
}
