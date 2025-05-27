package com.librartesj.library_service.repository;

import com.librartesj.library_service.dto.BookDTO;
import com.librartesj.library_service.dto.PartialBookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service")
public interface IBookAPI
{
    @GetMapping("/book/get-by-title/{title}")
    public BookDTO getBookByTitle(@PathVariable String title);

    @GetMapping("/book/search-by-title/{title}")
    public List<PartialBookDTO> searchByTitle (@PathVariable String title);

    @GetMapping("/book/get/{id}")
    public BookDTO getBook (@PathVariable Long id);


    
}
