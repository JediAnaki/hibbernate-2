package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Staff;

public class StaffDAO extends GenericDAO<Staff> {

    public StaffDAO() {
        super(Staff.class);
    }
}
