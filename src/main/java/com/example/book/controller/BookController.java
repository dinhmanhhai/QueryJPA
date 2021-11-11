package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> book(){
        return bookService.iWantThisBook();
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<List<Book>> findAll(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "ioweiruwqoeriqoerwueiro");
        return ResponseEntity.ok().headers(httpHeaders).body(bookService.findAll());
    }

    @GetMapping("/bookByName")
    public ResponseEntity<List<Book>> getAllBooksByName(@RequestParam(value = "name") String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "ioweiruwqoeriqoerwueiro");
        return ResponseEntity.ok().headers(httpHeaders).body(bookService.getAllBooksByName(name));
    }

    // API chet
//    @GetMapping("/bookByCode")
//    public ResponseEntity<?> findBookByCode(String code) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("token", "ioweiruwqoeriqoerwueiro");
//        return ResponseEntity.ok().headers(httpHeaders).body(bookService.findBookByCode(code));
//    }

    @PostMapping("/bookUpdate")
    public ResponseEntity<?> updateBookName(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "ioweiruwqoeriqoerwueiro");
        return ResponseEntity.ok().headers(httpHeaders).body(bookService.updateBookName(id, name));
    }

    @PostMapping("/bookDelete")
    public ResponseEntity<?> deleteBook(@RequestParam(value = "id") int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "ioweiruwqoeriqoerwueiro");
        return ResponseEntity.ok().headers(httpHeaders).body(bookService.deleteBook(id));
    }
}
