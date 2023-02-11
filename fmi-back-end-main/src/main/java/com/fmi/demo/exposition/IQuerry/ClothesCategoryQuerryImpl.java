package com.fmi.demo.exposition.IQuerry;

import com.fmi.demo.domain.model.ClothesCategory;
import com.fmi.demo.domain.repository.ClothesCategoryRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ErrorDetails;
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
public class ClothesCategoryQuerryImpl implements IQuerry<ClothesCategory> {

    private final ClothesCategoryRepository clothesCategoryRepository;

    @Override
    public ClothesCategory getById(String id) {
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        return clothesCategoryRepository.getById(id).get();
    }

    @Override
    public List<ClothesCategory> getAll() {
        return clothesCategoryRepository.getAll();
    }
}
