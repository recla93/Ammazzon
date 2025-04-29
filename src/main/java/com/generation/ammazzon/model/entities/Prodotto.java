package com.generation.ammazzon.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Prodotto extends BaseEntity
{
	private String nome;
	private double prezzo;

	@ManyToMany
	@JoinTable(
			name = "prodotto_to_categoria",
			joinColumns = @JoinColumn(name = "id_prodotto"),
			inverseJoinColumns = @JoinColumn(name = "id_categoria")
	)
	private List<Categoria> categorie = new ArrayList<>();
}
