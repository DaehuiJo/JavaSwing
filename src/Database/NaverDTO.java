package Database;

public class NaverDTO {

	private String title;
	private String author;
	private String price;
	private String isbn;
	private String image;
	private String publisher;
	private String text;
	private String book;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "NaverDTO [title=" + title + ", author=" + author + ", price=" + price + ", isbn=" + isbn + ", image="
				+ image + ", publisher=" + publisher + ", text=" + text + ", book=" + book + "]";
	}
	
}
