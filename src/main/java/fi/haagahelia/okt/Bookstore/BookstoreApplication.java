package fi.haagahelia.okt.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.okt.Bookstore.domain.BookRepository;
import fi.haagahelia.okt.Bookstore.domain.User;
import fi.haagahelia.okt.Bookstore.domain.UserRepository;
import fi.haagahelia.okt.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookRunner(BookRepository repo, UserRepository urepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				log.info("books");
				repo.save(new Book("1984", "George Orwell", 1949, "951-0-23801-5", 40.0));
				repo.save(new Book("The Brothers Karamazov", "Fedor Dostojevski", 1880, "978-951-23-5055-1", 59.90));
				repo.save(new Book("Slaughterhouse 5", "Kurt Vonnegut", 1969, "0-385-31208-3", 24.90));
				log.info("now users");
				// Create users:  admin/admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com", "ADMIN");
				urepo.save(user1);
				urepo.save(user2);
			}
			
		};
	}
	
}
