package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.City;

public class CityDAO extends GenericDAO<City> {

    public CityDAO() {
        super(City.class);
    }
}
