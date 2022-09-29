package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Saving initiated");
			
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("Classic"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Realistic"));
			crepository.save(new Category("Tragedy"));
			crepository.save(new Category("Fiction"));

			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", "4380679783266", 1960, 15.50,
					crepository.findByName("Fiction").get(0)));
			repository.save(new Book("Pride and Prejudice", "Jane Austen", "9780679783268", 1813, 9.90,
					crepository.findByName("Realistic").get(0)));
			repository.save(new Book("1984", "George Orwell", "2180679783212", 1949, 13.70,
					crepository.findByName("Fiction").get(0)));
			repository.save(new Book("The Lord of the Rings", "J. R. R. Tolkien", "7780679783277", 1954, 25.50,
					crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Hamlet", "William Shakespeare", "5680679783265", 1601, 4.90,
					crepository.findByName("Tragedy").get(0)));

			System.out.println("Loading default books into the DB");

			log.info("Fetching all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
