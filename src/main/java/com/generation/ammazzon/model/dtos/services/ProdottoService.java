package com.generation.ammazzon.model.dtos.services;

import com.generation.ammazzon.model.daos.ProdottoDao;
import com.generation.ammazzon.model.dtos.ProdottoDto;
import com.generation.ammazzon.model.dtos.mappers.ProdottoMapper;
import com.generation.ammazzon.model.entities.Prodotto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * La funzionalità che offre è la comunicazione con il db
 * sotto forma di DTO, non entità
 * Riceve/restituisce dto letti/da inserire nel db
 * DAO+MAPPER
 */
@Service
@RequiredArgsConstructor//genera un costruttore con le proprietà obbligatorie
public class ProdottoService
{
    private final ProdottoDao dao;
    private final ProdottoMapper mapper;


    public List<ProdottoDto> leggiTuttiProdottiComeDto()
    {
//        List<Prodotto> prodotti = dao.findAll();
//        List<ProdottoDto> res = mapper.toDtos(prodotti);
//        return res;
        return mapper.toDtos(dao.findAll());
    }
}
