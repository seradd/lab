package com.lab.hometask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Table(name = "item")
@Entity
public class Item extends BaseEntity<Long> {

    @NotNull
    @Column(name = "value")
    private String itemValue;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Attribute attribute;

}
