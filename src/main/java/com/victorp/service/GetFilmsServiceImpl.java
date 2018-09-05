package com.victorp.service;

import com.victorp.dao.FilmDao;
import com.victorp.model.Film;

import java.util.List;

public class GetFilmsServiceImpl implements GetFilmsService {

    private FilmDao filmDao;

    public GetFilmsServiceImpl(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public List<Film> getAllFilm() {
        return filmDao.getAllFilm();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDao.getFilmById(id);
    }

    @Override
    public Film updateFilm(Long id, String title, String description) {
        return filmDao.updateFilm(id, title, description);
    }

    @Override
    public void deleteFilmById(Long id) {
        filmDao.deleteFilmById(id);
    }

    @Override
    public Film insertFilm(Film film) {
        return filmDao.insertFilm(film);
    }
}
