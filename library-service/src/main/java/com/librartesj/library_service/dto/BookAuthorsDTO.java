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
public class BookAuthorsDTO
{
    private Long id;
    private String title;
    private String synopsis;
    private LocalDate print_date;
    List<AuthorSimpleDTO> authors_list;
}
