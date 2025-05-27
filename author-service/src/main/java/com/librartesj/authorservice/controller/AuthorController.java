package com.librartesj.authorservice.controller;


import com.librartesj.authorservice.dto.AuthorDTO;
import com.librartesj.authorservice.model.Author;
import com.librartesj.authorservice.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    @Autowired
    private IAuthorService authorService;

    @PostMapping("/create")
    public String createAuthor (@RequestBody Author author)
    {
        authorService.saveAuthor(author.getName(),author.getBiography(),author.getBirthdate(),author.getBooks_ids());
        return "Autor Creado Correctamente";
    }

    @PostMapping("/create-basic/{bookID}")
    public String createBasicAuthor(@RequestBody AuthorDTO author,@PathVariable Long bookID)
    {
        //Debo recibir el ID de Book como Long y enviarlo a saveBasicAuthor
        authorService.saveBasicAuthor(author,bookID);

        return "Autor Creado Correctamente";
    }

    @GetMapping("/get-all")
    public List<Author> getAllAuthors()
    {
        return authorService.getAllAuthors();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable Long id)
    {
        Author author = authorService.findAuthor(id);
        if (author == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Author with ID " + id + " Not Found"); //Devuelvo el String
        }
        return ResponseEntity.ok(author);//Devuelvo objeto Autor
    }

    /*@GetMapping("/get/{id}")
    public Author getAuthor(@PathVariable Long id)
    {
        return authorService.findAuthor(id);
    }*/



    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<?> getAuthorByName(@PathVariable String name)
    {
        Optional<Author> author = authorService.findAuthorByName(name);
        if (author.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Author with NAME " + name + " Not Found"); //Devuelvo el String
        }
        return ResponseEntity.ok(author.get());//Devuelvo objeto Autor //probar devolviendo author sin get
    }

    // Probando ResponseEntity Con LIsta, de ser positivo modificar a posterior los otros
    @GetMapping("/search-by-name/{name}")
    public ResponseEntity<?> searchAuthorByName (@PathVariable String name)
    {
        List<Author> authorList = authorService.searchAuthorByName(name);

        if(authorList.isEmpty() == true)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Authors NOT FOUND");
        }
        return ResponseEntity.ok(authorList);

    }

    @PutMapping("/update/{id}")
    public Author updateAuthor (@PathVariable Long id,
                                @RequestBody Author author)
    {
        authorService.updateAuthor(id,author);
        Author authory = authorService.findAuthor(id);
        return authory;

    }

    @PutMapping ("/update-booksid/{bookId}/{authorId}")
    public ResponseEntity<String> addBookId(@PathVariable Long bookId, @PathVariable Long authorId)
    {
        authorService.addBookId(bookId,authorId);
        return ResponseEntity.ok("ID agregada correctamente");

    }


    @DeleteMapping("/delete/{id}")
    public String deleteAuthor (@PathVariable Long id)
    {
        authorService.deleteAuthor(id);
        return "Eliminado Correctamente";
    }

}
