package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Book;
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
	
	
	
	public static List<Rbook> getAllBooks() {
        List<Rbook> books = new ArrayList<>();
        String sql = "SELECT books.title, books.author, books.publisher, books.isbn, " +
                "AVG(rat.rating) AS rating, " +
                "CASE WHEN loan.id IS NOT NULL THEN '〇' ELSE '×' END AS is_available " +
                "FROM books " +
                "LEFT JOIN rat ON books.id = rat.book_id " +
                "LEFT JOIN loan ON books.id = loan.book_id " +
                "GROUP BY books.isbn, loan.id " +
                "ORDER BY books.isbn";
        try {
            Connection con = getConnection();
            ResultSet rs = ((Statement) con).executeQuery(sql);
            while (rs.next()) {
                String title=rs.getString("title");
                String author=rs.getString("author");
                String publisher=rs.getString("publisher");
                String isbn=rs.getString("isbn");
                double setRating=rs.getFloat("rating");
                String Status=rs.getString("status");
                Rbook book = new Rbook(title, author, publisher, isbn, setRating, Status);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
			e.printStackTrace();
        }
        return books;
    }
	
	public static int registerBook(Book book) {
		String sql = "INSERT INTO books VALUES(default, ?, ?, ?, ?, ? )";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getIsbn());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getType());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	
		}
	
	public static List<Rbook> searchBooks(String keyword){
		List<Rbook> result = new ArrayList<>();
	    String sql = "SELECT books.title, books.author, books.isbn, books.publisher, AVG(rat.rating) AS avg_rating, CASE WHEN loan.book_id IS NOT NULL THEN '〇' ELSE '×' END AS is_loaned "
	        + "FROM books "
	        + "LEFT JOIN rat ON books.id = rat.book_id "
	        + "LEFT JOIN loan ON books.id = loan.book_id AND loan.returned_at IS NULL "
	        + "WHERE books.title LIKE ? OR books.author LIKE ? OR books.isbn LIKE ? OR books.publisher LIKE ? "
	        + "GROUP BY books.id, books.title, books.author, books.isbn, books.publisher, loan.book_id, rat.rating";
	    try (	Connection con = getConnection();
	    		PreparedStatement stmt = con.prepareStatement(sql)) {
	      stmt.setString(1, "%" + keyword + "%");
	      stmt.setString(2, "%" + keyword + "%");
	      stmt.setString(3, "%" + keyword + "%");
	      stmt.setString(4, "%" + keyword + "%");
	      ResultSet rs = stmt.executeQuery();
	      while (rs.next()) {
	    	  String title=rs.getString("title");
              String author=rs.getString("author");
              String publisher=rs.getString("publisher");
              String isbn=rs.getString("isbn");
              double setRating=rs.getFloat("rating");
              String Status=rs.getString("status");
              Rbook book = new Rbook(title, author, publisher, isbn, setRating, Status);
              result.add(book);
	    }
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
        return result;
    }
}

	
