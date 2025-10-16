package ru.kulikov.javarush.service;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import ru.kulikov.javarush.dao.PaymentDAO;
import ru.kulikov.javarush.dao.RentalDAO;
import ru.kulikov.javarush.dto.RentalRequestDTO;
import ru.kulikov.javarush.entity.*;

import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
public class RentalService {

    private final SessionFactory sessionFactory;
    private final RentalDAO rentalDAO;
    private final PaymentDAO paymentDAO;

    public void rentInventoryAtStore(RentalRequestDTO requestDTO) {

        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var customer = session.get(Customer.class, requestDTO.getCustomerId());
            var staff = session.get(Staff.class, requestDTO.getStaffId());
            var inventory = session.get(Inventory.class, requestDTO.getInventoryId());

            var lastRental = rentalDAO.findLastRentalByInventoryId(inventory.getInventoryId(), session);

            if (lastRental != null && lastRental.getReturnDate() == null) {
                throw new IllegalStateException("Фильм не может быть сейчас выдан, он не возращен");
            }

            Rental rental = Rental.builder()
                    .rentalDate(LocalDateTime.now())
                    .inventory(inventory)
                    .customer(customer)
                    .staff(staff)
                    .lastUpdate(Instant.now())
                    .build();
            rentalDAO.save(rental, session);
            Payment payment = Payment.builder()
                    .customer(customer)
                    .staff(staff)
                    .rental(rental)
                    .amount(requestDTO.getAmount())
                    .paymentDate(LocalDateTime.now())
                    .lastUpdate(Instant.now())
                    .build();
            paymentDAO.save(payment, session);
            session.getTransaction().commit();

        }
    }
}
