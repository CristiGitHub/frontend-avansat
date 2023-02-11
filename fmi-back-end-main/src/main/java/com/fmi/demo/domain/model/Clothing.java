package com.fmi.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clothing  {

    protected String id;
    private String name;
    private String description;
    private String image;
    private List<String> colors;
    ClothesCategory clothesCategory;
    ClothesBrand clothesBrand;

}
