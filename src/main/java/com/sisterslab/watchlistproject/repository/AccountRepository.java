package com.sisterslab.watchlistproject.repository;

import com.sisterslab.watchlistproject.model.Account;
import com.sisterslab.watchlistproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByName(String name);
}
