package com.sisterslab.watchlistproject.repository;

import com.sisterslab.watchlistproject.model.Film;
import com.sisterslab.watchlistproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByName(String name);
}
