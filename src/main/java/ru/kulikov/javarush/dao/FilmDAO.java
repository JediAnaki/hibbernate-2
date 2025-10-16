package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Film;

public class FilmDAO extends GenericDAO<Film> {

    public FilmDAO() {
        super(Film.class);
    }
}
