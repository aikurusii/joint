package dto;

public class Rbook {
	private String title;
	private String author;
	private String publisher;
	private String isbn;
	private double rating;
	private String status;
	
	public Rbook(String title,String author,String publisher,String isbn,double rating,String status) {
		super();
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.isbn=isbn;
		this.rating=rating;
		this.status=status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getStarus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
