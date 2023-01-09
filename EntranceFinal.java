//import required classes and packages
 import java.util.Scanner;
 import java.sql.*;
 class EntranceFinal {

 	//Creates the Entrance Page
 	public static void main(String[] args)
 	                          throws Exception
 	    {
 	        Entrancepage p = new Entrancepage();

 	       Connection conn = null;
			try {

               Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:C:\\\\\\\\Users\\\\\\\\user\\\\\\\\Desktop\\\\\\\\SQLITE\\\\\\\\sqlite-tools-win32-x86-3400100\\\\\\\\sqlite-tools-win32-x86-3400100//intune1.db");

				//create user table
				String sqlinsert = "CREATE TABLE User" +
                                  "(name     TEXT (100)  NOT NULL," +
                                  "username  TEXT (25)   PRIMARY KEY NOT NULL UNIQUE," +
                                  "password  TEXT (25)   NOT NULL UNIQUE," +
                                  "passcheck TEXT (25)   NOT NULL," +
                                  "gender    TEXT (6)    NOT NULL," +
                                  "age       INTEGER (2) NOT NULL)" ;


				PreparedStatement pstmt1 = conn.prepareStatement(sqlinsert);
				pstmt1.executeUpdate();

               pstmt1.close();

               //create post table
               sqlinsert = " CREATE TABLE Post" +
                           "(postext  TEXT (5000)," +
                           "username  REFERENCES User (username) MATCH SIMPLE," +
                           "postno    INTEGER     PRIMARY KEY)";


				PreparedStatement pstmt2 = conn.prepareStatement(sqlinsert);
				pstmt2.executeUpdate();

               pstmt2.close();

               //create messages table
				sqlinsert = " CREATE TABLE Messages" +
                           "(textmessage TEXT        NOT NULL," +
                           "textfrom     TEXT        REFERENCES User (username) NOT NULL," +
                           " texto       TEXT        REFERENCES User (username) NOT NULL," +
                           "status       INTEGER (1) NOT NULL," +
                           " textno      INTEGER     PRIMARY KEY NOT NULL)";


				PreparedStatement pstmt3 = conn.prepareStatement(sqlinsert);
				pstmt3.executeUpdate();

               pstmt3.close();

               //create friends table
				sqlinsert = " CREATE TABLE Friends" +
                           "(fusername TEXT REFERENCES User (username) NOT NULL," +
                           "friendusername TEXT REFERENCES User (username))";


				PreparedStatement pstmt4 = conn.prepareStatement(sqlinsert);
				pstmt4.executeUpdate();

               pstmt4.close();




			}catch (Exception ex) {

           }finally {
               if (conn != null) {
                   try {
                       conn.close();
                   } catch (SQLException exc) {
                   }
               }

		   }


 	        
     }

}