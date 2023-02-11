package com.fmi.demo.exposition.IQuerry;

import com.fmi.demo.domain.model.SavedOutfits;
import com.fmi.demo.domain.repository.SavedOutfitsRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SavedOutfitsQuerryImpl implements IQuerry<SavedOutfits> {

    private SavedOutfitsRepository savedOutfitsRepository;
    @Override
    public SavedOutfits getById(String id) {
        if(!StringUtils.hasText(id) || !savedOutfitsRepository.existsById(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        return savedOutfitsRepository.getById(id).get();
    }

    @Override
    public List<SavedOutfits> getAll() {
        return savedOutfitsRepository.getAll();
    }
}
