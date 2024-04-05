import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/dbdeneme";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2754";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına bağlantı sağlandı.");
        } catch (SQLException e) {
            System.err.println("Veritabanına bağlantı sağlanamadı: " + e.getMessage());
        }
        return connection;
    }

    // Kullanıcı girişini doğrulayan metot
    public static boolean verifyPassword(String kullaniciAdi, String sifre, String kullaniciTuru) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = getConnection();
        String query = "SELECT * FROM " + kullaniciTuru + " WHERE kullaniciad = ? AND sifre = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, kullaniciAdi);
        preparedStatement.setString(2, sifre);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String storedPassword = resultSet.getString("sifre"); // Şifre bilgisini veritabanından alın
            // Kullanıcı tarafından girilen şifreyi ve saklanan şifreyi karşılaştır
            return storedPassword.equals(sifre);
        }
        return false; // Kullanıcı adı bulunamadı
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Hata durumunda false döner
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Bağlantı kapatma hatası: " + e.getMessage());
        }
    }
}
}