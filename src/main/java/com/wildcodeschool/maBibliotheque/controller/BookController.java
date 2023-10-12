package com.wildcodeschool.maBibliotheque.controller;

import com.wildcodeschool.maBibliotheque.entity.Book;
import com.wildcodeschool.maBibliotheque.repository.BookRepository;
import com.wildcodeschool.maBibliotheque.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;


    // recherche par mot clé titre ou description
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String keyword) {
        List<Book> books = bookService.searchBooks(keyword);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Autowired
    private BookRepository bookRepository;


    // all books
    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


// creer un book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // supprimer un book

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Le livre a bien été supprimé");
    }

    // modifier un book

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book bookToUpdate = bookRepository.findById(id).get();
        if (book.getTitle() != null) {
            bookToUpdate.setTitle(book.getTitle());
        }
        if (book.getAuthor() != null) {
            bookToUpdate.setAuthor(book.getAuthor());
        }
        if (book.getDescription() != null) {
            bookToUpdate.setDescription(book.getDescription());
        }
        return bookRepository.save(bookToUpdate);
    }


}
