package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;

//import com.example.book.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

//    private BookSpecification bookSpecification;

    @Autowired
    private BookRepository bookrepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAll() {
        List<Book> books = null;
        TypedQuery<Book> tmp = entityManager.createNamedQuery("allBook", Book.class);
        for (Book book : tmp.getResultList()) {
            System.out.println(book.toString());
        }
        books = tmp.getResultList();

        return books;
    }

    public List<Book> getAllBooksByName(String name) {
        List<Book> books = bookrepository.getAllBooksByName(name);
//        List<Book> books = null;
//        Query tmp = entityManager.createNativeQuery("SELECT * From book where book.name = name");
//        books = tmp.getResultList();
        return books;
    }

    public boolean updateBookName(int id, String name) {
        Book book = new Book(id, name, "Japan");
        Optional books = bookrepository.findById(id);

        if (books.isEmpty()) {
            bookrepository.save(book);
            return true;
        }
        return false;
    }

    public Boolean deleteBook(int id) {
        Optional book = bookrepository.findById(id);
        if (book.isPresent()) {
            bookrepository.delete((Book) book.get());
            return true;
        }
        return false;
    }

    public List<Book> iWantThisBook() {
        return bookrepository.findAll(BookRepository.iWantThisBookDemo());
    }
}
