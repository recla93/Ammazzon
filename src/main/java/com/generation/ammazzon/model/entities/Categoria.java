package com.generation.ammazzon.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Categoria extends BaseEntity
{
	private String nome;

	@ManyToMany(mappedBy = "categorie")
	private List<Prodotto> prodotti = new ArrayList<>();
}
