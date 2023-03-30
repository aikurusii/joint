package dao;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Book;
import dto.Dbook;
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
			pstmt.setInt(5, book.getType());
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
	
	
	  public static void updateBooktype() throws SQLException, URISyntaxException {
		  String sql = "UPDATE books SET type = '0' WHERE type = '1' AND update_date < ?";
	        LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);
	        Timestamp timestamp = Timestamp.valueOf(oneYearAgo);
	        try (	Connection con = getConnection();
	        		PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setTimestamp(1, timestamp);
	            stmt.executeUpdate();
	        }
	    }
	  

	    public static List<Rbook> getAllBookss() throws SQLException {
	        List<Rbook> bookList = new ArrayList<>();
	        String sql ="SELECT books.title, books.author, books.publisher, books.isbn, AVG(rat.rating) as rating, loan.id as loan_id "
                    + "FROM books "
                    + "LEFT JOIN rat ON books.id = rat.book_id "
                    + "LEFT JOIN loan ON books.id = loan.book_id AND loan.returned_at IS NULL "
                    + "GROUP BY books.title, books.author, books.publisher, books.isbn, loan.id "
                    + "ORDER BY books.isbn ";

	        try (	Connection con = getConnection();
	        		PreparedStatement statement = con.prepareStatement(sql)) {
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    String isbn = resultSet.getString("isbn");
	                    String title = resultSet.getString("title");
	                    String author = resultSet.getString("author");
	                    String publisher = resultSet.getString("publisher");
	                    double rating = resultSet.getDouble("rating");
	                    boolean loan_id = resultSet.getInt("loan_id")>0;
	                    Rbook book = new Rbook(title, author, publisher,isbn, rating, loan_id);
	                    bookList.add(book);
	                }
	            }
	        } catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        return bookList;
	    }
	    
	    public static List<Dbook> getDAllBookss() throws SQLException {
	        List<Dbook> bookList = new ArrayList<>();
	        String sql ="SELECT books.id, books.title, books.author, books.publisher, books.isbn, AVG(rat.rating) as rating "
	                + "FROM books "
	                + "LEFT JOIN rat ON books.id = rat.book_id "
	                + "GROUP BY books.id, books.title, books.author, books.publisher, books.isbn "
	                + "ORDER BY books.isbn ";


	        try (	Connection con = getConnection();
	        		PreparedStatement statement = con.prepareStatement(sql)) {
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                	int id=resultSet.getInt("id");
	                    String isbn = resultSet.getString("isbn");
	                    String title = resultSet.getString("title");
	                    String author = resultSet.getString("author");
	                    String publisher = resultSet.getString("publisher");
	                    double rating = resultSet.getDouble("rating");
	                    Dbook book = new Dbook(id,title, author, publisher,isbn, rating);
	                    bookList.add(book);
	                }
	            }
	        } catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        return bookList;
	    }
	    
	    
	    public static List<Rbook> Searchbook(String keyword) throws SQLException {
	        List<Rbook> bookList = new ArrayList<>();
	            String sql = "SELECT books.title, books.author, books.publisher, books.isbn, AVG(rat.rating) as rating, loan.id as loan_id "
	                    + "FROM books "
	                    + "LEFT JOIN rat ON books.id = rat.book_id "
	                    + "LEFT JOIN loan ON books.id = loan.book_id AND loan.returned_at IS NULL "
	                    + "WHERE books.title ILIKE ? OR books.author ILIKE ? OR books.publisher ILIKE ? OR books.isbn ILIKE ? "
	                    + "GROUP BY books.title, books.author, books.publisher, books.isbn, loan.id "
	                    + "ORDER BY books.isbn";
	            try (	Connection con = getConnection();
	            		PreparedStatement stmt = con.prepareStatement(sql)) {
	                stmt.setString(1, "%" + keyword + "%");
	                stmt.setString(2, "%" + keyword + "%");
	                stmt.setString(3, "%" + keyword + "%");
	                stmt.setString(4, "%" + keyword + "%");
	                try (ResultSet rs = stmt.executeQuery()) {
	                    while (rs.next()) {
	                        String title = rs.getString("title");
	                        String author = rs.getString("author");
	                        String publisher = rs.getString("publisher");
	                        String isbn = rs.getString("isbn");
	                        Double rating = rs.getDouble("rating");
	                        boolean loan_id= rs.getInt("loan_id") > 0;

	                        Rbook book = new Rbook(title, author, publisher, isbn, rating, loan_id);
	                        bookList.add(book);
	                    }
	                }
	        } catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        return bookList;
	    }
	    
	    public static List<Dbook> SearchDbook(String keyword) throws SQLException {
	        List<Dbook> bookList = new ArrayList<>();
	            String sql = "SELECT books.id, books.title, books.author, books.publisher, books.isbn, AVG(rat.rating) as rating "
	                    + "FROM books "
	                    + "LEFT JOIN rat ON books.id = rat.book_id "
	                    + "WHERE books.isbn ILIKE ? "
	                    + "GROUP BY books.id, books.title, books.author, books.publisher, books.isbn "
	                    + "ORDER BY books.isbn";
	            try (	Connection con = getConnection();
	            		PreparedStatement stmt = con.prepareStatement(sql)) {
	                stmt.setString(1, "%" + keyword + "%");
	              
	                try (ResultSet rs = stmt.executeQuery()) {
	                    while (rs.next()) {
	                    	int id=rs.getInt("id");
	                        String title = rs.getString("title");
	                        String author = rs.getString("author");
	                        String publisher = rs.getString("publisher");
	                        String isbn = rs.getString("isbn");
	                        Double rating = rs.getDouble("rating");
	                       

	                        Dbook book = new Dbook(id, title, author, publisher, isbn, rating);
	                        bookList.add(book);
	                    }
	                }
	        } catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        return bookList;
	    }
	    
	    public static List<Book> getbook(int id) throws SQLException {
	        List<Book> result=new ArrayList<>();
	    	String sql = "SELECT * FROM books WHERE id = ?";

	        try (	Connection con = getConnection();
	        		PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                String title=rs.getString("title");
	                String author=rs.getString("author");
	                String publisher=rs.getString("publisher");
	                String isbn=rs.getString("isbn");
	                int type=rs.getInt("type");
	                Book book =new Book(id,title,author,publisher,isbn,type);
	         result.add(book);
	            }
	        
	        } catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return result;
			    
	}
	    public static void deleteBook(int id) {
	    	String sql="delete from books where id=?";
	    	  try (	Connection con = getConnection();
		        		PreparedStatement pstmt = con.prepareStatement(sql)) {
	    		  pstmt.setInt(1, id);
	    	      pstmt.executeUpdate();
	    	    } catch (SQLException e) {
	    	      e.printStackTrace();
	    	   
	    	  
	    	  } catch (URISyntaxException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
	    }
}
	
