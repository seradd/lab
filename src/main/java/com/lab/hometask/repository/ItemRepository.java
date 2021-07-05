package com.lab.hometask.repository;

import com.lab.hometask.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<List<Item>> findAllByCategoryIdAndIsActiveTrue(Long categoryId);

    @Query("select case when count(i)> 0 then true else false end from Item i where i.id= :itemId and i.isActive = true ")
    boolean itemExists(@Param("itemId") Long itemId);
}
