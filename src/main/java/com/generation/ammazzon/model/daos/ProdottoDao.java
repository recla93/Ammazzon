package com.generation.ammazzon.model.daos;

import com.generation.ammazzon.model.entities.Carrello;
import com.generation.ammazzon.model.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoDao extends JpaRepository<Prodotto,Long>
{
}
