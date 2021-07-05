package com.lab.hometask.web.rest;

import com.lab.hometask.domain.Item;
import com.lab.hometask.dto.ItemDto;
import com.lab.hometask.service.ItemService;
import com.lab.hometask.validator.ItemValidator;
import com.lab.hometask.web.rest.converter.ItemConverter;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/item/")
public class ItemResource extends ParentResource {

    private final ItemService itemService;
    private final ItemConverter itemConverter;
    private final ItemValidator itemValidator;

    @ApiOperation(value = "Create Items In Categories")
    @PostMapping("/create")
    public ResponseEntity<Void> createItemsWithCategory(@RequestBody ItemDto itemDto) {
        itemService.createItemsWithCategory(itemConverter.toEntity(itemDto));
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Gets items of a category")
    @GetMapping("/get-items/{categoryId}")
    public ResponseEntity<List<ItemDto>> createItemsWithCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(itemService.getItemsOfCategory(categoryId));
    }

    @ApiOperation(value = "Updates Item")
    @PutMapping("/update-item")
    public ResponseEntity<?> updateItems(@RequestBody Item item, BindingResult result) {
        itemValidator.validate(item, result);
        if (result.hasErrors()) {
            return ResponseEntity.ok(collectErrors(result, item.toString()));
        }
        return ResponseEntity.ok().body(itemService.updateItem(item));
    }
}
