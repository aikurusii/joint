package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Rbook;

public class Booksdao {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	
	public static List<Rbook>Rbooks(){
		List<Rbook> result=new ArrayList<>();
		 String sql = "SELECT books.title, books.author, books.isbn, books.publisher,books.status, AVG(rat.rating) as avg_rating " +
                 "FROM books " +
                 "LEFT JOIN rat ON books.isbn = rat.risbn " +
                 "GROUP BY books.title, books.author, books.isbn, books.publisher";
		 try(
				 Connection con = getConnection();
		 Statement stmt = con.createStatement()){;
        try(ResultSet rs = stmt.executeQuery(sql)){
    while (rs.next()) {
        String title = rs.getString("title");
        String author = rs.getString("author");
        String isbn = rs.getString("isbn");
        String publisher = rs.getString("publisher");
        double rating =rs.getDouble("rating");
        int status=rs.getInt("status");
        String st ="×";
        if(status==1) {
        	st="〇";
        	Rbook rbook=new Rbook(title,author,isbn,publisher,rating,st);
        	result.add(rbook);
        }
        
    }
        }
		 } catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			return result;
			
		}
}
