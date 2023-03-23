package dto;

public class User {
	private int id;
	private String mail;
	private String name;
	private String salt;
	private String password;
	private String hashedPassword;

	
	public User(int id,String name,String mail,String salt,String password,String hashedPassword) {
		super();
		this.id=id;
		this.name=name;
		this.mail=mail;
		this.salt=salt;
		this.password=password;
		this.hashedPassword=hashedPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
}