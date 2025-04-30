package com.generation.ammazzon.controllers;

import com.generation.ammazzon.model.dtos.ProdottoDto;
import com.generation.ammazzon.model.dtos.services.ProdottoService;
import com.generation.ammazzon.model.entities.Prodotto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProdottoController
{
    private final ProdottoService serv;

    @GetMapping
    public List<ProdottoDto> getAll()
    {
        return serv.leggiTuttiProdottiComeDto();
    }

}
