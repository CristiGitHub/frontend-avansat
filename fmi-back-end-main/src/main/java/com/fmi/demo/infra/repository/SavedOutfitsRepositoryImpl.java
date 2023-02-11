package com.fmi.demo.infra.repository;

import com.fmi.demo.domain.model.SavedOutfits;
import com.fmi.demo.domain.repository.SavedOutfitsRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;
import com.fmi.demo.infra.jpa.SavedOutfitsJPA;
import com.fmi.demo.infra.jpa.mapper.SavedOutfitsJPAMapper;
import com.fmi.demo.infra.repository.jpa.SavedOutfitsJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Repository
public class SavedOutfitsRepositoryImpl implements SavedOutfitsRepository {

    private SavedOutfitsJPAMapper savedOutfitsJPAMapper;

    private SavedOutfitsJPARepository savedOutfitsJPARepository;
    @Override
    public String save(SavedOutfits clothing) {
        return savedOutfitsJPARepository.save(savedOutfitsJPAMapper.toDto(clothing)).getId();
    }

    @Override
    public void delete(String id) {
        savedOutfitsJPARepository.deleteById(id);
    }

    @Override
    public Optional<SavedOutfits> getById(String id) {
        Optional<SavedOutfitsJPA> savedOutfitsJPA = savedOutfitsJPARepository.findById(id);
        if(savedOutfitsJPA.isEmpty()){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        return  Optional.of(savedOutfitsJPAMapper.toDomain(savedOutfitsJPA.get()));
    }

    @Override
    public boolean existsById(String id) {
        return savedOutfitsJPARepository.existsById(id);
    }

    @Override
    public List<SavedOutfits> getAll() {
        return savedOutfitsJPARepository.findAll().stream().map(savedOutfitsJPAMapper::toDomain).toList();
    }
}
