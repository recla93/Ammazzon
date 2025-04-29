package com.generation.ammazzon.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Utente extends BaseEntity
{
	private String username;

	@OneToOne(mappedBy = "utente")
	private Carrello carrello;

	@OneToMany(mappedBy = "utente",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Ordine> ordini = new ArrayList<>();
}
