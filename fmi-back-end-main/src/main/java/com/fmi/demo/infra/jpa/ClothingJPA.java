package com.fmi.demo.infra.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "product")
@Entity(name="Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothingJPA extends BasicEntityJPA{

    @Column(name = "name", nullable = false)
    private String name;

//TODO: IMPLEMENT USER CLASS MAKE IT A MANY TO MANY TO THIS CALSS
    //private UserJPA user;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name="colors")
    private String colors;

    @ManyToOne
    @JoinColumn(name="clothes_category")
    ClothesCategoryJPA clothesCategory;

    @ManyToOne
    @JoinColumn(name="clothes_brand")
    ClothesBrandJPA clothesBrand;

}
