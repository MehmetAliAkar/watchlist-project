package com.sisterslab.watchlistproject.repository;

import com.sisterslab.watchlistproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
