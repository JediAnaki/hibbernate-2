package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.FilmText;

public class FilmTextDAO extends GenericDAO<FilmText> {

    public FilmTextDAO() {
        super(FilmText.class);
    }
}
