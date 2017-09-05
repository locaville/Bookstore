package fi.haagahelia.okt.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.okt.Bookstore.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findById(long id);
	
	List<Book> findByTitle(String title);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByYear(int year);
	
	List<Book> findByIsbn(String isbn);
	
	List<Book> findByPrice(double price);

}
