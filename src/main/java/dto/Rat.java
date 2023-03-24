package dto;

public class Rat {
		private int id;
		private String bisbn;
		private int user_id;
		private int loan_id;
		private int rating;
		
	public Rat(int id,String bisbn,int user_id,int loan_id,int rating) {
		super();
		this.id=id;
		this.bisbn=bisbn;
		this.user_id=user_id;
		this.loan_id=loan_id;
		this.rating=rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_id() {
		return bisbn;
	}

	public void setBook_id(String bisbn) {
		this.bisbn = bisbn;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
