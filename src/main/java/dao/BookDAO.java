package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;

public class BookDAO {
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
	
	//isbnから図書を検索
	public static List<Book> SearchBook(String isbn) {
		
		List<Book> result = new ArrayList<>();
		
		String sql = "SELECT * FROM books WHERE isbn = ? and type = '1'";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, isbn);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					String type = rs.getString("type");
					int status = rs.getInt("status"); 

					Book book = new Book(id, title, author, isbn, publisher, type, status);
					result.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//借りる
	public static int BorrowBook(dto.Book book) {

		String sql = "UPDATE books SET type = 0 WHERE isbn = ?";

		int result = 0;
		
		try (	Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setString(1,book.getIsbn());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}	
		return result;
	}
	
	//返す
	public static int ReturnBook(dto.Book book) {

		String sql = "UPDATE books SET type = 1 WHERE isbn = ?";

		int result = 0;
		
		try (	Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setString(1,book.getIsbn());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}	
		return result;
	}
}