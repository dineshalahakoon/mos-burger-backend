package org.da.service;

import org.da.dto.Item;

import java.util.List;

public interface ItemService {
    void addItem(Item item);

    List<Item> getall();

    void removeItem(Long id);
}
