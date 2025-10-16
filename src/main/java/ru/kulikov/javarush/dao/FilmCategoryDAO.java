package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.FilmCategory;

public class FilmCategoryDAO extends GenericDAO<FilmCategory> {

    public FilmCategoryDAO() {
        super(FilmCategory.class);
    }
}
