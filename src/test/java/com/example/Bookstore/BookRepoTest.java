package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepoTest {
	@Autowired
	private BookRepository brepository;
	private CategoryRepository crepository;
	/*Problems with category repository, implemented below with category set to null
	@Test
	public void newBook() {
		crepository.save(new Category("Adventure"));
		crepository.save(new Category("Classic"));
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Realistic"));
		crepository.save(new Category("Tragedy"));
		crepository.save(new Category("Fiction"));
		brepository.save(new Book("Pride and Prejudice", "Jane Austen", "9780679783268", 1813, 9.90,
				crepository.findByName("Realistic").get(0)));
		assertThat(brepository.count() > 0);
	}*/
	@Test
	public void newBook() {
		Book book = new Book("Pride and Prejudice", "Jane Austen", "9780679783268", 1813, 9.90, null);
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	@Test
	public void delBook() {
		Book book = new Book("Pride and Prejudice", "Jane Austen", "9780679783268", 1813, 9.90, null);
		brepository.save(book);
		brepository.deleteById(book.getId());
		assertThat(brepository.count()).isEqualTo(5);
	}
}
