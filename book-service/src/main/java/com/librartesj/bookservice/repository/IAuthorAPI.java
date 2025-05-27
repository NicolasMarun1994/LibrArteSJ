package com.librartesj.bookservice.repository;

import com.librartesj.bookservice.dto.AuthorDTO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "author-service")
public interface IAuthorAPI
{
    @GetMapping("/authors/get-by-name/{author_name}")
    public AuthorDTO getAuthorByName(@PathVariable String author_name);

    @PostMapping("/authors/create-basic/{bookID}")
    public String createBasicAuthor(@RequestBody AuthorDTO author,@PathVariable Long bookID);

    @PutMapping("/authors/update-booksid/{bookId}/{authorId}")
    public String addBookId(@PathVariable Long bookId,@PathVariable Long authorId);



}
