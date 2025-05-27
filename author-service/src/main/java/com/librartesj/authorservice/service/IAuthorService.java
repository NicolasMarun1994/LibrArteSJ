package com.librartesj.authorservice.service;

import com.librartesj.authorservice.dto.AuthorDTO;
import com.librartesj.authorservice.model.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IAuthorService
{
    //CRUD
    public void saveAuthor(String name, String biography, LocalDate birthdate, List<Long> books_ids);

    public void saveBasicAuthor(AuthorDTO author, Long bookID);

    public List<Author> getAllAuthors();

    public Author findAuthor (Long id);

    public Optional<Author> findAuthorByName (String name);

    public List<Author> searchAuthorByName ( String name);

    public void addBookId(Long book_id, Long author_id);

    public void updateAuthor(Long id, Author author);



    public void deleteAuthor(Long id);
}
