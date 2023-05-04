/**
 * Book Class
 * @author christopher
 *
 */
public class Book {

	/**
	 * Parameters 
	 */
	protected String title;
	protected String author;
	protected double price;
	protected long isbn;
	protected String genre;
	protected int year;
	
	/**
	 * Default constructor 
	 */
	public Book() {
		
	}
	
	/**
	 * Param constructor 
	 * @param title
	 * @param author
	 * @param price
	 * @param isbn
	 * @param genre
	 * @param year
	 */
	public Book(String title, String author, double price,long isbn,String genre,int year) {
		
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.genre = genre;
		this.year = year;
	}

	
	/**
	 * Copy constuctor 
	 * @param b1
	 */
	public Book(Book b1) {
		this.title = b1.title;
		this.author = b1.author;
		this.price = b1.price;
		this.isbn = b1.isbn;
		this.genre = b1.genre;
		this.year = b1.year;
	}
	
	/**
	 * Getter for title 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter for title 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * getter for author 
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * setter for author 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * getter for price 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * setter for price 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * get for isbn 
	 * @return
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * setter for isbn 
	 * @param isbn
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * getter for genre 
	 * @return
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Setter for genre 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * getter for year 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * setter for year 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * to String method 
	 */
	public String toString() {
		return title + " " + author + " " + price + " " + isbn + " "
				+ genre + " " + year;
	}
	
	/**
	 * Equals method for book 
	 */
	public boolean equals(Object obj) {
		
		if(obj==null) {
			return false;
		}
		if(obj.getClass()!=this.getClass()) {
			return false;
		}
		
		Book b1 = (Book)obj;
		
		return this.title.equals(b1.title) &&
				this.author.equals(b1.author) &&
				this.price == b1.price &&
				this.isbn == b1.isbn &&
				this.genre.equals(b1.genre)&&
				this.year == b1.year;
				
		
		
		
	}
	
}
