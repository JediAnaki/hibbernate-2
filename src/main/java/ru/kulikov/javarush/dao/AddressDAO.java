package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Address;

public class AddressDAO extends GenericDAO<Address> {

    public AddressDAO() {
        super(Address.class);
    }
}
