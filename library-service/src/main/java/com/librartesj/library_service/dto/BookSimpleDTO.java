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
public class BookSimpleDTO
{
    private Long id;
    private String title;
    private String synopsis;
    private LocalDate print_date;
}
