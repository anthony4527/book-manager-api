package com.techreturners.bookmanager.service;

import com.techreturners.bookmanager.model.Book;
import com.techreturners.bookmanager.repository.BookManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookManagerServiceImpl implements BookManagerService {

    @Autowired
    BookManagerRepository bookManagerRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookManagerRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book insertBook(Book book) {

        //Book chkBook = bookManagerRepository.findById(book.getId()).get();

        return bookManagerRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        //Book book2 =  bookManagerRepository.findById(id).get();
        //return book2;

        Optional<Book> bookOptional = bookManagerRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }else
            return null;

//        return bookManagerRepository.findById(id).get();
    }

    //User Story 4 - Update Book By Id Solution
    @Override
    public void updateBookById(Long id, Book book) {
        Book retrievedBook = bookManagerRepository.findById(id).get();

        retrievedBook.setTitle(book.getTitle());
        retrievedBook.setDescription(book.getDescription());
        retrievedBook.setAuthor(book.getAuthor());
        retrievedBook.setGenre(book.getGenre());

        bookManagerRepository.save(retrievedBook);
    }

    //User Story 5 - Delete Book by Id
    @Override
    public void deleteBookById(Long id){
        bookManagerRepository.deleteById(id);
    }

}
