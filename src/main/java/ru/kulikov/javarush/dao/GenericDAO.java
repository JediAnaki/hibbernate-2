package ru.kulikov.javarush.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T> {
    private final Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getById(Serializable id, Session session) {
        return (T) session.get(clazz, id);
    }

    public List<T> getItems(int offset, int count, Session session) {
        var query = session.createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.getResultList();
    }

    public List<T> findAll(Session session) {
        return session.createQuery("from " + clazz.getName(), clazz).list();
    }

    public T save(final T entity, Session session) {
        session.saveOrUpdate(entity);
        return entity;
    }

    public void delete(final T entity, Session session) {
        session.delete(entity);
    }

    public void deleteById(final int entityId, Session session) {
        final T entity = getById(entityId, session);
        delete(entity, session);
    }
}
