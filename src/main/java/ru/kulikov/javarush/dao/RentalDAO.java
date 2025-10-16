package ru.kulikov.javarush.dao;

import org.hibernate.Session;
import ru.kulikov.javarush.entity.Rental;

import java.util.List;

public class RentalDAO extends GenericDAO<Rental> {

    public RentalDAO() {
        super(Rental.class);
    }

    public Rental findLastRentalByInventoryId(int inventoryId, Session session) {
        List<Rental> rentals = session.createQuery(
                        "from Rental r where r.inventory.inventoryId = :inventoryId order by r.rentalDate desc",
                        Rental.class
                )
                .setParameter("inventoryId", inventoryId)
                .setMaxResults(1)
                .getResultList();

        return rentals.isEmpty() ? null : rentals.get(0);
    }
}
