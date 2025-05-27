package com.librartesj.library_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSimpleDTO
{
    private Long id;
    private String name;
    private String biography;
    private LocalDate birthdate;
}
