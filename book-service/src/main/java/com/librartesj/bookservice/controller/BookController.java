package com.librartesj.bookservice.controller;


import com.librartesj.bookservice.dto.BookDTO;
import com.librartesj.bookservice.model.Book;
import com.librartesj.bookservice.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    private IBookService bookService;

    //Create new BOOK
    @PostMapping("/create")
    public String createBook(@RequestBody BookDTO bookDTO)
    {

        bookService.saveBook(bookDTO.getTitle(),bookDTO.getSynopsis(),bookDTO.getPrint_date(),bookDTO.getAuthors_names());
        return "Book creado Correctamente";
    }

    @GetMapping("/getall")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{id}")
    public Book getBook (@PathVariable Long id)
    {
        return bookService.findBook(id);
    }

    //busco libros que CONTENGAN en el TITULO cierta PALABRA
    @GetMapping("/search-by-title/{title}")
    public List<Book> searchByTitle(@PathVariable String title)
    {
        if(title.trim().isBlank() == true)
        {
            throw new IllegalArgumentException("El titulo no puede estar VACIO o CONTENER SOLO ESPACION");
        }
        title=title.trim();
        return bookService.searchByTitle(title);
    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title)
    {
        Optional<Book> book = bookService.findBookByTitle(title);

        if(book.isEmpty() == true)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book with TITLE " + title + " Not Found");
        }
        return ResponseEntity.ok(book.get());
    }



    @PutMapping("/update/{id}")
    public Book updateBook (@PathVariable Long id, @RequestBody Book book)
    {
        bookService.updateBook(id,book);
        Book booky = bookService.findBook(id);
        return booky;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook (@PathVariable Long id)
    {
        bookService.deleteBook(id);
        return "Book eliminado correctamente";
    }

}
