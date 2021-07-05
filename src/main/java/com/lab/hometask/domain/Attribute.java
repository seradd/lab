package com.lab.hometask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Table(name = "attribute")
@Entity
public class Attribute extends BaseEntity<Long> {

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "attribute_id")
    private Set<Item> items;

    @ManyToOne
    private Category category;

}
