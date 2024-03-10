package com.sisterslab.watchlistproject.model;

import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account extends BaseModel {
    private String name;
    private String description;
    //private Date publicationDate;
    private double puan;
    @ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
    private Set<User> users;
}
