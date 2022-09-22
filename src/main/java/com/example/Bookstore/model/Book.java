package com.example.Bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private int yr;
	private double price;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book() {
		super();
	}

	public Book(String title, String author, String isbn, int yr, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.yr = yr;
		this.price = price;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYr() {
		return yr;
	}

	public void setYr(int yr) {
		this.yr = yr;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null) {
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", yr=" + yr
					+ ", price=" + price + ", category=" + category + "]";
		} else {
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", yr=" + yr
					+ ", price=" + price + "]";
		}

	}

}
