package dojo;

import java.util.ArrayList;
import java.util.List;


public class Store implements ICollection {
	private List<Book> books = new ArrayList<Book>();

	public Store(List<Book> l) {
		books = l;
	}

	public Store() {

	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBooks(Book l) {
		books.add(l);
	}

	public void delBooks(Book l) {
		books.remove(l);
	}

	public String listBooks() {
		IIterator iterator = this.createIterator();
		
		String result = "";
		while(iterator.hasNext()) {
			Book liv = (Book)iterator.next();
			result += liv.getTitle() + ", " + liv.getAuthor() + ", "
					+ liv.getISBN() + "\n";
		}
		return result;
	}

	@Override
	public IIterator createIterator() {
		
		return new BookIterator();
	}

	class BookIterator implements IIterator {
		int current = 0;
		@Override
		public boolean hasNext() {
			if (current < books.size())
				return true;
			return false;
		}

		@Override
		public Object next() {
			current+=1;
			return books.get(current-1);
		}

	}
}
