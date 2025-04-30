package com.generation.ammazzon.model.dtos.mappers;

import com.generation.ammazzon.model.dtos.ItemAmmazzonDto;
import com.generation.ammazzon.model.entities.ItemAmmazzon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemMapper
{

    public ItemAmmazzonDto toDto(ItemAmmazzon item)
    {
        return new ItemAmmazzonDto(item.getId(), item.getProdotto().getNome(),item.getQtn(),item.getProdotto().getPrezzo());
    }

    public List<ItemAmmazzonDto> toDtos(List<ItemAmmazzon> items)
    {
        List<ItemAmmazzonDto> dtos = items.stream().map(item -> toDto(item)).toList();
        return dtos;
    }
}
