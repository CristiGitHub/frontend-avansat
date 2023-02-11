package com.fmi.demo.infra.jpa;

import com.fmi.demo.domain.model.enums.OccasionsEnum;
import com.fmi.demo.domain.model.enums.SeasonsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "saved_outfits")
@Entity(name="SavedOutfits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavedOutfitsJPA extends BasicEntityJPA{

    @Column(name="name")
    private String name;

    @Column(name="clothes_ids")
    private String clothesIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "occasion", nullable = false)
    private OccasionsEnum occasion;

    @Enumerated(EnumType.STRING)
    @Column(name = "season", nullable = false)
    private SeasonsEnum season;

}
