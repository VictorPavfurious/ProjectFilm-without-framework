package com.victorp.service;

import com.victorp.model.Film;

import java.util.List;

public interface GetFilmsService {
    List<Film> getAllFilm();
    Film getFilmById(Long id);
    Film updateFilm(Long id, String title, String description);
    void deleteFilmById(Long id);
    Film insertFilm(Film film);

}
