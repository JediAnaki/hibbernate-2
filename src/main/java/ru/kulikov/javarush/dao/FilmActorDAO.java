package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.FilmActor;

public class FilmActorDAO extends GenericDAO<FilmActor> {

    public FilmActorDAO() {
        super(FilmActor.class);
    }
}
