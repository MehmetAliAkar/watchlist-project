package com.sisterslab.watchlistproject.model;

import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "film")
public class Film extends BaseModel {
    private String name;
    private String description;
    //private Date publicationDate;
    private double puan;
    @ManyToMany(mappedBy = "films", fetch = FetchType.LAZY)

    private Set<User> users;
}
