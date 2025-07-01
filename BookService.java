package com.api.book.bootrestbook.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    private static final List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(101, "Java: The Complete Reference", "Herbert Schildt"));
        list.add(new Book(102, "Spring in Action", "Craig Walls"));
        list.add(new Book(103, "Effective Java", "Joshua Bloch"));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // Get a book by ID
    public Book getBookById(int id) {
        return list.stream()
                   .filter(book -> book.getId() == id)
                   .findFirst()
                   .orElse(null);
    }

    //adding the book
    public Book addBook(Book b){

         list.add(b);
         return b;
    }

    //deleting the book
    public void deleteBook(int bid){
        list.stream().filter(book-> book.getId() != bid).collect(Collectors.toList());
    }

    //update the book
    public void updateBook(Book book, int bookId){
        list.stream().map(b->{
            if(b.getId() == bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
