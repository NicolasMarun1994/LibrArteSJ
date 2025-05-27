package com.librartesj.bookservice.repository;

import com.librartesj.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IBookRepository extends JpaRepository<Book,Long>
{
    // ACA BUSCO EL NOMBRE EXACTO
    @Query("SELECT book FROM Book book WHERE LOWER(book.title) = LOWER(:title)")
    Optional<Book> findByTitle(String title);

    //ACA BUSCO EL NOMBRE QUE CONTENGA UNA PALBRA
    @Query("SELECT book FROM Book book WHERE LOWER(book.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> searchByTitle(String title);

}
