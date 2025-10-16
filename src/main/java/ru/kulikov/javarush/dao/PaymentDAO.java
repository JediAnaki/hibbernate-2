package ru.kulikov.javarush.dao;

import ru.kulikov.javarush.entity.Payment;

public class PaymentDAO extends GenericDAO<Payment> {

    public PaymentDAO() {
        super(Payment.class);
    }
}
