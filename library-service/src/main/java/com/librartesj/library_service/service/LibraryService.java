package com.librartesj.library_service.service;

import com.librartesj.library_service.dto.*;
import com.librartesj.library_service.repository.IAuthorAPI;
import com.librartesj.library_service.repository.IBookAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService implements ILibraryService
{
    @Autowired
    private IBookAPI bookAPI;

    @Autowired
    private IAuthorAPI authorAPI;


    @Override
    public BookAuthorsDTO getBookByTitle(String title)
    {
        BookAuthorsDTO bookAuthors = new BookAuthorsDTO();
        BookDTO book = bookAPI.getBookByTitle(title);
        bookAuthors.setId(book.getId());
        bookAuthors.setTitle(book.getTitle());
        bookAuthors.setSynopsis(book.getSynopsis());
        bookAuthors.setPrint_date(book.getPrint_date());
        bookAuthors.setAuthors_list(new ArrayList<AuthorSimpleDTO>());

        for(Long id : book.getAuthors_ids() )
        {
            AuthorDTO completeAuthor= authorAPI.getAuthor(id);
            AuthorSimpleDTO author = new AuthorSimpleDTO(
                    completeAuthor.getId(),
                    completeAuthor.getName(),
                    completeAuthor.getBiography(),
                    completeAuthor.getBirthdate()
            );

            bookAuthors.getAuthors_list().add(author);
        }
        return bookAuthors;

    }

    @Override
    public List<PartialBookDTO> searchBookByTitle(String title)
    {
        return bookAPI.searchByTitle(title);

    }

    @Override
    public AuthorBooksDTO getAuthorByName (String name)
    {
        AuthorDTO author = authorAPI.getAuthorByName(name);

        AuthorBooksDTO authorBooks = new AuthorBooksDTO();

        authorBooks.setId(author.getId());
        authorBooks.setName(author.getName());
        authorBooks.setBiography(author.getBiography());
        authorBooks.setBirthdate(author.getBirthdate());
        authorBooks.setBooks_list(new ArrayList<BookSimpleDTO>());

        for(Long id : author.getBooks_ids())
        {
            BookDTO completeBook = bookAPI.getBook(id);
            BookSimpleDTO simpleBook = new BookSimpleDTO(
                    completeBook.getId(),
                    completeBook.getTitle(),
                    completeBook.getSynopsis(),
                    completeBook.getPrint_date()
            );
            authorBooks.getBooks_list().add(simpleBook);
        }

        return authorBooks;

    }

    @Override
    public List<AuthorBooksDTO> searchAuthorByName(String name)
    {
        List<AuthorDTO> authorList = authorAPI.searchAuthorByName(name);
        List<AuthorBooksDTO> authorBooksList = new ArrayList<AuthorBooksDTO>();

        for(AuthorDTO author : authorList)
        {
            AuthorBooksDTO authorBooks = new AuthorBooksDTO();
            authorBooks.setId(author.getId());
            authorBooks.setName(author.getName());
            authorBooks.setBiography(author.getBiography());
            authorBooks.setBirthdate(author.getBirthdate());
            authorBooks.setBooks_list(new ArrayList<>());


            for(Long id : author.getBooks_ids())
            {
                BookDTO completeBook = bookAPI.getBook(id);
                BookSimpleDTO simpleBook = new BookSimpleDTO(
                        completeBook.getId(),
                        completeBook.getTitle(),
                        completeBook.getSynopsis(),
                        completeBook.getPrint_date()
                );

                authorBooks.getBooks_list().add(simpleBook);
            }

            authorBooksList.add(authorBooks);
        }

        return authorBooksList;

    }


}
