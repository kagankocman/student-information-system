
import com.github.jaiimageio.impl.plugins.tiff.TIFFPackBitsUtil;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBProcess {

    public static List<Ders> dersAdlariEkle(String kullaniciAd) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        OgrenciPanel ogrenci = new OgrenciPanel(OgrenciPanel.kullaniciAd);
        ogrenci.setVisible(false);
        String ocrCikti = ogrenci.getOcrCikti();
        StringBuilder dersAdlari = new StringBuilder();
        String desen = "\\b([A-Z]+[0-9]+[A-Z]*\\d*)\\s([^Z]+)\\s";
        Pattern pattern = Pattern.compile(desen);
        Matcher matcher = pattern.matcher(ocrCikti);

        List<Ders> gecmisDersler = new ArrayList<>();

        while (matcher.find()) {
            dersAdlari.setLength(0);
            String potansiyelDersAdi = (dersAdlari.append(matcher.group(2)).append("\n")).toString();

            if (!Character.isLetter(potansiyelDersAdi.charAt(0))) {
                continue;
            }

            if (!(dersAdiUygunMu(potansiyelDersAdi))) {
                if (potansiyelDersAdi.startsWith("TAKTS:30") || potansiyelDersAdi.startsWith("\"* *\"") || potansiyelDersAdi.startsWith("Top")) {
                } else {
                    Ders ders = new Ders(potansiyelDersAdi);
                    gecmisDersler.add(ders);
                }
            }
        }
        for (int x = 0; x < gecmisDersler.size(); x++) {
            String insertSQL = "UPDATE ogrenci SET gecmisdersler = array_append(gecmisdersler, ?) WHERE kullaniciad = ?";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, gecmisDersler.get(x).ad);
            pstmt.setString(2, kullaniciAd);
            pstmt.executeUpdate();
        }
        return gecmisDersler;
    }
    
    public static boolean dersAdiUygunMu(String ad) {
        String desen = ("([^Z]+)\\sZ");
        return ad.matches(desen);
    }
}
