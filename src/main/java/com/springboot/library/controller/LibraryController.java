package com.springboot.library.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.library.model.Book;

import com.springboot.library.model.User;

import com.springboot.library.repository.BookRepository;
import com.springboot.library.payment.PaymentGateway;

@RestController
public class LibraryController {

	@Autowired
	BookRepository bookRepository;

	/*
	 * This End point is responsible for fetching all books available in our
	 * database.
	 */
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getBooks() {
		List<Book> li = new ArrayList<Book>();
		bookRepository.findAll().forEach(li::add);
		return li;
	}
	/*
	 * This End point is responsible for fetching books that have been borrowed
	 */

	/*
	 * This End point is responsible for fetching total number of books.
	 */

//@RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
// public long countNoofBooks() {
// return bookRepository.count();
// }

	/*
	 * This End point is responsible for adding one or multiple books.
	 */
	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json")
	public void addBooks(@RequestBody List<Book> books) {
		System.out.println(books);
		bookRepository.saveAll(books);

	}

	/*
	 * This End point is responsible for deleting existing book.
	 */

	@RequestMapping(value = "/delBook", method = RequestMethod.DELETE, produces = "application/json")
	public void delBooks(@RequestBody Book books) {
		System.out.println(books);
		bookRepository.delete(books);

	}

}