package com.librartesj.library_service.controller;

import com.librartesj.library_service.dto.AuthorBooksDTO;
import com.librartesj.library_service.dto.AuthorDTO;
import com.librartesj.library_service.dto.BookAuthorsDTO;
import com.librartesj.library_service.dto.PartialBookDTO;
import com.librartesj.library_service.repository.IBookAPI;
import com.librartesj.library_service.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController
{
    @Autowired
    private ILibraryService libraryService;

    @GetMapping("/get-book-by-title/{title}")
    public BookAuthorsDTO findByTitle(@PathVariable String title)
    {
        return libraryService.getBookByTitle(title);
    }

    @GetMapping("/search-book-by-title/{title}")
    public List<PartialBookDTO> searchByTitle (@PathVariable String title)
    {
        return libraryService.searchBookByTitle(title);
    }

    @GetMapping("/get-author-by-name/{name}")
    public AuthorBooksDTO findByName (@PathVariable String name)
    {
        return libraryService.getAuthorByName(name);
    }

    @GetMapping("/search-author-by-name/{name}")
    public List<AuthorBooksDTO> searchByName (@PathVariable String name)
    {
        return libraryService.searchAuthorByName(name);


    }




}
