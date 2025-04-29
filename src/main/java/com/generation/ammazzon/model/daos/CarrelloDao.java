package com.generation.ammazzon.model.daos;

import com.generation.ammazzon.model.entities.Carrello;
import com.generation.ammazzon.model.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrelloDao extends JpaRepository<Carrello,Long>
{
}
