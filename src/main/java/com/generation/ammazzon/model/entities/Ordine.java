package com.generation.ammazzon.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ordine extends BaseEntity
{
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	private boolean pagato;
	private LocalDate consegna;
	private String indirizzo;

	@OneToMany(mappedBy = "ordine",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ItemAmmazzon> items = new ArrayList<>();

	public double getTotale()
	{
		return items.stream().mapToDouble(i->i.getQtn()*i.getProdotto().getPrezzo()).sum();
	}
}
