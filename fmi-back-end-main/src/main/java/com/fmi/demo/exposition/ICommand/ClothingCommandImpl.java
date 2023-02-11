package com.fmi.demo.exposition.ICommand;

import com.fmi.demo.domain.model.Clothing;
import com.fmi.demo.domain.repository.ClothingRepository;
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
public class ClothingCommandImpl implements ICommand<Clothing>{

    private final ClothingRepository clothingRepository;

    @Override
    public String save(Clothing body) {
        fieldValidation(body);
        return clothingRepository.save(body);
    }



    @Override
    public String update(Clothing body, String id) {
        if(!body.getId().equals(id) || !StringUtils.hasText(body.getId())){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        fieldValidation(body);
        return clothingRepository.save(body);
    }

    @Override
    public void delete(String id) {
        if(!StringUtils.hasText(id)){
            throw new CustomErrorHandler(ExceptionEnum.INVALID_FIELD);
        }
        clothingRepository.delete(id);

    }

    private void fieldValidation(Clothing body) {
        if(!StringUtils.hasText(body.getName()) ||
                ObjectUtils.isEmpty(body.getClothesBrand()) ||
                ObjectUtils.isEmpty(body.getClothesCategory()) ||
                body.getColors().size() <1
        ) {
            throw new CustomErrorHandler(ExceptionEnum.EMPTY_FIELD);
        }
    }
}
