package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	BookController bcontroller;
	
	@Test
	 public void contextLoads() throws Exception {
	 assertThat(bcontroller).isNotNull();
	 }
}
