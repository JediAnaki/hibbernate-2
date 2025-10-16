package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Inventory;

public class InventoryDAO extends GenericDAO<Inventory> {

    public InventoryDAO() {
        super(Inventory.class);
    }
}
