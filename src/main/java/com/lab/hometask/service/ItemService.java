package com.lab.hometask.service;

import com.lab.hometask.domain.Item;
import com.lab.hometask.dto.ItemDto;

import java.util.List;

public interface ItemService {

    void createItemsWithCategory(Item item);
    List<ItemDto> getItemsOfCategory(Long categoryId);
    ItemDto updateItem(Item item);
}
