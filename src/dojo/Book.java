package dojo;

public class Book {
private String title, author, ISBN;
	
	public Book (String title, String author, String ISBN){
		this.author = author;
		this.title = title;
		this.ISBN =  ISBN;
	}
	public Book() {
		
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
