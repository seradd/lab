package com.lab.hometask.service.impl;

import com.lab.hometask.domain.Item;
import com.lab.hometask.dto.ItemDto;
import com.lab.hometask.exception.CustomException;
import com.lab.hometask.repository.ItemRepository;
import com.lab.hometask.service.ItemService;
import com.lab.hometask.web.rest.converter.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemConverter itemConverter;

    @Override
    public void createItemsWithCategory(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<ItemDto> getItemsOfCategory(Long categoryId) {
        final List<Item> items = itemRepository.findAllByCategoryIdAndIsActiveTrue(categoryId)
                .orElseThrow(() -> new CustomException.ItemNotFoundException("No Items found with given categoryId: " + categoryId));
        return itemConverter.toDto(items);
    }

    @Override
    public ItemDto updateItem(Item item) {
        if (!itemRepository.itemExists(item.getId())) {
            throw new CustomException.ItemNotFoundException("No Items found with given Id: " + item.getId());
        }
        return itemConverter.toDto(itemRepository.save(item));
    }
}
