package com.lab.hometask.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @Override
    public String toString() {
        return "AttributeDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
