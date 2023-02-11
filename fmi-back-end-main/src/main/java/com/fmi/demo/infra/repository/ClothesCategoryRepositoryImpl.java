package com.fmi.demo.infra.repository;

import com.fmi.demo.domain.model.ClothesCategory;
import com.fmi.demo.domain.repository.ClothesCategoryRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;
import com.fmi.demo.infra.jpa.ClothesCategoryJPA;
import com.fmi.demo.infra.jpa.mapper.ClothesCategoryJPAMapper;
import com.fmi.demo.infra.repository.jpa.ClothesCategoryJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Repository
public class ClothesCategoryRepositoryImpl implements ClothesCategoryRepository {

    private final ClothesCategoryJPAMapper clothesCategoryJPAMapper;

    private final ClothesCategoryJPARepository clothesCategoryJPARepository;
    @Override
    public String save(ClothesCategory clothing) {
    return clothesCategoryJPARepository.save(clothesCategoryJPAMapper.toDto(clothing)).getId();
    }

    @Override
    public void delete(String id) {
        clothesCategoryJPARepository.deleteById(id);
    }

    @Override
    public Optional<ClothesCategory> getById(String id) {
        Optional<ClothesCategoryJPA> clothesCategoryJPA = clothesCategoryJPARepository.findById(id);
        if(clothesCategoryJPA.isEmpty()){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        return Optional.of(clothesCategoryJPAMapper.toDomain(clothesCategoryJPA.get()));
    }

    @Override
    public boolean existsById(String id) {
        return clothesCategoryJPARepository.existsById(id);
    }

    @Override
    public List<ClothesCategory> getAll() {
        return clothesCategoryJPARepository.findAll().stream().map(clothesCategoryJPAMapper::toDomain).toList();
    }
}
