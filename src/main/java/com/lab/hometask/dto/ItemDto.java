package com.lab.hometask.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String itemValue;
    private CategoryDto category;
}
