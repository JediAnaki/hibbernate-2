package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Store;

public class StoreDAO extends GenericDAO<Store> {

    public StoreDAO() {
        super(Store.class);
    }
}
