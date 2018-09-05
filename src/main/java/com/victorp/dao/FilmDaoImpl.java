package com.victorp.dao;

import com.victorp.model.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDaoImpl implements FilmDao {

    private Connection connection;

    public FilmDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Film> getAllFilm() {
        List<Film> listAllFilm = new ArrayList<>();

        String sql = "SELECT ID, TITLE, DESCRIPTION FROM FILMS";

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listAllFilm.add(new Film(resultSet.getLong( 1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAllFilm;
    }

    @Override
    public Film getFilmById(Long id) {
        String sql = "SELECT * FROM FILMS WHERE ID = ?";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Film film = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {
                film = new Film(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public Film updateFilm(Long id, String title, String description) {
        return null;
    }

    @Override
    public void deleteFilmById(Long id) {
        String sql = "DELETE FROM FILMS WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        Film film = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Film insertFilm(Film film) {
        String sql = "INSERT INTO FILMS (TITLE, DESCRIPTION) VALUES (?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
}
