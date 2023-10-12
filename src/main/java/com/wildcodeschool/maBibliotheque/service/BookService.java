package com.wildcodeschool.maBibliotheque.service;

import com.wildcodeschool.maBibliotheque.entity.Book;
import com.wildcodeschool.maBibliotheque.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }
}

