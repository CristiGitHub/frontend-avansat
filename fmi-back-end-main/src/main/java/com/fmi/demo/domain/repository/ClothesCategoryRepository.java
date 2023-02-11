package com.fmi.demo.domain.repository;

import com.fmi.demo.domain.model.ClothesCategory;
import com.fmi.demo.domain.model.Clothing;

import java.util.List;
import java.util.Optional;

public interface ClothesCategoryRepository {
    String save(ClothesCategory clothing);

    void delete(String id);

    Optional<ClothesCategory> getById(String id);

    boolean existsById(String id);

    List<ClothesCategory> getAll();
}
