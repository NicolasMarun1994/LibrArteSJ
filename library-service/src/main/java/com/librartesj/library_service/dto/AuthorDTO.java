package com.librartesj.library_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO
{
    private Long id;
    private String name;
    private String biography;
    private LocalDate birthdate;

    private List<Long> books_ids;
}
