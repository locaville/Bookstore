package fi.haagahelia.okt.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.okt.Bookstore.domain.BookRepository;
import fi.haagahelia.okt.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookRunner(BookRepository repo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				repo.save(new Book("1984", "George Orwell", 1949, "951-0-23801-5", 40.0));
				repo.save(new Book("The Brothers Karamazov", "Fedor Dostojevski", 1880, "978-951-23-5055-1", 59.90));
				repo.save(new Book("Slaughterhouse 5", "Kurt Vonnegut", 1969, "0-385-31208-3", 24.90));
			}
			
		};
	}
	
}
