import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Metotlar {

    public static List<Ogrenci> ogrenciOlustur(int s) {

        List<Ders> gecmisdersler = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT gecmisdersler FROM ogrenci WHERE kullaniciad = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "asli");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String[] textArray = (String[]) resultSet.getArray("gecmisdersler").getArray();
                for (String text : textArray) {
                    Ders ders = new Ders(text);
                    gecmisdersler.add(ders);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metotlar.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Ogrenci> ogrenciler = new ArrayList<>();
        for (int counter = 0; counter < s; counter++) {
            Ogrenci ogrenci = new Ogrenci();
            ogrenci.no = counter;
            ogrenci.adsoyad = "Ad Soyad" + " " + counter;
            ogrenci.kullaniciad = "kullanici" + counter;
            ogrenci.sifre = "sfr" + counter;
            for (int x = 0; x < gecmisdersler.size(); x++) {
                ogrenci.gecmisDersler.add(gecmisdersler.get(x));
                ogrenci.gecmisDerslerNot.add(randomNotOlustur());
            }
            ogrenci.agno = agnoHesapla(ogrenci.gecmisDerslerNot);
            //System.out.println(ogrenci.agno);
            ogrenciler.add(ogrenci);
        }
        return ogrenciler;
    }

    public static String randomNotOlustur() {
        Random random = new Random();
        String not = null;
        int randomSayi = random.nextInt(7);
        if (randomSayi == 0) {
            not = "AA";
        } else if (randomSayi == 1) {
            not = "BA";
        } else if (randomSayi == 2) {
            not = "BB";
        } else if (randomSayi == 3) {
            not = "CC";
        } else if (randomSayi == 4) {
            not = "DC";
        } else if (randomSayi == 5) {
            not = "DD";
        } else if (randomSayi == 6) {
            not = "FF";
        }
        return not;
    }

    public static float agnoHesapla(List<String> gecmisDerslerNot) {
        float gecmeNotu = 0;
        for (int x = 0; x < gecmisDerslerNot.size(); x++) {
            if (gecmisDerslerNot.get(x).equals("AA")) {
                gecmeNotu += (float) 4.0;
            } else if (gecmisDerslerNot.get(x).equals("BA")) {
                gecmeNotu += (float) 3.5;
            } else if (gecmisDerslerNot.get(x).equals("BB")) {
                gecmeNotu += (float) 3.0;
            } else if (gecmisDerslerNot.get(x).equals("CC")) {
                gecmeNotu += (float) 2.5;
            } else if (gecmisDerslerNot.get(x).equals("DC")) {
                gecmeNotu += (float) 1.5;
            } else if (gecmisDerslerNot.get(x).equals("DD")) {
                gecmeNotu += (float) 1.0;
            } else if (gecmisDerslerNot.get(x).equals("FF")) {
                gecmeNotu += (float) 0.0;
            }
        }
        //System.out.println(gecmeNotu + " / " + gecmisDerslerNot.size());
        return (gecmeNotu / (float) gecmisDerslerNot.size());
    }

    public static void ogrencileriDByaz(List<Ogrenci> ogrenciler) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        try {
            for (int x = 0; x < ogrenciler.size(); x++) {
                String sql = "INSERT INTO ogrenci (no, adsoyad, kullaniciad, sifre, agno) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, ogrenciler.get(x).no);
                preparedStatement.setString(2, ogrenciler.get(x).adsoyad);
                preparedStatement.setString(3, ogrenciler.get(x).kullaniciad);
                preparedStatement.setString(4, ogrenciler.get(x).sifre);
                preparedStatement.setFloat(5, ogrenciler.get(x).agno);
                preparedStatement.executeUpdate();

                try {
                    for (int y = 0; y < ogrenciler.get(x).gecmisDersler.size(); y++) {
                        String insert = "UPDATE ogrenci SET gecmisdersler = array_append(gecmisdersler, ?) WHERE kullaniciad = ?";
                        PreparedStatement pstmt = conn.prepareStatement(insert);
                        pstmt.setString(1, ogrenciler.get(x).gecmisDersler.get(y).ad);
                        pstmt.setString(2, ogrenciler.get(x).kullaniciad);
                        pstmt.executeUpdate();
                        try {
                            String insertSQL = "UPDATE ogrenci SET gecmisderslernot = array_append(gecmisderslernot, ?) WHERE kullaniciad = ?";
                            PreparedStatement pstmt2 = conn.prepareStatement(insertSQL);
                            pstmt2.setString(1, ogrenciler.get(x).gecmisDerslerNot.get(y));
                            pstmt2.setString(2, ogrenciler.get(x).kullaniciad);
                            pstmt2.executeUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(Metotlar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Metotlar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metotlar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
