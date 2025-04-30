package com.generation.ammazzon.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Carrello extends BaseEntity
{
	@OneToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "carrello")
	private List<ItemAmmazzon> items = new ArrayList<>();

	public double getTotale()
	{
		return items.stream().mapToDouble(i->i.getQtn()*i.getProdotto().getPrezzo()).sum();
	}
}
