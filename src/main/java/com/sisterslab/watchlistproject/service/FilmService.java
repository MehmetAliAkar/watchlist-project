package com.sisterslab.watchlistproject.service;

import com.sisterslab.watchlistproject.converter.FilmConverter;
import com.sisterslab.watchlistproject.dto.request.FilmRequestDto;
import com.sisterslab.watchlistproject.dto.response.FilmResponse;
import com.sisterslab.watchlistproject.model.Film;
import com.sisterslab.watchlistproject.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository accountRepository;
    private final FilmConverter accountConverter;
    private final UserService userService;

    public List<FilmResponse> save(List<FilmRequestDto> requestList) {
        List<Film> accountList = new ArrayList<>();
        for(FilmRequestDto request : requestList){
            Film account = accountConverter.toEntity(request);
            accountList.add(account);
        }
        List<Film> savedAccount = accountRepository.saveAll(accountList);
        List<FilmResponse> responseList = new ArrayList<>();
        for(Film account : savedAccount){
            responseList.add(accountConverter.toResponse(account));
        }
        return responseList;
    }

    public List<FilmResponse> getAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(accountConverter :: toResponse)
                .collect(Collectors.toList());
    }
    public void deleteByName(String name) {
        if (Objects.isNull(name)){
            throw new RuntimeException("Silinecek filmin adını giriniz!");
        }
        else{
            Film account = accountRepository.findByName(name);
            accountRepository.delete(account);
        }
    }

    public FilmResponse updateFilm(Long id, FilmRequestDto dto) {
        Film theRealAccount = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunadi"));
        theRealAccount.setName(dto.getName());
        theRealAccount.setDescription(dto.getDescription());
        theRealAccount.setPuan(dto.getPuan());

        return accountConverter
                .toResponse(accountRepository.save(theRealAccount));
    }

}
