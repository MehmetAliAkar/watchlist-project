package com.sisterslab.watchlistproject.model;

import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account extends BaseModel {
    private String name;
    private String description;
    private Date publicationDate;
    private double puan;
    /*@OneToMany(mappedBy = "account")
    private List<AccountUser> accountUserList;*/
}
