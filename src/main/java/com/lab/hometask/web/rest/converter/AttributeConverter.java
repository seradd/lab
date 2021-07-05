package com.lab.hometask.web.rest.converter;

import com.lab.hometask.domain.Attribute;
import com.lab.hometask.dto.AttributeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeConverter extends BaseConverter<Attribute, AttributeDto> {
}
