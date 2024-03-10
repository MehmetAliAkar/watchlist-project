package com.sisterslab.watchlistproject.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountRequestDto {
    private String name;
    //private Long userId;
    private String description;
    //private Date publicationDate;
    private double puan;
}
