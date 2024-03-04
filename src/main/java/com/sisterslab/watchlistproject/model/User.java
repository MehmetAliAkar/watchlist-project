package com.sisterslab.watchlistproject.model;

import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usr")
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String userName;
    private String email;
    private String password;
}
