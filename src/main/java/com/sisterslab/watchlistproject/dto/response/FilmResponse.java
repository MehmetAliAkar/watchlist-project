package com.sisterslab.watchlistproject.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FilmResponse {
    private Long id;
    //private Long userId;
    private Date createdDate;
    private Date updatedDate;
    private String name;
    private String description;
    private Date publicationDate;
    private double puan;
}
