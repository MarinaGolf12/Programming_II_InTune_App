import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Marina\\Desktop\\DMST\\sophomore year\\1st semester\\Progr II";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public Insert(String name, String username, String password, String passcheck, String gender, String age) {
        String sql = "INSERT INTO User(name, username, password, passcheck, gender, age) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, passcheck);
            pstmt.setString(5, gender);
            pstmt.setString(6, age);
            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}