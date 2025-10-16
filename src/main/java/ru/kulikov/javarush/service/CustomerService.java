package ru.kulikov.javarush.service;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.kulikov.javarush.dao.AddressDAO;
import ru.kulikov.javarush.dao.CityDAO;
import ru.kulikov.javarush.dao.CustomerDAO;
import ru.kulikov.javarush.dao.StoreDAO;
import ru.kulikov.javarush.entity.Address;
import ru.kulikov.javarush.entity.City;
import ru.kulikov.javarush.entity.Customer;
import ru.kulikov.javarush.entity.Store;

import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;
    private final StoreDAO storeDAO;
    private final AddressDAO addressDAO;
    private final CityDAO cityDAO;
    private final SessionFactory sessionFactory;


    public void createNewCustomer(String firstName,
                                  String lastName,
                                  String email,
                                  boolean active,
                                  LocalDateTime createDate,
                                  Instant lastUpdate,
                                  String street,
                                  String district,
                                  String postalCode,
                                  String phone,
                                  short cityId,
                                  byte storeId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            City city = cityDAO.getById(cityId, session);
            if (city == null) {
                throw new IllegalArgumentException("City with id " + cityId + " not found");
            }
            Store store = storeDAO.getById(storeId, session);
            if (store == null) {
                throw new IllegalArgumentException("Store with id " + storeId + " not found");
            }
            Address address = Address.builder()
                    .address(street)
                    .district(district)
                    .city(city)
                    .postalCode(postalCode)
                    .phone(phone)
                    .lastUpdate(lastUpdate)
                    .build();
            addressDAO.save(address, session);
            Customer customer = Customer.builder()
                    .store(store)
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .address(address)
                    .active(active)
                    .createDate(createDate)
                    .lastUpdate(lastUpdate)
                    .build();
            customerDAO.save(customer, session);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        }

    }
}
