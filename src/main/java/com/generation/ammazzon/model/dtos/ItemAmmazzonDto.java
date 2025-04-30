package com.generation.ammazzon.model.dtos;

public record ItemAmmazzonDto
        (
                Long id,
                String nomeProdotto,
                int qtn,
                double prezzoUnitario
        )
{
}
