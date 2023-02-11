package com.fmi.demo.domain.model.enums;

import lombok.Getter;

@Getter
public enum OccasionsEnum {

    FORMAL("Formal"),
    CASULA("Casual");
    private String name;

    OccasionsEnum(String name){
        this.name =name;
    }
}
