package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Language;

public class LanguageDAO extends GenericDAO<Language> {

    public LanguageDAO() {
        super(Language.class);
    }
}
