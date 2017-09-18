package fi.haagahelia.okt.Bookstore.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.okt.Bookstore.model.Book;

@RestController

public class BookController {

	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/booklist")
	public String allBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/booksjson")
	public List<Book> allBooksJSON(){
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/bookjson/{id}", method = RequestMethod.GET)
	public Book oneBookJSON(@PathVariable("id") Long bookId) {
		return repository.findOne(bookId);
	}

}
