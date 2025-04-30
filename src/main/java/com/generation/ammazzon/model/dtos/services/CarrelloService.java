package com.generation.ammazzon.model.dtos.services;

import com.generation.ammazzon.model.daos.CarrelloDao;
import com.generation.ammazzon.model.dtos.CarrelloPageDto;
import com.generation.ammazzon.model.dtos.mappers.CarrelloMapper;
import com.generation.ammazzon.model.entities.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService
{
    @Autowired
    CarrelloDao cDao;
    @Autowired
    CarrelloMapper cMapper;

    public CarrelloPageDto getMyCarrello(String username)
    {
        Carrello c = cDao.findByUtente_Username(username);
        return cMapper.toDto(c);
    }
}
