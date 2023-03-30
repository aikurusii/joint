package dto;

public class Dbook {
	private int id;
	private String title;
	private String author;
	private String publisher;
	private String isbn;
	private double rating;
	
	public Dbook(int id,String title,String author,String publisher,String isbn,double rating) {
		super();
		this.id=id;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.isbn=isbn;
		this.rating=rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}
