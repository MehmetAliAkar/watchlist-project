package com.sisterslab.watchlistproject.controller;

import com.sisterslab.watchlistproject.dto.request.FilmRequestDto;
import com.sisterslab.watchlistproject.dto.response.FilmResponse;
import com.sisterslab.watchlistproject.service.FilmService;
import com.sisterslab.watchlistproject.shared.endpoints.FilmEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FilmEndpoints.ACCOUNTS)
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;
    @PostMapping
    public List<FilmResponse> save(@RequestBody List<FilmRequestDto> dto){
        return filmService.save(dto);
    }

    @GetMapping
    public List<FilmResponse> getAll(){
        return filmService.getAll();
    }

    @DeleteMapping("/name")
    public void deleteByName(@RequestParam String name){
        filmService.deleteByName(name);
    }
    @PutMapping("/{id}")
    public FilmResponse updateAccount(@PathVariable Long id, @RequestBody FilmRequestDto dto){
        return filmService.updateFilm(id, dto);
    }
}