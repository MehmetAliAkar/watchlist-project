package com.sisterslab.watchlistproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

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
    @JoinTable(
            name = "user_account",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )

    private Set<Account> accounts;
}
