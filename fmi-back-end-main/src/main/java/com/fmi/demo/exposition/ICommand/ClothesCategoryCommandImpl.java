package com.fmi.demo.exposition.ICommand;

import com.fmi.demo.domain.model.ClothesCategory;
import com.fmi.demo.domain.repository.ClothesCategoryRepository;
import com.fmi.demo.exposition.exceptions.CustomErrorHandler;
import com.fmi.demo.exposition.exceptions.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClothesCategoryCommandImpl implements ICommand<ClothesCategory>{

    private ClothesCategoryRepository clothesCategoryRepository;
    @Override
    public String save(ClothesCategory body) {
        if(!StringUtils.hasText(body.getName()) || !StringUtils.hasText(body.getSession())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
        return clothesCategoryRepository.save(body);
    }

    @Override
    public String update(ClothesCategory body, String id) {
        if(!StringUtils.hasText(body.getName()) || !StringUtils.hasText(body.getSession())){
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
        if(!StringUtils.hasText(id) || !id.equals(body.getId()) || !StringUtils.hasText(body.getId())){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        return clothesCategoryRepository.save(body);
    }

    @Override
    public void delete(String id) {
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        clothesCategoryRepository.delete(id);
    }
}
