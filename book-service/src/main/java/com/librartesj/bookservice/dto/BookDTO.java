package com.librartesj.bookservice.dto;

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
public class BookDTO
{
    private Long id;
    private String title;
    private String synopsis;
    private LocalDate print_date;

    private List<String> authors_names;
}
