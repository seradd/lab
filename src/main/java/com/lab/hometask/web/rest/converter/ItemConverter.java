package com.lab.hometask.web.rest.converter;

import com.lab.hometask.domain.Item;
import com.lab.hometask.dto.ItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemConverter extends BaseConverter<Item, ItemDto> {
}
