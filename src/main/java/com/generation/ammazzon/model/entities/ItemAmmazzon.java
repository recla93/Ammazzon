package com.generation.ammazzon.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ItemAmmazzon extends BaseEntity
{
	private int qtn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_carrello")
	private Carrello carrello;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ordine")
	private Ordine ordine;
}
