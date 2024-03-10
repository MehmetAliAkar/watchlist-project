/*package com.sisterslab.watchlistproject.model;

import com.sisterslab.watchlistproject.core.model.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUser extends BaseModel {
    private String userName;
    private String accountName;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;
}*/
