package com.sisterslab.watchlistproject.model;

import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Usr")
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String userName;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "User_Course_Table",
            joinColumns = {
                    @JoinColumn(name="user_id",referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="account_id",referencedColumnName = "id")
            }
    )
    private List<Account> accounts;
}
