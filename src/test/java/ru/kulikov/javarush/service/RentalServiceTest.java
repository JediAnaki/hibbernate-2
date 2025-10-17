package ru.kulikov.javarush.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.kulikov.javarush.dao.PaymentDAO;
import ru.kulikov.javarush.dao.RentalDAO;
import ru.kulikov.javarush.entity.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    @Mock
    private RentalDAO rentalDAO;

    @Mock
    private PaymentDAO paymentDAO;

    private RentalService rentalService;

    private Customer testCustomer;
    private Staff testStaff;
    private Inventory testInventory;
    private Film testFilm;
    private Store testStore;

    @BeforeEach
    void setUp() {
        rentalService = new RentalService(sessionFactory, rentalDAO, paymentDAO);

        // Настройка мока сессии
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

        // Создание тестовых данных
        setupTestData();
    }

    private void setupTestData() {
        testStore = Store.builder()
                .storeId((byte) 1)
                .lastUpdate(Instant.now())
                .build();

        testCustomer = Customer.builder()
                .customerId(130)
                .firstName("John")
                .lastName("Doe")
                .email("john@test.com")
                .active(true)
                .store(testStore)
                .createDate(LocalDateTime.now())
                .lastUpdate(Instant.now())
                .build();

        testStaff = Staff.builder()
                .staffId((short) 1)
                .firstName("Mike")
                .lastName("Hillyer")
                .active(true)
                .username("Mike")
                .password("password")
                .store(testStore)
                .lastUpdate(Instant.now())
                .build();

        testFilm = Film.builder()
                .filmId((short) 1)
                .title("Test Film")
                .rentalDuration((byte) 3)
                .rentalRate(new BigDecimal("4.99"))
                .replacementCost(new BigDecimal("19.99"))
                .lastUpdate(Instant.now())
                .build();

        testInventory = Inventory.builder()
                .inventoryId(1)
                .film(testFilm)
                .store(testStore)
                .lastUpdate(Instant.now())
                .build();
    }


}