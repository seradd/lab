package com.lab.hometask.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Set<AttributeDto> attributes;

    @Override
    public String toString() {
        return "CategoryDto{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
