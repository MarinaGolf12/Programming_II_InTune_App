package application;

//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**Declare CheckFriends class.*/
class CheckFriends {

  /**check that a name given belongs to an already registered user.*/
  public static boolean friendExists(final String friend) {

      boolean flag = true;
      Connection conn = null;
      try {

          Class.forName("org.sqlite.JDBC");
	        conn = DriverManager.getConnection(
	        		"jdbc:sqlite:C://Users//Marina//"
	        		+ "Desktop//DMST//sophomore year//"
	        		+ "1st semester//Progr II//CODE//"
	        		+ "Original Code//INTUNE.db");
	        String sqlinsert =
	        		"SELECT * FROM User WHERE username LIKE ?";
	        PreparedStatement pstmt =
	        		conn.prepareStatement(sqlinsert);
	        pstmt.setString(1, friend);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            flag = true;
	        } else {
	            flag = false;
	        }

	    } catch (Exception ex) {
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException exc) {
	            }
	        }
	    }

	    return flag;

  }

}
