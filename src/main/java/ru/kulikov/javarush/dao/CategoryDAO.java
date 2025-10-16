package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Category;

public class CategoryDAO extends GenericDAO<Category> {

    public CategoryDAO() {
        super(Category.class);
    }
}
