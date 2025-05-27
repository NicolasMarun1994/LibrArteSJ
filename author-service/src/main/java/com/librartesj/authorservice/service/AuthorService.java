package com.librartesj.authorservice.service;

import com.librartesj.authorservice.dto.AuthorDTO;
import com.librartesj.authorservice.model.Author;
import com.librartesj.authorservice.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService
{
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public void saveAuthor(String name, String biography, LocalDate birthdate, List<Long> books_ids)
    {
        Author author = new Author();
        author.setName(name.toLowerCase().trim());
        author.setBiography(biography);
        author.setBirthdate(birthdate);
        author.setBooks_ids(books_ids);
        authorRepository.save(author);

    }
    @Override
    public void saveBasicAuthor(AuthorDTO author, Long bookID)
    {
        Author newAuthor = new Author();
        newAuthor.setName(author.getName());
        newAuthor = authorRepository.save(newAuthor);
        this.addBookId(bookID,newAuthor.getId());
    }



    @Override
    public List<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthor(Long id)
    {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Author> findAuthorByName (String name)
    {

        //valido para evitar busquedas innecesarias
        if(name==null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
        }
        name = name.trim();

        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> searchAuthorByName (String name)
    {
        name = name.trim();
        if( name.isBlank() == true || name.isEmpty() == true )
        {
            throw new IllegalArgumentException("El CAMPO no puede estar VACIO");
        }
        return authorRepository.searchByName(name);
    }

    @Override
    public void updateAuthor(Long id, Author author)
    {
        Author updated_author= this.findAuthor(id);
        updated_author.setName(author.getName().toLowerCase());
        updated_author.setBiography(author.getBiography());
        updated_author.setBirthdate(author.getBirthdate());
        updated_author.setBooks_ids(author.getBooks_ids());

        authorRepository.save(updated_author);
    }

    @Override
    public void addBookId(Long book_id,Long author_id)
    {
        Author author = authorRepository.findById(author_id).orElse(null);

        //List <Long> bookIdList = null;

        if( author != null )
        {
            //bookIdList = author.getBooks_ids();

            if(author.getBooks_ids() == null)
            {
                author.setBooks_ids(new ArrayList<Long>());
            }

            boolean bookAlreadyExist = author.getBooks_ids().contains(book_id);

            if(bookAlreadyExist == false)
            {
                author.getBooks_ids().add(book_id);

                //author.setBooks_ids(bookIdList);

                authorRepository.save(author);
            }

        }

    }


    @Override
    public void deleteAuthor(Long id)
    {
        authorRepository.deleteById(id);

    }
}
