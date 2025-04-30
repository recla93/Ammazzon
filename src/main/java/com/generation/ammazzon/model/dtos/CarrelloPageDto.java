package com.generation.ammazzon.model.dtos;

import com.generation.ammazzon.model.entities.ItemAmmazzon;

import java.util.List;

public record CarrelloPageDto
(
    Long id,
    List<ItemAmmazzonDto> items,
    double totale
)
{
}
