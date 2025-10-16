package ru.kulikov.javarush;

import org.hibernate.SessionFactory;
import ru.kulikov.javarush.dao.*;
import ru.kulikov.javarush.dto.RentalRequestDTO;
import ru.kulikov.javarush.service.RentalService;
import ru.kulikov.javarush.utill.HibernateUtil;

import java.math.BigDecimal;

public class App {
    public void run() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        CustomerDAO customerDAO = new CustomerDAO();
        StoreDAO storeDAO = new StoreDAO();
        AddressDAO addressDAO = new AddressDAO();
        CityDAO cityDAO = new CityDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        RentalDAO rentalDAO = new RentalDAO();


        RentalService rentalService = new RentalService(sessionFactory, rentalDAO, paymentDAO);

        RentalRequestDTO request = new RentalRequestDTO();
        request.setCustomerId((short) 1);
        request.setStaffId((byte) 1);
        request.setInventoryId(1);
        request.setAmount(BigDecimal.valueOf(4.99));

        try {
            rentalService.rentInventoryAtStore(request);
            System.out.println("Аренда успешно создана!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}