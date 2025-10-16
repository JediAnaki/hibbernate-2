package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Customer;

public class CustomerDAO extends GenericDAO<Customer> {

    public CustomerDAO() {
        super(Customer.class);
    }
}
