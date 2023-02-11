package com.fmi.demo.exposition.ICommand;

import com.fmi.demo.domain.model.SavedOutfits;
import com.fmi.demo.domain.repository.SavedOutfitsRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SavedOutfitsCommandImpl implements ICommand<SavedOutfits> {
    private SavedOutfitsRepository savedOutfitsRepository;
    @Override
    public String save(SavedOutfits body) {
        if(body.getClothesIds().isEmpty() || !StringUtils.hasText(body.getName()) || !ObjectUtils.isEmpty(body.getSeason()) ||
                !ObjectUtils.isEmpty(body.getOccasion())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
        return savedOutfitsRepository.save(body);
    }

    @Override
    public String update(SavedOutfits body, String id) {
        if(body.getClothesIds().isEmpty() || !StringUtils.hasText(body.getName()) || !ObjectUtils.isEmpty(body.getSeason()) ||
                !ObjectUtils.isEmpty(body.getOccasion())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
        if(!StringUtils.hasText(id) || savedOutfitsRepository.existsById(id) || !body.equals(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        return savedOutfitsRepository.save(body);
    }

    @Override
    public void delete(String id) {
        if(!StringUtils.hasText(id) || !savedOutfitsRepository.existsById(id)){
            throw new CustomErrorHandler(ExceptionEnum.OBJECT_NOT_FOUND);
        }
        savedOutfitsRepository.delete(id);
    }
}
