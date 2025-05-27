package com.librartesj.authorservice.repository;

import com.librartesj.authorservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long>
{
    @Query("SELECT author FROM Author author WHERE LOWER(author.name) = LOWER(:name)")
    Optional<Author> findByName(String name);

    @Query("SELECT author FROM Author author WHERE LOWER(author.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Author> searchByName(String name);


}
