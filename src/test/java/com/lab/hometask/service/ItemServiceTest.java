package com.lab.hometask.service;

import com.lab.hometask.domain.Item;
import com.lab.hometask.exception.CustomException;
import com.lab.hometask.repository.ItemRepository;
import com.lab.hometask.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;


    @Test
    void when_ItemNotExists_thenThrowException_onUpdateItem() {
        Item item = new Item();
        when(itemRepository.itemExists(item.getId())).thenReturn(false);
        CustomException.ItemNotFoundException exception = assertThrows(
                CustomException.ItemNotFoundException.class, () -> itemService.updateItem(new Item()));
        assertNotNull(exception);
        assertEquals(exception.getMessage(), "No Items found with given Id: " + item.getId());

    }

    @Test
    void when_ItemNotExists_thenThrowException_onGetItem() {
        when(itemRepository.findAllByCategoryIdAndIsActiveTrue(1L)).thenReturn(Optional.empty());
        CustomException.ItemNotFoundException exception = assertThrows(
                CustomException.ItemNotFoundException.class, () -> itemService.getItemsOfCategory(1L));
        assertNotNull(exception);
        assertEquals(exception.getMessage(), "No Items found with given categoryId: " + 1L);

    }

    private Item getItem() {
        Item item = new Item();
        item.setId(1L);
        return item;
    }
}
