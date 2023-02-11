package com.fmi.demo.infra.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Table(name="clothes_category")
@Entity(name="ClothesCategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothesCategoryJPA extends BasicEntityJPA{

    @Column(name = "name")
    private String name;

    @Column(name= "session")
    private String session;

    @OneToMany(mappedBy = "clothesCategory")
    Set<ClothingJPA> clothings = new HashSet<>();
}
