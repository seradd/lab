package com.lab.hometask.web.rest.converter;

import com.lab.hometask.domain.Category;
import com.lab.hometask.dto.CategoryDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryConverter extends BaseConverter<Category, CategoryDto> {
}
