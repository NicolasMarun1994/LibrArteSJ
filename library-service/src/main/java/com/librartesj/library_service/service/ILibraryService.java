package com.librartesj.library_service.service;

import com.librartesj.library_service.dto.AuthorBooksDTO;
import com.librartesj.library_service.dto.BookAuthorsDTO;
import com.librartesj.library_service.dto.BookDTO;
import com.librartesj.library_service.dto.PartialBookDTO;
import com.librartesj.library_service.repository.IBookAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ILibraryService
{
    public BookAuthorsDTO getBookByTitle (String title);

    public List<PartialBookDTO> searchBookByTitle (String title);

    public AuthorBooksDTO getAuthorByName (String name);

    public List<AuthorBooksDTO> searchAuthorByName (String name);


}
