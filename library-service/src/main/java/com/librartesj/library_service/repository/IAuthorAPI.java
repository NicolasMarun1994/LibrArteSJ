package com.librartesj.library_service.repository;

import com.librartesj.library_service.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "author-service")
public interface IAuthorAPI
{
    @GetMapping("/authors/get-by-name/{name}")
    public AuthorDTO getAuthorByName (@PathVariable String name);

   @GetMapping("/authors/search-by-name/{name}")
    public List<AuthorDTO> searchAuthorByName (@PathVariable String name);

    @GetMapping("/authors/get-by-id/{id}")
    public AuthorDTO getAuthor(@PathVariable Long id);

}
