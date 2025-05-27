package com.librartesj.bookservice.service;

import com.librartesj.bookservice.dto.AuthorDTO;
import com.librartesj.bookservice.dto.BookDTO;
import com.librartesj.bookservice.model.Book;
import com.librartesj.bookservice.repository.IAuthorAPI;
import com.librartesj.bookservice.repository.IBookRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService
{
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IAuthorAPI authorAPI;

    @Override
    public void saveBook(String title, String synopsis, LocalDate print_date,List<String> authors_names)
    {
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setSynopsis(synopsis);
        newBook.setPrint_date(print_date);
        newBook = bookRepository.save(newBook);

        List<Long>  authors_ids = new ArrayList<Long>();

        AuthorDTO author = null;
        for(String author_name : authors_names)
        {
            try
            {
                author = authorAPI.getAuthorByName(author_name);

            } catch (FeignException.NotFound NoneXistentAuthor)
            {
                author = null;

            }

            if(author == null)
            {
                AuthorDTO newAuthor = new AuthorDTO();
                newAuthor.setName(author_name);
                authorAPI.createBasicAuthor(newAuthor,newBook.getId());
                //el nuevo metodo CreateBasic debe enviar el ID de NEWBOOK

                author = authorAPI.getAuthorByName(author_name);
            }

            if(author != null)
            {

                authors_ids.add(author.getId());
                authorAPI.addBookId(newBook.getId(),author.getId());

            }

        }

        newBook.setAuthors_ids(authors_ids);
        bookRepository.save(newBook);
        
    }

    @Override
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();

    }

    @Override
    public List<Book> searchByTitle(String title)
    {

        return bookRepository.searchByTitle(title);
    }

    @Override
    public Optional<Book> findBookByTitle(String title)
    {
        if(title==null || title.trim().isEmpty())
        {
            throw new IllegalArgumentException("El Titulo no puede estar nulo o vacio");
        }
        title = title.trim();

        return bookRepository.findByTitle(title);


    }


    @Override
    public Book findBook (Long id)
    {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook (Long id, Book book)
    {
        Book updated_book = this.findBook(id);

        updated_book.setTitle(book.getTitle());
        updated_book.setSynopsis(book.getSynopsis());
        updated_book.setPrint_date(book.getPrint_date());
        updated_book.setAuthors_ids(book.getAuthors_ids());

        bookRepository.save(updated_book);

    }

    @Override
    public void deleteBook (Long id)
    {
        bookRepository.deleteById(id);
    }

}
