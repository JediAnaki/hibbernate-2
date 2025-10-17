package ru.kulikov.javarush.service;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.kulikov.javarush.dao.RentalDAO;

import java.time.LocalDateTime;

@AllArgsConstructor
public class RentalReturnService {

    private final RentalDAO rentalDAO;
    private final SessionFactory sessionFactory;

    public void returnRental(int rentalId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            var returnRentalById = rentalDAO.getById(rentalId, session);
            if (returnRentalById.getReturnDate() == null) {
                returnRentalById.setReturnDate(LocalDateTime.now());
            }
            System.out.println("Фильм с ID = " + rentalId + " успешно возвращен " + returnRentalById.getReturnDate());
            session.getTransaction().commit();
        }
    }
}
