package com.sisterslab.watchlistproject.converter;

import com.sisterslab.watchlistproject.dto.request.FilmRequestDto;
import com.sisterslab.watchlistproject.dto.response.FilmResponse;
import com.sisterslab.watchlistproject.model.Film;
import org.springframework.stereotype.Component;


@Component
public class FilmConverter {
    public FilmResponse toResponse(Film entity){
        FilmResponse response = new FilmResponse();
        response.setId(entity.getId());
        //buraya userId
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setName(entity.getName());
        response.setPuan(entity.getPuan());
        response.setDescription(entity.getDescription());
        //response.setPublicationDate(entity.getPublicationDate());

        return response;
    }

    public Film toEntity(FilmRequestDto dto){
        Film film = new Film();
        film.setName(dto.getName());
        film.setPuan(dto.getPuan());
        film.setDescription(dto.getDescription());

        /*User user = new User();
        user.setId(dto.getUserId());*/

        //account.setUsers(Collections.singletonList(user));
        return film;
    }
}
