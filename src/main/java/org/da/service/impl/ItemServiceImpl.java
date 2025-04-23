package org.da.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.da.dto.Item;
import org.da.dto.Orders;
import org.da.entity.ItemEntity;
import org.da.entity.OrderEntity;
import org.da.repository.ItemRepository;
import org.da.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
private final ItemRepository repository;
private final ModelMapper mapper;

    @Override
    public void addItem(Item item) {
        repository.save(mapper.map(item, ItemEntity.class));
    }

    @Override
    public List<Item> getall() {
        Iterable<ItemEntity> allitems = repository.findAll();
        List<Item> itemList=new ArrayList<>();

        allitems.forEach(itemEntity -> {
            itemList.add(mapper.map(itemEntity, Item.class));
        });
        return itemList;
    }

    @Override
    public void removeItem(Long id) {
        if (repository.existsById(id))
        {
            repository.deleteById(id);
        }
    }
}
