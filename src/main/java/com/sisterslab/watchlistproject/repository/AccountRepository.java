package com.sisterslab.watchlistproject.repository;

import com.sisterslab.watchlistproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
