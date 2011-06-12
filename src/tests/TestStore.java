package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dojo.Book;
import dojo.Store;


public class TestStore {
	@Test
	public void testBook(){
		Book book = new Book("cacador de pipas","Khaled Hussein","A0B211");
		assertEquals("A0B211", book.getISBN());
		assertEquals("cacador de pipas", book.getTitle());
		assertEquals("Khaled Hussein", book.getAuthor());
	}

	@Test
	public void testStore(){
		List<Book> books = new ArrayList<Book>();
		Store store = new Store(books);
		assertEquals(books,store.getBooks());
	}
	
	@Test
	public void testBookInStore(){
		Book l1 = new Book();
		l1.setAuthor("Summerville");
		l1.setTitle("Engenharia de Software");
		l1.setISBN("12345");

		Store loja = new Store();
		loja.addBooks(l1);
		

		assertTrue(this.verifyBook(l1, loja));

		Book l2 = new Book("Padroes de projeto","Erich Gama","213546");
		loja.addBooks(l2);

		assertTrue(this.verifyBook(l2, loja));
	}
	
	public boolean verifyBook(Book l, Store loja){
		
		boolean achou = false;
		for(Book liv : loja.getBooks())
			if(liv.equals(l))
				achou = true;
		
		return achou;
	}
	
	@Test
	public void testRemove(){
		Store store = new Store();
		Book l1 = new Book("Livro 1","Autor 1","123");
		Book l2 = new Book("Livro 2","Autor 2","456");
		store.addBooks(l1);
		store.addBooks(l2);		
		store.delBooks(l1);
		
		assertFalse(verifyBook(l1, store));
	}
	@Test 
	public void testListBooks(){
		String content;
		Store store = new Store();
		Book l1 = new Book("L 1","A 1","23");
		Book l2 = new Book("L 2","A 2","56");
		Book l3 = new Book("L 3","A 32","75");
		
		store.addBooks(l1);
		store.addBooks(l2);
		store.addBooks(l3);
		
		content = store.listBooks();
		String esperado = "L 1, A 1, 23\nL 2, A 2, 56\nL 3, A 32, 75\n";
		assertEquals(esperado, content);
	}
}
