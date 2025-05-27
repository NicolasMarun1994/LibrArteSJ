package com.librartesj.bookservice.service;

import com.librartesj.bookservice.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IBookService
{
    //CRUD
    public void saveBook (String title, String synopsis, LocalDate print_date,List<String> authors_names);
    public List<Book> getAllBooks ();

    public List<Book> searchByTitle(String title);
    public Optional<Book> findBookByTitle(String title);

    public Book findBook (Long id);
    public void updateBook (Long id,Book book);
    public void deleteBook (Long id);
}
