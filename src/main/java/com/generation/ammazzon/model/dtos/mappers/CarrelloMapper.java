package com.generation.ammazzon.model.dtos.mappers;

import com.generation.ammazzon.model.dtos.CarrelloPageDto;
import com.generation.ammazzon.model.dtos.ItemAmmazzonDto;
import com.generation.ammazzon.model.entities.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrelloMapper
{
    @Autowired
    ItemMapper itemMapper;

    public CarrelloPageDto toDto(Carrello c)
    {
        List<ItemAmmazzonDto> items = itemMapper.toDtos(c.getItems());

        return new CarrelloPageDto(c.getId(),items,c.getTotale());
    }

}
