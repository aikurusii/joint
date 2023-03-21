package dto;

public class Book {
	private int id;
	private String title;
	private String author;
	private String isbn;
	private String publisher;
	private String type;
	
	public Book(int id,String title,String author,String isbn,String publisher,String type) {
		super();
		this.id=id;
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.publisher=publisher;
		this.type=type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
