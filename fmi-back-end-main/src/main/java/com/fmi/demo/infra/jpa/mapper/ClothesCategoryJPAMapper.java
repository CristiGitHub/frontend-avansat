package com.fmi.demo.infra.jpa.mapper;

import com.fmi.demo.domain.model.ClothesCategory;
import com.fmi.demo.infra.jpa.ClothesCategoryJPA;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {}
)
public interface ClothesCategoryJPAMapper extends GenericMapper<ClothesCategory, ClothesCategoryJPA> {
}
