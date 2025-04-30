package com.generation.ammazzon.model.dtos;

import java.util.List;

public record ProdottoDto
(
  Long id,
  String nome,
  double prezzo,
  List<String> categorie
)
{
}
