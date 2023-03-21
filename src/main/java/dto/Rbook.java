package dto;

public class Rbook {
	private String title;
	private String author;
	private String isbn;
	private String publisher;
	private double rating;
	private String st;
	
	public Rbook(String title,String author,String isbn,String publisher,double rating,String st) {
		super();
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.publisher=publisher;
		this.rating=rating;
		this.st=st;
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

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}
	
}
