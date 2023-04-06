package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
   AuthorRepository authorRepository;

    public String addBook(Book book) {
        //bookRepository.save(book);

        int authorId = book.getAuthor().getId();

        System.out.println(authorId);

        Author author ;//= authorRepository.findById(authorId).get();

        try{
            author = authorRepository.findById(authorId).get();
        }
        catch(Exception e){
            return e.toString()+"Author not found";
        }

        book.setAuthor(author);

        List<Book> booksWritten = author.getBooksWritten();

        booksWritten.add(book);

        authorRepository.save(author);

        return "Book added successfully";
    }
}
