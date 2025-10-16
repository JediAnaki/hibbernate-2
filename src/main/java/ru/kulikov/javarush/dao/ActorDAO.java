package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Actor;

public class ActorDAO extends GenericDAO<Actor> {

    public ActorDAO() {
        super(Actor.class);
    }
}
